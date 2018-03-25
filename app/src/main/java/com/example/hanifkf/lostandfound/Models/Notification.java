package com.example.hanifkf.lostandfound.Models;

/**
 * Created by hanifkf on 25/02/2018.
 */

public class Notification {

    private int picture;
    private String nama,isi,waktu;

    public Notification(int picture, String nama, String isi, String waktu) {
        this.picture = picture;
        this.nama = nama;
        this.isi = isi;
        this.waktu = waktu;
    }

    public int getPicture() {
        return picture;
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

    public String getWaktu() {
        return waktu;
    }
}
