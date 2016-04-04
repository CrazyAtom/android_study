package org.androidtown.myclass3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
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
    public Baby CreateBaby(String name) { return new Baby(name, this);
    }

    public void onButtonCreateClicked(View v) {
        String name = editText.getText().toString();
        RadioButton radioButton01 = (RadioButton) findViewById(R.id.radioButton01);
        boolean personChecked = radioButton01.isChecked();

        if(person != null) {
            if(person.getName().equals(name) == true) {
                Toast.makeText(getApplicationContext(), name + "이(가) 이미 있습니다.", Toast.LENGTH_LONG).show();
            } else {
                person.setName(name);
            }
        } else {
            if(personChecked == true) {
                person = CreatePerson(name);
            } else {
                person = CreateBaby(name);
            }
        }

        imageView.setVisibility(View.VISIBLE);
    }

    public void onButtonWalkClicked(View v) {
        if(person != null)
            person.walk(10);
    }

    public void onButtonCryBabyClicked(View v) {
        if(person != null)
            if(person instanceof Baby) {
                Baby baby = (Baby) person;
                baby.cry();
            } else {
                Toast.makeText(getApplicationContext(), "Baby 객체가 아니어서 cry 메소드를 호출할 수 없습니다.", Toast.LENGTH_LONG).show();
            }
    }

    public void onButtonRunClicked(View v) {
        if(person != null)
            person.run(10);
    }
}