package com.example.hanifkf.lostandfound.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hanifkf.lostandfound.Models.Recent;
import com.example.hanifkf.lostandfound.R;
import com.example.hanifkf.lostandfound.Utils.CustomItemClickListener;

import java.util.ArrayList;

/**
 * Created by M Taufiq R on 25/02/2018.
 */

public class RecentAdapter extends RecyclerView.Adapter<RecentAdapter.RecentRecycleViewHolder> {

    private ArrayList<Recent> dataList;
    private CustomItemClickListener listener;

    public RecentAdapter(ArrayList<Recent> dataList, CustomItemClickListener listener) {
        this.dataList = dataList;
        this.listener = listener;
    }

    @Override
    public RecentAdapter.RecentRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_view_recent, parent, false);
        final RecentRecycleViewHolder mholder=new RecentRecycleViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(view,mholder.getPosition());
            }
        });
        return mholder;
    }

    @Override
    public void onBindViewHolder(RecentAdapter.RecentRecycleViewHolder holder, int position) {
        holder.profileImage.setImageResource(dataList.get(position).getProfileImage());
        holder.txtNama.setText(dataList.get(position).getNama());
        holder.txtHilang.setText(dataList.get(position).getHilang());
        holder.txtItem.setText(dataList.get(position).getItem());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class RecentRecycleViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama, txtHilang, txtItem;
        private ImageView profileImage;

        public RecentRecycleViewHolder(View itemView) {
            super(itemView);
            profileImage = (ImageView) itemView.findViewById(R.id.profile_image);
            txtNama = (TextView) itemView.findViewById(R.id.txt_nama);
            txtHilang = (TextView) itemView.findViewById(R.id.txt_hilang);
            txtItem = (TextView) itemView.findViewById(R.id.txt_item);
        }
    }

}
