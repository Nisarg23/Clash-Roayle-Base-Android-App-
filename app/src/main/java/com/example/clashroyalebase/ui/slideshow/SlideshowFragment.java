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
import androidx.lifecycle.ViewModelProviders;

import com.example.clashroyalebase.PlayerInfo;
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


    JSONObject obj;

    public static String base_url = "https://api.clashroyale.com/v1/players/";
    public static String url_player;
    public static String url_chest;

    public static ArrayList<String> chest = new ArrayList<String>();
    public static ArrayList<Integer> chestAt = new ArrayList<Integer>();

    public final String key = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiIsImtpZCI6IjI4YTMxOGY3LTAwMDAtYTFlYi03ZmExLTJjNzQzM2M2Y2NhNSJ9.eyJpc3MiOiJzdXBlcmNlbGwiLCJhdWQiOiJzdXBlcmNlbGw6Z2FtZWFwaSIsImp0aSI6IjVmYjEyNDI0LWIwODEtNDMwNC05MWQ0LTlkNjIyYmEwN2M5OSIsImlhdCI6MTU5MjIzNDk3MSwic3ViIjoiZGV2ZWxvcGVyLzBlZjM4ZDg5LWI1MjItYThhMC01YWE2LTQ1OGZlNjZmMTM4ZSIsInNjb3BlcyI6WyJyb3lhbGUiXSwibGltaXRzIjpbeyJ0aWVyIjoiZGV2ZWxvcGVyL3NpbHZlciIsInR5cGUiOiJ0aHJvdHRsaW5nIn0seyJjaWRycyI6WyIyNC4yMzUuMjEwLjc2Il0sInR5cGUiOiJjbGllbnQifV19.aCOBc9Gg2fyKCcd4GiyO3kKvG5tPWp52vWWLdJ_L8e_8WB9WVAorbx3fTiej3dfIbIK7rCKveNVwTUdWCLBJ3w";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        player_tag = root.findViewById(R.id.player_tag);
        search_player = root.findViewById(R.id.search_player);




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
                        URL urlForGetRequest = null;
                        invalid = false;

                        try {
                            urlForGetRequest = new URL(url_chest);
                            String readLine = null;
                            HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
                            conection.setRequestMethod("GET");
                            conection.setRequestProperty("Content-Type", "application/json");
                            conection.setRequestProperty("Authorization", "Bearer " + key);
                            int responseCode = conection.getResponseCode();


                            BufferedReader in = new BufferedReader(
                                    new InputStreamReader(conection.getInputStream()));
                            StringBuffer response = new StringBuffer();
                            while ((readLine = in.readLine()) != null) {
                                response.append(readLine);
                            }
                            in.close();
                             obj = new JSONObject(response.toString());





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
                                    try {
                                        JSONArray array = (JSONArray) obj.get("items");
                                        for (int i = 0; i < array.length(); i++) {
                                            JSONObject o = new JSONObject(array.get(i).toString());
                                            chest.add((String) o.get("name"));
                                            chestAt.add((Integer) o.get("index"));
                                            System.out.println(o.get("name") + "   " + o.get("index"));
                                        }
                                    }catch(JSONException e){
                                        e.printStackTrace();
                                        }




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