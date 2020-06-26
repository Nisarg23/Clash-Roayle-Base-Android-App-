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
import android.widget.ImageView;
import android.widget.Toast;



import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.clashroyalebase.Fragment1;
import com.example.clashroyalebase.PlayerInfo;
import com.example.clashroyalebase.Player_Buffering;
import com.example.clashroyalebase.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;

    public static EditText player_tag;
    public static Button search_player;

    static Boolean invalid;
    public static JSONArray arr;

    public static Button refresh;


    JSONObject obj;
    public static JSONObject obj_player;

    public static String base_url = "https://api.clashroyale.com/v1/players/";
    public static String url_player;
    public static String url_chest;

    public static ArrayList<String> chest = new ArrayList<String>();
    public static ArrayList<Integer> chestAt = new ArrayList<Integer>();

    public static Fragment fragment1;
    public static FragmentTransaction fm;

    public static final String key = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6IjVmYjEyNDI0LWIwODEtNDMwNC05MWQ0LTlkNjIyYmEwN2M5OSIsImlhdCI6MTU5MjIzNDk3MSwic3ViIjoiZGV2ZWxvcGVyLzBlZjM4ZDg5LWI1MjItYThhMC01YWE2LTQ1OGZlNjZmMTM4ZSIsInNjb3BlcyI6WyJyb3lhbGUiXSwibGltaXRzIjpbeyJ0aWVyIjoiZGV2ZWxvcGVyL3NpbHZlciIsInR5cGUiOiJ0aHJvdHRsaW5nIn0seyJjaWRycyI6WyIyNC4yMzUuMjEwLjc2Il0sInR5cGUiOiJjbGllbnQifV19.aCOBc9Gg2fyKCcd4GiyO3kKvG5tPWp52vWWLdJ_L8e_8WB9WVAorbx3fTiej3dfIbIK7rCKveNVwTUdWCLBJ3w";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        player_tag = root.findViewById(R.id.player_tag);
        search_player = root.findViewById(R.id.search_player);


//        Fragment f1 = new Fragment1();
//        FragmentTransaction fm = getChildFragmentManager().beginTransaction();
//        fm.add(R.id.child_fragment_container,f1).commitNow();
//        fm.hide(f1).commitNow();

        getChildFragmentManager().beginTransaction().add(R.id.child_fragment_container,new Fragment1(),"fragment1").commitNow();
        fragment1 = getChildFragmentManager().findFragmentByTag("fragment1");
         fm = getChildFragmentManager().beginTransaction();
        fm.hide(fragment1).commitNow();



        refresh = root.findViewById(R.id.refresh);


        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = (String) Fragment1.tag.getText();
                s = s.substring(1);
                SlideshowFragment.player_tag.setText(s);
                PlayerInfo.triggered_refresh = true;
                search_player.performClick();

            }
        });


        searchButtonListener();
        playerTagListener();


        return root;
    }

    public void playerTagListener(){
        player_tag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                player_tag.setText("");
            }
        });
    }

    public void searchButtonListener() {
        search_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String tag = "%23"+player_tag.getText().toString().toUpperCase();
                url_player = base_url + tag;
                url_chest = url_player.concat("/upcomingchests");
                url_chest = url_chest.replaceAll("\\s+","");

                InputMethodManager mgr = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);



                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        URL urlForGetRequest_player = null;
                        invalid = false;

                        try {

                            urlForGetRequest_player = new URL(url_player);
                            String readLine = null;
                            String readLine_player = null;
                            HttpURLConnection conection_player = (HttpURLConnection) urlForGetRequest_player.openConnection();

                            conection_player.setRequestMethod("GET");
                            conection_player.setRequestProperty("Content-Type", "application/json");
                            conection_player.setRequestProperty("Authorization", "Bearer " + key);



                            int responseCode_player = conection_player.getResponseCode();



                            BufferedReader in_player = new BufferedReader(
                                    new InputStreamReader(conection_player.getInputStream()));



                            StringBuffer response_player = new StringBuffer();
                            while ((readLine_player = in_player.readLine()) != null) {
                                response_player.append(readLine_player);
                            }

                            in_player.close();

                             obj_player = new JSONObject(response_player.toString());






                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                            System.out.println("MALFORMEDURL");
                            invalid = true;
                        } catch (IOException e) {
                            e.printStackTrace();
                            System.out.println("I/O");
                            invalid = true;
                        } catch (JSONException e) {
                            e.printStackTrace();
                            System.out.println("JSON");
                            invalid = true;
                        }

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (invalid == true){
                                    Toast toast = Toast.makeText(getActivity(),
                                            "Invalid player tag Provided",
                                            Toast.LENGTH_SHORT);

                                    toast.show();
                                }
                                else{
                                    startActivity(new Intent(getActivity(), PlayerInfo.class));

                                }
                            }
                        });
                    }
                }).start();


            }
        });
    }
}