package com.example.clashroyalebase.ui.gallery;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

    public ImageView imageView2;
    public ArrayList<Drawable> drawables = new ArrayList<Drawable>();

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
        imageView2 = root.findViewById(R.id.imageView2);



        return root;
    }
}
