package com.example.sweethome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onCook(View view){
        Intent intent = new Intent(MainActivity.this, foodListActivity.class);
        startActivity(intent);
    }
    public void onFav(View view){
        Intent intent = new Intent(MainActivity.this, favListActivity.class);
        startActivity(intent);
    }
    public void onQuit(View view){
        finish();
    }
}