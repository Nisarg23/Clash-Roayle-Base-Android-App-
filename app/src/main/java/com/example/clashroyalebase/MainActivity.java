package com.example.clashroyalebase;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.clashroyalebase.ui.gallery.GalleryFragment;
import com.example.clashroyalebase.ui.home.HomeFragment;
import com.example.clashroyalebase.ui.slideshow.SlideshowFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements
NavigationView.OnNavigationItemSelectedListener{
    public DrawerLayout drawer;

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         drawer = findViewById(R.id.drawer_layout);
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










    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if (id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void displaySelectedScreen(int id){
        Fragment fragment = null;

        switch (id){
            case R.id.nav_player_info:
                fragment = new SlideshowFragment();
                break;
            case R.id.nav_meta_decks:
                fragment = new GalleryFragment();
                break;
            case R.id.nav_my_decks:
                fragment = new HomeFragment();
                break;
        }

        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main,fragment).commit();
        }
        drawer.closeDrawer(GravityCompat.START);
    }

    public boolean onNavigationItemSelected(MenuItem item){
        System.out.println("SECTD");
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



}
