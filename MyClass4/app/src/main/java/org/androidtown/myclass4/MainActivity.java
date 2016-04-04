package org.androidtown.myclass4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
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

        Person person = new Person(name, this);

        person.age = 20;
        Person.total = Person.total + 1;

        return person;
    }

    public Baby CreateBaby(String name) {
        Baby baby = new Baby(name, this);

        baby.age = 1;
        baby.total = Person.total + 1;

        return baby;
    }

    public void onButtonCreateClicked(View v) {
        String name = editText.getText().toString();
        RadioButton radioButton01 = (RadioButton) findViewById(R.id.radioButton01);
        boolean personChecked = radioButton01.isChecked();

//        if(person != null) {
//            if(person.getName().equals(name) == true) {
//                Toast.makeText(getApplicationContext(), name + "이(가) 이미 있습니다.", Toast.LENGTH_LONG).show();
//            } else {
//                person.setName(name);
//            }
//        } else {
            if(personChecked == true) {
                person = CreatePerson(name);
            } else {
                person = CreateBaby(name);
            }
//        }

        imageView.setVisibility(View.VISIBLE);

        TextView textViewTotal = (TextView) findViewById(R.id.textViewTotal);
        textViewTotal.setText(Person.total + "명");
    }

    public void onButtonWalkClicked(View v) {
        if(person != null) {
            person.walk(10);
        }
    }

    public void onButtonCryBabyClicked(View v) {
        if(person != null) {
                person.cry();
            }
    }

    public void onButtonRunClicked(View v) {
        if(person != null) {
            person.run(10);
        }
    }
}