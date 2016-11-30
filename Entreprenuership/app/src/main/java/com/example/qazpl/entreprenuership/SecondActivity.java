package com.example.qazpl.entreprenuership;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.qazpl.entreprenuership.R.id.edt_phone;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_1);

        Button btn1 = (Button) findViewById(R.id.btn_next_1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mintent = new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(mintent);
            }
        });

        final EditText edt_phone = (EditText) findViewById(R.id.edt_phone);
        final EditText edt_price = (EditText) findViewById(R.id.edt_price);
        edt_price.addTextChangedListener(new NumberTextWatcherForThousand(edt_price));
        edt_phone.addTextChangedListener(new TextWatcher() {
            int prevL = 0;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                prevL = edt_phone.getText().toString().length();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int length = editable.length();
                if ((prevL < length) && (length == 3 || length == 8)) {
                    editable.append("-");
                }
            }
        });
    }

}
