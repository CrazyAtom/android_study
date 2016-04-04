package com.example.khb.study05;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editName, editOld, editAdd;
    TextView textResultName, textResultOld, textResultAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = (EditText) findViewById(R.id.editTextName);
        editOld = (EditText) findViewById(R.id.editTextOld);
        editAdd = (EditText) findViewById(R.id.editTextAdd);

        textResultName = (TextView) findViewById(R.id.textViewResultName);
        textResultOld = (TextView) findViewById(R.id.textViewResultOld);
        textResultAdd = (TextView) findViewById(R.id.textViewResultAdd);

        Button buttonClose = (Button) findViewById(R.id.buttonClose);
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                finish();
            }
        });
    }

    public void onButtonSaveClicked(View v) {
        String sName = editName.getText().toString();
        String sOld = editOld.getText().toString();
        String sAdd = editAdd.getText().toString();

        textResultName.setText(sName);
        textResultOld.setText(sOld);
        textResultAdd.setText(sAdd);

        String sResult;
        if (Integer.parseInt(sOld) > 19) {
            sResult = "성인 입니다";
        } else {
            sResult = "미성년 입니다";
        }

        Toast.makeText(this, sResult, Toast.LENGTH_LONG).show();
    }
}
