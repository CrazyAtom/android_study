package org.androidtown.touch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    int nCntTouch = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout layout = (FrameLayout) findViewById(R.id.layout);
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    float x = event.getX();
                    float y = event.getY();
                    ++nCntTouch;

                    EditText editTextX = (EditText) findViewById(R.id.editTextX);
                    EditText editTextY = (EditText) findViewById(R.id.editTextY);
                    EditText editTextCntTouch = (EditText) findViewById(R.id.editTextCntTouch);
                    editTextX.setText(String.valueOf(x));
                    editTextY.setText(String.valueOf(y));
                    editTextCntTouch.setText(String.valueOf(nCntTouch));
                }

                return true;
            }
        });
    }
}
