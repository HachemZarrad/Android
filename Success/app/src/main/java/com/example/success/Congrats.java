package com.example.success;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Congrats extends AppCompatActivity {

    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats);

        output = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        String message1 = intent.getStringExtra("message1");
        output.setText(message1);
    }

    public void modify(View v){
        finish();
    }

}
