package com.example.hanifkf.lostandfound.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hanifkf.lostandfound.R;
import com.example.hanifkf.lostandfound.Models.Home;
import com.example.hanifkf.lostandfound.Utils.CustomItemClickListener;

import java.util.ArrayList;

/**
 * Created by M Taufiq R on 24/02/2018.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private ArrayList<Home> dataList;
    private CustomItemClickListener listener;

    public HomeAdapter(ArrayList<Home> dataList, CustomItemClickListener listener) {
        this.dataList = dataList;
        this.listener = listener;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_view_home, parent, false);
        final HomeViewHolder mholder=new HomeViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(view,mholder.getPosition());
            }
        });
        return mholder;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public void onBindViewHolder(HomeAdapter.HomeViewHolder holder, int position) {
        holder.profileImage.setImageResource(dataList.get(position).getProfileImage());
        holder.txtNama.setText(dataList.get(position).getNama());
        holder.txtHilang.setText(dataList.get(position).getHilang());
        holder.txtSuggest.setText(dataList.get(position).getSuggest());
        holder.txtItem.setText(dataList.get(position).getItem());
        holder.imageView.setImageResource(dataList.get(position).getImageView());
        holder.txtdeskripsi.setText(dataList.get(position).getDeskripsi());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama, txtHilang, txtSuggest, txtItem,txtdeskripsi;
        private ImageView imageView, profileImage;

        public HomeViewHolder(View itemView) {
            super(itemView);
            txtdeskripsi=(TextView)itemView.findViewById(R.id.deskripsi_home);
            profileImage = (ImageView) itemView.findViewById(R.id.profile_image);
            txtNama = (TextView) itemView.findViewById(R.id.txt_nama);
            txtHilang = (TextView) itemView.findViewById(R.id.txt_hilang);
            txtSuggest = (TextView) itemView.findViewById(R.id.txt_suggest);
            txtItem = (TextView) itemView.findViewById(R.id.txt_item);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

}
