package com.example.sweethome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class cooking extends AppCompatActivity {
    int ROUND = 0;
    int LIMIT = 5;
    Intent getIntent = getIntent();
    Intent intentToMain = new Intent(cooking.this,MainActivity.class);
    //Intent intentToBack = new Intent(cooking.this,tutorialActivity.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cooking);
    }
    public void onBack(View view){
        if(ROUND==0){
            /*intentToBack.putExtra("key_positions",getIntent.getIntExtra("key_position",0));
            intentToBack.putExtra("key_titles",getIntent.getStringExtra("key_title"));
            intentToBack.putExtra("key_subtitles",getIntent.getStringExtra("key_subtitle"));
            startActivity(intentToBack);*/
        }else {
            ROUND--;
        }

    }
    public void onFoward(View view){

    }
    public void onComplete(View view){

    }
}