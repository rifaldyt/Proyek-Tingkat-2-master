package com.example.hanifkf.lostandfound.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hanifkf.lostandfound.Activity.DetailsActivity;
import com.example.hanifkf.lostandfound.R;
import com.example.hanifkf.lostandfound.Utils.CustomItemClickListener;
import com.example.hanifkf.lostandfound.Adapter.NotificationAdapter;
import com.example.hanifkf.lostandfound.Models.Home;
import com.example.hanifkf.lostandfound.Models.Notification;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by hanifkf on 24/02/2018.
 */

public class NotifFragment extends Fragment{

    private NotificationAdapter adapter;
    private ArrayList<Notification> notifrecycle;
    private ArrayList<Home> detailArrayList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View view=inflater.inflate(R.layout.fragment_notif,container,false);
        int[] profile = {
                R.drawable.sponge,
                R.drawable.krabs,
                R.drawable.sandy
        };

        String[] nama = {
                "Spongebob",
                "Mr.Krabs",
                "Sandy"
        };

        String[] hilang = {
                "Spongebob Memposting Penemuan Kunci Mobil",
                "Mr.Krab Mengomentari Postingan Anda",
                "Sandy Mengomentari Postingan Anda"

        };

        String[] item = {
                "5 menit yang lalu",
                "20 menit yang lalu",
                "4 jam yang lalu"
        };

        notifrecycle = new ArrayList<>();
        detailArrayList = new ArrayList<>();
        detailArrayList.add(new Home(R.drawable.sponge,"Spongebob", "Kunci Mobil", "Category : Otomotif",R.string.hilang_1,"Item : Menemukan", R.drawable.kunci));
        detailArrayList.add(new Home(R.drawable.squid,"Squidward", "HP HTC", "Category : Gadget",R.string.hilang_2,"Item : Hilang", R.drawable.htc));
        detailArrayList.add(new Home(R.drawable.squid,"Squidward", "HP HTC", "Category : Gadget",R.string.hilang_3,"Item : Hilang", R.drawable.htc));
        for (int i = 0; i < nama.length; i++) {
            notifrecycle.add(new Notification(profile[i], nama[i], hilang[i], item[i]));
        }

        RecyclerView recyclerView = view.findViewById(R.id.list_notif);
        adapter = new NotificationAdapter(notifrecycle, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Log.d(TAG, "onItemClick position: "+notifrecycle.get(position).getNama()+", "+notifrecycle.get(position).getIsi());
                Intent in=new Intent(getContext(), DetailsActivity.class);
                in.putExtra("profile",detailArrayList.get(position).getProfileImage());
                in.putExtra("deskripsi",detailArrayList.get(position).getDeskripsi());
                in.putExtra("nama",detailArrayList.get(position).getNama());
                in.putExtra("hilang",detailArrayList.get(position).getHilang());
                in.putExtra("suggest",detailArrayList.get(position).getSuggest());
                in.putExtra("item",detailArrayList.get(position).getItem());
                in.putExtra("image",detailArrayList.get(position).getImageView());
                startActivity(in);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}
