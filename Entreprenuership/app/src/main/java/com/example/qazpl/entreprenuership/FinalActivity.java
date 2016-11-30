package com.example.qazpl.entreprenuership;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {
    Context mContext;
    Intent intent;
    TextView account;
    TextView password;
    Boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deal);
        mContext = this;
        intent=getIntent();
        String person = intent.getStringExtra("person");
        TextView status_0 = (TextView) findViewById(R.id.status_0);
        TextView status_1 = (TextView) findViewById(R.id.status_1);
        TextView status_2 = (TextView) findViewById(R.id.status_2);
        TextView status_3 = (TextView) findViewById(R.id.status_3);
        TextView status_4 = (TextView) findViewById(R.id.status_4);
        account = (TextView) findViewById(R.id.account);
        password = (TextView) findViewById(R.id.password);
        if(person.equals("buyer")) flag = true;
        if(flag){
            status_0.setTextColor(Color.parseColor("#bdbdbd"));
            status_1.setTextColor(Color.parseColor("#ffffff"));
            status_1.setTypeface(null, Typeface.BOLD);
            status_2.setTextColor(Color.parseColor("#bdbdbd"));
            status_3.setTextColor(Color.parseColor("#bdbdbd"));
            status_4.setTextColor(Color.parseColor("#bdbdbd"));
            account.setText("KB 7347562-01-129986");
        }

    }

    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            int status = intent.getIntExtra("statusID",0);
            Log.d("Fire","status = " + status);
            TextView status_0 = (TextView) findViewById(R.id.status_0);
            TextView status_1 = (TextView) findViewById(R.id.status_1);
            TextView status_2 = (TextView) findViewById(R.id.status_2);
            TextView status_3 = (TextView) findViewById(R.id.status_3);
            TextView status_4 = (TextView) findViewById(R.id.status_4);

            switch (status) {
                case 0 :
                    status_0.setTextColor(Color.parseColor("#ffffff"));
                    status_0.setTypeface(null, Typeface.BOLD);
                    status_1.setTextColor(Color.parseColor("#bdbdbd"));
                    status_2.setTextColor(Color.parseColor("#bdbdbd"));
                    status_3.setTextColor(Color.parseColor("#bdbdbd"));
                    status_4.setTextColor(Color.parseColor("#bdbdbd"));
                    break;
                case 1 :
                    status_0.setTextColor(Color.parseColor("#bdbdbd"));
                    status_1.setTextColor(Color.parseColor("#ffffff"));
                    status_1.setTypeface(null, Typeface.BOLD);
                    status_2.setTextColor(Color.parseColor("#bdbdbd"));
                    status_3.setTextColor(Color.parseColor("#bdbdbd"));
                    status_4.setTextColor(Color.parseColor("#bdbdbd"));
                    break;
                case 2 :
                    status_0.setTextColor(Color.parseColor("#bdbdbd"));
                    status_1.setTextColor(Color.parseColor("#bdbdbd"));
                    status_2.setTextColor(Color.parseColor("#ffffff"));
                    status_2.setTypeface(null, Typeface.BOLD);
                    status_3.setTextColor(Color.parseColor("#bdbdbd"));
                    status_4.setTextColor(Color.parseColor("#bdbdbd"));
                    break;
                case 3 :
                    status_0.setTextColor(Color.parseColor("#bdbdbd"));
                    status_1.setTextColor(Color.parseColor("#bdbdbd"));
                    status_2.setTextColor(Color.parseColor("#bdbdbd"));
                    status_3.setTextColor(Color.parseColor("#ffffff"));
                    status_3.setTypeface(null, Typeface.BOLD);
                    status_4.setTextColor(Color.parseColor("#bdbdbd"));
                    if(flag) password.setText("AxK12Uz");
                    break;
                case 4 :
                    status_0.setTextColor(Color.parseColor("#bdbdbd"));
                    status_1.setTextColor(Color.parseColor("#bdbdbd"));
                    status_2.setTextColor(Color.parseColor("#bdbdbd"));
                    status_3.setTextColor(Color.parseColor("#bdbdbd"));
                    status_4.setTextColor(Color.parseColor("#ffffff"));
                    status_4.setTypeface(null, Typeface.BOLD);
                    break;
            }
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        mContext.registerReceiver(mReceiver, new IntentFilter("status"));
    }

    ;

    @Override
    public void onPause() {
        super.onPause();
        mContext.unregisterReceiver(mReceiver);
    }
}
