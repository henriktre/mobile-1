package com.example.henriktre.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class A2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a2);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String v1 = bundle.getString("T1");
            TextView T2 = findViewById(R.id.T2);
            T2.setText("Hello " + v1);

        }

        b2();
    }


    private void b2() {


        Button button = findViewById(R.id.B2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(A2Activity.this, A3Activity.class);
                startActivityForResult(intent, 1);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String v2 = data.getStringExtra("T4");
                TextView T3 = findViewById(R.id.T3);
                T3.setText("From A3: " + v2);
            }
        }
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(A2Activity.this, A1Activity.class);
        startActivity(intent);
        return;
    }
}
