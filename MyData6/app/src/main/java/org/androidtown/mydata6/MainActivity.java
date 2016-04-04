package org.androidtown.mydata6;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    String[] groups = {"친구", "가족"};
    String[] names = {"철수", "영희", "민희", "수지", "지민"};
    int count = 0;
    TextView textViewCount;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCount = (TextView) findViewById(R.id.textViewCount);
        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);

        final HashMap<String, ArrayList<String>> phonebook = new HashMap<String, ArrayList<String>>();

        ArrayList<String> friends = new ArrayList<String>();
        friends.add("철수");
        friends.add("영희");
        friends.add("민희");
        friends.add("수지");
        friends.add("지민");
        phonebook.put("친구", friends);

        ArrayList<String> family = new ArrayList<String>();
        family.add("할머니");
        family.add("할아버지");
        family.add("엄마");
        family.add("아빠");
        family.add("동생");
        phonebook.put("가족", family);

        Button buttonCreate = (Button) findViewById(R.id.buttonCreate);
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Person> persons = new ArrayList<Person>();

                int nameIndex = count % 5;
                Person curPerson = new Person(names[nameIndex]);
                persons.add(curPerson);
                Toast.makeText(getApplicationContext(), "사람" + names[nameIndex] + "이 만들어졌습니다.", Toast.LENGTH_LONG).show();

                String curName = curPerson.getName();
                addPersonTextView(curName);

                count++;
                textViewCount.setText(count + "명");
            }
        });

        Button buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Person> persons = new ArrayList<Person>();
                EditText editTextName = (EditText) findViewById(R.id.textViewName);
                String curName = editTextName.getText().toString();

                Person curPerson = new Person(curName);
                persons.add(curPerson);
                Toast.makeText(getApplicationContext(), "사람" + curName + "이 만들어졌습니다", Toast.LENGTH_LONG).show();

                addPersonTextView(curName);
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, groups);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "선택된 아이템 인덱스 : " + position, Toast.LENGTH_LONG).show();

                linearLayout.removeAllViews();

                String curGroup = groups[position];
                ArrayList<String> nameList = phonebook.get(curGroup);
                Iterator<String> iterator = nameList.iterator();
                while (iterator.hasNext()) {
                    String curName = iterator.next();
                    addPersonTextView(curName);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void addPersonTextView(String curName) {
        TextView nameTextView = new TextView(getApplicationContext());
        nameTextView.setText(curName);
        nameTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
        nameTextView.setTextColor(Color.BLUE);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        linearLayout.addView(nameTextView, params);
    }
}
