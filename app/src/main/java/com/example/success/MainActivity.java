package com.example.success;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText inputMathMark;
    private EditText inputMathCoeff;
    private EditText inputPhysicsMark;
    private EditText inputPhysicsCoeff;
    private EditText inputAndroidMark;
    private EditText inputAndroidCoeff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputMathMark = (EditText) findViewById(R.id.textView2);
        inputMathCoeff = (EditText) findViewById(R.id.textView3);
        inputPhysicsMark = (EditText) findViewById(R.id.textView5);
        inputPhysicsCoeff = (EditText) findViewById(R.id.textView6);
        inputAndroidMark = (EditText) findViewById(R.id.textView8);
        inputAndroidCoeff = (EditText) findViewById(R.id.textView9);

    }

    public float calculate(float mathMark, float mathCoeff, float physicsMark, float physicsCoeff, float androidMark, float androidCoeff) {

        float average = ((mathMark * mathCoeff) + (physicsMark * physicsCoeff) + (androidMark * androidCoeff)) / (mathCoeff + physicsCoeff + androidCoeff);

        return average;
    }

    public void goNext(View v) {
        float mathMark = Float.parseFloat(inputMathMark.getText().toString());
        float mathCoeff = Float.parseFloat(inputMathCoeff.getText().toString());
        float physicsMark = Float.parseFloat(inputPhysicsMark.getText().toString());
        float physicsCoeff = Float.parseFloat(inputPhysicsCoeff.getText().toString());
        float androidMark = Float.parseFloat(inputAndroidMark.getText().toString());
        float androidCoeff = Float.parseFloat(inputAndroidCoeff.getText().toString());

        if ((mathMark <= 20 && mathMark >= 0) && (mathCoeff >= 0.5 && mathCoeff <= 10) && (physicsMark <= 20 && physicsMark >= 0) && (physicsCoeff <= 10 && physicsCoeff >= 0.5) && (androidMark <= 20 && androidMark >= 0) && (androidCoeff <= 10 && androidCoeff >= 0.5)) {
            float average = calculate(mathMark, mathCoeff, physicsMark, physicsCoeff, androidMark, androidCoeff);


            if (average >= 10) {
                Intent intent = new Intent(this, Admitted.class);
                intent.putExtra("average", average);
                startActivity(intent);
            } else {
                Intent intent = new Intent(this, Fail.class);
                intent.putExtra("average", average);
                startActivity(intent);
            }

        }

        else
        {
            Toast.makeText(getApplicationContext(), "Please give a mark between 0 and 20 also a coefficient between 0.5 and 10", Toast.LENGTH_LONG).show();
        }
    }
}