package org.androidtown.hello12;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonWeb = (Button) findViewById(R.id.buttonWeb);
        buttonWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
                startActivity(intent);
            }
        });

        Button buttonCall = (Button) findViewById(R.id.buttonCall);
        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:01051591980"));
                startActivity(intent);
            }
        });

        Button buttonNewActivity = (Button) findViewById(R.id.buttonNewActivity);
        buttonNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User.loginName = "소녀시대";
                Intent intent = new Intent(getApplicationContext(), NewActivity.class);
                startActivityForResult(intent, User.REQ_CODE_PHONEBOOK);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == User.RES_CODE_SUCCESS) {
            String outName = data.getStringExtra("name");
            Toast.makeText(getApplicationContext(), "전달 받은 name 속성의 값 : " + outName, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "실패하였습니다", Toast.LENGTH_LONG).show();
        }
    }
}
