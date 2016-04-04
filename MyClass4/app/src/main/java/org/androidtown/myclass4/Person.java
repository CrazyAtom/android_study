package org.androidtown.myclass4;

import android.widget.Toast;

/**
 * Created by KHB on 2016-01-25.
 */
public class Person {
    public static int total = 0;
    public int age = 0;
    protected String name;
    protected MainActivity activity;

    public Person() {
    }

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
        this.name = name;
        Toast.makeText(this.activity.getApplicationContext(), "이름이" + name + "으로 정정 되었습니다.", Toast.LENGTH_LONG).show();
        this.activity.imageView.setImageResource(R.drawable.person);
    }

    public MainActivity getActivity() {
        return activity;
    }

    public void setActivity(MainActivity activity) {
        this.activity = activity;
    }

    public void walk(int speed) {
        Toast.makeText(this.activity.getApplicationContext(), name + "이(가)" + speed + "km 속도로 걸어갑니다.", Toast.LENGTH_LONG).show();
        this.activity.imageView.setImageResource(R.drawable.person_walk);
    }

    public void run(int speed) {
        Toast.makeText(this.activity.getApplicationContext(), name + "이(가)" + speed + "km 속도로 뛰어갑니다.", Toast.LENGTH_LONG).show();
        this.activity.imageView.setImageResource(R.drawable.person_run);
    }

    public void cry() {
        Toast.makeText(this.activity.getApplicationContext(), name + "이(가) 우는 방법을 모릅니다.", Toast.LENGTH_LONG).show();
    }
}
