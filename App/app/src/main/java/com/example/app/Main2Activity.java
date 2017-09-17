package com.example.app;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    private Button readbtn,inbtn,chabtn,posbtn;
    private WifiManager wifiManager;
    private WifiInfo wifiInfo;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        readbtn= (Button) findViewById(R.id.readbtn);
        inbtn= (Button) findViewById(R.id.inbtn);
        chabtn= (Button) findViewById(R.id.chabtn);
        text= (TextView) findViewById(R.id.text);
        posbtn= (Button) findViewById(R.id.posbtn);
        readbtn.setOnClickListener(this);
        inbtn.setOnClickListener(this);
        chabtn.setOnClickListener(this);
        posbtn.setOnClickListener(this);
        getLocalip();



    }

    private void getLocalip() {
        wifiManager= (WifiManager) getSystemService(Context.WIFI_SERVICE);
        wifiInfo=wifiManager.getConnectionInfo();
        int i=wifiInfo.getIpAddress();
        text.setText((i & 0xFF) + "." + ((i >> 8) & 0xFF) + "." + ((i >> 16) & 0xFF)+ "." + (i >> 24 & 0xFF));


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.readbtn:
                Intent intent=new Intent(Main2Activity.this,ReadActivity.class);
                startActivity(intent);
                break;
            case R.id.inbtn:
                Intent intent1=new Intent(Main2Activity.this,InputActivity.class);
                startActivity(intent1);
                break;
            case R.id.chabtn:
                Intent intent2=new Intent(Main2Activity.this,SearchActivity.class);
                startActivity(intent2);
                break;
            case R.id.posbtn:
                Intent intent3=new Intent(Main2Activity.this,PositionActivity.class);
                startActivity(intent3);
                break;

        }

    }
}
