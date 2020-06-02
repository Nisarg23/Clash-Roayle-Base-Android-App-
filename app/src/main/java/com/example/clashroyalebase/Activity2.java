package com.example.clashroyalebase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.clashroyalebase.ui.home.HomeFragment;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity {
    public static ImageView[] allCards = new ImageView[0];
    public static Button[] allButtons = new Button[0];

    public static int pos;

    public static TextInputEditText input_text;



    public static ImageView mirror;public static ImageView heal_spirit;public static ImageView ice_spirit;public static ImageView skeletons;public static ImageView barbarian_barrel;public static ImageView goblins;public static ImageView the_log;
    public static ImageView zap;public static ImageView rage;public static ImageView wall_breakers;public static ImageView bats;public static ImageView ice_golem;public static ImageView fire_spirits;public static ImageView spear_goblins;public static ImageView giant_snowball;
    public static ImageView royal_delievery;public static ImageView goblin_barrel;public static ImageView arrows;public static ImageView skeleton_army;public static ImageView bomber;public static ImageView tombstone;public static ImageView cannon;
    public static ImageView elixir_golem;public static ImageView firecracker;public static ImageView fisherman;public static ImageView tornado;public static ImageView skeleton_barrel;public static ImageView clone;public static ImageView earthquake;public static ImageView ice_wizard;
    public static ImageView royal_ghost;public static ImageView guards;public static ImageView princess;public static ImageView bandit;public static ImageView knight;public static ImageView archers;public static ImageView goblin_gang;public static ImageView miner;
    public static ImageView dart_goblin;public static ImageView mega_minion;public static ImageView minions;public static ImageView battle_ram;public static ImageView inferno_dragon;public static ImageView lumberjack;public static ImageView poison;
    public static ImageView freeze;public static ImageView zappies;public static ImageView electro_wizard;public static ImageView valkyrie;public static ImageView hunter;public static ImageView fireball;public static ImageView dark_prince;public static ImageView goblin_cage;
    public static ImageView night_witch;public static ImageView furncae;public static ImageView musketeer;public static ImageView tesla;public static ImageView bomb_tower;public static ImageView mortar;public static ImageView hog_rider;public static ImageView baby_dragon;
    public static ImageView flying_machine;public static ImageView battle_healer;public static ImageView magic_archer;public static ImageView mini_pekka;public static ImageView royal_hogs;public static ImageView wizard;public static ImageView prince;
    public static ImageView witch;public static ImageView goblin_hut;public static ImageView cannon_cart;public static ImageView inferno_tower;public static ImageView rascals;public static ImageView graveyard;public static ImageView minion_horde;public static ImageView ram_rider;
    public static ImageView barbarians;public static ImageView executioner;public static ImageView giant;public static ImageView balloon;public static ImageView bowler;public static ImageView electro_dragon;public static ImageView goblin_giant;
    public static ImageView ginat_skeleton;public static ImageView elixir_collector;public static ImageView xbow;public static ImageView royal_giant;public static ImageView elite_barbarians;public static ImageView rocket;public static ImageView sparky;
    public static ImageView lightning;public static ImageView barbarian_hut;public static ImageView pekka;public static ImageView mega_knight;public static ImageView royal_recruits;public static ImageView lava_hound;public static ImageView golem;
    public static ImageView three_musketeers;


    public static Button mirror_button;public static Button heal_spirit_button;public static Button ice_spirit_button;public static Button skeletons_button;public static Button barbarian_barrel_button;public static Button goblins_button;
    public static Button the_log_button;public static Button zap_button;public static Button rage_button;public static Button wall_breakers_button;public static Button bats_button;public static Button ice_golem_button;public static Button fire_spirits_button;
    public static Button spear_goblins_button;public static Button giant_snowball_button;public static Button royal_delievery_button;public static Button goblin_barrel_button;public static Button arrows_button;public static Button skeleton_army_button;
    public static Button bomber_button;public static Button tombstone_button;public static Button cannon_button;public static Button elixir_golem_button;public static Button firecracker_button;public static Button fisherman_button;public static Button tornado_button;
    public static Button skeleton_barrel_button;public static Button clone_button;public static Button earthquake_button;public static Button ice_wizard_button;public static Button royal_ghost_button;public static Button guards_button;public static Button princess_button;
    public static Button bandit_button;public static Button knight_button;public static Button archers_button;public static Button goblin_gang_button;public static Button miner_button;public static Button dart_goblin_button;public static Button mega_minion_button;
    public static Button minions_button;public static Button battle_ram_button;public static Button inferno_dragon_button;public static Button lumberjack_button;public static Button poison_button;public static Button freeze_button;public static Button zappies_button;
    public static Button electro_wizard_button;public static Button valkyrie_button;public static Button hunter_button;public static Button fireball_button;public static Button dark_prince_button;public static Button goblin_cage_button;
    public static Button night_witch_button;public static Button furncae_button;public static Button musketeer_button;public static Button tesla_button;public static Button bomb_tower_button;public static Button mortar_button;public static Button hog_rider_button;
    public static Button baby_dragon_button;public static Button flying_machine_button;public static Button battle_healer_button;public static Button magic_archer_button;public static Button mini_pekka_button;public static Button royal_hogs_button;
    public static Button wizard_button;public static Button prince_button;public static Button witch_button;public static Button goblin_hut_button;public static Button cannon_cart_button;public static Button inferno_tower_button;public static Button rascals_button;
    public static Button graveyard_button;public static Button minion_horde_button;public static Button ram_rider_button;public static Button barbarians_button;public static Button executioner_button;public static Button giant_button;public static Button balloon_button;
    public static Button bowler_button;public static Button electro_dragon_button;public static Button goblin_giant_button;public static Button ginat_skeleton_button;public static Button elixir_collector_button;public static Button xbow_button;
    public static Button royal_giant_button;public static Button elite_barbarians_button;public static Button rocket_button;public static Button sparky_button;public static Button lightning_button;public static Button barbarian_hut_button;
    public static Button pekka_button;public static Button mega_knight_button;public static Button royal_recruits_button;public static Button lava_hound_button;public static Button golem_button;public static Button three_musketeers_button;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        mirror = findViewById(R.id.mirror);heal_spirit = findViewById(R.id.heal_spirit);ice_spirit = findViewById(R.id.ice_spirit);skeletons = findViewById(R.id.skeletons);
        barbarian_barrel = findViewById(R.id.barbarian_barrel);goblins = findViewById(R.id.goblins);the_log = findViewById(R.id.the_log);zap = findViewById(R.id.zap);
        rage = findViewById(R.id.rage);wall_breakers = findViewById(R.id.wall_breakers);bats = findViewById(R.id.bats);ice_golem = findViewById(R.id.ice_golem);
        fire_spirits = findViewById(R.id.fire_spirits);spear_goblins = findViewById(R.id.spear_goblins);giant_snowball = findViewById(R.id.giant_snowball);royal_delievery = findViewById(R.id.royal_delivery);
        goblin_barrel = findViewById(R.id.goblin_barrel);arrows = findViewById(R.id.arrows);skeleton_army = findViewById(R.id.skeleton_army);bomber = findViewById(R.id.bomber);
        tombstone  = findViewById(R.id.tombstone);cannon = findViewById(R.id.cannon);elixir_golem = findViewById(R.id.elixir_golem);firecracker = findViewById(R.id.firecracker);
        fisherman = findViewById(R.id.fisherman);tornado = findViewById(R.id.tornado);skeleton_barrel = findViewById(R.id.skeleton_barrel);clone = findViewById(R.id.clone);
        earthquake  = findViewById(R.id.earthquake);ice_wizard = findViewById(R.id.ice_wizard);royal_ghost = findViewById(R.id.royal_ghost);guards = findViewById(R.id.guards);
        princess = findViewById(R.id.princess);bandit = findViewById(R.id.bandit);knight = findViewById(R.id.knight);archers = findViewById(R.id.archers);
        goblin_gang  = findViewById(R.id.goblin_gang);miner = findViewById(R.id.miner);dart_goblin = findViewById(R.id.dart_goblin);mega_minion = findViewById(R.id.mega_minion);
        minions = findViewById(R.id.minions);battle_ram = findViewById(R.id.battle_ram);inferno_dragon = findViewById(R.id.inferno_dragon);lumberjack = findViewById(R.id.lumberjack);
        poison = findViewById(R.id.poison);freeze = findViewById(R.id.freeze);zappies = findViewById(R.id.zappies);electro_wizard = findViewById(R.id.electro_wizard);
        valkyrie = findViewById(R.id.valkyrie);hunter = findViewById(R.id.hunter);fireball = findViewById(R.id.fireball);dark_prince = findViewById(R.id.dark_prince);
        goblin_cage = findViewById(R.id.goblin_cage);night_witch = findViewById(R.id.night_witch);furncae = findViewById(R.id.furnace);musketeer = findViewById(R.id.musketeer);
        tesla = findViewById(R.id.tesla);bomb_tower = findViewById(R.id.bomb_tower);mortar = findViewById(R.id.mortar);hog_rider = findViewById(R.id.hog_rider);
        baby_dragon = findViewById(R.id.baby_dragon);flying_machine = findViewById(R.id.flying_machine);battle_healer = findViewById(R.id.battle_healer);magic_archer = findViewById(R.id.magic_archer);
        mini_pekka = findViewById(R.id.mini_pekka);royal_hogs = findViewById(R.id.royal_hogs);wizard = findViewById(R.id.wizard);prince = findViewById(R.id.prince);
        witch  = findViewById(R.id.witch);goblin_hut = findViewById(R.id.goblin_hut);cannon_cart = findViewById(R.id.cannon_cart);inferno_tower = findViewById(R.id.inferno_tower);
        rascals = findViewById(R.id.rascals);graveyard = findViewById(R.id.graveyard);minion_horde = findViewById(R.id.minion_horde);ram_rider = findViewById(R.id.ram_rider);
        barbarians = findViewById(R.id.barbarians);executioner = findViewById(R.id.executioner);giant = findViewById(R.id.giant);balloon = findViewById(R.id.balloon);
        bowler = findViewById(R.id.bowler);electro_dragon = findViewById(R.id.electro_dragon);goblin_giant = findViewById(R.id.goblin_giant);ginat_skeleton = findViewById(R.id.giant_skeleton);
        elixir_collector = findViewById(R.id.elixir_collector);xbow = findViewById(R.id.xbow);royal_giant = findViewById(R.id.royal_giant);elite_barbarians = findViewById(R.id.elite_barbarians);
        rocket  = findViewById(R.id.rocket);sparky = findViewById(R.id.sparky);lightning = findViewById(R.id.lightning);barbarian_hut = findViewById(R.id.barbarian_hut);
        pekka = findViewById(R.id.pekka);mega_knight = findViewById(R.id.mega_knight);royal_recruits = findViewById(R.id.royal_recruits);lava_hound = findViewById(R.id.lava_hound);
        golem = findViewById(R.id.golem);three_musketeers = findViewById(R.id.three_musketeers);

        mirror_button = findViewById(R.id.mirror_button);heal_spirit_button = findViewById(R.id.heal_spirit_button);ice_spirit_button = findViewById(R.id.ice_spirit_button);
        skeletons_button = findViewById(R.id.skeletons_button);barbarian_barrel_button = findViewById(R.id.barbarian_barrel_button);
        goblins_button = findViewById(R.id.goblins_button);the_log_button = findViewById(R.id.the_log_button);zap_button = findViewById(R.id.zap_button);
        rage_button = findViewById(R.id.rage_button);wall_breakers_button = findViewById(R.id.wall_breakers_button);bats_button = findViewById(R.id.bats_button);
        ice_golem_button = findViewById(R.id.ice_golem_button);fire_spirits_button = findViewById(R.id.fire_spirits_button);spear_goblins_button = findViewById(R.id.spear_goblins_button);
        giant_snowball_button = findViewById(R.id.giant_snowball_button);royal_delievery_button = findViewById(R.id.royal_delivery_button);goblin_barrel_button = findViewById(R.id.goblin_barrel_button);
        arrows_button = findViewById(R.id.arrows_button);skeleton_army_button = findViewById(R.id.skeleton_army_button);bomber_button = findViewById(R.id.bomber_button);
        tombstone_button  = findViewById(R.id.tombstone_button);cannon_button = findViewById(R.id.cannon_button);elixir_golem_button = findViewById(R.id.elixir_golem_button);
        firecracker_button = findViewById(R.id.firecracker_button);fisherman_button = findViewById(R.id.fisherman_button);tornado_button = findViewById(R.id.tornado_button);
        skeleton_barrel_button = findViewById(R.id.skeleton_barrel_button);clone_button = findViewById(R.id.clone_button);earthquake_button  = findViewById(R.id.earthquake_button);
        ice_wizard_button = findViewById(R.id.ice_wizard_button);royal_ghost_button = findViewById(R.id.royal_ghost_button);guards_button = findViewById(R.id.guards_button);
        princess_button = findViewById(R.id.princess_button);bandit_button = findViewById(R.id.bandit_button);knight_button = findViewById(R.id.knight_button);
        archers_button = findViewById(R.id.archers_button);goblin_gang_button  = findViewById(R.id.goblin_gang_button);miner_button = findViewById(R.id.miner_button);
        dart_goblin_button = findViewById(R.id.dart_goblin_button);mega_minion_button = findViewById(R.id.mega_minion_button);minions_button = findViewById(R.id.minions_button);
        battle_ram_button = findViewById(R.id.battle_ram_button);inferno_dragon_button = findViewById(R.id.inferno_dragon_button);lumberjack_button = findViewById(R.id.lumberjack_button);
        poison_button = findViewById(R.id.poison_button);freeze_button = findViewById(R.id.freeze_button);zappies_button = findViewById(R.id.zappies_button);
        electro_wizard_button = findViewById(R.id.electro_wizard_button);valkyrie_button = findViewById(R.id.valkyrie_button);hunter_button = findViewById(R.id.hunter_button);
        fireball_button = findViewById(R.id.fireball_button);dark_prince_button = findViewById(R.id.dark_prince_button);goblin_cage_button= findViewById(R.id.goblin_cage_button);
        night_witch_button = findViewById(R.id.night_witch_button);furncae_button = findViewById(R.id.furnace_button);musketeer_button = findViewById(R.id.musketeer_button);
        tesla_button = findViewById(R.id.tesla_button);bomb_tower_button = findViewById(R.id.bomb_tower_button);mortar_button = findViewById(R.id.mortar_button);
        hog_rider_button = findViewById(R.id.hog_rider_button);baby_dragon_button = findViewById(R.id.baby_dragon_button);flying_machine_button = findViewById(R.id.flying_machine_button);
        battle_healer_button = findViewById(R.id.battle_healer_button);magic_archer_button = findViewById(R.id.magic_archer_button);mini_pekka_button = findViewById(R.id.mini_pekka_button);
        royal_hogs_button = findViewById(R.id.royal_hogs_button);wizard_button = findViewById(R.id.wizard_button);prince_button = findViewById(R.id.prince_button);
        witch_button  = findViewById(R.id.witch_button);goblin_hut_button = findViewById(R.id.goblin_hut_button);cannon_cart_button = findViewById(R.id.cannon_cart_button);
        inferno_tower_button = findViewById(R.id.inferno_tower_button);rascals_button = findViewById(R.id.rascals_button);graveyard_button = findViewById(R.id.graveyard_button);
        minion_horde_button = findViewById(R.id.minion_horde_button);ram_rider_button = findViewById(R.id.ram_rider_button);barbarians_button = findViewById(R.id.barbarians_button);
        executioner_button = findViewById(R.id.executioner_button);giant_button = findViewById(R.id.giant_button);balloon_button = findViewById(R.id.balloon_button);
        bowler_button = findViewById(R.id.bowler_button);electro_dragon_button = findViewById(R.id.electro_dragon_button);goblin_giant_button = findViewById(R.id.goblin_giant_button);
        ginat_skeleton_button = findViewById(R.id.giant_skeleton_button);elixir_collector_button = findViewById(R.id.eleixir_collector_button);
        xbow_button = findViewById(R.id.xbow_button);royal_giant_button = findViewById(R.id.royal_giant_button);elite_barbarians_button = findViewById(R.id.elite_barbarians_button);
        rocket_button  = findViewById(R.id.rocket_button);sparky_button = findViewById(R.id.sparky_button);lightning_button = findViewById(R.id.lightning_button);
        barbarian_hut_button = findViewById(R.id.barbarian_hut_button);pekka_button = findViewById(R.id.pekka_button);mega_knight_button = findViewById(R.id.mega_knight_button);
        royal_recruits_button = findViewById(R.id.royal_recruits_button);lava_hound_button = findViewById(R.id.lava_hound_button);
        golem_button = findViewById(R.id.golem_button);three_musketeers_button = findViewById(R.id.three_musketeers_button);

        allCards = new ImageView[]{mirror, heal_spirit, ice_spirit, skeletons, barbarian_barrel, goblins, the_log,
                zap, rage, wall_breakers, bats, ice_golem, fire_spirits, spear_goblins, giant_snowball,
                royal_delievery, goblin_barrel, arrows, skeleton_army, bomber, tombstone, cannon,
                elixir_golem, firecracker, fisherman, tornado, skeleton_barrel, clone, earthquake, ice_wizard,
                royal_ghost, guards, princess, bandit, knight, archers, goblin_gang, miner,
                dart_goblin, mega_minion, minions, battle_ram, inferno_dragon, lumberjack, poison,
                freeze, zappies, electro_wizard, valkyrie, hunter, fireball, dark_prince, goblin_cage,
                night_witch, furncae, musketeer, tesla, bomb_tower, mortar, hog_rider, baby_dragon,
                flying_machine, battle_healer, magic_archer, mini_pekka, royal_hogs, wizard, prince,
                witch, goblin_hut, cannon_cart, inferno_tower, rascals, graveyard, minion_horde, ram_rider,
                barbarians, executioner, giant, balloon, bowler, electro_dragon, goblin_giant,
                ginat_skeleton, elixir_collector, xbow, royal_giant, elite_barbarians, rocket, sparky,
                lightning, barbarian_hut, pekka, mega_knight, royal_recruits, lava_hound, golem,
                three_musketeers};
        allButtons = new Button[]{mirror_button, heal_spirit_button, ice_spirit_button, skeletons_button, barbarian_barrel_button, goblins_button, the_log_button,
                zap_button, rage_button, wall_breakers_button, bats_button, ice_golem_button, fire_spirits_button, spear_goblins_button, giant_snowball_button,
                royal_delievery_button, goblin_barrel_button, arrows_button, skeleton_army_button, bomber_button, tombstone_button, cannon_button,
                elixir_golem_button, firecracker_button, fisherman_button, tornado_button, skeleton_barrel_button, clone_button, earthquake_button, ice_wizard_button,
                royal_ghost_button, guards_button, princess_button, bandit_button, knight_button, archers_button, goblin_gang_button, miner_button,
                dart_goblin_button, mega_minion_button, minions_button, battle_ram_button, inferno_dragon_button, lumberjack_button, poison_button,
                freeze_button, zappies_button, electro_wizard_button, valkyrie_button, hunter_button, fireball_button, dark_prince_button, goblin_cage_button,
                night_witch_button, furncae_button, musketeer_button, tesla_button, bomb_tower_button, mortar_button, hog_rider_button, baby_dragon_button,
                flying_machine_button, battle_healer_button, magic_archer_button, mini_pekka_button, royal_hogs_button, wizard_button, prince_button,
                witch_button, goblin_hut_button, cannon_cart_button, inferno_tower_button, rascals_button, graveyard_button, minion_horde_button, ram_rider_button,
                barbarians_button, executioner_button, giant_button, balloon_button, bowler_button, electro_dragon_button, goblin_giant_button,
                ginat_skeleton_button, elixir_collector_button, xbow_button, royal_giant_button, elite_barbarians_button, rocket_button, sparky_button,
                lightning_button, barbarian_hut_button, pekka_button, mega_knight_button, royal_recruits_button, lava_hound_button, golem_button,
                three_musketeers_button};

        input_text = findViewById(R.id.text_input);

        Bundle b = getIntent().getExtras();
        pos = b.getInt("key");





        DisableButtons();
        CardClick();
        UseButtonClick();
        FindCard();
        ChangeConstraints(allCards,allButtons);


    }
    public void ChangeConstraints(ImageView[] temp_cards,Button[] temp_buttons){
        ConstraintSet constraintSet = new ConstraintSet();
        ConstraintLayout constraintLayout = findViewById(R.id.constrain_activity2);
        constraintSet.clone(constraintLayout);


        for (int i=0; i<temp_cards.length;i++){
            if (i<4){
                if (i % 4 == 0){
                    constraintSet.connect(temp_cards[i].getId(),constraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT,8);
                    constraintSet.connect(temp_cards[i].getId(),constraintSet.TOP,R.id.text_field,ConstraintSet.BOTTOM,16);

                    constraintSet.connect(temp_buttons[i].getId(),constraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT,8);
                    constraintSet.connect(temp_buttons[i].getId(),constraintSet.TOP,temp_cards[i].getId(),ConstraintSet.BOTTOM,0);
                }
                else{
                    constraintSet.connect(temp_cards[i].getId(),constraintSet.LEFT,temp_cards[i-1].getId(),ConstraintSet.RIGHT,8);
                    constraintSet.connect(temp_cards[i].getId(),constraintSet.TOP,R.id.text_field,ConstraintSet.BOTTOM,16);

                    constraintSet.connect(temp_buttons[i].getId(),constraintSet.LEFT,temp_buttons[i-1].getId(),ConstraintSet.RIGHT,8);
                    constraintSet.connect(temp_buttons[i].getId(),constraintSet.TOP,temp_cards[i].getId(),ConstraintSet.BOTTOM,0);
                }
            }
            else if (i % 4 == 0){
                constraintSet.connect(temp_cards[i].getId(),constraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT,8);
                constraintSet.connect(temp_cards[i].getId(),constraintSet.TOP,temp_buttons[i-4].getId(),ConstraintSet.BOTTOM,8);

                constraintSet.connect(temp_buttons[i].getId(),constraintSet.LEFT,ConstraintSet.PARENT_ID,ConstraintSet.LEFT,8);
                constraintSet.connect(temp_buttons[i].getId(),constraintSet.TOP,temp_cards[i].getId(),ConstraintSet.BOTTOM,0);
            }
            else{
                constraintSet.connect(temp_cards[i].getId(),constraintSet.LEFT,temp_cards[i-1].getId(),ConstraintSet.RIGHT,8);
                constraintSet.connect(temp_cards[i].getId(),constraintSet.TOP,temp_buttons[i-4].getId(),ConstraintSet.BOTTOM,8);

                constraintSet.connect(temp_buttons[i].getId(),constraintSet.LEFT,temp_buttons[i-1].getId(),ConstraintSet.RIGHT,8);
                constraintSet.connect(temp_buttons[i].getId(),constraintSet.TOP,temp_cards[i].getId(),ConstraintSet.BOTTOM,0);
            }
        }
        constraintSet.applyTo(constraintLayout);
    }

    public void FindCard(){

        TextWatcher t = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String g = input_text.getEditableText().toString();
                ArrayList<ImageView> temp_cards = new ArrayList<ImageView>();
                ArrayList<Button> temp_buttons = new ArrayList<Button>();
                for (int i=0; i <allCards.length;i++){
                    ImageView c = allCards[i];
                    Button b = allButtons[i];
                    String tag = c.getTag().toString();
                    if (tag.contains("_")) {
                        tag = tag.replace("_", " ");
                    }
                    if (tag.contains(s)){
                        temp_cards.add(c);
                        temp_buttons.add(b);
                        c.setVisibility(View.VISIBLE);
                        b.setVisibility(View.INVISIBLE);

                    }
                    else{
                        c.setVisibility(View.INVISIBLE);
                        b.setVisibility(View.INVISIBLE);
                    }

                }
                ImageView[] card = temp_cards.toArray(new ImageView[0]);
                Button[] button = temp_buttons.toArray(new Button[0]);
                ChangeConstraints(card,button);
            }
        };

        input_text.addTextChangedListener(t);
    }

    public void onBackPressed(){
        for (int j=0; j<HomeFragment.decks.length;j++) {
            for (int i = 0; i < 8; i++) {
                Button b = HomeFragment.decks[j].button_array[i];
                b.setTag("unselected");
            }
        }

        finish();
    }

    public static void DisableButtons(){
        HomeFragment.Deck deck = HomeFragment.decks[pos];
        for (int i = 0; i < 8; i++) {
            ImageView c = deck.card_array[i];
            for (int j = 0; j < allButtons.length; j++) {
                if (allCards[j].getTag().equals(c.getTag())) {
                    allButtons[j].setEnabled(false);
                }

            }
        }

    }

    public void CardClick(){

        for (int i =0; i<allCards.length;i++) {
            final Button b = allButtons[i];
            ImageView c = allCards[i];
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



    public void UseButtonClick(){
        for (int i =0; i<allCards.length;i++) {
            final Button b = allButtons[i];
            final ImageView c = allCards[i];
            b.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceType")
                @Override
                public void onClick(View view) {
                    Drawable d = c.getDrawable();
                    for (int k = 0; k< HomeFragment.decks.length; k++) {
                        for (int j = 0; j < 8; j++) {
                            ImageView f = HomeFragment.decks[k].card_array[j];
                            Button e = HomeFragment.decks[k].button_array[j];
                            if (e.getTag().equals("selected")) {
                                e.setTag("unselected");
                                f.setImageDrawable(d);
                                f.setTag(c.getTag());
                                HomeFragment.GetAverageElixir();
                                finish();
                            }
                        }
                    }


                }
            });
        }
    }

}

