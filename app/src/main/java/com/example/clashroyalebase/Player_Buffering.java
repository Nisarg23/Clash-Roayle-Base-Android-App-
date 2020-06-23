package com.example.clashroyalebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.clashroyalebase.ui.slideshow.SlideshowFragment;

import org.json.JSONException;
import org.json.JSONObject;

public class Player_Buffering extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player__buffering);

        final ImageView arena = PlayerInfo.arena;
        final ImageView[] chest_buttons = PlayerInfo.chest_buttons;

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {



                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
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

                            PlayerInfo.indexs[i].setText("+"+(SlideshowFragment.chestAt.get(i)+1));
                        }

                        JSONObject o = SlideshowFragment.obj_player;
                        try {
                            PlayerInfo.player_name.setText( o.get("name").toString());
                            PlayerInfo.tag.setText(o.get("tag").toString());
                            PlayerInfo.trophies.setText(o.get("trophies").toString());

                            JSONObject obj = new JSONObject( o.get("arena").toString());
                            String arena_name = obj.get("name").toString();


                            switch (arena_name){
                                case "Arena 1":
                                    arena.setImageResource(R.drawable.arena1);
                                    break;
                                case "Arena 2":
                                    arena.setImageResource(R.drawable.arena2);
                                    break;
                                case "Arena 3":
                                    arena.setImageResource(R.drawable.arena3);
                                    break;
                                case "Arena 4":
                                    arena.setImageResource(R.drawable.arena4);
                                    break;
                                case "Arena 5":
                                    arena.setImageResource(R.drawable.arena5);
                                    break;
                                case "Arena 6":
                                    arena.setImageResource(R.drawable.arena6);
                                    break;
                                case "Arena 7":
                                    arena.setImageResource(R.drawable.arena7);
                                    break;
                                case "Arena 8":
                                    arena.setImageResource(R.drawable.arena8);
                                    break;
                                case "Arena 9":
                                    arena.setImageResource(R.drawable.arena9);
                                    break;
                                case "Arena 10":
                                    arena.setImageResource(R.drawable.arena10);
                                    break;
                                case "Arena 11":
                                    arena.setImageResource(R.drawable.arena11);
                                    break;
                                case "Arena 12":
                                    arena.setImageResource(R.drawable.arena12);
                                    break;
                                case "Challenger I":
                                    arena.setImageResource(R.drawable.challenger1);
                                    break;
                                case "Challenger II":
                                    arena.setImageResource(R.drawable.challenger2);
                                    break;
                                case "Challenger III":
                                    arena.setImageResource(R.drawable.challenger3);
                                    break;
                                case "Master I":
                                    arena.setImageResource(R.drawable.master1);
                                    break;
                                case "Master II":
                                    arena.setImageResource(R.drawable.master2);
                                    break;
                                case "Master III":
                                    arena.setImageResource(R.drawable.master3);
                                    break;
                                case "Champion":
                                    arena.setImageResource(R.drawable.champion);
                                    break;
                                case "Grand Champion":
                                    arena.setImageResource(R.drawable.grand_champion);
                                    break;
                                case "Royal Champion":
                                    arena.setImageResource(R.drawable.royal_champion);
                                    break;
                                case "Ultimate Champion":
                                    arena.setImageResource(R.drawable.ultimate_champion);
                                    break;
                            }





                        } catch (JSONException e) {
                            e.printStackTrace();
                           finish();
                        }

                    }
                });
            }

        }).start();
        finish();
    }
}
