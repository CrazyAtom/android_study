package org.androidtown.study16;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    School school = null;
    Stack<Student> stackStudent = new Stack<Student>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextName = (EditText) findViewById(R.id.editTextName);
                EditText editTextAge = (EditText) findViewById(R.id.editTextAge);
                String name = editTextName.getText().toString();
                int age = Integer.valueOf(editTextAge.getText().toString());

                Student student = new Student(name, age);
                if(school == null) {
                    school = new School("우리학교");
                }
                school.addItem(student);
                stackStudent.push(student);
                Toast.makeText(getApplicationContext(), "학생 객체가 리스트에 추가됨 : " + name + "," + "학생의 나이 : " + age, Toast.LENGTH_LONG).show();

                TextView textViewCount = (TextView) findViewById(R.id.textViewCount);
                textViewCount.setText("추가된 학생의 총 수 : " + school.size());

                ResetScrollView();
            }
        });

        Button buttonRecentAdd = (Button) findViewById(R.id.buttonRecentAdd);
        buttonRecentAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(stackStudent.empty() == true)
                    return;

                Student student = stackStudent.pop();
                String name = student.getName();
                int age = student.getAge();

                Intent intent = new Intent(getApplicationContext(), StudentInfoActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("age", age);

                startActivityForResult(intent, 1);
            }
        });
    }

    public void ResetScrollView() {
        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
        TextView textViewList = (TextView) findViewById(R.id.textViewList);

        textViewList.setText(school.toString());
    }
}
