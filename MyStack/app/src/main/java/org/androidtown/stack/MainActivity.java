package org.androidtown.stack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.EmptyStackException;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button buttonPush;
    Button buttonPop;

    Stack<Integer> stack = new Stack<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        buttonPush = (Button) findViewById(R.id.buttonPush);
        buttonPop = (Button) findViewById(R.id.buttonPop);

        buttonPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = stack.size() + 1;
                stack.push(value);
                editText.setText("\n스택에 추가함 : " + value);

                editText.append("\n스택 : " + stack);
            }
        });

        buttonPop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int outValue = stack.pop();
                    editText.setText("\n스택에서 가져옴 : " + outValue);
                    editText.append("\n스택 : " + stack);
                } catch (EmptyStackException e) {
                    Toast.makeText(getApplicationContext(), "스택이 비어 있습니다", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
