package com.example.clashroyalebase;

import android.content.Context;
import android.content.SharedPreferences;
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

import java.util.Hashtable;
import java.util.List;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {
    public DrawerLayout drawer;
    public ListView mDrawerList;

    public static Hashtable<String, Boolean> fragment_selected = new Hashtable<String, Boolean>();

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












    }
//    public void selectItem(int position){
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        switch(position) {
//            case 0:
//                if(fragmentManager.findFragmentByTag("one") != null) {
//                    //if the fragment exists, show it.
//                    fragmentManager.beginTransaction().show(fragmentManager.findFragmentByTag("one")).commit();
//                } else {
//                    //if the fragment does not exist, add it to fragment manager.
//                    fragmentManager.beginTransaction().add(R.id.container, new HomeFragment(), "one").commit();
//                }
//                if(fragmentManager.findFragmentByTag("two") != null){
//                    //if the other fragment is visible, hide it.
//                    fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("two")).commit();
//                }
//                break;
//            case 1:
//                if(fragmentManager.findFragmentByTag("two") != null) {
//                    //if the fragment exists, show it.
//                    fragmentManager.beginTransaction().show(fragmentManager.findFragmentByTag("two")).commit();
//                } else {
//                    //if the fragment does not exist, add it to fragment manager.
//                    fragmentManager.beginTransaction().add(R.id.container, new GalleryFragment(), "two").commit();
//                }
//                if(fragmentManager.findFragmentByTag("one") != null){
//                    //if the other fragment is visible, hide it.
//                    fragmentManager.beginTransaction().hide(fragmentManager.findFragmentByTag("one")).commit();
//                }
//                break;
//        }
//
//        // update selected item and title, then close the drawer
//        mDrawerList.setItemChecked(position, true);
//        drawer.closeDrawer(mDrawerList);
//
//    }
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        selectItem(position);
//    }

//    public boolean onOptionsItemSelected(MenuItem item){
//        int id = item.getItemId();
//
//        if (id == R.id.action_settings){
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }


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
        editor.commit();

    }
    public void onStop(){
        save();
        super.onStop();

    }





}
