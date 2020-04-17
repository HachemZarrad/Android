package com.example.success;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Fail extends AppCompatActivity {

    private EditText looser;
    String message2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fail);

        looser = (EditText) findViewById(R.id.editText);

        Intent intent = getIntent();
        float average = intent.getFloatExtra("average",1);
        looser.setText(" اسود وجهك يا فاشل يا مدوبل ما تحشمش على روحك جايب " +
                  average + " معدل \n " + " العام الجاي نشاله يا جحش ");
        message2 = looser.getText().toString();

    }

    public void send(View v){
        try {
            String sms = looser.getText().toString();
            Intent sendIntent = new Intent(Intent.ACTION_VIEW);
            sendIntent.putExtra("sms_body",sms );
            sendIntent.setType("vnd.android-dir/mms-sms");
            startActivity(sendIntent);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(),
                    "SMS faild, please try again later!",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }


    }

    public void verify(View v){
        finish();
    }
}



