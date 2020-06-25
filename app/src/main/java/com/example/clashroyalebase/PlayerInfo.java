package com.example.clashroyalebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayerInfo extends AppCompatActivity {

    public static Boolean player_info;

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

    public static TextView tournament_cards_won;






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

    lvl_text = findViewById(R.id.star_text);



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

      best_season = findViewById(R.id.best_season_txt);
        level = findViewById(R.id.level_txt);
        best_season_trophies = findViewById(R.id.best_season_trophies_txt);
        current_trophies = findViewById(R.id.current_trophies_txt);
        previous_season = findViewById(R.id.previeous_season_txt);
        highest_best = findViewById(R.id.personal_best_txt);
        previous_trophies = findViewById(R.id.previous_season_trophies_txt);
        highest_previous_trophies = findViewById(R.id.best_trophies_txt);
        league = findViewById(R.id.league_txt);
        wins = findViewById(R.id.wins_txt);
        max_wins = findViewById(R.id.max_wins_txt);
        cards_won = findViewById(R.id.cards_won_txt);
        three_crown_wins = findViewById(R.id.three_crown_wins_txt);
        losses = findViewById(R.id.losses_txt);
        battle_count = findViewById(R.id.battle_count_txt);
        days_played = findViewById(R.id.days_spent_playing_txt);
        win_rate = findViewById(R.id.win_rate_txt);
        draws = findViewById(R.id.draws_txt);
        battle_count_tournaments = findViewById(R.id.tournament_battle_count_txt);
        tournament_cards_won = findViewById(R.id.tournament_cards_won_txt);

        startActivity(new Intent(this, Player_Buffering.class));


    }
}