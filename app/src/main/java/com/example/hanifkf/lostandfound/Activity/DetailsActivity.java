package com.example.hanifkf.lostandfound.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.hanifkf.lostandfound.Adapter.CommentsAdapter;
import com.example.hanifkf.lostandfound.Adapter.EditProfileAdapter;
import com.example.hanifkf.lostandfound.Models.Comments;
import com.example.hanifkf.lostandfound.Models.EditProfile;
import com.example.hanifkf.lostandfound.R;
import com.example.hanifkf.lostandfound.Adapter.DetailsAdapter;
import com.example.hanifkf.lostandfound.Models.Details;

import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //Tombol Back
        back=(ImageView)findViewById(R.id.back_details);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ArrayList<Details> detailsArrayList = new ArrayList<Details>();

        //Recycler View Details
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

        //List Comment
        ArrayList<Comments> commentsArrayList = new ArrayList<Comments>();

        commentsArrayList.add(new Comments(R.drawable.sandy, "Sandy", "Sepertinya Pernah Melihat", "4 jam lalu"));
        commentsArrayList.add(new Comments(R.drawable.krabs, "Mr.Krabs", "Saya menemukannya", "20 menit lalu"));

        RecyclerView recyclerViewComments = (RecyclerView) findViewById(R.id.recycler_view_comment);
        CommentsAdapter commentsAdapter = new CommentsAdapter(commentsArrayList);
        RecyclerView.LayoutManager layoutManagerComments = new LinearLayoutManager(this);
        recyclerViewComments.setLayoutManager(layoutManagerComments);
        recyclerViewComments.setAdapter(commentsAdapter);
    }

}
