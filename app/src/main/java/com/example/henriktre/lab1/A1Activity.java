package com.example.henriktre.lab1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.content.SharedPreferences;

import java.util.ArrayList;

public class A1Activity extends AppCompatActivity {
    public ArrayList<String> days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a1);
        s2();
        b1();
    }
    private void s2() {

        days = new ArrayList<String>();
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");
        days.add("Sunday");


        Spinner spinner = findViewById(R.id.L1);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter =  new ArrayAdapter(this, android.R.layout.simple_spinner_item, days);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        getPref();


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                SharedPreferences sharedPref = getSharedPreferences("Filename", 0);

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("pos", i);
                editor.apply();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
    private void getPref() {
        Spinner spinner = findViewById(R.id.L1);
        SharedPreferences sharedPref = getSharedPreferences("Filename", 0);
        int pos = sharedPref.getInt("pos", -1);
        if(pos != -1) {
            spinner.setSelection(pos);
        }
    }

    private void b1() {


        Button button = findViewById(R.id.B1);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText t1 = findViewById(R.id.T1);
                Intent intent = new Intent(A1Activity.this, A2Activity.class);
                intent.putExtra("T1", t1.getText().toString());
                startActivity(intent);
            }
        });
    }
    @Override
    public void onBackPressed() {
        this.finishAffinity();
    }
}
