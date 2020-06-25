package com.example.clashroyalebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.clashroyalebase.ui.slideshow.SlideshowFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Player_Buffering extends AppCompatActivity {
    JSONObject obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player__buffering);

        final ImageView arena = PlayerInfo.arena;
        final ImageView[] chest_buttons = PlayerInfo.chest_buttons;



        new Thread(new Runnable() {
            @Override
            public void run() {
                URL urlForGetRequest = null;
                try {
                    urlForGetRequest = new URL(SlideshowFragment.url_chest);
                    String readLine = null;
                    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
                    conection.setRequestMethod("GET");
                    conection.setRequestProperty("Content-Type", "application/json");
                    conection.setRequestProperty("Authorization", "Bearer " + SlideshowFragment.key);

                    int responseCode = conection.getResponseCode();
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(conection.getInputStream()));
                    StringBuffer response = new StringBuffer();

                    while ((readLine = in.readLine()) != null) {
                        response.append(readLine);
                    }
                    in.close();
                    obj = new JSONObject(response.toString());

                    JSONArray array = (JSONArray) obj.get("items");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject o = new JSONObject(array.get(i).toString());
                        SlideshowFragment.chest.add((String) o.get("name"));
                        SlideshowFragment.chestAt.add((Integer) o.get("index"));
                    }


                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    System.out.println("MALFORMEDURL");

                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("I/O");

                } catch (JSONException e) {
                    e.printStackTrace();
                    System.out.println("JSON");

                }



                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        for (int i=0; i<SlideshowFragment.chest.size();i++){
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
                            PlayerInfo.lvl_text.setText(o.get("expLevel").toString());
                            PlayerInfo.level.setText(o.get("expLevel").toString());
                            PlayerInfo.highest_best.setText(o.get("bestTrophies").toString());
                            PlayerInfo.wins.setText(o.get("wins").toString());
                            PlayerInfo.losses.setText(o.get("losses").toString());
                            PlayerInfo.battle_count.setText(o.get("battleCount").toString());
                            PlayerInfo.three_crown_wins.setText(o.get("threeCrownWins").toString());
                            PlayerInfo.max_wins.setText(o.get("challengeMaxWins").toString());
                            PlayerInfo.cards_won.setText(o.get("challengeCardsWon").toString());
                            PlayerInfo.tournament_cards_won.setText(o.get("tournamentCardsWon").toString());
                            PlayerInfo.battle_count_tournaments.setText(o.get("tournamentBattleCount").toString());


                            int wins = Integer.parseInt(o.get("wins").toString());
                            int losses = Integer.parseInt(o.get("losses").toString());
                            int total_games = Integer.parseInt(o.get("battleCount").toString());

                            int win_rate = Math.round((wins*100) / total_games);
                            PlayerInfo.win_rate.setText(Integer.toString(win_rate)+"%");
                            PlayerInfo.draws.setText(Integer.toString(total_games-wins-losses));


                            JSONObject league = (JSONObject) o.get("leagueStatistics");
                            JSONObject bestSeason = (JSONObject) league.get("bestSeason");

                            PlayerInfo.best_season.setText(bestSeason.get("id").toString());
                            PlayerInfo.best_season_trophies.setText(bestSeason.get("trophies").toString());

                            JSONObject currentSeason = (JSONObject) league.get("currentSeason");
                            PlayerInfo.current_trophies.setText(currentSeason.get("trophies").toString());

                            JSONObject previousSeason = (JSONObject) league.get("previousSeason");
                            PlayerInfo.previous_trophies.setText(previousSeason.get("trophies").toString());
                            PlayerInfo.previous_season.setText(previousSeason.get("id").toString());
                            PlayerInfo.highest_previous_trophies.setText(previousSeason.get("bestTrophies").toString());

                            int torunament_games = Integer.parseInt(o.get("tournamentBattleCount").toString());

                            int time = (((total_games + torunament_games)*3)/60)/24;
                            PlayerInfo.days_played.setText(Integer.toString(time));





                            JSONObject obj = new JSONObject( o.get("arena").toString());
                            String arena_name = obj.get("name").toString();
                            PlayerInfo.league.setText(arena_name);
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
                            Thread.sleep(500);

                            SlideshowFragment.chest.clear();
                            SlideshowFragment.chestAt.clear();
                            finish();

                        } catch (JSONException | InterruptedException e) {
                            e.printStackTrace();
                            finish();
                        }

                    }
                });
            }

        }).start();


    }
}
