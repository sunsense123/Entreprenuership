package com.example.qazpl.entreprenuership;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {
    Boolean available = true;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String token = FirebaseInstanceId.getInstance().getToken();
        Toast.makeText(MainActivity.this, token, Toast.LENGTH_SHORT).show();
        Log.d("Firebase","Token: "+token);
        Button btn1 = (Button) findViewById(R.id.btn_create);
        Button btn2 = (Button) findViewById(R.id.btn_search);
        Button btn3 = (Button) findViewById(R.id.btn_current_deal);
        TextView btn4 = (TextView) findViewById(R.id.btn_demo);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mintent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(mintent);

                overridePendingTransition(R.anim.in_from_right,R.anim.out_to_left);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mintent = new Intent();
                mintent.setClass(MainActivity.this,FinalActivity.class);
                startActivity(mintent);


            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(available) {
                    startActivity(new Intent(MainActivity.this, FinalActivity.class));

                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DemoActivity.class));
            }
        });

    }
}
