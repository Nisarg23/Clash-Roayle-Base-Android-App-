package com.example.clashroyalebase;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

public class TrialActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trial);

        ImageView s = findViewById(R.id.aoc);


        s.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                Uri app = Uri.parse("clashroyale://copyDeck?deck=26000010;26000014;26000021;26000030;26000038;27000000;28000000;28000011");
                //Intent intent = getPackageManager().getLaunchIntentForPackage("com.supercell.clashroyale");
                Intent intent = new Intent(Intent.ACTION_VIEW,app);

                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities = packageManager.queryIntentActivities(intent,
                        PackageManager.MATCH_DEFAULT_ONLY);
                boolean isIntentSafe = activities.size() > 0;

                if (isIntentSafe == true) {
                    startActivity(intent);
                }
                else{
                    Toast t = Toast.makeText(TrialActivity.this,
                            "You Don't Have Clash Royale",
                            Toast.LENGTH_SHORT);
                    t.show();

                }
            }
        });


    }


}
