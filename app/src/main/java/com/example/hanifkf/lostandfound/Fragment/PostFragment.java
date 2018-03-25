package com.example.hanifkf.lostandfound.Fragment;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hanifkf.lostandfound.R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.maps.model.LatLng;

import static android.app.Activity.RESULT_OK;
import static android.content.ContentValues.TAG;

/**
 * Created by hanifkf on 24/02/2018.
 */

public class PostFragment extends Fragment{

    private static int IMG_RESULT = 1;
    private static int IMG_CAMERA = 2;
    String ImageDecode;
    ImageView imageViewLoad,cameraLoad;
    ImageView LoadImage,Locationload;
    Intent intent;
    String[] FILE;
    TextView lokasi;
    public static final int PICK_UP = 0;
    private static int REQUEST_CODE = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_post,container,false);

        imageViewLoad = (ImageView)view.findViewById(R.id.img_post);
        LoadImage = (ImageView) view.findViewById(R.id.open_gallery);
        cameraLoad=(ImageView)view.findViewById(R.id.open_camera);
        Locationload=(ImageView)view.findViewById(R.id.open_location);
        lokasi=(TextView)view.findViewById(R.id.lokasi_id);
        LoadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(intent, IMG_RESULT);
            }
        });

        cameraLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent,IMG_CAMERA);
                }

            }
        });
        Locationload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPlaceAutoComplete(PICK_UP);
            }
        });


        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.kategori, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        return view;
    }

    private void showPlaceAutoComplete(int typeLocation) {
        // isi RESUT_CODE tergantung tipe lokasi yg dipilih.
        // titik jmput atau tujuan
        REQUEST_CODE = typeLocation;

        // Filter hanya tmpat yg ada di Indonesia
        AutocompleteFilter typeFilter = new AutocompleteFilter.Builder().setCountry("ID").build();
        try {
            // Intent untuk mengirim Implisit Intent
            Intent mIntent = new PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_OVERLAY)
                    .setFilter(typeFilter)
                    .build(getActivity());
            // jalankan intent impilist
            startActivityForResult(mIntent, REQUEST_CODE);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace(); // cetak error
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace(); // cetak error
            // Display Toast
            Toast.makeText(getContext(), "Layanan Play Services Tidak Tersedia", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        try {
            if (resultCode == RESULT_OK ){

                Log.d(TAG, "onActivityResult: "+resultCode+" "+requestCode);
                //Toast.makeText(this, "Sini Gaes2", Toast.LENGTH_SHORT).show();
                // Tampung Data tempat ke variable
                Place placeData = PlaceAutocomplete.getPlace(getContext(), data);

                if (requestCode==REQUEST_CODE){
                    // Show in Log Cat
                    Log.d("autoCompletePlace Data", placeData.toString());

                    // Dapatkan Detail
                    String placeAddress = placeData.getAddress().toString();
                    LatLng placeLatLng = placeData.getLatLng();
                    String placeName = placeData.getName().toString();

                    // Cek user milih titik jemput atau titik tujuan
                    lokasi.setText(placeAddress);
                }
                else if (requestCode == IMG_RESULT && null != data) {

                    Uri URI = data.getData();
                    String[] FILE = { MediaStore.Images.Media.DATA };

                    Cursor cursor = getContext().getContentResolver().query(URI, FILE, null, null, null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(FILE[0]);
                    ImageDecode = cursor.getString(columnIndex);
                    cursor.close();

                    imageViewLoad.setImageBitmap(BitmapFactory.decodeFile(ImageDecode));

                }
                else if (requestCode == IMG_CAMERA) {
                    Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
                    imageViewLoad.setImageBitmap(thumbnail);
                }

            }
        } catch (Exception e) {
            Log.d(TAG, "onActivityResult: "+e.toString());
            Toast.makeText(getContext(), "Please try again", Toast.LENGTH_LONG).show();
        }
    }

}
