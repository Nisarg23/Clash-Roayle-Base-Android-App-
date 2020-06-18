package com.example.clashroyalebase.ui.gallery;

import android.annotation.SuppressLint;
import android.content.Intent;
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

    public ImageView imageView2;
    public static ArrayList<Drawable> drawables = new ArrayList<Drawable>();
    public static int share_button = -1;

    public Spinner spinner;


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


        ConstraintLayout gallery_constraint = root.findViewById(R.id.gallery_constraint);
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 90, getResources().getDisplayMetrics());
        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 85, getResources().getDisplayMetrics());

        LinearLayout.LayoutParams layoutParams_img = new LinearLayout.LayoutParams(width, height);

        int h = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 50, getResources().getDisplayMetrics());
        int w = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 350, getResources().getDisplayMetrics());

        layoutParams_text = new LinearLayout.LayoutParams(w, h);

        int he = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics());
        int wi = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, getResources().getDisplayMetrics());

        layoutParams_button = new LinearLayout.LayoutParams(he, wi);


        for (int i = 0; i < 400; i++) {
            ImageView a = new ImageView(getActivity());
            a.setId(View.generateViewId());


            a.setImageResource(R.drawable.ic_launcher_background);

            a.setLayoutParams(layoutParams_img);
            meta_cards.add(a);
            gallery_constraint.addView(a);

            if (i % 8 == 0) {
                TextView b = new TextView(getActivity());
                b.setId(View.generateViewId());
                b.setLayoutParams(layoutParams_text);
                b.setText("Win Rate: ");
                b.setTextSize(20);
                b.setTypeface(b.getTypeface(), Typeface.BOLD);
                win_rate.add(b);
                gallery_constraint.addView(b);

                Button c = new Button(getActivity());
                c.setId(View.generateViewId());
                c.setLayoutParams(layoutParams_button);
                c.setBackground(getResources().getDrawable(R.drawable.deck_copy));
                deck_copy.add(c);
                gallery_constraint.addView(c);

            }
        }


        ConstraintSet constraintSet = new ConstraintSet();
        @SuppressLint("CutPasteId") ConstraintLayout constraintLayout = root.findViewById(R.id.gallery_constraint);
        constraintSet.clone(constraintLayout);

        constraintSet.connect(R.id.textView2, constraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 50);
        constraintSet.connect(R.id.textView2, constraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 50);
        constraintSet.connect(R.id.spinner, constraintSet.LEFT, R.id.textView2, ConstraintSet.RIGHT, 30);
        constraintSet.connect(R.id.spinner, constraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 50);

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


        for (int i = 1; i < 50; i++) {
            constraintSet.connect(meta_cards.get(i * 8).getId(), constraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 8);
            constraintSet.connect(meta_cards.get(i * 8).getId(), constraintSet.TOP, win_rate.get(i - 1).getId(), ConstraintSet.BOTTOM, 30);
            constraintSet.connect(meta_cards.get(i * 8 + 1).getId(), constraintSet.LEFT, meta_cards.get(i * 8).getId(), ConstraintSet.RIGHT, 8);
            constraintSet.connect(meta_cards.get(i * 8 + 1).getId(), constraintSet.TOP, win_rate.get(i - 1).getId(), ConstraintSet.BOTTOM, 30);
            constraintSet.connect(meta_cards.get(i * 8 + 2).getId(), constraintSet.LEFT, meta_cards.get(i * 8 + 1).getId(), ConstraintSet.RIGHT, 8);
            constraintSet.connect(meta_cards.get(i * 8 + 2).getId(), constraintSet.TOP, win_rate.get(i - 1).getId(), ConstraintSet.BOTTOM, 30);
            constraintSet.connect(meta_cards.get(i * 8 + 3).getId(), constraintSet.LEFT, meta_cards.get(i * 8 + 2).getId(), ConstraintSet.RIGHT, 8);
            constraintSet.connect(meta_cards.get(i * 8 + 3).getId(), constraintSet.TOP, win_rate.get(i - 1).getId(), ConstraintSet.BOTTOM, 30);

            constraintSet.connect(meta_cards.get(i * 8 + 4).getId(), constraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 8);
            constraintSet.connect(meta_cards.get(i * 8 + 4).getId(), constraintSet.TOP, meta_cards.get(i * 8).getId(), ConstraintSet.BOTTOM, 8);
            constraintSet.connect(meta_cards.get(i * 8 + 5).getId(), constraintSet.LEFT, meta_cards.get(i * 8 + 4).getId(), ConstraintSet.RIGHT, 8);
            constraintSet.connect(meta_cards.get(i * 8 + 5).getId(), constraintSet.TOP, meta_cards.get(i * 8 + 1).getId(), ConstraintSet.BOTTOM, 8);
            constraintSet.connect(meta_cards.get(i * 8 + 6).getId(), constraintSet.LEFT, meta_cards.get(i * 8 + 5).getId(), ConstraintSet.RIGHT, 8);
            constraintSet.connect(meta_cards.get(i * 8 + 6).getId(), constraintSet.TOP, meta_cards.get(i * 8 + 2).getId(), ConstraintSet.BOTTOM, 8);
            constraintSet.connect(meta_cards.get(i * 8 + 7).getId(), constraintSet.LEFT, meta_cards.get(i * 8 + 6).getId(), ConstraintSet.RIGHT, 8);
            constraintSet.connect(meta_cards.get(i * 8 + 7).getId(), constraintSet.TOP, meta_cards.get(i * 8 + 3).getId(), ConstraintSet.BOTTOM, 8);

            constraintSet.connect(win_rate.get(i).getId(), constraintSet.TOP, meta_cards.get(i * 8 + 7).getId(), ConstraintSet.BOTTOM, 50);
            constraintSet.connect(win_rate.get(i).getId(), constraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 410);

            constraintSet.connect(deck_copy.get(i).getId(), constraintSet.TOP, meta_cards.get(i * 8 + 7).getId(), ConstraintSet.BOTTOM, 50);
            constraintSet.connect(deck_copy.get(i).getId(), constraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 30);


        }

        constraintSet.applyTo(constraintLayout);
        spinner_click();
        deck_copy_click();


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
                        startActivity(new Intent(getActivity(), BufferingActivity.class));
                        break;
                    case "Tournaments":
                        link = "https://statsroyale.com/decks/popular?type=tournament";
                        startActivity(new Intent(getActivity(), BufferingActivity.class));
                        break;
                    case "Arena 12":
                        link = "https://statsroyale.com/decks/popular?type=ladder&arena=12";
                        startActivity(new Intent(getActivity(), BufferingActivity.class));
                        break;
                    case "Arena 11":
                        link = "https://statsroyale.com/decks/popular?type=ladder&arena=11";
                        startActivity(new Intent(getActivity(), BufferingActivity.class));
                        break;
                    case "Arena 10":
                        link = "https://statsroyale.com/decks/popular?type=ladder&arena=10";
                        startActivity(new Intent(getActivity(), BufferingActivity.class));
                        break;
                    case "Arena 9":
                        link = "https://statsroyale.com/decks/popular?type=ladder&arena=9";
                        startActivity(new Intent(getActivity(), BufferingActivity.class));
                        break;
                    case "Arena 8":
                        link = "https://statsroyale.com/decks/popular?type=ladder&arena=8";
                        startActivity(new Intent(getActivity(), BufferingActivity.class));
                        break;
                    case "Arena 7":
                        link = "https://statsroyale.com/decks/popular?type=ladder&arena=7";
                        startActivity(new Intent(getActivity(), BufferingActivity.class));
                        break;
                    case "Arena 6":
                        link = "https://statsroyale.com/decks/popular?type=ladder&arena=6";
                        startActivity(new Intent(getActivity(), BufferingActivity.class));
                        break;
                    case "Arena 5":
                        link = "https://statsroyale.com/decks/popular?type=ladder&arena=5";
                        startActivity(new Intent(getActivity(), BufferingActivity.class));
                        break;
                    case "Arena 4":
                        link = "https://statsroyale.com/decks/popular?type=ladder&arena=4";
                        startActivity(new Intent(getActivity(), BufferingActivity.class));
                        break;
                    case "Arena 3":
                        link = "https://statsroyale.com/decks/popular?type=ladder&arena=3";
                        startActivity(new Intent(getActivity(), BufferingActivity.class));
                        break;
                    case "Arena 2":
                        link = "https://statsroyale.com/decks/popular?type=ladder&arena=2";
                        startActivity(new Intent(getActivity(), BufferingActivity.class));
                        break;
                    case "Arena 1":
                        link = "https://statsroyale.com/decks/popular?type=ladder&arena=1";
                        startActivity(new Intent(getActivity(), BufferingActivity.class));
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


