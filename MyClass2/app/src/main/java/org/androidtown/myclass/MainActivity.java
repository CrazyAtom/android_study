package org.androidtown.myclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    ImageView imageView;
    Person person = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editTextName);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    public Person CreatePerson(String name) {
        return new Person(name, this);
    }

    public void onButtonCreateClicked(View v) {
        String name = editText.getText().toString();
        if(person == null) {
            person = CreatePerson(name);
        }
        else {
            person.setName(name);
        }
    }

    public void onButtonWalkClicked(View v) {
        if(person != null)
            person.walk(10);
    }

    public void onButtonRunClicked(View v) {
        if(person != null)
            person.run(10);
    }
}

class Person {
    private  String name;
    MainActivity activity;

    public Person(String name, MainActivity activity) {
        this.name = name;
        this.activity = activity;
        Toast.makeText(this.activity.getApplicationContext(), name + "이(가) 만들어 졌습니다.", Toast.LENGTH_LONG).show();
        this.activity.imageView.setImageResource(R.drawable.person);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        Toast.makeText(this.activity.getApplicationContext(), oldName + "의 이름이" + name + "으로 정정 되었습니다.", Toast.LENGTH_LONG).show();
        this.activity.imageView.setImageResource(R.drawable.person);
    }

    public void walk(int speed) {
        Toast.makeText(this.activity.getApplicationContext(), name + "이(가)" + speed + "km 속도로 걸어갑니다.", Toast.LENGTH_LONG).show();
        this.activity.imageView.setImageResource(R.drawable.person_walk);
    }

    public void run(int speed) {
        Toast.makeText(this.activity.getApplicationContext(), name + "이(가)" + speed + "km 속도로 뛰어갑니다.", Toast.LENGTH_LONG).show();
        this.activity.imageView.setImageResource(R.drawable.person_run);
    }
}
