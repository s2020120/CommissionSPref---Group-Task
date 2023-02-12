package com.example.activty3243;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView txtname, txtcommission;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        txtname = findViewById(R.id.AgentName2);
        txtcommission = findViewById(R.id.ComPay);

        sharedPreferences = getSharedPreferences("SHARED_PREF", MODE_PRIVATE);

        String sname = sharedPreferences.getString("NAME", "");
        int netpay = sharedPreferences.getInt("Netpay",0);

        txtname.setText(sname);
        txtcommission.setText(netpay);
    }
}