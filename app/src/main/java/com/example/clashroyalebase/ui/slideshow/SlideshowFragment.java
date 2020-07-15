package com.example.clashroyalebase.ui.slideshow;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.clashroyalebase.Fragment1;
import com.example.clashroyalebase.PlayerInfo;
import com.example.clashroyalebase.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    public static EditText player_tag;
    public static Button search_player;

    static Boolean invalid;
    public static JSONArray arr;

    public static Button refresh;


    JSONObject obj;
    public static JSONObject obj_player;

    public static String base_url = "https://api.clashroyale.com/v1/players/";
    public static String url_player;
    public static String url_chest;

    public static ArrayList<String> chest = new ArrayList<String>();
    public static ArrayList<Integer> chestAt = new ArrayList<Integer>();

    public static Fragment fragment1;
    public static FragmentTransaction fm;

    public static final String key = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6IjVmYjEyNDI0LWIwODEtNDMwNC05MWQ0LTlkNjIyYmEwN2M5OSIsImlhdCI6MTU5MjIzNDk3MSwic3ViIjoiZGV2ZWxvcGVyLzBlZjM4ZDg5LWI1MjItYThhMC01YWE2LTQ1OGZlNjZmMTM4ZSIsInNjb3BlcyI6WyJyb3lhbGUiXSwibGltaXRzIjpbeyJ0aWVyIjoiZGV2ZWxvcGVyL3NpbHZlciIsInR5cGUiOiJ0aHJvdHRsaW5nIn0seyJjaWRycyI6WyIyNC4yMzUuMjEwLjc2Il0sInR5cGUiOiJjbGllbnQifV19.aCOBc9Gg2fyKCcd4GiyO3kKvG5tPWp52vWWLdJ_L8e_8WB9WVAorbx3fTiej3dfIbIK7rCKveNVwTUdWCLBJ3w";


    public static Integer arena;
    public static String player_name;
    public static String tag;
    public static String trophies;

    public static String lvl_text;

    public static String best_season;
    public static String level;

    public static String best_season_trophies;
    public static String highest_previous_trophies;
    public static String current_trophies;
    public static String previous_season;
    public static String highest_best;
    public static String previous_trophies;

    public static String league;
    public static String wins;
    public static String max_wins;
    public static String three_crown_wins;
    public static String losses;
    public static String battle_count;
    public static String draws;
    public static String win_rate;
    public static String cards_won;
    public static String battle_count_tournaments;
    public static String days_played;
    public static String current_highest;

    public static String tournament_cards_won;

    public static Integer chest1;
    public static Integer chest2;
    public static Integer chest3;
    public static Integer chest4;
    public static Integer chest5;
    public static Integer chest6;
    public static Integer chest7;
    public static Integer chest8;
    public static Integer chest9;
    public static Integer chest10;
    public static Integer chest11;
    public static Integer chest12;
    public static Integer chest13;
    public static Integer chest14;

    public static String t1;
    public static String t2;
    public static String t3;
    public static String t4;
    public static String t5;
    public static String t6;
    public static String t7;
    public static String t8;
    public static String t9;
    public static String t10;
    public static String t11;
    public static String t12;
    public static String t13;
    public static String t14;

    public static Integer current_arena;
    public static Integer previous_arena;
    public static Integer best_arena;

    public static Boolean saved = false;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        player_tag = root.findViewById(R.id.player_tag);
        search_player = root.findViewById(R.id.search_player);



        getChildFragmentManager().beginTransaction().add(R.id.child_fragment_container,new Fragment1(),"fragment1").commitNow();
        fragment1 = getChildFragmentManager().findFragmentByTag("fragment1");
         fm = getChildFragmentManager().beginTransaction();
        fm.hide(fragment1).commitNow();

        refresh = root.findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = (String) Fragment1.tag.getText();
                s = s.substring(1);
                SlideshowFragment.player_tag.setText(s);
                PlayerInfo.triggered_refresh = true;
                search_player.performClick();

            }
        });


        searchButtonListener();
        playerTagListener();

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("AppData", Context.MODE_PRIVATE);
         player_name = sharedPreferences.getString("playerName","");

        if (!player_name.equals("")){
            saved = true;
            fm.show(fragment1).commitNow();
            player_name = sharedPreferences.getString("playerName","");
            best_season = sharedPreferences.getString("bestSeason","");
            level = sharedPreferences.getString("level","");
            best_season_trophies = sharedPreferences.getString("bestSeasonTrophies","");
            current_trophies = sharedPreferences.getString("currentTrophies","");
            previous_season = sharedPreferences.getString("previousSeason","");
            highest_previous_trophies = sharedPreferences.getString("highestPreviousTrophies","");
            wins = sharedPreferences.getString("wins","");
            max_wins = sharedPreferences.getString("maxWins","");
            cards_won = sharedPreferences.getString("cardsWon","");
            three_crown_wins = sharedPreferences.getString("threeCrownWins","");
            losses = sharedPreferences.getString("losses","");
            days_played = sharedPreferences.getString("daysPlayed","");
            win_rate = sharedPreferences.getString("winRate","");
            draws = sharedPreferences.getString("Draws","");
            battle_count = sharedPreferences.getString("battleCount","");
            battle_count_tournaments = sharedPreferences.getString("battleCountTournaments","");
            tournament_cards_won = sharedPreferences.getString("tournamentCardsWon","");
            highest_best = sharedPreferences.getString("highestBest","");
            previous_trophies = sharedPreferences.getString("previousTrophies","");
            tag = sharedPreferences.getString("tag","");
            trophies = sharedPreferences.getString("trophies","");
            lvl_text = sharedPreferences.getString("starText","");
            league = sharedPreferences.getString("league","");
            current_highest = sharedPreferences.getString("currentHighest","");




            t1 = sharedPreferences.getString("t1","");
            t2 = sharedPreferences.getString("t2","");
            t3 = sharedPreferences.getString("t3","");
            t4 = sharedPreferences.getString("t4","");
            t5 = sharedPreferences.getString("t5","");
            t6 = sharedPreferences.getString("t6","");
            t7 = sharedPreferences.getString("t7","");
            t8 = sharedPreferences.getString("t8","");
            t9 = sharedPreferences.getString("t9","");
            t10 = sharedPreferences.getString("t10","");
            t11 = sharedPreferences.getString("t11","");
            t12 = sharedPreferences.getString("t12","");
            t13 = sharedPreferences.getString("t13","");
            t14 = sharedPreferences.getString("t14","");

            chest1 = sharedPreferences.getInt("chest1",0);
            chest2 = sharedPreferences.getInt("chest2",0);
            chest3 = sharedPreferences.getInt("chest3",0);
            chest4 = sharedPreferences.getInt("chest4",0);
            chest5 = sharedPreferences.getInt("chest5",0);
            chest6 = sharedPreferences.getInt("chest6",0);
            chest7 = sharedPreferences.getInt("chest7",0);
            chest8 = sharedPreferences.getInt("chest8",0);
            chest9 = sharedPreferences.getInt("chest9",0);
            chest10 = sharedPreferences.getInt("chest10",0);
            chest11 = sharedPreferences.getInt("chest11",0);
            chest12 = sharedPreferences.getInt("chest12",0);
            chest13 = sharedPreferences.getInt("chest13",0);
            chest14 = sharedPreferences.getInt("chest14",0);


            arena = sharedPreferences.getInt("arena",0);
            current_arena = sharedPreferences.getInt("currentArena",0);

            previous_arena = sharedPreferences.getInt("previousArena",0);
            best_arena = sharedPreferences.getInt("bestArena",0);



            refresh.setVisibility(View.VISIBLE);
        }



        return root;
    }

    public void playerTagListener(){
        player_tag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player_tag.setText("");
            }
        });
    }

    public void searchButtonListener() {
        search_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String tag = "%23"+player_tag.getText().toString().toUpperCase();
                url_player = base_url + tag;
                url_chest = url_player.concat("/upcomingchests");
                url_chest = url_chest.replaceAll("\\s+","");

                InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);



                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        URL urlForGetRequest_player = null;
                        invalid = false;

                        try {

                            urlForGetRequest_player = new URL(url_player);
                            String readLine = null;
                            String readLine_player = null;
                            HttpURLConnection conection_player = (HttpURLConnection) urlForGetRequest_player.openConnection();

                            conection_player.setRequestMethod("GET");
                            conection_player.setRequestProperty("Content-Type", "application/json");
                            conection_player.setRequestProperty("Authorization", "Bearer " + key);



                            int responseCode_player = conection_player.getResponseCode();



                            BufferedReader in_player = new BufferedReader(
                                    new InputStreamReader(conection_player.getInputStream()));



                            StringBuffer response_player = new StringBuffer();
                            while ((readLine_player = in_player.readLine()) != null) {
                                response_player.append(readLine_player);
                            }

                            in_player.close();

                             obj_player = new JSONObject(response_player.toString());






                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                            System.out.println("MALFORMEDURL");
                            invalid = true;
                        } catch (IOException e) {
                            e.printStackTrace();
                            System.out.println("I/O");
                            invalid = true;
                        } catch (JSONException e) {
                            e.printStackTrace();
                            System.out.println("JSON");
                            invalid = true;
                        }

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (invalid == true){
                                    Toast toast = Toast.makeText(getActivity(),
                                            "Invalid player tag Provided",
                                            Toast.LENGTH_SHORT);

                                    toast.show();
                                }
                                else{
                                    startActivity(new Intent(getActivity(), PlayerInfo.class));

                                }
                            }
                        });
                    }
                }).start();


            }
        });
    }
}