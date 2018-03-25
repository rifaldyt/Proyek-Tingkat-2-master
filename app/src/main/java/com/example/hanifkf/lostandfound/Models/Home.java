package com.example.hanifkf.lostandfound.Models;

/**
 * Created by M Taufiq R on 24/02/2018.
 */

public class Home {
    private int profileImage;
    private String nama;
    private String hilang;
    private String suggest;
    private int deskripsi;
    private String item;
    private int imageView;

    public Home(int profileImage, String nama, String hilang, String suggest, int deskripsi, String item, int imageView) {
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

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHilang() {
        return hilang;
    }

    public void setHilang(String hilang) {
        this.hilang = hilang;
    }

    public String getSuggest() {
        return suggest;
    }

    public int getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(int deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getImageView() {
        return imageView;
    }
}
