package com.example.sgpacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class ChemistryActivity extends AppCompatActivity {
    TextInputEditText s1, s2, s3, s4, s5, s6, s7, s8;
    TextView sgpares;
    Button calculate,reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemistry);

        s1 = findViewById(R.id.m1);
        s2 = findViewById(R.id.chem);
        s3 =findViewById(R.id.cpc);
        s4 = findViewById(R.id.elec);
        s5 = findViewById(R.id.mech);
        s6 = findViewById(R.id.engll);
        s7 = findViewById(R.id.cheml);
        s8 = findViewById(R.id.cpll);
        reset = findViewById(R.id.resetchem);
        sgpares = findViewById(R.id.sgparescse3);
        calculate=findViewById(R.id.chemcalculate);
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
                Intent intent = new Intent(ChemistryActivity.this,ChemistryActivity.class);
                intent.putExtra("mode",1);
                startActivity(intent);
            }
        });
    }
    public void sgpacalculate() {
        if (s1.getText().toString().equals("") || s2.getText().toString().equals("") || s3.getText().toString().equals("") || s4.getText().toString().equals("") || s5.getText().toString().equals("") || s6.getText().toString().equals("") || s7.getText().toString().equals("") || s8.getText().toString().equals("")) {
            Toast.makeText(ChemistryActivity.this, "Please enter All marks", Toast.LENGTH_SHORT);

        } else {
            int sb1 = Integer.parseInt(s1.getText().toString());
            int sb2 = Integer.parseInt(s2.getText().toString());
            int sb3 = Integer.parseInt(s3.getText().toString());
            int sb4 = Integer.parseInt(s4.getText().toString());
            int sb5 = Integer.parseInt(s5.getText().toString());
            int sb6 = Integer.parseInt(s6.getText().toString());
            int sb7 = Integer.parseInt(s7.getText().toString());
            int sb8 = Integer.parseInt(s8.getText().toString());

            if ((sb1 > 0 && sb1 <= 100) && (sb2 <= 100 && sb2 > 0) && (sb3 <= 100 && sb3 > 0) && (sb4 <= 100 && sb4 > 0) && (sb5 <= 100 && sb5 > 0) && (sb6 <= 100 && sb6 > 0) && (sb7 <= 100 && sb7 > 0) && (sb8 <= 100 && sb8 > 0)) {
                int r1 = ((sb1 / 10) + 1) * 4;
                int r2 = ((sb2 / 10) + 1) * 4;
                int r3 = ((sb3 / 10) + 1) * 3;
                int r4 = ((sb4 / 10) + 1) * 3;
                int r5 = ((sb5 / 10) + 1) * 3;
                int r6 = ((sb6 / 10) + 1) * 1;
                int r7 = ((sb7 / 10) + 1) * 1;
                int r8 = ((sb8 / 10) + 1) * 1;
                int totalc = 20;
                int sum = r1 + r2 + r3 + r4 + r5 + r6 + r7 + r8;
                float s = (float) (sum);
                float c = (float) (totalc);
                float sgpa = s / c;
                sgpares.setText(String.valueOf(sgpa));
            } else {
                Toast.makeText(ChemistryActivity.this, "Please Check Your Marks", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
