package com.example.clashroyalebase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.clashroyalebase.ui.slideshow.SlideshowFragment;



public class Fragment1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public static ImageView arena;
    public static TextView player_name;


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

    public static TextView tag;

    public static TextView trophies;
    public static TextView star_txt;

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

    public static Button refresh;

    public static ImageView current_arena;
    public static ImageView previous_arena;
    public static ImageView best_arena;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_1, container, false);

        player_name = root.findViewById(R.id.player_name);
        arena = root.findViewById(R.id.arena);
        best_season = root.findViewById(R.id.best_season_txt);
        best_season_trophies = root.findViewById(R.id.best_season_trophies_txt);
        current_trophies = root.findViewById(R.id.current_trophies_txt);
        highest_best = root.findViewById(R.id.personal_best_txt);
        wins = root.findViewById(R.id.wins_txt);
        three_crown_wins = root.findViewById(R.id.three_crown_wins_txt);
        losses = root.findViewById(R.id.losses_txt);
        battle_count = root.findViewById(R.id.battle_count_txt);
        days_played = root.findViewById(R.id.days_spent_playing_txt);
        win_rate = root.findViewById(R.id.win_rate_txt);
        draws = root.findViewById(R.id.draws_txt);
        battle_count_tournaments = root.findViewById(R.id.tournament_battle_count_txt);
        tournament_cards_won = root.findViewById(R.id.tournament_cards_won_txt);
        previous_season = root.findViewById(R.id.previous_season_txt);
        previous_trophies = root.findViewById(R.id.previous_season_trophies);
        tag = root.findViewById(R.id.tag);
        trophies = root.findViewById(R.id.current_trophies_txt);
        star_txt = root.findViewById(R.id.star_text);
        current_highest = root.findViewById(R.id.current_highest_trophies_txt);

        current_arena = root.findViewById(R.id.currentArena);
        best_arena = root.findViewById(R.id.bestArena);
        previous_arena = root.findViewById(R.id.previousArena);



         chest1 = root.findViewById(R.id.chest1);
         chest2 = root.findViewById(R.id.chest2);
         chest3 = root.findViewById(R.id.chest3);
         chest4 = root.findViewById(R.id.chest4);
         chest5 = root.findViewById(R.id.chest5);
         chest6 = root.findViewById(R.id.chest6);
         chest7 = root.findViewById(R.id.chest7);
         chest8 = root.findViewById(R.id.chest8);
         chest9 = root.findViewById(R.id.chest9);
         chest10 = root.findViewById(R.id.chest10);
         chest11 = root.findViewById(R.id.chest11);
         chest12 = root.findViewById(R.id.chest12);
         chest13 = root.findViewById(R.id.chest13);
         chest14 = root.findViewById(R.id.chest14);

        t1 = root.findViewById(R.id.index1);
         t2 = root.findViewById(R.id.index2);
         t3 = root.findViewById(R.id.index3);
         t4= root.findViewById(R.id.index4);
         t5 = root.findViewById(R.id.index5);
         t6 = root.findViewById(R.id.index6);
         t7 = root.findViewById(R.id.index7);
         t8 = root.findViewById(R.id.index8);
         t9 = root.findViewById(R.id.index9);
         t10 = root.findViewById(R.id.index10);
         t11 = root.findViewById(R.id.index11);
         t12 = root.findViewById(R.id.index12);
         t13 = root.findViewById(R.id.index13);
         t14 = root.findViewById(R.id.index14);

         if (SlideshowFragment.saved == true) {
             player_name.setText(SlideshowFragment.player_name);
             best_season.setText(SlideshowFragment.best_season);
             best_season_trophies.setText(SlideshowFragment.best_season_trophies);
             current_trophies.setText(SlideshowFragment.current_trophies);
             wins.setText(SlideshowFragment.wins);
             three_crown_wins.setText(SlideshowFragment.three_crown_wins);
             losses.setText(SlideshowFragment.losses);
             battle_count.setText(SlideshowFragment.battle_count);
             days_played.setText(SlideshowFragment.days_played);
             win_rate.setText(SlideshowFragment.win_rate);
             draws.setText(SlideshowFragment.draws);
             battle_count_tournaments.setText(SlideshowFragment.battle_count_tournaments);
             tournament_cards_won.setText(SlideshowFragment.tournament_cards_won);
             highest_best.setText(SlideshowFragment.highest_best);
             previous_trophies.setText(SlideshowFragment.previous_trophies);
             tag.setText(SlideshowFragment.tag);
             trophies.setText(SlideshowFragment.trophies);
             star_txt.setText(SlideshowFragment.lvl_text);
             current_highest.setText(SlideshowFragment.current_highest);
             previous_season.setText(SlideshowFragment.previous_season);


             t1.setText(SlideshowFragment.t1);
             t2.setText(SlideshowFragment.t2);
             t3.setText(SlideshowFragment.t3);
             t4.setText(SlideshowFragment.t4);
             t5.setText(SlideshowFragment.t5);
             t6.setText(SlideshowFragment.t6);
             t7.setText(SlideshowFragment.t7);
             t8.setText(SlideshowFragment.t8);
             t9.setText(SlideshowFragment.t9);
             t10.setText(SlideshowFragment.t10);
             t11.setText(SlideshowFragment.t11);
             t12.setText(SlideshowFragment.t12);
             t13.setText(SlideshowFragment.t13);
             t14.setText(SlideshowFragment.t14);

             if (SlideshowFragment.chest1 !=0){
                 chest1.setImageResource(SlideshowFragment.chest1);
             }
             if (SlideshowFragment.chest2 !=0){
                 chest2.setImageResource(SlideshowFragment.chest2);
             }
             if (SlideshowFragment.chest3 !=0){
                 chest3.setImageResource(SlideshowFragment.chest3);
             }
             if (SlideshowFragment.chest4 !=0){
                 chest4.setImageResource(SlideshowFragment.chest4);
             }
             if (SlideshowFragment.chest5 !=0){
                 chest5.setImageResource(SlideshowFragment.chest5);
             }
             if (SlideshowFragment.chest6 !=0){
                 chest6.setImageResource(SlideshowFragment.chest6);
             }
             if (SlideshowFragment.chest7 !=0){
                 chest7.setImageResource(SlideshowFragment.chest7);
             }
             if (SlideshowFragment.chest8 !=0){
                 chest8.setImageResource(SlideshowFragment.chest8);
             }
             if (SlideshowFragment.chest9 !=0){
                 chest9.setImageResource(SlideshowFragment.chest9);
             }
             if (SlideshowFragment.chest10 !=0){
                 chest10.setImageResource(SlideshowFragment.chest10);
             }
             if (SlideshowFragment.chest11 !=0){
                 chest11.setImageResource(SlideshowFragment.chest11);
             }
             if (SlideshowFragment.chest12 !=0){
                 chest12.setImageResource(SlideshowFragment.chest12);
             }
             if (SlideshowFragment.chest13 !=0){
                 chest13.setImageResource(SlideshowFragment.chest13);
             }
             if (SlideshowFragment.chest14 !=0){
                 chest14.setImageResource(SlideshowFragment.chest14);
             }

             if (SlideshowFragment.arena !=0){
                 arena.setImageResource(SlideshowFragment.arena);
             }
             if (SlideshowFragment.current_arena !=0){
                 current_arena.setImageResource(SlideshowFragment.current_arena);
             }
             if (SlideshowFragment.previous_arena !=0){
                 previous_arena.setImageResource(SlideshowFragment.previous_arena);
             }
             if (SlideshowFragment.best_arena !=0){
                 best_arena.setImageResource(SlideshowFragment.best_arena);
             }
         }



        return root;
    }

}
