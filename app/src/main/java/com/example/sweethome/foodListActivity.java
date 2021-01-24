package com.example.sweethome;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class foodListActivity extends AppCompatActivity {
    ListView listView;
    String[] mTitle = {"บัวลอยเสียบไม้", "ขนมโคกะทิ"};
    String[] mSubtitle = {"เปลี่ยนบัวลอยธรรมดาให้น่ากินมากขึ้นกับเมนู \"บัวลอยเสียบไม้\"","อยู่บ้านฟิน ๆ กินขนมไทย \"ขนมโคกะทิ\" ที่ทำเองง่าย ๆ"};
    int[] mImage = {R.drawable.thumbnail_bualoy_stick,R.drawable.thumbnal_ko_kati};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        listView = (ListView) findViewById(R.id.list_item);
        MyAdapter myAdapter = new MyAdapter(this,mTitle,mSubtitle,mImage);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(foodListActivity.this,tutorialActivity.class);
                intent.putExtra("key_position",position);
                intent.putExtra("key_title",mTitle[position]);
                intent.putExtra("key_subtitle",mSubtitle[position]);
                startActivity(intent);
            }
        });
    }
    public class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        String rSubtitle[];
        int rImage[];

        //LOAD DATA from PARAMETER
        MyAdapter(Context _c, String _title[], String _subtitle[], int _img[]){
            super(_c, R.layout.row_food, R.id.text_title, _title);
            this.context = _c;
            this.rTitle = _title;
            this.rSubtitle = _subtitle;
            this.rImage = _img;
        }

        //LOAD VIEW AND SET CONTENT on VIEW
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
            //LOAD CONTEXT SERVICE
            LayoutInflater inflater =(LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //LOAD VIEW BY LAYOUT
            View row_food = inflater.inflate(R.layout.row_food,parent,false);
            //LOAD OBJECT ON VIEW
            TextView vTitle = row_food.findViewById(R.id.text_title);
            TextView vSubtitle = row_food.findViewById(R.id.text_subtitle);
            ImageView vImage = row_food.findViewById(R.id.img_thumbnail);
            //SET CONTENT ON OBJ
            vTitle.setText(rTitle[position]);
            vSubtitle.setText(rSubtitle[position]);
            vImage.setImageResource(rImage[position]);
            return row_food;
        }
    }
}