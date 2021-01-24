package com.example.sweethome;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class tutorialActivity extends AppCompatActivity {
    String mTitle, mSubtitle;
    int[] mImage = {R.drawable.cover_bualoy_stick,R.drawable.cover_ko_kati};
    String[] mInclude = {"แป้ง", "ไข่ไก่", "กะทิ", "แป้งข้าวจ้าว", "ไข่ไก่", "กะทิ", "แป้งข้าวจ้าว", "ไข่ไก่", "กะทิ", "แป้งข้าวจ้าว", "ไข่ไก่", "กะทิ", "แป้งข้าวจ้าว", "ไข่ไก่", "กะทิ", "แป้งข้าวจ้าว"};
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        Intent intent = getIntent();
        position = intent.getIntExtra("key_position",0);
        mTitle = intent.getStringExtra("key_title");
        mSubtitle = intent.getStringExtra("key_subtitle");

        TextView vTitle = tutorialActivity.this.findViewById(R.id.text_tuto_title);
        TextView vSubtitle = tutorialActivity.this.findViewById(R.id.text_tuto_subtitle);
        ImageView vImage = tutorialActivity.this.findViewById(R.id.img_cover);

        vTitle.setText(getText(R.string.label_menu)+" "+mTitle);
        vSubtitle.setText(mSubtitle);
        vImage.setImageResource(mImage[position]);

        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,mInclude);
        ListView listView = findViewById(R.id.list_include);
        listView.setAdapter(aa);
    }
    public void onStart(View view){
        Intent intentToTutorial = new Intent(tutorialActivity.this,cookingActivity.class);
        intentToTutorial.putExtra("key_position",position);
        intentToTutorial.putExtra("key_title",mTitle);
        intentToTutorial.putExtra("key_subtitle",mSubtitle);
        startActivity(intentToTutorial);
    }
}