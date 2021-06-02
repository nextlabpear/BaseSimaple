package com.nextlabpear.basesimple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class TreeActivity extends AppCompatActivity {

    TextView mTreeTV = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree);

        mTreeTV = findViewById(R.id.treeTV);
        makeTree(7);

    }


    private void makeTree(int n) {

        String result = "";
        for( int i = 0; i < n; i++)
        {
            for( int step = 1; step < n-i; step++ ){
                result = result.concat(" ");
            }
            for(  int star = 0; star < i*2+1; star++ ) {
                result = result.concat("*");
            }
            result = result.concat("\r\n");
        }

        Log.i( "BaseSimple", result);

        mTreeTV.setText(result);



    }



}