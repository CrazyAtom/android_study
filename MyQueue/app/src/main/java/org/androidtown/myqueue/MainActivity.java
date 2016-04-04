package org.androidtown.myqueue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.androidtown.myqueue.R;

import java.util.EmptyStackException;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button buttonOffer;
    Button buttonPoll;

    ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        buttonOffer = (Button) findViewById(R.id.buttonOffer);
        buttonPoll = (Button) findViewById(R.id.buttonPoll);

        buttonOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = queue.size() + 1;
                queue.offer(value);
                editText.setText("\n큐에 추가함 : " + value);

                editText.append("\n큐 : " + queue);
            }
        });

        buttonPoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int outValue = queue.poll();
                    editText.setText("\n큐에서 가져옴 : " + outValue);
                    editText.append("\n큐 : " + queue);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "큐가 비어 있습니다", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
