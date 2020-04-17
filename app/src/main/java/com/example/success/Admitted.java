package com.example.success;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class Admitted extends AppCompatActivity {

    private EditText congrats;
    String message1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admitted);

        congrats = (EditText) findViewById(R.id.editText);
        Intent intent = getIntent();
        float average = intent.getFloatExtra("average",1);
        congrats.setText("صحة يا غول سلكتها يا وحش مبروك عليك\n" +
                "المعدل: " + average );
        message1 = congrats.getText().toString();
      }

      public void send(View v){
          try {
              String sms = congrats.getText().toString();
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

      public void verify(View V){
        finish();
      }


    }

