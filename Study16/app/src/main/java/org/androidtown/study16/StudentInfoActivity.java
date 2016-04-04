package org.androidtown.study16;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by KHB on 2016-02-16.
 */
public class StudentInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentinfo);

        Intent passedIntend = getIntent();
        if(passedIntend != null) {
            String name = passedIntend.getStringExtra("name");
            int age = passedIntend.getIntExtra("age", 20);

            EditText editTextName = (EditText) findViewById(R.id.editTextPassedName);
            editTextName.setText(name);

            EditText editTextAge = (EditText) findViewById(R.id.editTextPassedAge);
            editTextAge.setText(Integer.toString(age));
        }

        Button buttonClose = (Button) findViewById(R.id.buttonClose);
        buttonClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
