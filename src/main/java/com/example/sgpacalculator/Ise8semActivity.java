package com.example.sgpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Ise8semActivity extends AppCompatActivity {
    TextInputEditText s1, s2, s3, s4, s5;
    TextView sgpares;
    Button calculate,reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ise8sem);
        s1 = findViewById(R.id.iot);
        s2 = findViewById(R.id.pe4);
        s3 =findViewById(R.id.pwp2);
        s4 = findViewById(R.id.ts);
        s5 = findViewById(R.id.is);
        reset = findViewById(R.id.resetise8);
        sgpares = findViewById(R.id.sgparesise8);
        calculate=findViewById(R.id.ise8calculate);
        calculate.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sgpacalculate();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(Ise8semActivity.this,Ise8semActivity.class);
                intent.putExtra("mode",1);
                startActivity(intent);
            }
        });
    }
    public void sgpacalculate() {
        if (s1.getText().toString().equals("") || s2.getText().toString().equals("") || s3.getText().toString().equals("") || s4.getText().toString().equals("") || s5.getText().toString().equals("")) {
            Toast.makeText(Ise8semActivity.this, "Please enter All marks", Toast.LENGTH_SHORT);

        } else {
            int sb1 = Integer.parseInt(s1.getText().toString());
            int sb2 = Integer.parseInt(s2.getText().toString());
            int sb3 = Integer.parseInt(s3.getText().toString());
            int sb4 = Integer.parseInt(s4.getText().toString());
            int sb5 = Integer.parseInt(s5.getText().toString());

            if ((sb1 > 0 && sb1 <= 100) && (sb2 <= 100 && sb2 > 0) && (sb3 <= 100 && sb3 > 0) && (sb4 <= 100 && sb4 > 0) && (sb5 <= 100 && sb5 > 0)) {
                int r1 = ((sb1 / 10) + 1) * 4;
                int r2 = ((sb2 / 10) + 1) * 4;
                int r3 = ((sb3 / 10) + 1) * 3;
                int r4 = ((sb4 / 10) + 1) * 3;
                int r5 = ((sb5 / 10) + 1) * 3;
                int totalc = 18;
                int sum = r1 + r2 + r3 + r4 + r5;
                float s = (float) (sum);
                float c = (float) (totalc);
                float sgpa = s / c;
                sgpares.setText(String.valueOf(sgpa));
            } else {
                Toast.makeText(Ise8semActivity.this, "Please Check Your Marks", Toast.LENGTH_SHORT).show();
            }
        }
    }
}