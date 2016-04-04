package org.androidtown.myclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Person Person01 = new Person("철수", this);
        Person01.walk(10);

        Person Person02 = new Person("영희", this);
        Person02.walk(10);

        Person Person03 = new Person("민희", this);
        Person03.walk(10);
    }
}

class Person {
    private  String name;
    MainActivity activity;
    Leg leg = new Leg();

    public Person(String name, MainActivity activity) {
        this.name = name;
        this.activity = activity;
    }

    public Leg GetLeg() {
        return leg;
    }

    public void walk(int speed) {
        System.out.println(name + "이(가)" + speed + "km 속도로 걸어갑니다.");
        Toast.makeText(this.activity.getApplicationContext(), name + "이(가)" + speed + "km 속도로 걸어갑니다.", Toast.LENGTH_LONG).show();
    }

    public void run(int speed) {
        System.out.println(name + "이(가)" + speed + "km 속도로 뛰어갑니다.");
		Toast.makeText(this.activity.getApplicationContext(), name + "이(가)" + speed + "km 속도로 뛰어갑니다.", Toast.LENGTH_LONG).show();
    }
}

class Leg {
    private String left = "왼쪽";
    private String right = "오른쪽";

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }
}
