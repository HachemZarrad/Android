package com.example.success;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Looser extends AppCompatActivity {

    private TextView output;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looser);

        output = (TextView) findViewById(R.id.textView);
        Intent intent = getIntent();
        String message2 = intent.getStringExtra("message2");
        output.setText(message2);
    }

    public void modify(View v){
        finish();

    }
}

