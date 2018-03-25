package com.example.hanifkf.lostandfound.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hanifkf.lostandfound.Models.Details;
import com.example.hanifkf.lostandfound.R;

import java.util.ArrayList;

/**
 * Created by M Taufiq R on 25/02/2018.
 */

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.DetailsViewHolder> {

    private ArrayList<Details> dataList;

    public DetailsAdapter(ArrayList<Details> dataList) {
        this.dataList = dataList;
    }

    @Override
    public DetailsAdapter.DetailsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_view_details, parent, false);
        return new DetailsAdapter.DetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DetailsAdapter.DetailsViewHolder holder, int position) {
        holder.profileImage.setImageResource(dataList.get(position).getProfileImage());
        holder.txtNama.setText(dataList.get(position).getNama());
        holder.txtHilang.setText(dataList.get(position).getHilang());
        holder.txtDeskripsi.setText(dataList.get(position).getDeskripsi());
        holder.txtHp.setText(dataList.get(position).getSuggest());
        holder.txtAlamat.setText(dataList.get(position).getItem());
        holder.imageview.setImageResource(dataList.get(position).getImageView());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class DetailsViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama, txtHilang, txtDeskripsi, txtHp, txtAlamat;
        private ImageView imageview, profileImage;

        public DetailsViewHolder(View itemView) {
            super(itemView);
            profileImage = (ImageView) itemView.findViewById(R.id.profile_image);
            txtNama = (TextView) itemView.findViewById(R.id.txt_nama);
            txtHilang = (TextView) itemView.findViewById(R.id.txt_hilang);
            txtDeskripsi = (TextView) itemView.findViewById(R.id.deskripsi);
            txtHp = (TextView) itemView.findViewById(R.id.txt_hp);
            txtAlamat = (TextView) itemView.findViewById(R.id.txt_alamat);
            imageview = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

}
