package com.example.hanifkf.lostandfound.Models;

/**
 * Created by M Taufiq R on 25/02/2018.
 */

public class Details {
    private int profileImage;
    private String nama;
    private String hilang;
    private String suggest;
    private int deskripsi;
    private String item;
    private int imageView;

    public Details(int profileImage, String nama, String hilang, String suggest, int deskripsi, String item, int imageView) {
        this.profileImage = profileImage;
        this.nama = nama;
        this.hilang = hilang;
        this.suggest = suggest;
        this.deskripsi = deskripsi;
        this.item = item;
        this.imageView = imageView;
    }

    public int getProfileImage() {
        return profileImage;
    }

    public String getNama() {
        return nama;
    }

    public String getHilang() {
        return hilang;
    }

    public String getSuggest() {
        return suggest;
    }

    public int getDeskripsi() {
        return deskripsi;
    }

    public String getItem() {
        return item;
    }

    public int getImageView() {
        return imageView;
    }
}
