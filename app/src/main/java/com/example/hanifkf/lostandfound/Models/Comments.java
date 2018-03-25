package com.example.hanifkf.lostandfound.Models;

/**
 * Created by M Taufiq R on 19/03/2018.
 */

public class Comments {

    private int picture;
    private String nama,isi,waktu;

    public Comments(int picture, String nama, String isi, String waktu) {
        this.picture = picture;
        this.nama = nama;
        this.isi = isi;
        this.waktu = waktu;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
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

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }
}
