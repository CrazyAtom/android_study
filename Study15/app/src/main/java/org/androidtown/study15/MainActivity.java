package org.androidtown.study15;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    School school = null;

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
                Toast.makeText(getApplicationContext(), "학생 객체가 리스트에 추가됨 : " + name + "," + "학생의 나이 : " + age, Toast.LENGTH_LONG).show();

                TextView textViewCount = (TextView) findViewById(R.id.textViewCount);
                textViewCount.setText("추가된 학생의 총 수 : " + school.size());

                Intent intent = new Intent(getApplicationContext(), StudentInfoActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("age", age);

                startActivityForResult(intent, 1);
            }
        });

        Button buttonList = (Button) findViewById(R.id.buttonList);
        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
                TextView textViewList = (TextView) findViewById(R.id.textViewList);

                textViewList.setText(school.getName());
                textViewList.setText(school.toString());
            }
        });
    }
}
