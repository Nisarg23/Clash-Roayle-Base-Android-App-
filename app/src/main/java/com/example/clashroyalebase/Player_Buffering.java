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
                                    chest_buttons[i].setTag("silver");
                                    break;
                                case "Giant Chest":
                                    chest_buttons[i].setImageResource(R.drawable.giant_chest);
                                    chest_buttons[i].setTag("giant");
                                    break;
                                case "Magical Chest":
                                    chest_buttons[i].setImageResource(R.drawable.magical_chest);
                                    chest_buttons[i].setTag("magical");
                                    break;
                                case "Legendary Chest":
                                    chest_buttons[i].setImageResource(R.drawable.legendary_chest);
                                    chest_buttons[i].setTag("legendary");
                                    break;
                                case "Golden Chest":
                                    chest_buttons[i].setImageResource(R.drawable.gold_chest);
                                    chest_buttons[i].setTag("gold");
                                    break;
                                case "Epic Chest":
                                    chest_buttons[i].setImageResource(R.drawable.epic_chest);
                                    chest_buttons[i].setTag("epic");
                                    break;
                                case "Mega Lightning Chest":
                                    chest_buttons[i].setImageResource(R.drawable.mega_lightning_chest);
                                    chest_buttons[i].setTag("mega_lightning");
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
                            PlayerInfo.highest_best.setText(o.get("bestTrophies").toString());
                            PlayerInfo.wins.setText(o.get("wins").toString());
                            PlayerInfo.losses.setText(o.get("losses").toString());
                            PlayerInfo.battle_count.setText(o.get("battleCount").toString());
                            PlayerInfo.three_crown_wins.setText(o.get("threeCrownWins").toString());
                            PlayerInfo.tournament_cards_won.setText(o.get("tournamentCardsWon").toString());
                            PlayerInfo.battle_count_tournaments.setText(o.get("tournamentBattleCount").toString());


                            int wins = Integer.parseInt(o.get("wins").toString());
                            int three_wins = Integer.parseInt(o.get("threeCrownWins").toString());
                            int losses = Integer.parseInt(o.get("losses").toString());
                            int total_games = Integer.parseInt(o.get("battleCount").toString());

                            int win_rate = Math.round(((wins)*100) / total_games);
                            PlayerInfo.win_rate.setText(Integer.toString(win_rate)+"%");
                            PlayerInfo.draws.setText(Integer.toString(total_games-wins-losses));


                            JSONObject league = (JSONObject) o.get("leagueStatistics");
                            JSONObject bestSeason = (JSONObject) league.get("bestSeason");

                            PlayerInfo.best_season.setText(bestSeason.get("id").toString());
                            PlayerInfo.best_season_trophies.setText(bestSeason.get("trophies").toString());
                            PlayerInfo.best_arena.setImageResource(getArenaId((Integer) bestSeason.get("trophies")));
                            PlayerInfo.best_arena.setTag(getArenaName((Integer) bestSeason.get("trophies")));


                            JSONObject currentSeason = (JSONObject) league.get("currentSeason");
                            try {
                                PlayerInfo.current_trophies.setText(currentSeason.get("trophies").toString());
                                PlayerInfo.current_highest.setText(currentSeason.get("bestTrophies").toString());
                                PlayerInfo.current_arena.setImageResource(getArenaId((Integer) currentSeason.get("trophies")));
                                PlayerInfo.current_arena.setTag(getArenaName((Integer) currentSeason.get("trophies")));
                            }
                            catch (org.json.JSONException e){
                                PlayerInfo.current_arena.setTag("");
                            }


                            JSONObject previousSeason = (JSONObject) league.get("previousSeason");
                            PlayerInfo.previous_trophies.setText(previousSeason.get("trophies").toString());
                            PlayerInfo.previous_season.setText(previousSeason.get("id").toString());
                            PlayerInfo.previous_arena.setImageResource(getArenaId((Integer) previousSeason.get("trophies")));
                            PlayerInfo.previous_arena.setTag(getArenaName((Integer) previousSeason.get("trophies")));

                            int torunament_games = Integer.parseInt(o.get("tournamentBattleCount").toString());

                            int time = (((total_games + torunament_games)*3)/60)/24;
                            PlayerInfo.days_played.setText(Integer.toString(time));





                            JSONObject obj = new JSONObject( o.get("arena").toString());
                            String arena_name = obj.get("name").toString();
                            switch (arena_name){
                                case "Arena 1":
                                    arena.setImageResource(R.drawable.arena1);
                                    arena.setTag("arena1");
                                    break;
                                case "Arena 2":
                                    arena.setImageResource(R.drawable.arena2);
                                    arena.setTag("arena2");
                                    break;
                                case "Arena 3":
                                    arena.setImageResource(R.drawable.arena3);
                                    arena.setTag("arena3");
                                    break;
                                case "Arena 4":
                                    arena.setImageResource(R.drawable.arena4);
                                    arena.setTag("arena4");
                                    break;
                                case "Arena 5":
                                    arena.setImageResource(R.drawable.arena5);
                                    arena.setTag("arena5");
                                    break;
                                case "Arena 6":
                                    arena.setImageResource(R.drawable.arena6);
                                    arena.setTag("arena6");
                                    break;
                                case "Arena 7":
                                    arena.setImageResource(R.drawable.arena7);
                                    arena.setTag("arena7");
                                    break;
                                case "Arena 8":
                                    arena.setImageResource(R.drawable.arena8);
                                    arena.setTag("arena8");
                                    break;
                                case "Arena 9":
                                    arena.setImageResource(R.drawable.arena9);
                                    arena.setTag("arena9");
                                    break;
                                case "Arena 10":
                                    arena.setImageResource(R.drawable.arena10);
                                    arena.setTag("arena10");
                                    break;
                                case "Arena 11":
                                    arena.setImageResource(R.drawable.arena11);
                                    arena.setTag("arena11");
                                    break;
                                case "Arena 12":
                                    arena.setImageResource(R.drawable.arena12);
                                    arena.setTag("arena2");
                                    break;
                                case "Challenger I":
                                    arena.setImageResource(R.drawable.league1);
                                    arena.setTag("league1");
                                    break;
                                case "Challenger II":
                                    arena.setImageResource(R.drawable.league2);
                                    arena.setTag("league2");
                                    break;
                                case "Challenger III":
                                    arena.setImageResource(R.drawable.league3);
                                    arena.setTag("league3");
                                    break;
                                case "Master I":
                                    arena.setImageResource(R.drawable.league4);
                                    arena.setTag("league4");
                                    break;
                                case "Master II":
                                    arena.setImageResource(R.drawable.league5);
                                    arena.setTag("league5");
                                    break;
                                case "Master III":
                                    arena.setImageResource(R.drawable.league6);
                                    arena.setTag("league6");
                                    break;
                                case "Champion":
                                    arena.setImageResource(R.drawable.league7);
                                    arena.setTag("league7");
                                    break;
                                case "Grand Champion":
                                    arena.setImageResource(R.drawable.league8);
                                    arena.setTag("league8");
                                    break;
                                case "Royal Champion":
                                    arena.setImageResource(R.drawable.league9);
                                    arena.setTag("league9");
                                    break;
                                case "Ultimate Champion":
                                    arena.setImageResource(R.drawable.league10);
                                    arena.setTag("league10");
                                    break;
                            }
                            Thread.sleep(500);

                            SlideshowFragment.chest.clear();
                            SlideshowFragment.chestAt.clear();

                            if (PlayerInfo.triggered_refresh == true){
                                PlayerInfo.triggered_refresh = false;
                                refresh();

                            }
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
    public  void refresh(){
        Fragment1.player_name.setText(PlayerInfo.player_name.getText());
        Fragment1.best_season.setText(PlayerInfo.best_season.getText());
        Fragment1.best_season_trophies.setText(PlayerInfo.best_season_trophies.getText());
        Fragment1.current_trophies.setText(PlayerInfo.current_trophies.getText());
        Fragment1.previous_season.setText(PlayerInfo.previous_season.getText());
        Fragment1.wins.setText(PlayerInfo.wins.getText());
        Fragment1.three_crown_wins.setText(PlayerInfo.three_crown_wins.getText());
        Fragment1.losses.setText(PlayerInfo.losses.getText());
        Fragment1.battle_count.setText(PlayerInfo.battle_count.getText());
        Fragment1.days_played.setText(PlayerInfo.days_played.getText());
        Fragment1.win_rate.setText(PlayerInfo.win_rate.getText());
        Fragment1.draws.setText(PlayerInfo.draws.getText());
        Fragment1.battle_count_tournaments.setText(PlayerInfo.battle_count_tournaments.getText());
        Fragment1.tournament_cards_won.setText(PlayerInfo.tournament_cards_won.getText());
        Fragment1.highest_best.setText(PlayerInfo.highest_best.getText());
        Fragment1.previous_trophies.setText(PlayerInfo.previous_trophies.getText());
        Fragment1.tag.setText(PlayerInfo.tag.getText());
        Fragment1.trophies.setText(PlayerInfo.trophies.getText());
        Fragment1.star_txt.setText(PlayerInfo.lvl_text.getText());
        Fragment1.current_highest.setText(PlayerInfo.current_highest.getText());


        Fragment1.t1.setText(PlayerInfo.t1.getText());
        Fragment1.t2.setText(PlayerInfo.t2.getText());
        Fragment1.t3.setText(PlayerInfo.t3.getText());
        Fragment1.t4.setText(PlayerInfo.t4.getText());
        Fragment1.t5.setText(PlayerInfo.t5.getText());
        Fragment1.t6.setText(PlayerInfo.t6.getText());
        Fragment1.t7.setText(PlayerInfo.t7.getText());
        Fragment1.t8.setText(PlayerInfo.t8.getText());
        Fragment1.t9.setText(PlayerInfo.t9.getText());
        Fragment1.t10.setText(PlayerInfo.t10.getText());
        Fragment1.t11.setText(PlayerInfo.t11.getText());
        Fragment1.t12.setText(PlayerInfo.t12.getText());
        Fragment1.t13.setText(PlayerInfo.t13.getText());
        Fragment1.t14.setText(PlayerInfo.t14.getText());


        Fragment1.arena.setImageDrawable(PlayerInfo.arena.getDrawable());
        Fragment1.chest1.setImageDrawable(PlayerInfo.chest1.getDrawable());
        Fragment1.chest2.setImageDrawable(PlayerInfo.chest2.getDrawable());
        Fragment1.chest3.setImageDrawable(PlayerInfo.chest3.getDrawable());
        Fragment1.chest4.setImageDrawable(PlayerInfo.chest4.getDrawable());
        Fragment1.chest5.setImageDrawable(PlayerInfo.chest5.getDrawable());
        Fragment1.chest6.setImageDrawable(PlayerInfo.chest6.getDrawable());
        Fragment1.chest7.setImageDrawable(PlayerInfo.chest7.getDrawable());
        Fragment1.chest8.setImageDrawable(PlayerInfo.chest8.getDrawable());
        Fragment1.chest9.setImageDrawable(PlayerInfo.chest9.getDrawable());
        Fragment1.chest10.setImageDrawable(PlayerInfo.chest10.getDrawable());
        Fragment1.chest11.setImageDrawable(PlayerInfo.chest11.getDrawable());
        Fragment1.chest12.setImageDrawable(PlayerInfo.chest12.getDrawable());
        Fragment1.chest13.setImageDrawable(PlayerInfo.chest13.getDrawable());
        Fragment1.chest14.setImageDrawable(PlayerInfo.chest14.getDrawable());

        Fragment1.arena.setTag(PlayerInfo.arena.getTag());
        Fragment1.chest1.setTag(PlayerInfo.chest1.getTag());
        Fragment1.chest2.setTag(PlayerInfo.chest2.getTag());
        Fragment1.chest3.setTag(PlayerInfo.chest3.getTag());
        Fragment1.chest4.setTag(PlayerInfo.chest4.getTag());
        Fragment1.chest5.setTag(PlayerInfo.chest5.getTag());
        Fragment1.chest6.setTag(PlayerInfo.chest6.getTag());
        Fragment1.chest7.setTag(PlayerInfo.chest7.getTag());
        Fragment1.chest8.setTag(PlayerInfo.chest8.getTag());
        Fragment1.chest9.setTag(PlayerInfo.chest9.getTag());
        Fragment1.chest10.setTag(PlayerInfo.chest10.getTag());
        Fragment1.chest11.setTag(PlayerInfo.chest11.getTag());
        Fragment1.chest12.setTag(PlayerInfo.chest12.getTag());
        Fragment1.chest13.setTag(PlayerInfo.chest13.getTag());
        Fragment1.chest14.setTag(PlayerInfo.chest14.getTag());

        Fragment1.current_arena.setTag(PlayerInfo.current_arena.getTag());
        Fragment1.previous_arena.setTag(PlayerInfo.previous_arena.getTag());
        Fragment1.best_arena.setTag(PlayerInfo.best_arena.getTag());

        Fragment1.current_arena.setImageDrawable(PlayerInfo.current_arena.getDrawable());
        Fragment1.previous_arena.setImageDrawable(PlayerInfo.previous_arena.getDrawable());
        Fragment1.best_arena.setImageDrawable(PlayerInfo.best_arena.getDrawable());


        finish();


    }
    public void onBackPressed(){

    }

    private int getArenaId(int trophies){
        int arena_id = R.drawable.ic_launcher_background;
        if (trophies < 300){
            arena_id = R.drawable.arena1;
        }
        else if (trophies < 600 && trophies >= 300){
            arena_id = R.drawable.arena2;
        }
        else if (trophies < 1000 && trophies >= 600){
            arena_id = R.drawable.arena3;
        }
        else if (trophies < 1300 && trophies >= 1000){
            arena_id = R.drawable.arena4;
        }
        else if (trophies < 1600 && trophies >= 1300){
            arena_id = R.drawable.arena5;
        }
        else if (trophies < 2000 && trophies >= 1600){
            arena_id = R.drawable.arena6;
        }
        else if (trophies < 2300 && trophies >= 2000){
            arena_id = R.drawable.arena7;
        }
        else if (trophies < 2600 && trophies >= 2300){
            arena_id = R.drawable.arena8;
        }
        else if (trophies < 3000 && trophies >= 2600){
            arena_id = R.drawable.arena9;
        }
        else if (trophies < 3300 && trophies >= 3000){
            arena_id = R.drawable.arena10;
        }
        else if (trophies < 3600 && trophies >= 3300){
            arena_id = R.drawable.arena11;
        }
        else if (trophies < 4000 && trophies >= 3300){
            arena_id = R.drawable.arena12;
        }
        else if (trophies < 4300 && trophies >= 4000){
            arena_id = R.drawable.league1;
        }
        else if (trophies < 4600 && trophies >= 4300){
            arena_id = R.drawable.league2;
        }
        else if (trophies < 5000 && trophies >= 4600){
            arena_id = R.drawable.league3;
        }
        else if (trophies < 5300 && trophies >= 5000){
            arena_id = R.drawable.league4;
        }
        else if (trophies < 5600 && trophies >= 5300){
            arena_id = R.drawable.league5;
        }
        else if (trophies < 6000 && trophies >= 5600){
            arena_id = R.drawable.league6;
        }
        else if (trophies < 6300 && trophies >= 6000){
            arena_id = R.drawable.league7;
        }
        else if (trophies < 6600 && trophies >= 6300){
            arena_id = R.drawable.league8;
        }
        else if (trophies < 7000 && trophies >= 6600){
            arena_id = R.drawable.league9;
        }
        else if (trophies > 7000){
            arena_id = R.drawable.league10;
        }

        return arena_id;
    }

    public String getArenaName(int trophies){
        String arena_name = "";
        if (trophies < 300){
            arena_name = "arena1";
        }
        else if (trophies < 600 && trophies >= 300){
            arena_name = "arena2";
        }
        else if (trophies < 1000 && trophies >= 600){
            arena_name = "arena3";
        }
        else if (trophies < 1300 && trophies >= 1000){
            arena_name = "arena4";
        }
        else if (trophies < 1600 && trophies >= 1300){
            arena_name = "arena5";
        }
        else if (trophies < 2000 && trophies >= 1600){
            arena_name = "arena6";
        }
        else if (trophies < 2300 && trophies >= 2000){
            arena_name = "arena7";
        }
        else if (trophies < 2600 && trophies >= 2300){
            arena_name = "arena8";
        }
        else if (trophies < 3000 && trophies >= 2600){
            arena_name = "arena9";
        }
        else if (trophies < 3300 && trophies >= 3000){
            arena_name = "arena10";
        }
        else if (trophies < 3600 && trophies >= 3300){
            arena_name = "arena11";
        }
        else if (trophies < 4000 && trophies >= 3300){
            arena_name = "arena12";
        }
        else if (trophies < 4300 && trophies >= 4000){
            arena_name = "league1";
        }
        else if (trophies < 4600 && trophies >= 4300){
            arena_name = "league2";
        }
        else if (trophies < 5000 && trophies >= 4600){
            arena_name = "league3";
        }
        else if (trophies < 5300 && trophies >= 5000){
            arena_name = "league4";
        }
        else if (trophies < 5600 && trophies >= 5300){
            arena_name = "league5";
        }
        else if (trophies < 6000 && trophies >= 5600){
            arena_name = "league6";
        }
        else if (trophies < 6300 && trophies >= 6000){
            arena_name = "league7";
        }
        else if (trophies < 6600 && trophies >= 6300){
            arena_name = "league8";
        }
        else if (trophies < 7000 && trophies >= 6600){
            arena_name = "league9";
        }
        else if (trophies > 7000){
            arena_name = "league10";
        }

        return arena_name;
    }

}
