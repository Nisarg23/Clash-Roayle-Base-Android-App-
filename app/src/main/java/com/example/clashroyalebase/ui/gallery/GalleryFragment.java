package com.example.clashroyalebase.ui.gallery;

import android.annotation.SuppressLint;
import android.bluetooth.le.ScanSettings;
import android.content.Intent;
import android.content.res.Resources;
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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.clashroyalebase.BufferingActivity;
import com.example.clashroyalebase.MainActivity;
import com.example.clashroyalebase.R;
import com.example.clashroyalebase.ui.home.HomeFragment;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {
    public LinearLayout.LayoutParams layoutParams_text;

    private GalleryViewModel galleryViewModel;
    public Elements img;
    public Elements txt;
    public InputStream is;
    public Drawable d;
    public static ArrayList<ImageView> meta_cards = new ArrayList<ImageView>();
    public static ArrayList<TextView> win_rate = new ArrayList<TextView>();

    public ImageView imageView2;
    public ArrayList<Drawable> drawables = new ArrayList<Drawable>();

    public Spinner spinner;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("ResourceType")
    @RequiresApi(api = Build.VERSION_CODES.O)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        String[] items = {"","Arena 1", "Arena 2", "Arena 3", "Arena 4", "Arena 5", "Arena 6", "Arena 7", "Arena 8", "Arena 9", "Arena 10", "Arena 11", "Arena 12", "Legendary Arena","Tournaments"};
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


        for (int i =0; i<400; i++){
            ImageView a = new ImageView(getActivity());
            a.setId(View.generateViewId());


            a.setImageResource(R.drawable.ic_launcher_background);

            a.setLayoutParams(layoutParams_img);
            meta_cards.add(a);
            gallery_constraint.addView(a);

            if (i%8 ==0) {
                TextView b = new TextView(getActivity());
                b.setId(View.generateViewId());
                b.setLayoutParams(layoutParams_text);
                b.setText("This is: "+ i);
                b.setTextSize(20);
                b.setTypeface(b.getTypeface(), Typeface.BOLD);
                win_rate.add(b);
                gallery_constraint.addView(b);
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

        for (int i=1; i<50;i++) {
            constraintSet.connect(meta_cards.get(i*8).getId(), constraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 8);
            constraintSet.connect(meta_cards.get(i*8).getId(), constraintSet.TOP, win_rate.get(i-1).getId(), ConstraintSet.BOTTOM, 30);
            constraintSet.connect(meta_cards.get(i*8+1).getId(), constraintSet.LEFT, meta_cards.get(i*8).getId(), ConstraintSet.RIGHT, 8);
            constraintSet.connect(meta_cards.get(i*8+1).getId(), constraintSet.TOP, win_rate.get(i-1).getId(), ConstraintSet.BOTTOM, 30);
            constraintSet.connect(meta_cards.get(i*8+2).getId(), constraintSet.LEFT, meta_cards.get(i*8+1).getId(), ConstraintSet.RIGHT, 8);
            constraintSet.connect(meta_cards.get(i*8+2).getId(), constraintSet.TOP, win_rate.get(i-1).getId(), ConstraintSet.BOTTOM, 30);
            constraintSet.connect(meta_cards.get(i*8+3).getId(), constraintSet.LEFT, meta_cards.get(i*8+2).getId(), ConstraintSet.RIGHT, 8);
            constraintSet.connect(meta_cards.get(i*8+3).getId(), constraintSet.TOP, win_rate.get(i-1).getId(), ConstraintSet.BOTTOM, 30);

            constraintSet.connect(meta_cards.get(i*8+4).getId(), constraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 8);
            constraintSet.connect(meta_cards.get(i*8+4).getId(), constraintSet.TOP, meta_cards.get(i*8).getId(), ConstraintSet.BOTTOM, 8);
            constraintSet.connect(meta_cards.get(i*8+5).getId(), constraintSet.LEFT, meta_cards.get(i*8+4).getId(), ConstraintSet.RIGHT, 8);
            constraintSet.connect(meta_cards.get(i*8+5).getId(), constraintSet.TOP, meta_cards.get(i*8+1).getId(), ConstraintSet.BOTTOM, 8);
            constraintSet.connect(meta_cards.get(i*8+6).getId(), constraintSet.LEFT, meta_cards.get(i*8+5).getId(), ConstraintSet.RIGHT, 8);
            constraintSet.connect(meta_cards.get(i*8+6).getId(), constraintSet.TOP, meta_cards.get(i*8+2).getId(), ConstraintSet.BOTTOM, 8);
            constraintSet.connect(meta_cards.get(i*8+7).getId(), constraintSet.LEFT, meta_cards.get(i*8+6).getId(), ConstraintSet.RIGHT, 8);
            constraintSet.connect(meta_cards.get(i*8+7).getId(), constraintSet.TOP, meta_cards.get(i*8+3).getId(), ConstraintSet.BOTTOM, 8);

            constraintSet.connect(win_rate.get(i).getId(), constraintSet.TOP, meta_cards.get(i*8+7).getId(), ConstraintSet.BOTTOM, 50);
            constraintSet.connect(win_rate.get(i).getId(), constraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 410);

        }

        constraintSet.applyTo(constraintLayout);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch (spinner.getSelectedItem().toString()){
                    case "Legendary Arena":
                        startActivity(new Intent(getActivity(), BufferingActivity.class));

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

        return root;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

}
