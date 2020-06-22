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

     startActivity(new Intent(this,Player_Buffering.class));



//    for (int i=0; i<14;i++){
//        switch (SlideshowFragment.chest.get(i)){
//            case "Silver Chest":
//                chest_buttons[i].setImageResource(R.drawable.silver_chest);
//                break;
//            case "Giant Chest":
//                chest_buttons[i].setImageResource(R.drawable.giant_chest);
//                break;
//            case "Magical Chest":
//                chest_buttons[i].setImageResource(R.drawable.magical_chest);
//                break;
//            case "Legendary Chest":
//                chest_buttons[i].setImageResource(R.drawable.legendary_chest);
//                break;
//            case "Golden Chest":
//                chest_buttons[i].setImageResource(R.drawable.gold_chest);
//                break;
//            case "Epic Chest":
//                chest_buttons[i].setImageResource(R.drawable.epic_chest);
//                break;
//            case "Mega Lightning Chest":
//                chest_buttons[i].setImageResource(R.drawable.mega_lightning_chest);
//                break;
//        }
//
//       indexs[i].setText("+"+(SlideshowFragment.chestAt.get(i)+1));
//    }
//
//        JSONObject o = SlideshowFragment.obj_player;
//        try {
//        player_name.setText( o.get("name").toString());
//        tag.setText(o.get("tag").toString());
//        trophies.setText(o.get("trophies").toString());
//
//        JSONObject obj = new JSONObject( o.get("arena").toString());
//        String arena_name = obj.get("name").toString();
//
//
//        switch (arena_name){
//            case "Arena 1":
//                arena.setImageResource(R.drawable.arena1);
//                break;
//            case "Arena 2":
//                arena.setImageResource(R.drawable.arena2);
//                break;
//            case "Arena 3":
//                arena.setImageResource(R.drawable.arena3);
//                break;
//            case "Arena 4":
//                arena.setImageResource(R.drawable.arena4);
//                break;
//            case "Arena 5":
//                arena.setImageResource(R.drawable.arena5);
//                break;
//            case "Arena 6":
//                arena.setImageResource(R.drawable.arena6);
//                break;
//            case "Arena 7":
//                arena.setImageResource(R.drawable.arena7);
//                break;
//            case "Arena 8":
//                arena.setImageResource(R.drawable.arena8);
//                break;
//            case "Arena 9":
//                arena.setImageResource(R.drawable.arena9);
//                break;
//            case "Arena 10":
//                arena.setImageResource(R.drawable.arena10);
//                break;
//            case "Arena 11":
//                arena.setImageResource(R.drawable.arena11);
//                break;
//            case "Arena 12":
//                arena.setImageResource(R.drawable.arena12);
//                break;
//            case "Challenger I":
//                arena.setImageResource(R.drawable.challenger1);
//                break;
//            case "Challenger II":
//                arena.setImageResource(R.drawable.challenger2);
//                break;
//            case "Challenger III":
//                arena.setImageResource(R.drawable.challenger3);
//                break;
//            case "Master I":
//                arena.setImageResource(R.drawable.master1);
//                break;
//            case "Master II":
//                arena.setImageResource(R.drawable.master2);
//                break;
//            case "Master III":
//                arena.setImageResource(R.drawable.master3);
//                break;
//            case "Champion":
//                arena.setImageResource(R.drawable.champion);
//                break;
//            case "Grand Champion":
//                arena.setImageResource(R.drawable.grand_champion);
//                break;
//            case "Royal Champion":
//                arena.setImageResource(R.drawable.royal_champion);
//                break;
//            case "Ultimate Champion":
//                arena.setImageResource(R.drawable.ultimate_champion);
//                break;
//        }
//
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

    }
}