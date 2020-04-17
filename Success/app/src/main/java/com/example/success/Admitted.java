package com.example.success;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;

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
          Intent intent = new Intent(this,Congrats.class);
          intent.putExtra("message1",message1);
          startActivityForResult(intent,1);

      }

      public void verify(View V){
        finish();
      }
    }

