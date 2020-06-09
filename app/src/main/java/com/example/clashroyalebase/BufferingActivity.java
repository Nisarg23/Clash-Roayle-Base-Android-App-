package com.example.clashroyalebase;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.clashroyalebase.ui.gallery.GalleryFragment;
import com.example.clashroyalebase.ui.gallery.GalleryViewModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class BufferingActivity extends AppCompatActivity {

    public Elements img;
    public Elements txt;
    public InputStream is;
    public Drawable d;
    public ArrayList<Drawable> drawables = new ArrayList<Drawable>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buffering);

                new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Document doc = Jsoup.connect(GalleryFragment.link).get();
                    img = doc.getElementsByTag("img");
                    txt = doc.getElementsByClass("ui__headerBig");


                    img.remove(0);
                    img.remove(0);
                    img.remove(0);

                    for (int i =0; i<400;i++) {
                        try {
                            String url = img.get(i).toString();
                            int end_index = url.indexOf('>');
                            url = url.substring(10, end_index - 1);
                            is = (InputStream) new URL(url).getContent();
                            d = Drawable.createFromStream(is, "src name");
                            drawables.add(d);
                            if (i < 50) {
                                String sub = txt.get(i).toString();
                                sub = sub.substring(27);
                                int end = sub.indexOf('<');
                                sub = sub.substring(0, end);
                                GalleryFragment.win_rate.get(i).setText("Win rate: " + sub+ "%");
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i=0; i<400;i++){
                            GalleryFragment.meta_cards.get(i).setImageDrawable(drawables.get(i));
                        }
                        finish();
                    }
                });
            }
        }).start();


    }

}
