package org.androidtown.myclass4;

import android.widget.Toast;

/**
 * Created by KHB on 2016-01-25.
 */
public class Baby extends Person {
    public Baby(String name, MainActivity activity) {
        this.name = name;
        this.activity = activity;
        Toast.makeText(this.activity.getApplicationContext(), name + "이(가) 만들어 졌습니다.", Toast.LENGTH_LONG).show();
        this.activity.imageView.setImageResource(R.drawable.baby);
    }

    @Override
    public void cry() {
        super.cry();
        Toast.makeText(this.activity.getApplicationContext(), name + "이(가) 웁니다", Toast.LENGTH_LONG).show();
        this.activity.imageView.setImageResource(R.drawable.baby_cry);
    }
}
