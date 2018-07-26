package com.example.admin1.oyorooms;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView myRecyclerView;
    RecyclerView.LayoutManager myRecyclerViewLayoutManager;
    RecyclerView.Adapter myRecyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null) {
            actionBar.hide();
        }
        Window window = HomeActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        myRecyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        myRecyclerViewLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        myRecyclerView.setLayoutManager(myRecyclerViewLayoutManager);
        List<String> input = new ArrayList<String>();
        String[] cities = {"Banglore","Coorg","Mysore","Chennai","Delhi","Gurgoan","Hyderabad","Kolkata","Mumbai","Noida","Pune","All Cities"};
        for(int i=0;i<cities.length;i++) {
            input.add(cities[i]);
        }
        myRecyclerViewAdapter = new MyAdapter(input);
        myRecyclerView.setAdapter(myRecyclerViewAdapter);
    }
}
