package com.example.clashroyalebase.ui.gallery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.clashroyalebase.BufferingActivity;
import com.example.clashroyalebase.PopActivity;
import com.example.clashroyalebase.R;

import org.jsoup.select.Elements;

import java.io.InputStream;
import java.util.ArrayList;

public class GalleryFragment extends Fragment {
    public LinearLayout.LayoutParams layoutParams_text;
    public LinearLayout.LayoutParams layoutParams_button;

    public static String link;

    private GalleryViewModel galleryViewModel;
    public Elements img;
    public Elements txt;
    public InputStream is;
    public Drawable d;
    public static ArrayList<ImageView> meta_cards = new ArrayList<ImageView>();
    public static ArrayList<TextView> win_rate = new ArrayList<TextView>();
    public static ArrayList<Button> deck_copy = new ArrayList<Button>();
    public static ArrayList<ConstraintLayout> constraint_layouts = new ArrayList<ConstraintLayout>();

    public ImageView imageView2;
    public static ArrayList<Drawable> drawables = new ArrayList<Drawable>();
    public static int share_button = -1;
    public static Boolean empty_decks = true;

    public static Spinner spinner;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("ResourceType")
    @RequiresApi(api = Build.VERSION_CODES.O)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        String[] items = {"", "Arena 1", "Arena 2", "Arena 3", "Arena 4", "Arena 5", "Arena 6", "Arena 7", "Arena 8", "Arena 9", "Arena 10", "Arena 11", "Arena 12", "Legendary Arena", "Tournaments"};
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.spinner, items);

        spinner = root.findViewById(R.id.spinner);
        spinner.setAdapter(adapter);

        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint1));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint2));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint3));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint4));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint5));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint6));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint7));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint8));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint9));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint10));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint11));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint12));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint13));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint14));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint15));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint16));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint17));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint18));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint19));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint20));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint21));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint22));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint23));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint24));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint25));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint26));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint27));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint28));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint29));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint30));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint31));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint32));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint33));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint34));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint35));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint36));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint37));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint38));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint39));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint40));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint41));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint42));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint43));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint44));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint45));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint46));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint47));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint48));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint49));
        constraint_layouts.add((ConstraintLayout) root.findViewById(R.id.constraint50));

        int screenSize = getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK;

        int tmp_width_card;
        int tmp_height_card;
        int tmp_width_txt;
        int tmp_height_txt;
        int tmp_width_button;
        int tmp_height_button;
        switch(screenSize) {
            case Configuration.SCREENLAYOUT_SIZE_LARGE:
                tmp_width_card = 110;
                tmp_height_card = 120;
                tmp_width_txt = 370;
                tmp_height_txt = 60;
                tmp_width_button = 50;
                tmp_height_button = 50;

                break;
            case Configuration.SCREENLAYOUT_SIZE_XLARGE:
                tmp_width_card = 130;
                tmp_height_card = 150;
                tmp_width_txt = 390;
                tmp_height_txt = 70;
                tmp_width_button = 70;
                tmp_height_button = 70;

                break;
            default:
                tmp_width_card = 85;
                tmp_height_card = 100;
                tmp_width_txt = 350;
                tmp_height_txt = 50;
                tmp_width_button = 40;
                tmp_height_button = 40;
        }


        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, tmp_height_card, getResources().getDisplayMetrics());
        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, tmp_width_card, getResources().getDisplayMetrics());

        LinearLayout.LayoutParams layoutParams_img = new LinearLayout.LayoutParams(width, height);

        int h = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, tmp_height_txt, getResources().getDisplayMetrics());
        int w = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, tmp_width_txt, getResources().getDisplayMetrics());

        layoutParams_text = new LinearLayout.LayoutParams(w, h);

        int he = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, tmp_height_button, getResources().getDisplayMetrics());
        int wi = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, tmp_width_button, getResources().getDisplayMetrics());

        layoutParams_button = new LinearLayout.LayoutParams(he, wi);


        for (int i = 0; i < 400; i++) {
            ImageView a = new ImageView(getActivity());
            a.setId(View.generateViewId());
            a.setImageResource(R.drawable.ic_launcher_background);

            a.setLayoutParams(layoutParams_img);
            meta_cards.add(a);
            int index = (int) Math.floor(i/8);
            constraint_layouts.get(index).addView(a);


            if (i % 8 == 0) {
                TextView b = new TextView(getActivity());
                b.setId(View.generateViewId());
                b.setLayoutParams(layoutParams_text);
                b.setText("Win Rate: ");
                b.setTextSize(20);
                b.setTypeface(b.getTypeface(), Typeface.BOLD);
                win_rate.add(b);
                constraint_layouts.get((i/8)).addView(b);


                Button c = new Button(getActivity());
                c.setId(View.generateViewId());
                c.setLayoutParams(layoutParams_button);
                c.setBackground(getResources().getDrawable(R.drawable.deck_copy));
                deck_copy.add(c);
                constraint_layouts.get((i/8)).addView(c);


            }
        }









//        for (int i=1; i<constraint_layouts.size();i++){
//            ConstraintSet constraintSet = new ConstraintSet();
//            @SuppressLint("CutPasteId") ConstraintLayout constraintLayout1 = constraint_layouts.get(i);
//            constraintSet.clone(constraintLayout1);
//            System.out.println("i "+ i);
//
//            constraintSet.connect(meta_cards.get(i * 8).getId(), constraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 8);
//            constraintSet.connect(meta_cards.get(i * 8).getId(), constraintSet.TOP, win_rate.get(i - 1).getId(), ConstraintSet.BOTTOM, 30);
//            constraintSet.connect(meta_cards.get(i * 8 + 1).getId(), constraintSet.LEFT, meta_cards.get(i * 8).getId(), ConstraintSet.RIGHT, 8);
//            constraintSet.connect(meta_cards.get(i * 8 + 1).getId(), constraintSet.TOP, win_rate.get(i - 1).getId(), ConstraintSet.BOTTOM, 30);
//            constraintSet.connect(meta_cards.get(i * 8 + 2).getId(), constraintSet.LEFT, meta_cards.get(i * 8 + 1).getId(), ConstraintSet.RIGHT, 8);
//            constraintSet.connect(meta_cards.get(i * 8 + 2).getId(), constraintSet.TOP, win_rate.get(i - 1).getId(), ConstraintSet.BOTTOM, 30);
//            constraintSet.connect(meta_cards.get(i * 8 + 3).getId(), constraintSet.LEFT, meta_cards.get(i * 8 + 2).getId(), ConstraintSet.RIGHT, 8);
//            constraintSet.connect(meta_cards.get(i * 8 + 3).getId(), constraintSet.TOP, win_rate.get(i - 1).getId(), ConstraintSet.BOTTOM, 30);
//
//            constraintSet.connect(meta_cards.get(i * 8 + 4).getId(), constraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 8);
//            constraintSet.connect(meta_cards.get(i * 8 + 4).getId(), constraintSet.TOP, meta_cards.get(i * 8).getId(), ConstraintSet.BOTTOM, 8);
//            constraintSet.connect(meta_cards.get(i * 8 + 5).getId(), constraintSet.LEFT, meta_cards.get(i * 8 + 4).getId(), ConstraintSet.RIGHT, 8);
//            constraintSet.connect(meta_cards.get(i * 8 + 5).getId(), constraintSet.TOP, meta_cards.get(i * 8 + 1).getId(), ConstraintSet.BOTTOM, 8);
//            constraintSet.connect(meta_cards.get(i * 8 + 6).getId(), constraintSet.LEFT, meta_cards.get(i * 8 + 5).getId(), ConstraintSet.RIGHT, 8);
//            constraintSet.connect(meta_cards.get(i * 8 + 6).getId(), constraintSet.TOP, meta_cards.get(i * 8 + 2).getId(), ConstraintSet.BOTTOM, 8);
//            constraintSet.connect(meta_cards.get(i * 8 + 7).getId(), constraintSet.LEFT, meta_cards.get(i * 8 + 6).getId(), ConstraintSet.RIGHT, 8);
//            constraintSet.connect(meta_cards.get(i * 8 + 7).getId(), constraintSet.TOP, meta_cards.get(i * 8 + 3).getId(), ConstraintSet.BOTTOM, 8);
//
//            constraintSet.connect(win_rate.get(i).getId(), constraintSet.TOP, meta_cards.get(i * 8 + 7).getId(), ConstraintSet.BOTTOM, 50);
//            constraintSet.connect(win_rate.get(i).getId(), constraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 410);
//
//            constraintSet.connect(deck_copy.get(i).getId(), constraintSet.TOP, meta_cards.get(i * 8 + 7).getId(), ConstraintSet.BOTTOM, 50);
//            constraintSet.connect(deck_copy.get(i).getId(), constraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 30);
//
//
//            constraintSet.applyTo(constraintLayout1);
//
//        }

        ConstraintSet constraintSet = new ConstraintSet();
        ConstraintLayout constraintLayout = constraint_layouts.get(0);
        constraintSet.clone(constraintLayout);


        constraintSet.connect(meta_cards.get(0).getId(), constraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 8);
        constraintSet.connect(meta_cards.get(0).getId(), constraintSet.TOP, R.id.spinner, ConstraintSet.BOTTOM, 30);
        constraintSet.connect(meta_cards.get(1).getId(), constraintSet.LEFT, meta_cards.get(0).getId(), ConstraintSet.RIGHT, 8);
        constraintSet.connect(meta_cards.get(1).getId(), constraintSet.TOP, R.id.spinner, ConstraintSet.BOTTOM, 30);
        constraintSet.connect(meta_cards.get(2).getId(), constraintSet.LEFT, meta_cards.get(1).getId(), ConstraintSet.RIGHT, 8);
        constraintSet.connect(meta_cards.get(2).getId(), constraintSet.TOP, R.id.spinner, ConstraintSet.BOTTOM, 30);
        constraintSet.connect(meta_cards.get(3).getId(), constraintSet.LEFT, meta_cards.get(2).getId(), ConstraintSet.RIGHT, 8);
        constraintSet.connect(meta_cards.get(3).getId(), constraintSet.TOP, R.id.spinner, ConstraintSet.BOTTOM, 30);

        constraintSet.connect(meta_cards.get(4).getId(), constraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 8);
        constraintSet.connect(meta_cards.get(4).getId(), constraintSet.TOP, meta_cards.get(0).getId(), ConstraintSet.BOTTOM, 8);
        constraintSet.connect(meta_cards.get(5).getId(), constraintSet.LEFT, meta_cards.get(4).getId(), ConstraintSet.RIGHT, 8);
        constraintSet.connect(meta_cards.get(5).getId(), constraintSet.TOP, meta_cards.get(1).getId(), ConstraintSet.BOTTOM, 8);
        constraintSet.connect(meta_cards.get(6).getId(), constraintSet.LEFT, meta_cards.get(5).getId(), ConstraintSet.RIGHT, 8);
        constraintSet.connect(meta_cards.get(6).getId(), constraintSet.TOP, meta_cards.get(2).getId(), ConstraintSet.BOTTOM, 8);
        constraintSet.connect(meta_cards.get(7).getId(), constraintSet.LEFT, meta_cards.get(6).getId(), ConstraintSet.RIGHT, 8);
        constraintSet.connect(meta_cards.get(7).getId(), constraintSet.TOP, meta_cards.get(3).getId(), ConstraintSet.BOTTOM, 8);

        constraintSet.connect(win_rate.get(0).getId(), constraintSet.TOP, meta_cards.get(7).getId(), ConstraintSet.BOTTOM, 50);
        constraintSet.connect(win_rate.get(0).getId(), constraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 410);

        constraintSet.connect(deck_copy.get(0).getId(), constraintSet.TOP, meta_cards.get(7).getId(), ConstraintSet.BOTTOM, 50);
        constraintSet.connect(deck_copy.get(0).getId(), constraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 30);

        constraintSet.applyTo(constraintLayout);

        for (int i = 1; i < 50; i++) {
            ConstraintSet constraintSet1 = new ConstraintSet();
            ConstraintLayout constraintLayout1 = constraint_layouts.get(i);
            constraintSet1.clone(constraintLayout1);


            constraintSet1.connect(meta_cards.get(i * 8).getId(), constraintSet1.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 8);
            constraintSet1.connect(meta_cards.get(i * 8).getId(), constraintSet1.TOP, win_rate.get(i - 1).getId(), ConstraintSet.BOTTOM, 30);
            constraintSet1.connect(meta_cards.get(i * 8 + 1).getId(), constraintSet1.LEFT, meta_cards.get(i * 8).getId(), ConstraintSet.RIGHT, 8);
            constraintSet1.connect(meta_cards.get(i * 8 + 1).getId(), constraintSet1.TOP, win_rate.get(i - 1).getId(), ConstraintSet.BOTTOM, 30);
            constraintSet1.connect(meta_cards.get(i * 8 + 2).getId(), constraintSet1.LEFT, meta_cards.get(i * 8 + 1).getId(), ConstraintSet.RIGHT, 8);
            constraintSet1.connect(meta_cards.get(i * 8 + 2).getId(), constraintSet1.TOP, win_rate.get(i - 1).getId(), ConstraintSet.BOTTOM, 30);
            constraintSet1.connect(meta_cards.get(i * 8 + 3).getId(), constraintSet1.LEFT, meta_cards.get(i * 8 + 2).getId(), ConstraintSet.RIGHT, 8);
            constraintSet1.connect(meta_cards.get(i * 8 + 3).getId(), constraintSet1.TOP, win_rate.get(i - 1).getId(), ConstraintSet.BOTTOM, 30);

            constraintSet1.connect(meta_cards.get(i * 8 + 4).getId(), constraintSet1.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 8);
            constraintSet1.connect(meta_cards.get(i * 8 + 4).getId(), constraintSet1.TOP, meta_cards.get(i * 8).getId(), ConstraintSet.BOTTOM, 8);
            constraintSet1.connect(meta_cards.get(i * 8 + 5).getId(), constraintSet1.LEFT, meta_cards.get(i * 8 + 4).getId(), ConstraintSet.RIGHT, 8);
            constraintSet1.connect(meta_cards.get(i * 8 + 5).getId(), constraintSet1.TOP, meta_cards.get(i * 8 + 1).getId(), ConstraintSet.BOTTOM, 8);
            constraintSet1.connect(meta_cards.get(i * 8 + 6).getId(), constraintSet1.LEFT, meta_cards.get(i * 8 + 5).getId(), ConstraintSet.RIGHT, 8);
            constraintSet1.connect(meta_cards.get(i * 8 + 6).getId(), constraintSet1.TOP, meta_cards.get(i * 8 + 2).getId(), ConstraintSet.BOTTOM, 8);
            constraintSet1.connect(meta_cards.get(i * 8 + 7).getId(), constraintSet1.LEFT, meta_cards.get(i * 8 + 6).getId(), ConstraintSet.RIGHT, 8);
            constraintSet1.connect(meta_cards.get(i * 8 + 7).getId(), constraintSet1.TOP, meta_cards.get(i * 8 + 3).getId(), ConstraintSet.BOTTOM, 8);

            constraintSet1.connect(win_rate.get(i).getId(), constraintSet1.TOP, meta_cards.get(i * 8 + 7).getId(), ConstraintSet.BOTTOM, 50);
            constraintSet1.connect(win_rate.get(i).getId(), constraintSet1.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 410);

            constraintSet1.connect(deck_copy.get(i).getId(), constraintSet1.TOP, meta_cards.get(i * 8 + 7).getId(), ConstraintSet.BOTTOM, 50);
            constraintSet1.connect(deck_copy.get(i).getId(), constraintSet1.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 30);

            constraintSet1.applyTo(constraintLayout1);
        }



        spinner_click();
        deck_copy_click();
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("AppData", Context.MODE_PRIVATE);
        String spinner_value = sharedPreferences.getString("spinner","");
        switch (spinner_value){
            case "Legendary Arena":
                spinner.setSelection(13);
                empty_decks = false;
                break;
            case "Tournaments":
                spinner.setSelection(14);
                empty_decks = false;
                break;
            case "Arena 12":
                spinner.setSelection(12);
                empty_decks = false;
                break;
            case "Arena 11":
                spinner.setSelection(11);
                empty_decks = false;
                break;
            case "Arena 10":
                spinner.setSelection(10);
                empty_decks = false;
                break;
            case "Arena 9":
                spinner.setSelection(9);
                empty_decks = false;
                break;
            case "Arena 8":
                spinner.setSelection(8);
                empty_decks = false;
                break;
            case "Arena 7":
                spinner.setSelection(7);
                empty_decks = false;
                break;
            case "Arena 6":
                spinner.setSelection(6);
                empty_decks = false;
                break;
            case "Arena 5":
                spinner.setSelection(5);
                empty_decks = false;
                break;
            case "Arena 4":
                spinner.setSelection(4);
                empty_decks = false;
                break;
            case "Arena 3":
                spinner.setSelection(3);
                empty_decks = false;
                break;
            case "Arena 2":
                spinner.setSelection(2);
                empty_decks = false;
                break;
            case "Arena 1":
                spinner.setSelection(1);
                empty_decks = false;
                break;

        }


        return root;
    }

    public void spinner_click() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                drawables.clear();
                switch (spinner.getSelectedItem().toString()) {
                    case "Legendary Arena":
                        link = "https://statsroyale.com/decks/popular?type=ladder";
                        empty_decks = false;
                        startActivity(new Intent(getActivity(), BufferingActivity.class));
                        break;
                    case "Tournaments":
                        link = "https://statsroyale.com/decks/popular?type=tournament";
                        empty_decks = false;
                        startActivity(new Intent(getActivity(), BufferingActivity.class));
                        break;
                    case "Arena 12":
                        link = "https://statsroyale.com/decks/popular?type=ladder&arena=12";
                        empty_decks = false;
                        startActivity(new Intent(getActivity(), BufferingActivity.class));
                        break;
                    case "Arena 11":
                        link = "https://statsroyale.com/decks/popular?type=ladder&arena=11";
                        empty_decks = false;
                        startActivity(new Intent(getActivity(), BufferingActivity.class));
                        break;
                    case "Arena 10":
                        link = "https://statsroyale.com/decks/popular?type=ladder&arena=10";
                        startActivity(new Intent(getActivity(), BufferingActivity.class));
                        empty_decks = false;
                        break;
                    case "Arena 9":
                        link = "https://statsroyale.com/decks/popular?type=ladder&arena=9";
                        startActivity(new Intent(getActivity(), BufferingActivity.class));
                        empty_decks = false;
                        break;
                    case "Arena 8":
                        link = "https://statsroyale.com/decks/popular?type=ladder&arena=8";
                        startActivity(new Intent(getActivity(), BufferingActivity.class));
                        empty_decks = false;
                        break;
                    case "Arena 7":
                        link = "https://statsroyale.com/decks/popular?type=ladder&arena=7";
                        startActivity(new Intent(getActivity(), BufferingActivity.class));
                        empty_decks = false;
                        break;
                    case "Arena 6":
                        link = "https://statsroyale.com/decks/popular?type=ladder&arena=6";
                        startActivity(new Intent(getActivity(), BufferingActivity.class));
                        empty_decks = false;
                        break;
                    case "Arena 5":
                        link = "https://statsroyale.com/decks/popular?type=ladder&arena=5";
                        startActivity(new Intent(getActivity(), BufferingActivity.class));
                        empty_decks = false;
                        break;
                    case "Arena 4":
                        link = "https://statsroyale.com/decks/popular?type=ladder&arena=4";
                        startActivity(new Intent(getActivity(), BufferingActivity.class));
                        empty_decks = false;
                        break;
                    case "Arena 3":
                        link = "https://statsroyale.com/decks/popular?type=ladder&arena=3";
                        startActivity(new Intent(getActivity(), BufferingActivity.class));
                        empty_decks = false;
                        break;
                    case "Arena 2":
                        link = "https://statsroyale.com/decks/popular?type=ladder&arena=2";
                        startActivity(new Intent(getActivity(), BufferingActivity.class));
                        empty_decks = false;
                        break;
                    case "Arena 1":
                        link = "https://statsroyale.com/decks/popular?type=ladder&arena=1";
                        startActivity(new Intent(getActivity(), BufferingActivity.class));
                        empty_decks = false;
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }

    public void deck_copy_click() {
        for (int i = 0; i < deck_copy.size(); i++) {
            final int j = i;
            deck_copy.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    share_button = j;
                    startActivity(new Intent(getActivity(), PopActivity.class));

                }
            });
        }
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }
}
