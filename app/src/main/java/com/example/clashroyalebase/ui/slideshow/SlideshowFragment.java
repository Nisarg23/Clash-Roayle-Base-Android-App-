package com.example.clashroyalebase.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.clashroyalebase.R;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    public static EditText player_tag;
    public static Button search_player;

    public static String url = "https://statsroyale.com/profile/";

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

        return root;
    }
}
