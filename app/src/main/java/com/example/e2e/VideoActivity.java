package com.example.e2e;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.ArrayList;

public class VideoActivity extends AppCompatActivity {

    ViewPager viewPager;
    ChipNavigationBar chipNavigationBar;
    RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);


        ActionBar actionBar = getSupportActionBar();
        viewPager=findViewById(R.id.viewPager);
        chipNavigationBar=findViewById(R.id.chipNavigationBar);
        chipNavigationBar.setItemSelected(R.id.Video,true);
        recyclerView=findViewById(R.id.videoRecycle);

        ArrayList<VideoData> vd = new ArrayList<>();
      vd.add(new VideoData(R.drawable.vid1,"vid1"));
        vd.add(new VideoData(R.drawable.vid2,"vid2"));
        vd.add(new VideoData(R.drawable.vid3,"vid3"));

        recyclerView.setLayoutManager(new LinearLayoutManager(VideoActivity.this));
        recyclerView.setAdapter(new VideoAdapter(this,vd));


        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {

                switch (i){
                    case R.id.Dashboard:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        break;

                    case R.id.Video:
                        startActivity(new Intent(getApplicationContext(),VideoActivity.class));
                        overridePendingTransition(0,0);
                        break;

                    case R.id.Profile:
                        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        overridePendingTransition(0,0);
                        break;

                }
            }
        });




    }
}