package com.example.qazpl.entreprenuership;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class DemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        Button btn1 = (Button) findViewById(R.id.btn1);
        Button btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DemoActivity.this, "Processing : IN", Toast.LENGTH_LONG).show();
                new HttpPostRequest().execute("3", "010-2999-4263");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DemoActivity.this, "Processing : DEPOSIT", Toast.LENGTH_LONG).show();
                new HttpPostRequest().execute("4", "010-2999-4263");

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DemoActivity.this, "Processing : OUT", Toast.LENGTH_LONG).show();
                new HttpPostRequest().execute("5", "010-2999-4263");

            }
        });


    }

    public class HttpPostRequest extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... info) {
            String sResult = "Error";

            try {
                URL url = new URL("http://52.78.239.42/trade.php");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                conn.setRequestMethod("POST");
                String body = "op=" + info[0] + "&"
                        + "phone=" + info[1];

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
                sResult = builder.toString();
                Log.e("CHECK", sResult);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return sResult;

        }


        @Override
        protected void onPostExecute(String result) {
            Log.e("RESULT", result);


        }

    }
}
