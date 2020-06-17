package com.example.clashroyalebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.clashroyalebase.ui.slideshow.SlideshowFragment;

public class PlayerInfo extends AppCompatActivity {



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

     ImageView[] chest_buttons =new ImageView[]{
        chest1, chest2, chest3, chest4,
                chest5, chest6, chest7, chest8, chest9, chest10, chest11, chest12, chest13, chest14
    };

    for (int i=0; i<14;i++){
        switch (SlideshowFragment.chest.get(i)){
            case "Silver Chest":
                chest_buttons[i].setImageResource(R.drawable.silver_chest);
                break;
            case "Giant Chest":
                chest_buttons[i].setImageResource(R.drawable.giant_chest);
                break;
            case "Magical Chest":
                chest_buttons[i].setImageResource(R.drawable.magical_chest);
                break;
            case "Legendary Chest":
                chest_buttons[i].setImageResource(R.drawable.legendary_chest);
                break;
            case "Golden Chest":
                chest_buttons[i].setImageResource(R.drawable.gold_chest);
                break;
            case "Epic Chest":
                chest_buttons[i].setImageResource(R.drawable.epic_chest);
                break;
            case "Mega Lightning Chest":
                chest_buttons[i].setImageResource(R.drawable.mega_lightning_chest);
                break;
        }
    }

    }
}