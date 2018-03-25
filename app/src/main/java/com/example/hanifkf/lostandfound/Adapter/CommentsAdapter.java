package com.example.hanifkf.lostandfound.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hanifkf.lostandfound.Models.Comments;
import com.example.hanifkf.lostandfound.R;

import java.util.ArrayList;

/**
 * Created by M Taufiq R on 19/03/2018.
 */

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder> {

    private ArrayList<Comments> dataList;

    public CommentsAdapter(ArrayList<Comments> dataList) {
        this.dataList = dataList;
    }

    @Override
    public CommentsAdapter.CommentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_view_comments, parent, false);
        return new CommentsAdapter.CommentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommentsAdapter.CommentsViewHolder holder, int position) {
        holder.profil.setImageResource(dataList.get(position).getPicture());
        holder.username.setText(dataList.get(position).getNama());
        holder.isi.setText(dataList.get(position).getIsi());
        holder.waktu.setText(dataList.get(position).getWaktu());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class CommentsViewHolder extends RecyclerView.ViewHolder{
        private ImageView profil;
        private TextView username,isi,waktu;

        public CommentsViewHolder(View itemView) {
            super(itemView);
            profil=(ImageView)itemView.findViewById(R.id.icon_image);
            username=(TextView)itemView.findViewById(R.id.txt_username);
            isi=(TextView)itemView.findViewById(R.id.txt_isi);
            waktu=(TextView)itemView.findViewById(R.id.txt_waktu);
        }
    }

}
