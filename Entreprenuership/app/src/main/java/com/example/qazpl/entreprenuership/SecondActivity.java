package com.example.qazpl.entreprenuership;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent mintent = new Intent(SecondActivity.this,ThirdActivity.class);
        startActivity(mintent);
    }
}
