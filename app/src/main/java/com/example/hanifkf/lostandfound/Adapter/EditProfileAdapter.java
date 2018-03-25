package com.example.hanifkf.lostandfound.Adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.hanifkf.lostandfound.R;
import com.example.hanifkf.lostandfound.Models.EditProfile;

import java.util.ArrayList;

public class EditProfileAdapter extends ArrayAdapter<EditProfile> {

    public EditProfileAdapter(Activity context, ArrayList<EditProfile> editProfileArrayList) {
        super(context, 0, editProfileArrayList);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.list_view_edit_profile, parent, false);

        EditProfile editProfile = getItem(position);

        TextView nama = (TextView) view.findViewById(R.id.txt_nama);
        nama.setText(editProfile.getNama());

        TextView isi = (TextView) view.findViewById(R.id.txt_isi);
        isi.setText(editProfile.getIsi());

        return view;
    }

}