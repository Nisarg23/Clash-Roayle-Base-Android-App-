package com.example.clashroyalebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.clashroyalebase.ui.gallery.GalleryFragment;
import com.example.clashroyalebase.ui.home.HomeFragment;

public class PopActivity extends AppCompatActivity {
    public static Button[] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = (int) (dm.widthPixels*.6);
        int height = (int) (dm.heightPixels*.19);

        //.3
        //.15

        getWindow().setLayout(width,height);

        Button b1= findViewById(R.id.button1);
        Button b2= findViewById(R.id.button2);
        Button b3= findViewById(R.id.button3);
        Button b4= findViewById(R.id.button4);
        Button b5= findViewById(R.id.button5);
        Button b6= findViewById(R.id.button6);
        Button b7= findViewById(R.id.button7);
        Button b8= findViewById(R.id.button8);
        Button b9= findViewById(R.id.button9);
        Button b10= findViewById(R.id.button10);

        buttons = new Button[]{b1,b2,b3,b4,b5,b6,b7,b8,b9,b10};

        for (int i=0; i<buttons.length;i++){
            final Button b = buttons[i];
            final int j = GalleryFragment.share_button;
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try{
                        int deck = Integer.parseInt((String) b.getTag());
                        HomeFragment.decks[deck].c1.setImageDrawable(GalleryFragment.drawables.get(j *50));
                        HomeFragment.decks[deck].c2.setImageDrawable(GalleryFragment.drawables.get(j*50+1));
                        HomeFragment.decks[deck].c3.setImageDrawable(GalleryFragment.drawables.get(j*50+2));
                        HomeFragment.decks[deck].c4.setImageDrawable(GalleryFragment.drawables.get(j*50+3));
                        HomeFragment.decks[deck].c5.setImageDrawable(GalleryFragment.drawables.get(j*50+4));
                        HomeFragment.decks[deck].c6.setImageDrawable(GalleryFragment.drawables.get(j*50+5));
                        HomeFragment.decks[deck].c7.setImageDrawable(GalleryFragment.drawables.get(j*50+6));
                        HomeFragment.decks[deck].c8.setImageDrawable(GalleryFragment.drawables.get(j*50+7));

                        Toast toast = Toast.makeText(PopActivity.this,
                                "Deck Copied",
                                Toast.LENGTH_SHORT);

                        toast.show();

                        finish();

                    }catch(NullPointerException e){
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
