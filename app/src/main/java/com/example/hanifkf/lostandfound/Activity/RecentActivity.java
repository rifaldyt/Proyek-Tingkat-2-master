package com.example.hanifkf.lostandfound.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.hanifkf.lostandfound.R;
import com.example.hanifkf.lostandfound.Adapter.DetailsAdapter;
import com.example.hanifkf.lostandfound.Models.Details;

import java.util.ArrayList;

public class RecentActivity extends AppCompatActivity {

    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_post);
        back=(ImageView)findViewById(R.id.back_details);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ArrayList<Details> detailsArrayList = new ArrayList<Details>();

        Intent intent = getIntent();
        int profile = intent.getIntExtra("profile", 0);
        int image = intent.getIntExtra("image", 0);
        String nama = intent.getStringExtra("nama").toString();
        String hilang = intent.getStringExtra("hilang").toString();
        String suggest = intent.getStringExtra("suggest").toString();
        String item = intent.getStringExtra("item").toString();
        int deskripsi=intent.getIntExtra("deskripsi",0);

        detailsArrayList.add(new Details(profile, nama, hilang, suggest, deskripsi,item, image));
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        DetailsAdapter detailsAdapter = new DetailsAdapter(detailsArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(detailsAdapter);
    }

}

