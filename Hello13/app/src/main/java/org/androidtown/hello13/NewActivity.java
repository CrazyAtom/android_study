package org.androidtown.hello13;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

//        Intent passedIntend = getIntent();
//        if(passedIntend != null) {
            String loginName = User.loginName;//passedIntend.getStringExtra("loginName");
            Toast.makeText(getApplicationContext(), "새로운 화면에서 받은 loginName : " + loginName, Toast.LENGTH_LONG).show();
//        }

        Button buttonBack = (Button) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "돌아가기 버튼이 눌렸어요.", Toast.LENGTH_LONG).show();

                Intent intent = new Intent();
                intent.putExtra("name", "mike");
                setResult(User.RES_CODE_SUCCESS, intent);

                finish();
            }
        });
    }
}
