package org.androidtown.mydata;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] names = {"철수", "영희", "민희", "수지", "지민"};
    Person[] persons = new Person[5];
    int count = 0;
    TextView textViewCount;
    ScrollView scrollView;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCount = (TextView) findViewById(R.id.textViewCount);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        Button buttonCreate = (Button) findViewById(R.id.buttonCreate);
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count >= persons.length) {
                    Person[] tempPersons = new Person[persons.length + 5];
                    System.arraycopy(persons, 0, tempPersons, 0, persons.length);
                    persons = tempPersons;
                }

                int nameIndex = count % 5;
                persons[count] = new Person(names[nameIndex]);
                Toast.makeText(getApplicationContext(), "사람" + names[nameIndex] + "이 만들어졌습니다.", Toast.LENGTH_LONG).show();

                String curName = persons[count].getName();

                TextView nameTextView = new TextView(getApplicationContext());
                nameTextView.setText(curName);
                nameTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
                nameTextView.setTextColor(Color.parseColor("#0000FF"));

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

                linearLayout.addView(nameTextView, params);

                count++;
                textViewCount.setText(count + "명");
            }
        });
    }
}
