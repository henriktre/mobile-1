package com.example.henriktre.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class A3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a3);
        b3();
    }

    private void b3() {


        Button button = findViewById(R.id.B3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText t4 = findViewById(R.id.T4);
                Intent intent = new Intent(A3Activity.this, A2Activity.class);
                intent.putExtra("T4", t4.getText().toString());
                setResult(A2Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(A3Activity.this, A2Activity.class);
        startActivity(intent);
        return;
    }
}
