package com.example.hanifkf.lostandfound.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hanifkf.lostandfound.Activity.DetailsActivity;
import com.example.hanifkf.lostandfound.R;
import com.example.hanifkf.lostandfound.Utils.CustomItemClickListener;
import com.example.hanifkf.lostandfound.Adapter.RecentAdapter;
import com.example.hanifkf.lostandfound.Models.Home;
import com.example.hanifkf.lostandfound.Models.Recent;

import java.util.ArrayList;

/**
 * Created by hanifkf on 24/02/2018.
 */

public class RecentFragment extends Fragment{

    private RecentAdapter adapter;
    private ArrayList<Recent> recentArrayList;
    private ArrayList<Home> homeArrayList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_recent,container,false);

        recentArrayList = new ArrayList<>();

        recentArrayList.add(new Recent(R.drawable.squid, "Squidward", "HP HTC", "Hilang"));
        recentArrayList.add(new Recent(R.drawable.squid, "Squidward", "Kunci Mobil", "Hilang"));
        homeArrayList = new ArrayList<>();
        homeArrayList.add(new Home(R.drawable.squid,"Squidward", "HP HTC", "Category : Gadget",R.string.hilang_1,"Item : Hilang", R.drawable.htc));
        homeArrayList.add(new Home(R.drawable.squid,"Squidward", "Kunci Mobil", "Category : Otomotif",R.string.hilang_2,"Item : Hilang", R.drawable.kunci));

        RecyclerView recyclerView = view.findViewById(R.id.recentpost);
        adapter = new RecentAdapter(recentArrayList, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent in=new Intent(getContext(), DetailsActivity.class);
                in.putExtra("profile",homeArrayList.get(position).getProfileImage());
                in.putExtra("deskripsi",homeArrayList.get(position).getDeskripsi());
                in.putExtra("nama",homeArrayList.get(position).getNama());
                in.putExtra("hilang",homeArrayList.get(position).getHilang());
                in.putExtra("suggest",homeArrayList.get(position).getSuggest());
                in.putExtra("item",homeArrayList.get(position).getItem());
                in.putExtra("image",homeArrayList.get(position).getImageView());
                startActivity(in);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}
