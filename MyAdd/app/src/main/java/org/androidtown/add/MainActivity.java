package org.androidtown.add;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText01;
    EditText editText02;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText01 = (EditText) findViewById(R.id.editText01);
        editText02 = (EditText) findViewById(R.id.editText02);
        textView = (TextView) findViewById(R.id.textViewResult);

        Button button = (Button) findViewById(R.id.buttonCalc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String szVal01 = editText01.getText().toString();
                String szVal02 = editText02.getText().toString();
                double dVal01 = Double.parseDouble(szVal01);
                double dVal02 = Double.parseDouble(szVal02);
                double dValResult = dVal01 + dVal02;

                String szValResult = String.valueOf(dValResult);
                textView.setText(szValResult);
            }
        });

    }
}
