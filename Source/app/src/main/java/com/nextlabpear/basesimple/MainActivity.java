package com.nextlabpear.basesimple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }






    public void intent(){
        Intent nIntent = new Intent(this.getApplicationContext(), SubSaimpleActivity.class);
        nIntent.putExtra("key", "value");
        startActivity(nIntent);
    }


    final Handler mHandlerRefresh = new Handler( Looper.myLooper());
    public void postDelay(){
        mHandlerRefresh.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        }, 3000);
    }

    public void uiThread(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}