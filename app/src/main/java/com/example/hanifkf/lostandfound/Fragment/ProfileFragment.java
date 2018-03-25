package com.example.hanifkf.lostandfound.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.hanifkf.lostandfound.Activity.EditProfileActivity;
import com.example.hanifkf.lostandfound.Login.MainActivity;
import com.example.hanifkf.lostandfound.R;

/**
 * Created by hanifkf on 24/02/2018.
 */

public class ProfileFragment extends Fragment{

    LinearLayout linearLayout1, linearLayout2, linearLayout3, linearLayout4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_profile,container,false);

        linearLayout1 = (LinearLayout)view.findViewById(R.id.linear1);
        linearLayout2 = (LinearLayout)view.findViewById(R.id.linear2);
        linearLayout3 = (LinearLayout)view.findViewById(R.id.linear3);
        linearLayout4 = (LinearLayout)view.findViewById(R.id.linear4);

        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), EditProfileActivity.class);
                startActivity(intent);
            }
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("Email"));
                String Send[] = {"contact.teamequinox@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL, Send);
                intent.setType("message/text");
                Intent choser = intent.createChooser(intent, "Launch Email");
                startActivity(choser);
            }
        });

        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getContext(), "Versi 1.0", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        linearLayout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
