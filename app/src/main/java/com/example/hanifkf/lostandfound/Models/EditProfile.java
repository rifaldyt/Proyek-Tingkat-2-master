package com.example.hanifkf.lostandfound.Models;

/**
 * Created by M Taufiq R on 26/02/2018.
 */

public class EditProfile {
    private String nama;
    private String isi;

    public EditProfile(String nama, String isi) {
        this.nama = nama;
        this.isi = isi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getIsi() {
        return isi;
    }
}
