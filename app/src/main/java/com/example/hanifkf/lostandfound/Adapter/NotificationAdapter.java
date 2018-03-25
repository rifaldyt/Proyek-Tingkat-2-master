package com.example.hanifkf.lostandfound.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.hanifkf.lostandfound.R;
import com.example.hanifkf.lostandfound.Models.Notification;
import com.example.hanifkf.lostandfound.Utils.CustomItemClickListener;

import java.util.ArrayList;

/**
 * Created by hanifkf on 25/02/2018.
 */

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotifRecycleViewHolder> {

    private ArrayList<Notification> dataList;
    private CustomItemClickListener listener;

    public NotificationAdapter(ArrayList<Notification> dataList, CustomItemClickListener listener) {
        this.dataList = dataList;
        this.listener = listener;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public NotifRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_view_notif, parent, false);
        final NotifRecycleViewHolder mholder=new NotifRecycleViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(view,mholder.getPosition());
            }
        });
        return mholder;
    }

    @Override
    public void onBindViewHolder(NotifRecycleViewHolder holder, int position) {
        holder.profil.setImageResource(dataList.get(position).getPicture());
        holder.username.setText(dataList.get(position).getNama());
        holder.isi.setText(dataList.get(position).getIsi());
        holder.waktu.setText(dataList.get(position).getWaktu());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class NotifRecycleViewHolder extends RecyclerView.ViewHolder{
        private ImageView profil;
        private TextView username,isi,waktu;

        public NotifRecycleViewHolder(View itemView) {
            super(itemView);
            profil=(ImageView)itemView.findViewById(R.id.icon_image);
            username=(TextView)itemView.findViewById(R.id.txt_username);
            isi=(TextView)itemView.findViewById(R.id.txt_isi);
            waktu=(TextView)itemView.findViewById(R.id.txt_waktu);
        }
    }

}