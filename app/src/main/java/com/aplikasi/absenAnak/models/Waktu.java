package com.aplikasi.absenAnak.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Waktu implements Parcelable {

    private String nama;
    private String hari;
    private String keterangan;

    public Waktu() {
    }

    public Waktu(String nama, String hari, String keterangan) {
        this.nama = nama;
        this.hari = hari;
        this.keterangan = keterangan;
    }

    public String getName() {
        return nama;
    }

    public void setName(String name) {
        this.nama = nama;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getStatus() {
        return keterangan;
    }

    public void setStatus(String status) { this.keterangan = keterangan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.hari);
        dest.writeString(this.keterangan);
    }

    protected Waktu(Parcel in) {
        this.nama = in.readString();
        this.hari = in.readString();
        this.keterangan = in.readString();
    }

    public static final Creator<Waktu> CREATOR = new Creator<Waktu>() {
        @Override
        public Waktu createFromParcel(Parcel source) {
            return new Waktu(source);
        }

        @Override
        public Waktu[] newArray(int size) {
            return new Waktu[size];
        }
    };

    @Override
    public String toString() {
        return "GoalScorer{" +
                "nama='" + nama + '\'' +
                ", hari=" + hari + + '\'' +
                ", keterangan=" + keterangan +
                '}';
    }
}
