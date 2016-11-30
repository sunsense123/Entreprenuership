package com.example.qazpl.entreprenuership;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    String name;
    String phone;
    String price;
    String place;
    EditText edt1;
    EditText edt2;
    EditText edt3;
    EditText edt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_1);

        Button btn1 = (Button) findViewById(R.id.btn_next_1);
        edt1 = (EditText) findViewById(R.id.edt_name);
        edt2 = (EditText) findViewById(R.id.edt_phone);
        edt3 = (EditText) findViewById(R.id.edt_price);
        edt4 = (EditText) findViewById(R.id.edt_place);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edt1.getText().toString();
                phone = edt2.getText().toString();
                price = edt3.getText().toString();
                place = edt4.getText().toString();

                Intent mintent = new Intent(SecondActivity.this, ThirdActivity.class);

                mintent.putExtra("name",name);
                mintent.putExtra("phone",phone);
                mintent.putExtra("price",price);
                mintent.putExtra("place",place);

                startActivity(mintent);
                overridePendingTransition(R.anim.in_from_right,R.anim.out_to_left);

                finish();

            }
        });
    }
}
