package com.example.success;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

import java.lang.reflect.InvocationTargetException;

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
        float average = calculate(mathMark, mathCoeff, physicsMark, physicsCoeff, androidMark, androidCoeff);

        try {
            if (average >= 10) {
                Intent intent = new Intent(this, Admitted.class);
                intent.putExtra("average", average);
                startActivityForResult(intent, 0);
            } else {
                Intent intent = new Intent(this, Fail.class);
                intent.putExtra("average", average);
                startActivityForResult(intent, 1);
            }

        }

        catch (Exception e){
            Toast.makeText(this,"Please give a mark between 0 and 20 , also a coefficient between 1 and 10",Toast.LENGTH_LONG).show();
        }
    }
}