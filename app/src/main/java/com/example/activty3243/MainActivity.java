package com.example.activty3243;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_AName, et_PAmount, et_SEstate,et_Comm,et_VAT;
    Button btnsubmit;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_AName = findViewById(R.id.AgentName);
        et_PAmount = findViewById(R.id.PrincipalAmount);
        et_SEstate = findViewById(R.id.SoldRealEstate);
        et_Comm = findViewById(R.id.Commission);
        et_VAT = findViewById(R.id.VAT);

        sharedPreferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);


        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = et_AName.getText().toString();
                int PrincipalAmount = Integer.parseInt(et_PAmount.getText().toString().trim());
                int SoldEstate = Integer.parseInt(et_SEstate.getText().toString().trim());
                int Commission = Integer.parseInt(et_Comm.getText().toString().trim());
                int VAT = Integer.parseInt(et_VAT.getText().toString().trim());

                int FVAT = VAT/100;
                int Vat = (PrincipalAmount * SoldEstate) * FVAT;
                int NetPay = ((PrincipalAmount * SoldEstate) * Commission) - Vat;

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("NAME", Name);
                editor.putInt("NetPay", NetPay);
                editor.apply();

                Intent intent = new Intent(MainActivity.this, Activity2.class);
                startActivity(intent);
            }
        });

    }
}