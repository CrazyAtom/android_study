package org.androidtown.myclass3;

import android.widget.Toast;

/**
 * Created by KHB on 2016-01-25.
 */
public class Baby extends Person {
    public Baby(String name, MainActivity activity) {
        this.name = name;
        this.activity = activity;
        this.activity.imageView.setImageResource(R.drawable.baby);
    }

    public void cry() {
        Toast.makeText(this.activity.getApplicationContext(), name + "이(가) 웁니다", Toast.LENGTH_LONG).show();
        this.activity.imageView.setImageResource(R.drawable.baby_cry);
    }
}
