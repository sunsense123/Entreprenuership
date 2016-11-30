package com.example.qazpl.entreprenuership;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
                //Intent mintent = new Intent();
                //mintent.setClass(MainActivity.this,FinalActivity.class);
                //startActivity(mintent);
                new HttpPostRequest().execute("2","010-2999-4263","123","123",FirebaseInstanceId.getInstance().getToken());

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
                Log.d("Fire", sResult);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sResult;
        }

        @Override
        protected void onPostExecute(String result){

            Intent intent = new Intent(MainActivity.this,FinalActivity.class);
            //    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("person","buyer");
            startActivity(intent);
            overridePendingTransition(R.anim.in_from_right,R.anim.out_to_left);
            finish();
        }
    }
}
