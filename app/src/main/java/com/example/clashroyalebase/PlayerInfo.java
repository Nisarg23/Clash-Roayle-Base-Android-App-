package com.example.clashroyalebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.clashroyalebase.ui.slideshow.SlideshowFragment;

import org.json.JSONException;
import org.json.JSONObject;

public class PlayerInfo extends AppCompatActivity {

    public static Boolean player_info;

    public static ImageView arena;
    public static TextView player_name;
    public static TextView tag;
    public static TextView trophies;

    public static TextView[] indexs;
    public static ImageView[] chest_buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);
    ImageView chest1 = findViewById(R.id.chest1);
      ImageView chest2 = findViewById(R.id.chest2);
      ImageView chest3 = findViewById(R.id.chest3);
      ImageView chest4 = findViewById(R.id.chest4);
      ImageView chest5 = findViewById(R.id.chest5);
      ImageView chest6 = findViewById(R.id.chest6);
      ImageView chest7 = findViewById(R.id.chest7);
     ImageView chest8 = findViewById(R.id.chest8);
     ImageView chest9 = findViewById(R.id.chest9);
     ImageView chest10 = findViewById(R.id.chest10);
     ImageView chest11 = findViewById(R.id.chest11);
     ImageView chest12 = findViewById(R.id.chest12);
     ImageView chest13 = findViewById(R.id.chest13);
     ImageView chest14 = findViewById(R.id.chest14);

     TextView t1 = findViewById(R.id.index1);
    TextView t2 = findViewById(R.id.index2);
    TextView t3 = findViewById(R.id.index3);
    TextView t4= findViewById(R.id.index4);
    TextView t5 = findViewById(R.id.index5);
    TextView t6 = findViewById(R.id.index6);
    TextView t7 = findViewById(R.id.index7);
    TextView t8 = findViewById(R.id.index8);
    TextView t9 = findViewById(R.id.index9);
    TextView t10 = findViewById(R.id.index10);
    TextView t11 = findViewById(R.id.index11);
    TextView t12 = findViewById(R.id.index12);
    TextView t13 = findViewById(R.id.index13);
    TextView t14 = findViewById(R.id.index14);

     player_name = findViewById(R.id.player_name);
     tag = findViewById(R.id.tag);

     trophies = findViewById(R.id.trophies);


     indexs = new TextView[]{t1,t2,t3,t4,t5,
            t6,t7,t8,t9,t10,t11,t12,t13,t14

    };

      chest_buttons =new ImageView[]{
        chest1, chest2, chest3, chest4,
                chest5, chest6, chest7, chest8, chest9, chest10, chest11, chest12, chest13, chest14
    };

      arena = findViewById(R.id.arena);

        startActivity(new Intent(this, Player_Buffering.class));


    }
}