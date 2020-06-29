package com.example.clashroyalebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.clashroyalebase.ui.gallery.GalleryFragment;
import com.example.clashroyalebase.ui.gallery.GalleryViewModel;
import com.example.clashroyalebase.ui.home.HomeFragment;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;


public class BufferingActivity extends AppCompatActivity {

    public Elements img;
    public Elements txt;
    public InputStream is;
    public Drawable d;
    public static ArrayList<String> keys = new ArrayList<String>();

    public static TextView buffering_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buffering);




            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Document doc = Jsoup.connect(GalleryFragment.link).get();
                        Document doc2 = Jsoup.connect("https://statsroyale.com/cards").get();

                        img = doc.getElementsByTag("img");
                        txt = doc.getElementsByClass("ui__headerBig");


                        img.remove(0);
                        img.remove(0);
                        img.remove(0);


                        for (int i = 0; i < 400; i++) {
                            String url = img.get(i).toString();
                            int end_index = url.indexOf('>');
                            url = url.substring(10, end_index - 1);
                            end_index = (url.indexOf(".png"));

                            url = url.substring(46, end_index);


                            switch (url) {
                                case "minion":
                                    url = "minions";
                                    break;
                                case "fire_fireball":
                                    url = "fireball";
                                    break;
                                case "order_volley":
                                    url = "arrows";
                                    break;
                                case "skeleton_horde":
                                    url = "skeleton_army";
                                    break;
                                case "wallbreaker":
                                    url = "wall_breakers";
                                    break;
                                case "goblin_archer":
                                    url = "spear_goblins";
                                    break;
                                case "chr_witch":
                                    url = "witch";
                                    break;
                                case "fire_furnace":
                                    url = "goblin_hut";
                                    break;
                                case "chr_golem":
                                    url = "golem";
                                    break;
                                case "angry_barbarian":
                                    url = "elite_barbarians";
                                    break;
                                case "zapMachine":
                                    url = "sparky";
                                    break;
                                case "chr_balloon":
                                    url = "balloon";
                                    break;
                                case "royal_hog":
                                    url = "royal_hogs";
                                    break;
                                case "rage_barbarian":
                                    url = "lumberjack";
                                    break;
                                case "skeleton_balloon":
                                    url = "skeleton_barrel";
                                    break;
                                case "skeleton_warriors":
                                    url = "guards";
                                    break;
                                case "blowdart_goblin":
                                    url = "dart_goblin";
                                    break;
                                case "snow_spirits":
                                    url = "ice_spirit";
                                    break;
                                case "building_xbow":
                                    url = "xbow";
                                    break;
                                case "building_elixir_collector":
                                    url = "elixir_collector";
                                    break;
                                case "building_inferno":
                                    url = "inferno_tower";
                                    break;
                                case "building_mortar":
                                    url = "mortar";
                                    break;
                                case "building_tesla":
                                    url = "tesla";
                                    break;
                                case "firespirit_hut":
                                    url = "furnace";
                                    break;
                                case "chaos_cannon":
                                    url = "cannon";
                                    break;
                                case "copy":
                                    url = "clone";
                                    break;
                                case "snowball":
                                    url = "giant_snowball";
                                    break;
                                case "barb_barrel":
                                    url = "barbarian_barrel";
                                    break;
                                case "healspirit":
                                    url = "heal_spirit";
                                    break;
                                case "ghost":
                                    url = "royal_ghost";
                                    break;
                                case "dark_witch":
                                    url = "night_witch";
                                    break;
                                case "skeletondragon":
                                    url = "baby_dragon";
                                    break;
                            }
                            GalleryFragment.meta_cards.get(i).setTag(url);

//                        try {
                            int id = HomeFragment.drawable_dict.get(url);
                            Drawable d = ResourcesCompat.getDrawable(getApplicationContext().getResources(), id, null);
                            GalleryFragment.drawables.add(d);
                            //}
//                        catch (NullPointerException e){
//                            e.printStackTrace();
//                        }


                            if (i < 50) {
                                String sub = txt.get(i).toString();
                                sub = sub.substring(27);
                                int end = sub.indexOf('<');
                                sub = sub.substring(0, end);
                                GalleryFragment.win_rate.get(i).setText("Win rate: " + sub + "%");
                            }

                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            for (int i = 0; i < GalleryFragment.drawables.size(); i++) {
                                GalleryFragment.meta_cards.get(i).setImageDrawable(GalleryFragment.drawables.get(i));
                            }
                            finish();
                        }
                    });
                }
            }).start();





    }
    public void onBackPressed() {

    }


}
