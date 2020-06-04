package com.example.clashroyalebase.ui.gallery;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    public Elements img;
    public InputStream is;
    public Drawable d;
    public ArrayList<ImageView> meta_cards = new ArrayList<ImageView>();
    public ArrayList<TextView> win_rate = new ArrayList<TextView>();

    public ImageView imageView2;
    public ArrayList<Drawable> drawables = new ArrayList<Drawable>();

    @SuppressLint("ResourceType")
    @RequiresApi(api = Build.VERSION_CODES.O)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        String[] items = {"Arena 1", "Arena 2", "Arena 3", "Arena 4", "Arena 5", "Arena 6", "Arena 7", "Arena 8", "Arena 9", "Arena 10", "Arena 11", "Arena 12", "Legendary Arena","Tournaments"};
        //ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),  items, android.R.layout.simple_spinner_item);
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.spinner, items);


        Spinner listView = root.findViewById(R.id.spinner);
        listView.setAdapter(adapter);

        ConstraintLayout gallery_constraint = root.findViewById(R.id.gallery_constraint);
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 90, getResources().getDisplayMetrics());
        int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 85, getResources().getDisplayMetrics());

        LinearLayout.LayoutParams layoutParams_img = new LinearLayout.LayoutParams(width, height);

        int h = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 35, getResources().getDisplayMetrics());
        int w = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 300, getResources().getDisplayMetrics());

        LinearLayout.LayoutParams layoutParams_text = new LinearLayout.LayoutParams(w, h);





        ConstraintSet constraintSet = new ConstraintSet();
        @SuppressLint("CutPasteId") ConstraintLayout constraintLayout = root.findViewById(R.id.gallery_constraint);
        constraintSet.clone(constraintLayout);

        for (int i =0; i<4; i++){
            ImageView a = new ImageView(getActivity());
            a.setId(i);
            a.setImageResource(R.drawable.ic_launcher_background);
            a.setLayoutParams(layoutParams_img);
            meta_cards.add(a);
            gallery_constraint.addView(a);

            TextView b = new TextView(getActivity());
            b.setId(i+90);
            b.setLayoutParams(layoutParams_text);
            b.setText("Win Rate: 53.66%");
            b.setAutoSizeTextTypeWithDefaults(TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM);
            win_rate.add(b);
            gallery_constraint.addView(b);
        }
        System.out.println(constraintLayout.getChildAt(1));
        System.out.println(constraintLayout.getChildAt(2));
        System.out.println(constraintLayout.getChildAt(3));
        System.out.println(constraintLayout.getChildAt(4));
        System.out.println(constraintLayout.getChildAt(5));
        System.out.println(constraintLayout.getChildAt(6));
        System.out.println(constraintLayout.getChildAt(7));
        System.out.println(constraintLayout.getChildAt(8));
        System.out.println(constraintLayout.getChildAt(9));
        System.out.println(meta_cards.get(0).getId());
        constraintSet.connect(meta_cards.get(0).getId(), constraintSet.TOP, R.id.spinner, ConstraintSet.BOTTOM, 16);

//        for (int i=0; i<4;i++) {
//            if (i < 4) {
//                if (i % 4 == 0) {
//                    constraintSet.connect(meta_cards.get(i).getId(), constraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 8);
//                    constraintSet.connect(meta_cards.get(i).getId(), constraintSet.TOP, R.id.spinner, ConstraintSet.BOTTOM, 16);
//
//                }
//                else{
//                    constraintSet.connect(meta_cards.get(i).getId(), constraintSet.LEFT, meta_cards.get(i-1).getId(), ConstraintSet.LEFT, 8);
//                    constraintSet.connect(meta_cards.get(i).getId(), constraintSet.TOP, R.id.spinner, ConstraintSet.BOTTOM, 16);
//                }
//            }
//        }
        constraintSet.applyTo(constraintLayout);


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Document doc = Jsoup.connect("https://statsroyale.com/decks/popular?type=ladder").get();
//                    img = doc.getElementsByTag("img");
//                    img.remove(0);
//                    img.remove(0);
//                    img.remove(0);
//
//                    for (int i =0; i<80;i++) {
//                        try {
//                            String url = img.get(i).toString();
//                            int end_index = url.indexOf('>');
//                            url = url.substring(10, end_index - 1);
//                            is = (InputStream) new URL(url).getContent();
//                            d = Drawable.createFromStream(is, "src name");
//                            drawables.add(d);
//
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//
//                getActivity().runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        for (int i=0; i<10; i++){
//                            for (int j=0; j<8;j++){
//                                HomeFragment.decks[i].card_array[j].setImageDrawable(drawables.get(i*8+j));
//                            }
//                        }
//                    }
//                });
//            }
//        }).start();

        return root;
    }
}
