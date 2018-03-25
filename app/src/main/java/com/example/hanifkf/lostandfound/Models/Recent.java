package com.example.hanifkf.lostandfound.Models;

/**
 * Created by M Taufiq R on 25/02/2018.
 */

public class Recent {
    private int profileImage;
    private String nama;
    private String hilang;
    private String item;

    public Recent(int profileImage, String nama, String hilang, String item) {
        this.profileImage = profileImage;
        this.nama = nama;
        this.hilang = hilang;
        this.item = item;
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

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
