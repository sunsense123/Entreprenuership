package com.example.qazpl.entreprenuership;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.iid.FirebaseInstanceId;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ThirdActivity extends AppCompatActivity {
    String name;
    String phone;
    String price;
    String place;
    String bank;
    String bank_name;
    EditText edt1;
    EditText edt2;
    String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_2);
        token = FirebaseInstanceId.getInstance().getToken();

        edt1 = (EditText) findViewById(R.id.edt_bank);
        edt2 = (EditText) findViewById(R.id.edt_bank_name);
        Intent ForGet = getIntent();
        name = ForGet.getStringExtra("name");
        phone = ForGet.getStringExtra("phone");
        price = ForGet.getStringExtra("price");
        place = ForGet.getStringExtra("place");

        Button btn1 = (Button) findViewById(R.id.btn_next_2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                new HttpPostRequest().execute("1", phone, name, price, token);


            }
        });
    }

    private class HttpPostRequest extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... info) {
            String sResult = "Error";

            try {
                URL url = new URL("http://52.78.239.42/trade.php");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                conn.setRequestMethod("POST");
                String body = "op=" + info[0] +"&"
                        +"phone=" + info[1] + "&"
                        +"product=" + info[2] + "&"
                        +"price=" + info[3] + "&"
                        +"token=" + info[4];

                OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
                osw.write(body);
                osw.flush();

                InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8");
                BufferedReader reader = new BufferedReader(tmp);
                StringBuilder builder = new StringBuilder();
                String str;

                while ((str = reader.readLine()) != null) {
                    builder.append(str);
                }
                sResult     = builder.toString();
                Log.e("CHECK", sResult);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sResult;
        }

        @Override
        protected void onPostExecute(String result){

            Intent intent = new Intent(ThirdActivity.this,FinalActivity.class);
      //    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("person","seller");
            startActivity(intent);
            overridePendingTransition(R.anim.in_from_right,R.anim.out_to_left);
            finish();
        }
    }

}
