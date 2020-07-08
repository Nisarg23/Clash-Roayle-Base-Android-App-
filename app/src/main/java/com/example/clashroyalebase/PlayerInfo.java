package com.example.clashroyalebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.clashroyalebase.ui.slideshow.SlideshowFragment;

public class PlayerInfo extends AppCompatActivity {



    public static ImageView arena;
    public static TextView player_name;
    public static TextView tag;
    public static TextView trophies;

    public static TextView[] indexs;
    public static ImageView[] chest_buttons;

    public static TextView lvl_text;

    public static TextView best_season;
    public static TextView level;

    public static TextView best_season_trophies;
    public static TextView highest_previous_trophies;
    public static TextView current_trophies;
    public static TextView previous_season;
    public static TextView highest_best;
    public static TextView previous_trophies;

    public static TextView league;
    public static TextView wins;
    public static TextView max_wins;
    public static TextView three_crown_wins;
    public static TextView losses;
    public static TextView battle_count;
    public static TextView draws;
    public static TextView win_rate;
    public static TextView cards_won;
    public static TextView battle_count_tournaments;
    public static TextView days_played;
    public static TextView current_highest;

    public static TextView tournament_cards_won;

    public static ImageView chest1;
    public static ImageView chest2;
    public static ImageView chest3;
    public static ImageView chest4;
    public static ImageView chest5;
    public static ImageView chest6;
    public static ImageView chest7;
    public static ImageView chest8;
    public static ImageView chest9;
    public static ImageView chest10;
    public static ImageView chest11;
    public static ImageView chest12;
    public static ImageView chest13;
    public static ImageView chest14;

    public static TextView t1;
    public static TextView t2;
    public static TextView t3;
    public static TextView t4;
    public static TextView t5;
    public static TextView t6;
    public static TextView t7;
    public static TextView t8;
    public static TextView t9;
    public static TextView t10;
    public static TextView t11;
    public static TextView t12;
    public static TextView t13;
    public static TextView t14;

    public static Boolean triggered_refresh = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);
     chest1 = findViewById(R.id.chest1);
       chest2 = findViewById(R.id.chest2);
      chest3 = findViewById(R.id.chest3);
      chest4 = findViewById(R.id.chest4);
       chest5 = findViewById(R.id.chest5);
       chest6 = findViewById(R.id.chest6);
       chest7 = findViewById(R.id.chest7);
      chest8 = findViewById(R.id.chest8);
      chest9 = findViewById(R.id.chest9);
      chest10 = findViewById(R.id.chest10);
      chest11 = findViewById(R.id.chest11);
      chest12 = findViewById(R.id.chest12);
      chest13 = findViewById(R.id.chest13);
      chest14 = findViewById(R.id.chest14);

      t1 = findViewById(R.id.index1);
     t2 = findViewById(R.id.index2);
     t3 = findViewById(R.id.index3);
     t4= findViewById(R.id.index4);
    t5 = findViewById(R.id.index5);
     t6 = findViewById(R.id.index6);
     t7 = findViewById(R.id.index7);
    t8 = findViewById(R.id.index8);
    t9 = findViewById(R.id.index9);
    t10 = findViewById(R.id.index10);
     t11 = findViewById(R.id.index11);
    t12 = findViewById(R.id.index12);
     t13 = findViewById(R.id.index13);
    t14 = findViewById(R.id.index14);




     indexs = new TextView[]{t1,t2,t3,t4,t5,
            t6,t7,t8,t9,t10,t11,t12,t13,t14

    };

      chest_buttons =new ImageView[]{
        chest1, chest2, chest3, chest4,
                chest5, chest6, chest7, chest8, chest9, chest10, chest11, chest12, chest13, chest14
    };

      arena = findViewById(R.id.arena);
    lvl_text = findViewById(R.id.star_text);
     player_name = findViewById(R.id.player_name);
     tag = findViewById(R.id.tag);
     trophies = findViewById(R.id.current_trophies_txt);
      best_season = findViewById(R.id.best_season_txt);
       best_season_trophies = findViewById(R.id.best_season_trophies_txt);
        current_trophies = findViewById(R.id.current_trophies_txt);
        previous_season = findViewById(R.id.previous_season_txt);
        previous_trophies = findViewById(R.id.previous_season_trophies);
        wins = findViewById(R.id.wins_txt);
        losses = findViewById(R.id.losses_txt);
        battle_count = findViewById(R.id.battle_count_txt);
        win_rate = findViewById(R.id.win_rate_txt);
        draws = findViewById(R.id.draws_txt);
        three_crown_wins = findViewById(R.id.three_crown_wins_txt);

        highest_best = findViewById(R.id.personal_best_txt);
        days_played = findViewById(R.id.days_spent_playing_txt);
        battle_count_tournaments = findViewById(R.id.tournament_battle_count_txt);
        tournament_cards_won = findViewById(R.id.tournament_cards_won_txt);
        current_highest = findViewById(R.id.current_highest_trophies_txt);

        startActivity(new Intent(this, Player_Buffering.class));

        Button b = findViewById(R.id.save_tag);



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SlideshowFragment.fm.show(SlideshowFragment.fragment1).commitNow();

                Fragment1.player_name.setText(player_name.getText());
                Fragment1.best_season.setText(best_season.getText());
                Fragment1.best_season_trophies.setText(best_season_trophies.getText());
                Fragment1.current_trophies.setText(current_trophies.getText());
                Fragment1.previous_season.setText(previous_season.getText());
                Fragment1.wins.setText(wins.getText());
                Fragment1.three_crown_wins.setText(three_crown_wins.getText());
                Fragment1.losses.setText(losses.getText());
                Fragment1.battle_count.setText(battle_count.getText());
                Fragment1.days_played.setText(days_played.getText());
                Fragment1.win_rate.setText(win_rate.getText());
                Fragment1.draws.setText(draws.getText());
                Fragment1.battle_count_tournaments.setText(battle_count_tournaments.getText());
                Fragment1.tournament_cards_won.setText(tournament_cards_won.getText());
                Fragment1.highest_best.setText(highest_best.getText());
                Fragment1.previous_trophies.setText(previous_trophies.getText());
                Fragment1.tag.setText(tag.getText());
                Fragment1.trophies.setText(trophies.getText());
                Fragment1.star_txt.setText(lvl_text.getText());
                Fragment1.current_highest.setText(current_highest.getText());

                Fragment1.t1.setText(t1.getText());
                Fragment1.t2.setText(t2.getText());
                Fragment1.t3.setText(t3.getText());
                Fragment1.t4.setText(t4.getText());
                Fragment1.t5.setText(t5.getText());
                Fragment1.t6.setText(t6.getText());
                Fragment1.t7.setText(t7.getText());
                Fragment1.t8.setText(t8.getText());
                Fragment1.t9.setText(t9.getText());
                Fragment1.t10.setText(t10.getText());
                Fragment1.t11.setText(t11.getText());
                Fragment1.t12.setText(t12.getText());
                Fragment1.t13.setText(t13.getText());
                Fragment1.t14.setText(t14.getText());


                Fragment1.arena.setImageDrawable(arena.getDrawable());
                Fragment1.arena.setTag(arena.getTag());
                Fragment1.chest1.setImageDrawable(chest1.getDrawable());
                Fragment1.chest1.setTag(chest1.getTag());
                Fragment1.chest2.setImageDrawable(chest2.getDrawable());
                Fragment1.chest2.setTag(chest2.getTag());
                Fragment1.chest3.setImageDrawable(chest3.getDrawable());
                Fragment1.chest3.setTag(chest3.getTag());
                Fragment1.chest4.setImageDrawable(chest4.getDrawable());
                Fragment1.chest4.setTag(chest4.getTag());
                Fragment1.chest5.setImageDrawable(chest5.getDrawable());
                Fragment1.chest5.setTag(chest5.getTag());
                Fragment1.chest6.setImageDrawable(chest6.getDrawable());
                Fragment1.chest6.setTag(chest6.getTag());
                Fragment1.chest7.setImageDrawable(chest7.getDrawable());
                Fragment1.chest7.setTag(chest7.getTag());
                Fragment1.chest8.setImageDrawable(chest8.getDrawable());
                Fragment1.chest8.setTag(chest8.getTag());
                Fragment1.chest9.setImageDrawable(chest9.getDrawable());
                Fragment1.chest9.setTag(chest9.getTag());
                Fragment1.chest10.setImageDrawable(chest10.getDrawable());
                Fragment1.chest10.setTag(chest10.getTag());
                Fragment1.chest11.setImageDrawable(chest11.getDrawable());
                Fragment1.chest11.setTag(chest11.getTag());
                Fragment1.chest12.setImageDrawable(chest12.getDrawable());
                Fragment1.chest12.setTag(chest12.getTag());
                Fragment1.chest13.setImageDrawable(chest13.getDrawable());
                Fragment1.chest13.setTag(chest13.getTag());
                Fragment1.chest14.setImageDrawable(chest14.getDrawable());
                Fragment1.chest14.setTag(chest14.getTag());



                SlideshowFragment.refresh.setVisibility(View.VISIBLE);


                finish();
            }
        });

        if (triggered_refresh == true){
            finish();
        }


    }



}