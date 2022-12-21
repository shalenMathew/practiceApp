package com.example.e2e;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



ArrayList<dataClass> list;
MyAdapter adapter;

    ViewPager viewPager;
ChipNavigationBar chipNavigationBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        viewPager=findViewById(R.id.viewPager);
        chipNavigationBar=findViewById(R.id.chipNavigationBar);
        chipNavigationBar.setItemSelected(R.id.Dashboard,true);

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


        loadCards();


    }

    private void loadCards() {

        list=new ArrayList<>();
        list.add(new dataClass("Cost differentiator","This product is about blah blah blah blah balh blah blah blah blah balh blah blah blah blah balh blah blah blah blah balh This","9/11/2001",R.drawable.pic1));
        list.add(new dataClass("Price efficient","This product is about blah blah blah blah balh blah blah blah blah balh blah blah blah blah balh blah blah blah blah balh This produ ","3/5/2012",R.drawable.pic2));
        list.add(new dataClass("Cyber protocol Defi","This product is about blah blah blah blah balh blah blah blah blah This product is about blah blah blah blah balh blah blah blah  ","4/2/2076",R.drawable.pic3));

         adapter = new MyAdapter(this,list);
         viewPager.setPageTransformer(true,new ZoomAnimation());
        viewPager.setAdapter(adapter);


    }
}