package com.example.clashroyalebase.ui.slideshow;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.clashroyalebase.PlayerInfo;
import com.example.clashroyalebase.R;
import com.example.clashroyalebase.ui.gallery.GalleryFragment;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    public static EditText player_tag;
    public static Button search_player;

    public static String base_url = "https://www.deckshop.pro/spy/player/";
    public static String url;

    public Elements img;
    public Elements txt;
    public Elements txt1;
    Document doc;
    public Element invalid;
    public Element invalid2;
    public InputStream is;
    public Drawable d;
    public ArrayList<Drawable> drawables = new ArrayList<Drawable>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        player_tag = root.findViewById(R.id.player_tag);
        search_player = root.findViewById(R.id.search_player);

        search_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url = url + player_tag.getText().toString();

            }
        });

        searchButtonListener();





        return root;
}
public void searchButtonListener(){
    search_player.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final String tag = player_tag.getText().toString().toUpperCase();
            url = base_url + tag;

            InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                         doc = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                                .referrer("http://www.google.com").ignoreHttpErrors(true).get();;
                        txt = doc.getElementsByClass("text-white text-center mb-3");
                        invalid = txt.get(0);
                        System.out.println(invalid.html());




                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (invalid.html().toString().equals("Player with tag #"+ tag+ " not found.")){

                                Toast toast = Toast.makeText(getActivity(),
                                        "Invalid hashtag Provided",
                                        Toast.LENGTH_SHORT);

                                toast.show();
                            }
                            else{
//                                Elements queue = doc.getElementsByClass("ui__tooltip ui__tooltipTop ui__tooltipMiddle chests__tooltip");
//                                System.out.println(queue.get(0).html());
//                                System.out.println(queue.get(13).html());
//                                startActivity(new Intent(getActivity(), PlayerInfo.class));
                            }
                        }
                    });
                }
            }).start();
        }
    });


    }
}
