package com.example.qazpl.entreprenuership;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_2);

        Button btn1 = (Button) findViewById(R.id.btn_next_2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mintent = new Intent(ThirdActivity.this, FinalActivity.class);
                startActivity(mintent);
                overridePendingTransition(R.anim.in_from_right,R.anim.out_to_left);
            }
        });
    }
}
