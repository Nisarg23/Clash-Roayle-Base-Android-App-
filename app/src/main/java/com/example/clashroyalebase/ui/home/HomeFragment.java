package com.example.clashroyalebase.ui.home;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.clashroyalebase.Activity2;
import com.example.clashroyalebase.R;
import com.example.clashroyalebase.TrialActivity;

import java.util.HashMap;
import java.util.Hashtable;

public class HomeFragment extends Fragment {
    public static HashMap<String, Integer> elixir_dict = new HashMap<String, Integer>();
    public static HashMap<String, Integer> drawable_dict = new HashMap<String, Integer>();

    public static Deck[] decks = new Deck[0];



    public static TextView[] textViews = new TextView[0];
    public static TextView textView1;public static TextView textView2;
    public static TextView textView3;public static TextView textView4;
    public static TextView textView5;public static TextView textView6;
    public static TextView textView7;public static TextView textView8;
    public static TextView textView9;public static TextView textView10;

    public static TextView elixir_cost_text_views[] = new TextView[0];
    public static TextView elixir_cost_text_view1;public static TextView elixir_cost_text_view2;
    public static TextView elixir_cost_text_view3;public static TextView elixir_cost_text_view4;
    public static TextView elixir_cost_text_view5;public static TextView elixir_cost_text_view6;
    public static TextView elixir_cost_text_view7;public static TextView elixir_cost_text_view8;
    public static TextView elixir_cost_text_view9;public static TextView elixir_cost_text_view10;

    public static AlertDialog dialog;
    public static EditText editText1;

    public static Button[] addButtons = new Button[0];
    public static Button addButton1;public static Button addButton2;public static Button addButton3;public static Button addButton4;
    public static Button addButton5;public static Button addButton6;public static Button addButton7;public static Button addButton8;

    public static Button addButton9;public static Button addButton10;public static Button addButton11;public static Button addButton12;
    public static Button addButton13;public static Button addButton14;public static Button addButton15;public static Button addButton16;

    public static Button addButton17;public static Button addButton18;public static Button addButton19;public static Button addButton20;
    public static Button addButton21;public static Button addButton22;public static Button addButton23;public static Button addButton24;

    public static Button addButton25;public static Button addButton26;public static Button addButton27;public static Button addButton28;
    public static Button addButton29;public static Button addButton30;public static Button addButton31;public static Button addButton32;


    public static Button addButton33;public static Button addButton34;public static Button addButton35;public static Button addButton36;
    public static Button addButton37;public static Button addButton38;public static Button addButton39;public static Button addButton40;

    public static Button addButton41;public static Button addButton42;public static Button addButton43;public static Button addButton44;
    public static Button addButton45;public static Button addButton46;public static Button addButton47;public static Button addButton48;

    public static Button addButton49;public static Button addButton50;public static Button addButton51;public static Button addButton52;
    public static Button addButton53;public static Button addButton54;public static Button addButton55;public static Button addButton56;

    public static Button addButton57;public static Button addButton58;public static Button addButton59;public static Button addButton60;
    public static Button addButton61;public static Button addButton62;public static Button addButton63;public static Button addButton64;

    public static Button addButton65;public static Button addButton66;public static Button addButton67;public static Button addButton68;
    public static Button addButton69;public static Button addButton70;public static Button addButton71;public static Button addButton72;

    public static Button addButton73;public static Button addButton74;public static Button addButton75;public static Button addButton76;
    public static Button addButton77;public static Button addButton78;public static Button addButton79;public static Button addButton80;

    public static ImageView[] cardViews = new ImageView[0];
    public static ImageView cardView1;public static ImageView cardView2;public static ImageView cardView3;public static ImageView cardView4;
    public static ImageView cardView5;public static ImageView cardView6;public static ImageView cardView7;public static ImageView cardView8;

    public static ImageView cardView9;public static ImageView cardView10;public static ImageView cardView11;public static ImageView cardView12;
    public static ImageView cardView13;public static ImageView cardView14;public static ImageView cardView15;public static ImageView cardView16;

    public static ImageView cardView17;public static ImageView cardView18;public static ImageView cardView19;public static ImageView cardView20;
    public static ImageView cardView21;public static ImageView cardView22;public static ImageView cardView23;public static ImageView cardView24;

    public static ImageView cardView25;public static ImageView cardView26;public static ImageView cardView27;public static ImageView cardView28;
    public static ImageView cardView29;public static ImageView cardView30;public static ImageView cardView31;public static ImageView cardView32;


    public static ImageView cardView33;public static ImageView cardView34;public static ImageView cardView35;public static ImageView cardView36;
    public static ImageView cardView37;public static ImageView cardView38;public static ImageView cardView39;public static ImageView cardView40;

    public static ImageView cardView41;public static ImageView cardView42;public static ImageView cardView43;public static ImageView cardView44;
    public static ImageView cardView45;public static ImageView cardView46;public static ImageView cardView47;public static ImageView cardView48;

    public static ImageView cardView49;public static ImageView cardView50;public static ImageView cardView51;public static ImageView cardView52;
    public static ImageView cardView53;public static ImageView cardView54;public static ImageView cardView55;public static ImageView cardView56;

    public static ImageView cardView57;public static ImageView cardView58;public static ImageView cardView59;public static ImageView cardView60;
    public static ImageView cardView61;public static ImageView cardView62;public static ImageView cardView63;public static ImageView cardView64;

    public static ImageView cardView65;public static ImageView cardView66;public static ImageView cardView67;public static ImageView cardView68;
    public static ImageView cardView69;public static ImageView cardView70;public static ImageView cardView71;public static ImageView cardView72;

    public static ImageView cardView73;public static ImageView cardView74;public static ImageView cardView75;public static ImageView cardView76;
    public static ImageView cardView77;public static ImageView cardView78;public static ImageView cardView79;public static ImageView cardView80;

    public static int deck_selected = -1;


    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        super.onCreate(savedInstanceState);

        this.setRetainInstance(true);
 /*
        My Code
         */


        addButton1 = root.findViewById(R.id.add1);addButton2 = root.findViewById(R.id.add2);addButton3 = root.findViewById(R.id.add3);addButton4 = root.findViewById(R.id.add4);
        addButton5 = root.findViewById(R.id.add5);addButton6 = root.findViewById(R.id.add6);addButton7 = root.findViewById(R.id.add7);addButton8 = root.findViewById(R.id.add8);

        addButton9 = root.findViewById(R.id.add9);addButton10 = root.findViewById(R.id.add10);addButton11 = root.findViewById(R.id.add11);addButton12 = root.findViewById(R.id.add12);
        addButton13 = root.findViewById(R.id.add13);addButton14 = root.findViewById(R.id.add14);addButton15 = root.findViewById(R.id.add15);addButton16 = root.findViewById(R.id.add16);

        addButton17 = root.findViewById(R.id.add17);addButton18 = root.findViewById(R.id.add18);addButton19 = root.findViewById(R.id.add19);addButton20 = root.findViewById(R.id.add20);
        addButton21 = root.findViewById(R.id.add21);addButton22 = root.findViewById(R.id.add22);addButton23 = root.findViewById(R.id.add23);addButton24 = root.findViewById(R.id.add24);

        addButton25 = root.findViewById(R.id.add25);addButton26 = root.findViewById(R.id.add26);addButton27 = root.findViewById(R.id.add27);addButton28 = root.findViewById(R.id.add28);
        addButton29 = root.findViewById(R.id.add29);addButton30 = root.findViewById(R.id.add30);addButton31 = root.findViewById(R.id.add31);addButton32 = root.findViewById(R.id.add32);

        addButton33 = root.findViewById(R.id.add33);addButton34 = root.findViewById(R.id.add34);addButton35 = root.findViewById(R.id.add35);addButton36 = root.findViewById(R.id.add36);
        addButton37 = root.findViewById(R.id.add37);addButton38 = root.findViewById(R.id.add38);addButton39 = root.findViewById(R.id.add39);addButton40 = root.findViewById(R.id.add40);

        addButton41 = root.findViewById(R.id.add41);addButton42 = root.findViewById(R.id.add42);addButton43 = root.findViewById(R.id.add43);addButton44 = root.findViewById(R.id.add44);
        addButton45 = root.findViewById(R.id.add45);addButton46 = root.findViewById(R.id.add46);addButton47 = root.findViewById(R.id.add47);addButton48 = root.findViewById(R.id.add48);

        addButton49 = root.findViewById(R.id.add49);addButton50 = root.findViewById(R.id.add50);addButton51 = root.findViewById(R.id.add51);addButton52 = root.findViewById(R.id.add52);
        addButton53 = root.findViewById(R.id.add53);addButton54 = root.findViewById(R.id.add54);addButton55 = root.findViewById(R.id.add55);addButton56 = root.findViewById(R.id.add56);

        addButton57 = root.findViewById(R.id.add57);addButton58 = root.findViewById(R.id.add58);addButton59 = root.findViewById(R.id.add59);addButton60 = root.findViewById(R.id.add60);
        addButton61 = root.findViewById(R.id.add61);addButton62 = root.findViewById(R.id.add62);addButton63 = root.findViewById(R.id.add63);addButton64 = root.findViewById(R.id.add64);

        addButton65 = root.findViewById(R.id.add65);addButton66 = root.findViewById(R.id.add66);addButton67 = root.findViewById(R.id.add67);addButton68 = root.findViewById(R.id.add68);
        addButton69 = root.findViewById(R.id.add69);addButton70 = root.findViewById(R.id.add70);addButton71 = root.findViewById(R.id.add71);addButton72 = root.findViewById(R.id.add72);

        addButton73 = root.findViewById(R.id.add73);addButton74 = root.findViewById(R.id.add74);addButton75 = root.findViewById(R.id.add75);addButton76 = root.findViewById(R.id.add76);
        addButton77 = root.findViewById(R.id.add77);addButton78 = root.findViewById(R.id.add78);addButton79 = root.findViewById(R.id.add79);addButton80 = root.findViewById(R.id.add80);


        cardView1= root.findViewById(R.id.card1);cardView2= root.findViewById(R.id.card2);cardView3= root.findViewById(R.id.card3);cardView4= root.findViewById(R.id.card4);
        cardView5= root.findViewById(R.id.card5);cardView6= root.findViewById(R.id.card6);cardView7= root.findViewById(R.id.card7);cardView8= root.findViewById(R.id.card8);

        cardView9= root.findViewById(R.id.card9);cardView10= root.findViewById(R.id.card10);cardView11= root.findViewById(R.id.card11);cardView12= root.findViewById(R.id.card12);
        cardView13= root.findViewById(R.id.card13);cardView14= root.findViewById(R.id.card14);cardView15= root.findViewById(R.id.card15);cardView16= root.findViewById(R.id.card16);

        cardView17 = root.findViewById(R.id.card17);cardView18 = root.findViewById(R.id.card18);cardView19 = root.findViewById(R.id.card19);cardView20 = root.findViewById(R.id.card20);
        cardView21 = root.findViewById(R.id.card21);cardView22 = root.findViewById(R.id.card22);cardView23 = root.findViewById(R.id.card23);cardView24 = root.findViewById(R.id.card24);

        cardView25 = root.findViewById(R.id.card25);cardView26 = root.findViewById(R.id.card26);cardView27 = root.findViewById(R.id.card27);cardView28 = root.findViewById(R.id.card28);
        cardView29 = root.findViewById(R.id.card29);cardView30 = root.findViewById(R.id.card30);cardView31 = root.findViewById(R.id.card31);cardView32 = root.findViewById(R.id.card32);

        cardView33 = root.findViewById(R.id.card33);cardView34 = root.findViewById(R.id.card34);cardView35 = root.findViewById(R.id.card35);cardView36 = root.findViewById(R.id.card36);
        cardView37 = root.findViewById(R.id.card37);cardView38 = root.findViewById(R.id.card38);cardView39 = root.findViewById(R.id.card39);cardView40 = root.findViewById(R.id.card40);

        cardView41 = root.findViewById(R.id.card41);cardView42 = root.findViewById(R.id.card42);cardView43 = root.findViewById(R.id.card43);cardView44 = root.findViewById(R.id.card44);
        cardView45 = root.findViewById(R.id.card45);cardView46 = root.findViewById(R.id.card46);cardView47 = root.findViewById(R.id.card47);cardView48 = root.findViewById(R.id.card48);

        cardView49 = root.findViewById(R.id.card49);cardView50 = root.findViewById(R.id.card50);cardView51 = root.findViewById(R.id.card51);cardView52 = root.findViewById(R.id.card52);
        cardView53 = root.findViewById(R.id.card53);cardView54 = root.findViewById(R.id.card54);cardView55 = root.findViewById(R.id.card55);cardView56 = root.findViewById(R.id.card56);

        cardView57 = root.findViewById(R.id.card57);cardView58 = root.findViewById(R.id.card58);cardView59 = root.findViewById(R.id.card59);cardView60 = root.findViewById(R.id.card60);
        cardView61 = root.findViewById(R.id.card61);cardView62 = root.findViewById(R.id.card62);cardView63 = root.findViewById(R.id.card63);cardView64 = root.findViewById(R.id.card64);

        cardView65 = root.findViewById(R.id.card65);cardView66 = root.findViewById(R.id.card66);cardView67 = root.findViewById(R.id.card67);cardView68 = root.findViewById(R.id.card68);
        cardView69 = root.findViewById(R.id.card69);cardView70 = root.findViewById(R.id.card70);cardView71 = root.findViewById(R.id.card71);cardView72 = root.findViewById(R.id.card72);

        cardView73 = root.findViewById(R.id.card73);cardView74 = root.findViewById(R.id.card74);cardView75 = root.findViewById(R.id.card75);cardView76 = root.findViewById(R.id.card76);
        cardView77 = root.findViewById(R.id.card77);cardView78 = root.findViewById(R.id.card78);cardView79 = root.findViewById(R.id.card79);cardView80 = root.findViewById(R.id.card80);

        elixir_cost_text_view1 = root.findViewById(R.id.elixir_cost_text_view1);elixir_cost_text_view2 = root.findViewById(R.id.elixir_cost_text_view2);
        elixir_cost_text_view3 = root.findViewById(R.id.elixir_cost_text_view3);elixir_cost_text_view4 = root.findViewById(R.id.elixir_cost_text_view4);
        elixir_cost_text_view5 = root.findViewById(R.id.elixir_cost_text_view5);elixir_cost_text_view6 = root.findViewById(R.id.elixir_cost_text_view6);
        elixir_cost_text_view7 = root.findViewById(R.id.elixir_cost_text_view7);elixir_cost_text_view8 = root.findViewById(R.id.elixir_cost_text_view8);
        elixir_cost_text_view9 = root.findViewById(R.id.elixir_cost_text_view9);elixir_cost_text_view10 = root.findViewById(R.id.elixir_cost_text_view10);

        textView1 = root.findViewById(R.id.deck_text1);textView2 = root.findViewById(R.id.deck_text2);
        textView3 = root.findViewById(R.id.deck_text3);textView4 = root.findViewById(R.id.deck_text4);
        textView5 = root.findViewById(R.id.deck_text5);textView6 = root.findViewById(R.id.deck_text6);
        textView7 = root.findViewById(R.id.deck_text7);textView8 = root.findViewById(R.id.deck_text8);
        textView9 = root.findViewById(R.id.deck_text9);textView10 = root.findViewById(R.id.deck_text10);

        cardViews = new ImageView[]{cardView1,cardView2,cardView3,cardView4,cardView5,cardView6,cardView7,cardView8,
                cardView9,cardView10,cardView11,cardView12,cardView13,cardView14,cardView15,cardView16,
                cardView17,cardView18,cardView19,cardView20,cardView21,cardView22,cardView23,cardView24,
                cardView25,cardView26,cardView27,cardView28,cardView29,cardView30,cardView31,cardView32,
                cardView33,cardView34,cardView35,cardView36,cardView37,cardView38,cardView39,cardView40,
                cardView41,cardView42,cardView43,cardView44,cardView45,cardView46,cardView47,cardView48,
                cardView49,cardView50,cardView51,cardView52,cardView53,cardView54,cardView55,cardView56,
                cardView57,cardView58,cardView59,cardView60,cardView61,cardView62,cardView63,cardView64,
                cardView65,cardView66,cardView67,cardView68,cardView69,cardView70,cardView71,cardView72,
                cardView73,cardView74,cardView75,cardView76,cardView77,cardView78,cardView79,cardView80};

        addButtons = new Button[]{addButton1,addButton2,addButton3,addButton4,addButton5,addButton6,addButton7,addButton8,
                addButton9,addButton10,addButton11,addButton12,addButton13,addButton14,addButton15,addButton16,
                addButton17,addButton18,addButton19,addButton20,addButton21,addButton22,addButton23,addButton24,
                addButton25,addButton26,addButton27,addButton28,addButton29,addButton30,addButton31,addButton32,
                addButton33,addButton34,addButton35,addButton36,addButton37,addButton38,addButton39,addButton40,
                addButton41,addButton42,addButton43,addButton44,addButton45,addButton46,addButton47,addButton48,
                addButton49,addButton50,addButton51,addButton52,addButton53,addButton54,addButton55,addButton56,
                addButton57,addButton58,addButton59,addButton60,addButton61,addButton62,addButton63,addButton64,
                addButton65,addButton66,addButton67,addButton68,addButton69,addButton70,addButton71,addButton72,
                addButton73,addButton74,addButton75,addButton76,addButton77,addButton78,addButton79,addButton80};

        textViews = new TextView[]{textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9,textView10};

        elixir_cost_text_views = new TextView[]{elixir_cost_text_view1,elixir_cost_text_view2,elixir_cost_text_view3
                ,elixir_cost_text_view4,elixir_cost_text_view5,elixir_cost_text_view6,elixir_cost_text_view7
                ,elixir_cost_text_view8,elixir_cost_text_view9,elixir_cost_text_view10};

        elixir_dict.put("mirror",0);elixir_dict.put("heal_spirit",1);elixir_dict.put("ice_spirit",1);elixir_dict.put("skeletons",1);elixir_dict.put("barbarian_barrel",2);
        elixir_dict.put("goblins",2);elixir_dict.put("the_log",2);elixir_dict.put("zap",2);elixir_dict.put("rage",2);elixir_dict.put("wall_breakers",2);
        elixir_dict.put("bats",2);elixir_dict.put("ice_golem",2);elixir_dict.put("fire_spirits",2);elixir_dict.put("spear_goblins",2);elixir_dict.put("giant_snowball",2);
        elixir_dict.put("royal_delivery",3);elixir_dict.put("goblin_barrel",3);elixir_dict.put("arrows",3);elixir_dict.put("skeleton_army",3);elixir_dict.put("bomber",3);
        elixir_dict.put("tombstone",3);elixir_dict.put("cannon",3);elixir_dict.put("elixir_golem",3);elixir_dict.put("firecracker",3);elixir_dict.put("fisherman",3);
        elixir_dict.put("tornado",3);elixir_dict.put("skeleton_barrel",3);elixir_dict.put("clone",3);elixir_dict.put("earthquake",3);elixir_dict.put("ice_wizard",3);
        elixir_dict.put("royal_ghost",3);elixir_dict.put("guards",3);elixir_dict.put("princess",3);elixir_dict.put("bandit",3);elixir_dict.put("knight",3);
        elixir_dict.put("archers",3);elixir_dict.put("goblin_gang",3);elixir_dict.put("miner",3);elixir_dict.put("dart_goblin",3);elixir_dict.put("mega_minion",3);
        elixir_dict.put("minions",3);elixir_dict.put("battle_ram",4);elixir_dict.put("inferno_dragon",4);elixir_dict.put("lumberjack",4);elixir_dict.put("poison",4);
        elixir_dict.put("freeze",4);elixir_dict.put("zappies",4);elixir_dict.put("electro_wizard",4);elixir_dict.put("valkyrie",4);elixir_dict.put("hunter",4);
        elixir_dict.put("fireball",4);elixir_dict.put("dark_prince",4);elixir_dict.put("goblin_cage",4);elixir_dict.put("night_witch",4);elixir_dict.put("furnace",4);
        elixir_dict.put("musketeer",4);elixir_dict.put("tesla",4);elixir_dict.put("bomb_tower",4);elixir_dict.put("mortar",4);elixir_dict.put("hog_rider",4);
        elixir_dict.put("baby_dragon",4);elixir_dict.put("flying_machine",4);elixir_dict.put("battle_healer",4);elixir_dict.put("magic_archer",4);elixir_dict.put("mini_pekka",4);
        elixir_dict.put("royal_hogs",5);elixir_dict.put("wizard",5);elixir_dict.put("prince",5);elixir_dict.put("witch",5);elixir_dict.put("goblin_hut",5);
        elixir_dict.put("cannon_cart",5);elixir_dict.put("inferno_tower",5);elixir_dict.put("rascals",5);elixir_dict.put("graveyard",5);elixir_dict.put("minion_horde",5);
        elixir_dict.put("ram_rider",5);elixir_dict.put("barbarians",5);elixir_dict.put("executioner",5);elixir_dict.put("giant",5);elixir_dict.put("balloon",5);
        elixir_dict.put("bowler",5);elixir_dict.put("electro_dragon",5);elixir_dict.put("goblin_giant",6);elixir_dict.put("giant_skeleton",6);elixir_dict.put("elixir_collector",6);
        elixir_dict.put("xbow",6);elixir_dict.put("royal_giant",6);elixir_dict.put("elite_barbarians",6);elixir_dict.put("rocket",6);elixir_dict.put("sparky",6);
        elixir_dict.put("lightning",6);elixir_dict.put("barbarian_hut",6);elixir_dict.put("pekka",7);elixir_dict.put("mega_knight",7);
        elixir_dict.put("lava_hound",7);elixir_dict.put("golem",8);elixir_dict.put("three_musketeers",9);elixir_dict.put("royal_recruits",7);

        drawable_dict.put("mirror",R.drawable.mirror);drawable_dict.put("heal_spirit",R.drawable.heal_spirit);drawable_dict.put("ice_spirit",R.drawable.ice_spirit);drawable_dict.put("skeletons",R.drawable.skeletons);drawable_dict.put("barbarian_barrel",R.drawable.barbarian_barrel);
        drawable_dict.put("goblins",R.drawable.goblins);drawable_dict.put("the_log",R.drawable.the_log);drawable_dict.put("zap",R.drawable.zap);drawable_dict.put("rage",R.drawable.rage);drawable_dict.put("wall_breakers",R.drawable.wall_breakers);
        drawable_dict.put("bats",R.drawable.bats);drawable_dict.put("ice_golem",R.drawable.ice_golem);drawable_dict.put("fire_spirits",R.drawable.fire_spirits);drawable_dict.put("spear_goblins",R.drawable.spear_goblins);drawable_dict.put("giant_snowball",R.drawable.giant_snowball);
        drawable_dict.put("royal_delivery",R.drawable.royal_delivery);drawable_dict.put("goblin_barrel",R.drawable.goblin_barrel);drawable_dict.put("arrows",R.drawable.arrows);drawable_dict.put("skeleton_army",R.drawable.skeleton_army);drawable_dict.put("bomber",R.drawable.bomber);
        drawable_dict.put("tombstone",R.drawable.tombstone);drawable_dict.put("cannon",R.drawable.cannon);drawable_dict.put("elixir_golem",R.drawable.elixir_golem);drawable_dict.put("firecracker",R.drawable.firecracker);drawable_dict.put("fisherman",R.drawable.fisherman);
        drawable_dict.put("tornado",R.drawable.tornado);drawable_dict.put("skeleton_barrel",R.drawable.skeleton_barrel);drawable_dict.put("clone",R.drawable.clone);drawable_dict.put("earthquake",R.drawable.earthquake);drawable_dict.put("ice_wizard",R.drawable.ice_wizard);
        drawable_dict.put("royal_ghost",R.drawable.royal_ghost);drawable_dict.put("guards",R.drawable.guards);drawable_dict.put("princess",R.drawable.princess);drawable_dict.put("bandit",R.drawable.bandit);drawable_dict.put("knight",R.drawable.knight);
        drawable_dict.put("archers",R.drawable.archers);drawable_dict.put("goblin_gang",R.drawable.goblin_gang);drawable_dict.put("miner",R.drawable.miner);drawable_dict.put("dart_goblin",R.drawable.dart_goblin);drawable_dict.put("mega_minion",R.drawable.mega_minion);
        drawable_dict.put("minions",R.drawable.minions);drawable_dict.put("battle_ram",R.drawable.battle_ram);drawable_dict.put("inferno_dragon",R.drawable.inferno_dragon);drawable_dict.put("lumberjack",R.drawable.lumberjack);drawable_dict.put("poison",R.drawable.poison);
        drawable_dict.put("freeze",R.drawable.freeze);drawable_dict.put("zappies",R.drawable.zappies);drawable_dict.put("electro_wizard",R.drawable.electro_wizard);drawable_dict.put("valkyrie",R.drawable.valkyrie);drawable_dict.put("hunter",R.drawable.hunter);
        drawable_dict.put("fireball",R.drawable.fireball);drawable_dict.put("dark_prince",R.drawable.dark_prince);drawable_dict.put("goblin_cage",R.drawable.goblin_cage);drawable_dict.put("night_witch",R.drawable.night_witch);drawable_dict.put("furnace",R.drawable.furnace);
        drawable_dict.put("musketeer",R.drawable.musketeer);drawable_dict.put("tesla",R.drawable.tesla);drawable_dict.put("bomb_tower",R.drawable.bomb_tower);drawable_dict.put("mortar",R.drawable.mortar);drawable_dict.put("hog_rider",R.drawable.hog_rider);
        drawable_dict.put("baby_dragon",R.drawable.baby_dragon);drawable_dict.put("flying_machine",R.drawable.flying_machine);drawable_dict.put("battle_healer",R.drawable.battle_healer);drawable_dict.put("magic_archer",R.drawable.magic_archer);drawable_dict.put("mini_pekka",R.drawable.mini_pekka);
        drawable_dict.put("royal_hogs",R.drawable.royal_hogs);drawable_dict.put("wizard",R.drawable.wizard);drawable_dict.put("prince",R.drawable.prince);drawable_dict.put("witch",R.drawable.witch);drawable_dict.put("goblin_hut",R.drawable.goblin_hut);
        drawable_dict.put("cannon_cart",R.drawable.cannon_cart);drawable_dict.put("inferno_tower",R.drawable.inferno_tower);drawable_dict.put("rascals",R.drawable.rascals);drawable_dict.put("graveyard",R.drawable.graveyard);drawable_dict.put("minion_horde",R.drawable.minion_horde);
        drawable_dict.put("ram_rider",R.drawable.ram_rider);drawable_dict.put("barbarians",R.drawable.barbarians);drawable_dict.put("executioner",R.drawable.executioner);drawable_dict.put("giant",R.drawable.giant);drawable_dict.put("balloon",R.drawable.balloon);
        drawable_dict.put("bowler",R.drawable.bowler);drawable_dict.put("electro_dragon",R.drawable.electro_dragon);drawable_dict.put("goblin_giant",R.drawable.goblin_giant);drawable_dict.put("giant_skeleton",R.drawable.giant_skeleton);drawable_dict.put("elixir_collector",R.drawable.elixir_collector);
        drawable_dict.put("xbow",R.drawable.xbow);drawable_dict.put("royal_giant",R.drawable.royal_giant);drawable_dict.put("elite_barbarians",R.drawable.elite_barbarians);drawable_dict.put("rocket",R.drawable.rocket);drawable_dict.put("sparky",R.drawable.sparky);
        drawable_dict.put("lightning",R.drawable.lightning);drawable_dict.put("barbarian_hut",R.drawable.barbarian_hut);drawable_dict.put("pekka",R.drawable.pekka);drawable_dict.put("mega_knight",R.drawable.mega_knight);
        drawable_dict.put("lava_hound",R.drawable.lava_hound);drawable_dict.put("golem",R.drawable.golem);drawable_dict.put("three_musketeers",R.drawable.three_musketeers);drawable_dict.put("royal_recruits",R.drawable.royal_recruits);



        Deck deck1 = new Deck(textView1,elixir_cost_text_view1,cardView1,
                cardView2,cardView3,cardView4,cardView5,cardView6,cardView7,
                cardView8,addButton1,addButton2,addButton3,addButton4,addButton5,
                addButton6,addButton7,addButton8);
        Deck deck2 = new Deck(textView2,elixir_cost_text_view2,cardView9,
                cardView10,cardView11,cardView12,cardView13,cardView14,cardView15,
                cardView16,addButton9,addButton10,addButton11,addButton12,addButton13,
                addButton14,addButton15,addButton16);
        Deck deck3 = new Deck(textView3,elixir_cost_text_view3,cardView17,
                cardView18,cardView19,cardView20,cardView21,cardView22,cardView23,
                cardView24,addButton17,addButton18,addButton19,addButton20,
                addButton21,addButton22,addButton23,addButton24);
        Deck deck4 = new Deck(textView4,elixir_cost_text_view4,cardView25,
                cardView26,cardView27,cardView28,cardView29,cardView30,cardView31,cardView32,
                addButton25,addButton26,addButton27,addButton28,addButton29,addButton30,addButton31,addButton32);
        Deck deck5 = new Deck(textView5,elixir_cost_text_view5,cardView33,
                cardView34,cardView35,cardView36,cardView37,cardView38,cardView39,
                cardView40,addButton33,addButton34,addButton35,addButton36,
                addButton37,addButton38,addButton39,addButton40);
        Deck deck6 = new Deck(textView6,elixir_cost_text_view6,cardView41,
                cardView42,cardView43,cardView44,cardView45,cardView46,cardView47,
                cardView48,addButton41,addButton42,addButton43,addButton44,addButton45,
                addButton46,addButton47,addButton48);
        Deck deck7 = new Deck(textView7,elixir_cost_text_view7,cardView49,
                cardView50,cardView51,cardView52,cardView53,cardView54,cardView55,
                cardView56,addButton49,addButton50,addButton51,addButton52,addButton53
                ,addButton54,addButton55,addButton56);
        Deck deck8 = new Deck(textView8,elixir_cost_text_view8,cardView57,
                cardView58,cardView59,cardView60,cardView61,cardView62,cardView63,
                cardView64,addButton57,addButton58,addButton59,addButton60,addButton61,addButton62
                ,addButton63,addButton64);
        Deck deck9 = new Deck(textView9,elixir_cost_text_view9,cardView65,
                cardView66,cardView67,cardView68,cardView69,cardView70,cardView71,
                cardView72,addButton65,addButton66,addButton67,addButton68,addButton69,
                addButton70,addButton71,addButton72);
        Deck deck10 = new Deck(textView10,elixir_cost_text_view10,cardView73,
                cardView74,cardView75,cardView76,cardView77,cardView78,cardView79,cardView80,
                addButton73,addButton74,addButton75,addButton76,addButton77,addButton78,addButton79,addButton80);

         decks = new Deck[]{deck1,deck2,deck3,deck4,deck5,deck6,deck7,deck8,deck9,deck10};


        cardView1.setImageResource(R.drawable.arena1);
        cardView2.setImageResource(R.drawable.arena2);
        cardView3.setImageResource(R.drawable.arena3);
        cardView4.setImageResource(R.drawable.arena4);
        cardView5.setImageResource(R.drawable.arena5);
        cardView6.setImageResource(R.drawable.arena6);
        cardView7.setImageResource(R.drawable.arena7);
        cardView8.setImageResource(R.drawable.arena8);
        cardView9.setImageResource(R.drawable.arena9);
        cardView10.setImageResource(R.drawable.arena10);
        cardView11.setImageResource(R.drawable.arena11);
        cardView12.setImageResource(R.drawable.arena12);
        cardView13.setImageResource(R.drawable.league1);
        cardView14.setImageResource(R.drawable.league2);
        cardView15.setImageResource(R.drawable.league3);
        cardView16.setImageResource(R.drawable.league4);
        cardView17.setImageResource(R.drawable.league5);
        cardView18.setImageResource(R.drawable.league6);
        cardView19.setImageResource(R.drawable.league7);
        cardView17.setImageResource(R.drawable.league8);
        cardView18.setImageResource(R.drawable.league9);
        cardView19.setImageResource(R.drawable.league10);

        AddClick();
        CardClick();
        DeckName();
        GetAverageElixir();
        return root;
    }

    @Override
    public void onPause() {
        super.onPause();

        if (getParentFragmentManager().findFragmentByTag("MyFragment") != null)
            getParentFragmentManager().findFragmentByTag("MyFragment").setRetainInstance(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getParentFragmentManager().findFragmentByTag("MyFragment") != null)
            getParentFragmentManager().findFragmentByTag("MyFragment").getRetainInstance();
    }




    public static void GetAverageElixir() {


        for (int j=0; j<decks.length;j++) {
            double total = 0;
            double average;
            for (int i = 0; i < 8; i++) {
                ImageView c = decks[j].card_array[i];
                if (!c.getTag().equals("")) {
                    if (c.getTag().equals("mirror")) {
                        total = total + 1.5;
                    } else {

                        total = total + elixir_dict.get(c.getTag());
                    }

                }

            }
            average = (double) total / 8;
            average = Math.round(average * 10) / 10.0;
            elixir_cost_text_views[j].setText("Average Elixir Cost: " + average);
        }



    }
    public void DeckName(){
        dialog = new AlertDialog.Builder(getActivity()).create();
        editText1 = new EditText(getActivity());
        dialog.setTitle("Edit this text");
        dialog.setView(editText1);

        for (int i=0; i<textViews.length;i++) {
            final TextView t = textViews[i];

            t.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "SAVE TEXT", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            t.setText(" "+editText1.getText() + "");


                        }
                    });
                    dialog.setButton(DialogInterface.BUTTON_POSITIVE, "CANCEL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    dialog.show();
                    editText1.setText(t.getText());

                }
            });



        }
    }

    public void openActivity2(int pos){

        Intent intent = new Intent(getActivity(), Activity2.class);
        Bundle b = new Bundle();
        b.putInt("key", pos);
        intent.putExtras(b);
        startActivity(intent);
    }


    public void CardClick() {
        for (int j = 0; j < decks.length; j++){
            for (int i = 0; i < 8; i++) {
                final Button b = decks[j].button_array[i];
                ImageView c = decks[j].card_array[i];
                c.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (b.getVisibility() == View.INVISIBLE) {
                            b.setVisibility(View.VISIBLE);
                        } else {
                            b.setVisibility(View.INVISIBLE);
                        }
                    }
                });
            }
        }
    }

    public void AddClick(){
        for (int j =0; j<decks.length;j++) {
            final int k = j;
            for (int i = 0; i < 8; i++) {
                final Button b = decks[j].button_array[i];
                final ImageView c = decks[j].card_array[i];
                final int pos = j;
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        b.setTag("selected");
                        deck_selected = k;
                        for (int m=0; m<8;m++) {
                            decks[k].button_array[m].setVisibility(View.INVISIBLE);
                        }
                        openActivity2(pos);

                    }
                });
            }
        }
    }
    public static class Deck {
        public TextView deck_text_view;
        public TextView elixir_text_view;
        public ImageView c1; public Button b1;
        public ImageView c2; public Button b2;
        public ImageView c3; public Button b3;
        public ImageView c4; public Button b4;
        public ImageView c5; public Button b5;
        public ImageView c6; public Button b6;
        public ImageView c7; public Button b7;
        public ImageView c8; public Button b8;

        public ImageView[] card_array;
        public Button[] button_array;

        public Deck(TextView deck_text_view, TextView elixir_text_view, ImageView c1,
                    ImageView c2,ImageView c3,ImageView c4,ImageView c5,ImageView c6,
                    ImageView c7, ImageView c8, Button b1, Button b2, Button b3, Button b4,
                    Button b5, Button b6, Button b7, Button b8
        ){

            this.deck_text_view = deck_text_view;
            this.elixir_text_view = elixir_text_view;
            this.c1 = c1; this.b1 = b1;
            this.c2 = c2; this.b2 = b2;
            this.c3 = c3; this.b3 = b3;
            this.c4 = c4; this.b4 = b4;
            this.c5 = c5; this.b5 = b5;
            this.c6 = c6; this.b6 = b6;
            this.c7 = c7; this.b7 = b7;
            this.c8 = c8; this.b8 = b8;
            card_array = new ImageView[]{c1,c2,c3,c4,c5,c6,c7,c8};
            button_array = new Button[]{b1,b2,b3,b4,b5,b6,b7,b8};


        }
    }
}

