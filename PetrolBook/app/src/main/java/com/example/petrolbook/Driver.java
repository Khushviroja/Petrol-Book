package com.example.petrolbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Driver extends AppCompatActivity {

    private dbconnect dbconnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);

        dbconnect = new dbconnect(this);
    }

    public void fun(View view) {

        EditText edt1 = findViewById(R.id.e1);
        EditText edt2 = findViewById(R.id.e2);
        EditText edt3 = findViewById(R.id.e3);
        EditText edt4 = findViewById(R.id.e4);
        EditText edt5 = findViewById(R.id.e5);
        EditText edt6 = findViewById(R.id.e6);

        String valname, valmno, valvno, valskm, valdate, valprice;
        valname = edt1.getText().toString();
        valmno = edt2.getText().toString();
        valvno = edt3.getText().toString();
        valskm = edt4.getText().toString();
        valdate = edt5.getText().toString();
        valprice = edt6.getText().toString();

        if(dbconnect.insertData(valname,valmno,valvno,valskm,valdate,valprice)){
            Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Data insertion failed", Toast.LENGTH_SHORT).show();
        }

        Intent a1 = new Intent(this,Driver.class);
        startActivity(a1);

    }


    public void fun1(View view) {
        Intent a2 = new Intent(this,Admin.class);
        startActivity(a2);
        finish();
    }
}