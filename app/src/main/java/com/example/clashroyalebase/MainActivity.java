package com.example.clashroyalebase;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.clashroyalebase.ui.gallery.GalleryFragment;
import com.example.clashroyalebase.ui.home.HomeFragment;
import com.example.clashroyalebase.ui.slideshow.SlideshowFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {
    public DrawerLayout drawer;
    public ListView mDrawerList;
    public static HashMap<String, Integer> drawable_chest = new HashMap<String, Integer>();
    public static Hashtable<String, Boolean> fragment_selected = new Hashtable<String, Boolean>();
    public static HashMap<String, Integer> drawable_arena = new HashMap<String, Integer>();

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         drawer = findViewById(R.id.drawer_layout);
         mDrawerList = findViewById(R.id.drawer_listview);
//        NavigationView navigationView = findViewById(R.id.nav_view);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.nav_my_decks, R.id.nav_meta_decks, R.id.nav_player_info)
//                .setDrawerLayout(drawer)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.content_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this,drawer,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().add(R.id.content_main,new HomeFragment(),"home").commitNow();
        getSupportFragmentManager().beginTransaction().add(R.id.content_main,new GalleryFragment(),"gallery").commitNow();
        getSupportFragmentManager().beginTransaction().add(R.id.content_main,new SlideshowFragment(),"slideshow").commitNow();

        Fragment f1 = getSupportFragmentManager().findFragmentByTag("home");
        Fragment f2 = getSupportFragmentManager().findFragmentByTag("gallery");
        Fragment f3 = getSupportFragmentManager().findFragmentByTag("slideshow");

        getSupportFragmentManager().beginTransaction().hide(f2).commitNow();
        getSupportFragmentManager().beginTransaction().hide(f3).commitNow();

        fragment_selected.put("home",true);
        fragment_selected.put("gallery",false);
        fragment_selected.put("slideshow",false);

        Drawable silver = getResources().getDrawable(R.drawable.silver_chest);
        Drawable gold = getResources().getDrawable(R.drawable.silver_chest);
        Drawable epic = getResources().getDrawable(R.drawable.silver_chest);
        Drawable giant = getResources().getDrawable(R.drawable.silver_chest);
        Drawable mega_lightning = getResources().getDrawable(R.drawable.silver_chest);
        Drawable legendary = getResources().getDrawable(R.drawable.silver_chest);
        Drawable magical = getResources().getDrawable(R.drawable.silver_chest);

        drawable_chest.put("silver",R.drawable.silver_chest);
        drawable_chest.put("gold",R.drawable.gold_chest);
        drawable_chest.put("epic",R.drawable.epic_chest);
        drawable_chest.put("giant",R.drawable.giant_chest);
        drawable_chest.put("mega_lightning",R.drawable.mega_lightning_chest);
        drawable_chest.put("legendary",R.drawable.legendary_chest);
        drawable_chest.put("magical",R.drawable.magical_chest);

        drawable_arena.put("arena1",R.drawable.arena1);
        drawable_arena.put("arena2",R.drawable.arena2);
        drawable_arena.put("arena3",R.drawable.arena3);
        drawable_arena.put("arena4",R.drawable.arena4);
        drawable_arena.put("arena5",R.drawable.arena5);
        drawable_arena.put("arena6",R.drawable.arena6);
        drawable_arena.put("arena7",R.drawable.arena7);
        drawable_arena.put("arena8",R.drawable.arena8);
        drawable_arena.put("arena9",R.drawable.arena9);
        drawable_arena.put("arena10",R.drawable.arena10);
        drawable_arena.put("arena11",R.drawable.arena11);
        drawable_arena.put("arena12",R.drawable.arena12);
        drawable_arena.put("league1",R.drawable.league1);
        drawable_arena.put("league2",R.drawable.league2);
        drawable_arena.put("league3",R.drawable.league3);
        drawable_arena.put("league4",R.drawable.league4);
        drawable_arena.put("league5",R.drawable.league5);
        drawable_arena.put("league6",R.drawable.league6);
        drawable_arena.put("league7",R.drawable.league7);
        drawable_arena.put("league8",R.drawable.league8);
        drawable_arena.put("league9",R.drawable.league9);
        drawable_arena.put("league10",R.drawable.league10);


    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void displaySelectedScreen(int id){
        String tag = "";
        String select= "";

        switch (id){
            case R.id.nav_player_info:
                tag = "slideshow";
                select = "slideshow";
                break;
            case R.id.nav_meta_decks:
                tag = "gallery";
                select = "gallery";
                break;
            case R.id.nav_my_decks:
                tag = "home";
                select = "home";
                break;
        }
        FragmentManager manager = getSupportFragmentManager();
        if (fragment_selected.get("home").equals(true)){
            fragment_selected.replace("home",false);
            getSupportFragmentManager().beginTransaction().hide(manager.findFragmentByTag("home")).commitNow();
        }
        else if (fragment_selected.get("gallery").equals(true)){
            fragment_selected.replace("gallery",false);
            getSupportFragmentManager().beginTransaction().hide(manager.findFragmentByTag("gallery")).commitNow();
        }
        else if (fragment_selected.get("slideshow").equals(true)){
            fragment_selected.replace("slideshow",false);
            getSupportFragmentManager().beginTransaction().hide(manager.findFragmentByTag("slideshow")).commitNow();
        }



        if (!tag.equals("")){
            getSupportFragmentManager().beginTransaction().show(manager.findFragmentByTag(tag)).commitNow();
            //getSupportFragmentManager().beginTransaction().detach(manager.findFragmentByTag("home")).commitNow();
        }
        fragment_selected.replace(tag,true);

        drawer.closeDrawer(GravityCompat.START);


    }






    @RequiresApi(api = Build.VERSION_CODES.N)
    public boolean onNavigationItemSelected(MenuItem item){
        int id = item.getItemId();

            displaySelectedScreen(id);
            return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    public void onBackPressed() {
        moveTaskToBack(true);
    }

    private void save(){
        SharedPreferences sharedPreferences = getSharedPreferences("AppData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        for (int i=0; i<HomeFragment.cardViews.length;i++){
            String key = "card" + Integer.toString((i+1));
            editor.putString(key,HomeFragment.cardViews[i].getTag().toString());

        }

        for (int i=0; i<HomeFragment.decks.length;i++){
            String deck_text = HomeFragment.decks[i].deck_text_view.getText().toString();
            String elixir_text = HomeFragment.decks[i].elixir_text_view.getText().toString();
            String deck = "deck" + Integer.toString((i+1));
            String elixir = "elixir" + Integer.toString((i+1));
            editor.putString(deck,deck_text);
            editor.putString(elixir,elixir_text);

        }

        String spinner =  GalleryFragment.spinner.getSelectedItem().toString();
        editor.putString("spinner",spinner);

        editor.putString("playerName",Fragment1.player_name.getText().toString());
        editor.putString("bestSeason",Fragment1.best_season.getText().toString());
        editor.putString("level",Fragment1.level.getText().toString());
        editor.putString("bestSeasonTrophies",Fragment1.best_season_trophies.getText().toString());
        editor.putString("currentTrophies",Fragment1.current_trophies.getText().toString());
        editor.putString("previousSeason",Fragment1.previous_season.getText().toString());
        editor.putString("highestPreviousTrophies",Fragment1.highest_previous_trophies.getText().toString());
        editor.putString("league",Fragment1.league.getText().toString());
        editor.putString("wins",Fragment1.wins.getText().toString());
        editor.putString("maxWins",Fragment1.max_wins.getText().toString());
        editor.putString("cardsWon",Fragment1.cards_won.getText().toString());
        editor.putString("threeCrownWins",Fragment1.three_crown_wins.getText().toString());
        editor.putString("losses",Fragment1.losses.getText().toString());
        editor.putString("daysPlayed",Fragment1.days_played.getText().toString());
        editor.putString("winRate",Fragment1.win_rate.getText().toString());
        editor.putString("Draws",Fragment1.draws.getText().toString());
        editor.putString("battleCount",Fragment1.battle_count.getText().toString());
        editor.putString("battleCountTournaments",Fragment1.battle_count_tournaments.getText().toString());
        editor.putString("tournamentCardsWon",Fragment1.tournament_cards_won.getText().toString());
        editor.putString("highestBest",Fragment1.highest_best.getText().toString());
        editor.putString("previousTrophies",Fragment1.previous_trophies.getText().toString());
        editor.putString("tag",Fragment1.tag.getText().toString());
        editor.putString("trophies",Fragment1.trophies.getText().toString());
        editor.putString("starText",Fragment1.star_txt.getText().toString());

        editor.putString("t1",Fragment1.t1.getText().toString());
        editor.putString("t2",Fragment1.t2.getText().toString());
        editor.putString("t3",Fragment1.t3.getText().toString());
        editor.putString("t4",Fragment1.t4.getText().toString());
        editor.putString("t5",Fragment1.t5.getText().toString());
        editor.putString("t6",Fragment1.t6.getText().toString());
        editor.putString("t7",Fragment1.t7.getText().toString());
        editor.putString("t8",Fragment1.t8.getText().toString());
        editor.putString("t9",Fragment1.t9.getText().toString());
        editor.putString("t10",Fragment1.t10.getText().toString());
        editor.putString("t11",Fragment1.t11.getText().toString());
        editor.putString("t12",Fragment1.t12.getText().toString());
        editor.putString("t13",Fragment1.t13.getText().toString());
        editor.putString("t14",Fragment1.t14.getText().toString());

        try{
            editor.putInt("chest1",drawable_chest.get((Fragment1.chest1.getTag())));
            editor.putInt("chest2",drawable_chest.get((Fragment1.chest2.getTag())));
            editor.putInt("chest3",drawable_chest.get((Fragment1.chest3.getTag())));
            editor.putInt("chest4",drawable_chest.get((Fragment1.chest4.getTag())));
            editor.putInt("chest5",drawable_chest.get((Fragment1.chest5.getTag())));
            editor.putInt("chest6",drawable_chest.get((Fragment1.chest6.getTag())));
            editor.putInt("chest7",drawable_chest.get((Fragment1.chest7.getTag())));
            editor.putInt("chest8",drawable_chest.get((Fragment1.chest8.getTag())));
            editor.putInt("chest9",drawable_chest.get((Fragment1.chest9.getTag())));
            editor.putInt("chest10",drawable_chest.get((Fragment1.chest10.getTag())));
            editor.putInt("chest11",drawable_chest.get((Fragment1.chest11.getTag())));
            editor.putInt("chest12",drawable_chest.get((Fragment1.chest12.getTag())));
            editor.putInt("chest13",drawable_chest.get((Fragment1.chest13.getTag())));
            editor.putInt("chest14",drawable_chest.get((Fragment1.chest14.getTag())));

            editor.putInt("arena",drawable_arena.get((Fragment1.arena.getTag())));
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }


        editor.commit();

    }
    public void onStop(){
        save();
        super.onStop();

    }





}
