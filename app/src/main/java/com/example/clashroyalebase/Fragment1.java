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


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
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
    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_1, container, false);

        player_name = root.findViewById(R.id.player_name);
        arena = root.findViewById(R.id.arena);
        best_season = root.findViewById(R.id.best_season_txt);
        level = root.findViewById(R.id.level_txt);
        best_season_trophies = root.findViewById(R.id.best_season_trophies_txt);
        current_trophies = root.findViewById(R.id.current_trophies_txt);
        previous_season = root.findViewById(R.id.previeous_season_txt);
        highest_best = root.findViewById(R.id.personal_best_txt);
        previous_trophies = root.findViewById(R.id.previous_season_trophies_txt);
        highest_previous_trophies = root.findViewById(R.id.best_trophies_txt);
        league = root.findViewById(R.id.league_txt);
        wins = root.findViewById(R.id.wins_txt);
        max_wins = root.findViewById(R.id.max_wins_txt);
        cards_won = root.findViewById(R.id.cards_won_txt);
        three_crown_wins = root.findViewById(R.id.three_crown_wins_txt);
        losses = root.findViewById(R.id.losses_txt);
        battle_count = root.findViewById(R.id.battle_count_txt);
        days_played = root.findViewById(R.id.days_spent_playing_txt);
        win_rate = root.findViewById(R.id.win_rate_txt);
        draws = root.findViewById(R.id.draws_txt);
        battle_count_tournaments = root.findViewById(R.id.tournament_battle_count_txt);
        tournament_cards_won = root.findViewById(R.id.tournament_cards_won_txt);

        tag = root.findViewById(R.id.tag);
        trophies = root.findViewById(R.id.trophies);
        star_txt = root.findViewById(R.id.star_text);

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




        return root;
    }
}
