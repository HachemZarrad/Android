package com.example.success;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
        Intent intent = new Intent(this,Looser.class);
        intent.putExtra("message2",message2);
        startActivityForResult(intent,0);

    }

    public void verify(View v){
        finish();
    }
}



