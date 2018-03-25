package com.example.hanifkf.lostandfound.Activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.hanifkf.lostandfound.R;
import com.example.hanifkf.lostandfound.Adapter.EditProfileAdapter;
import com.example.hanifkf.lostandfound.Models.EditProfile;

import java.util.ArrayList;

public class EditProfileActivity extends AppCompatActivity {

    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        back= (ImageView)findViewById(R.id.back_edit);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ArrayList<EditProfile> editProfiles = new ArrayList<EditProfile>();

        editProfiles.add(new EditProfile("Nama", "Squidward"));
        editProfiles.add(new EditProfile("Email", "squidward@gmail.com"));
        editProfiles.add(new EditProfile("Nomor Handphone", "087822066651"));
        editProfiles.add(new EditProfile("Alamat", "Jl. Bikini Bottom no.247"));

        EditProfileAdapter profileAdapter = new EditProfileAdapter(this, editProfiles);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(profileAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Dialog();
                }else if(i==1){
                    Dialog();
                }else if(i==2){
                    Dialog();
                }else if(i==3){
                    Dialog();
                }
            }
        });
    }

    public void Dialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(EditProfileActivity.this);
        LayoutInflater inflater = EditProfileActivity.this.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialog_edit_profile, null))
                // Add action buttons
                .setPositiveButton("Ubah", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                })
                .setNegativeButton("Batalkan", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
