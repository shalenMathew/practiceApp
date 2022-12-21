package com.example.e2e;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class MyAdapter extends PagerAdapter{

    Context context;
    ArrayList<dataClass> dataClassArrayList;

    public MyAdapter(Context context, ArrayList<dataClass> dataClassArrayList) {
        this.context = context;
        this.dataClassArrayList = dataClassArrayList;
    }

    @Override
    public int getCount() {
        return dataClassArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        View view = LayoutInflater.from(context).inflate(R.layout.adapter_layout, container, false);

        // intalizing id
        TextView titleIv = view.findViewById(R.id.title);
        TextView descriptionIv = view.findViewById(R.id.description);
        ImageView imgIv = view.findViewById(R.id.image);
        TextView dateIv = view.findViewById(R.id.date);

        dataClass dataObject = dataClassArrayList.get(position);
        String title = dataObject.getTitle();
        String description = dataObject.getDescription();
        String date = dataObject.getDate();
        int img = dataObject.getImage();

        titleIv.setText(title);
        descriptionIv.setText(description);
        imgIv.setImageResource(img);
        dateIv.setText(date);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "The current protocol is under development , will on " + date, Toast.LENGTH_SHORT).show();
            }
        });


        container.addView(view, position);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

container.removeView((View) object);

    }


}
