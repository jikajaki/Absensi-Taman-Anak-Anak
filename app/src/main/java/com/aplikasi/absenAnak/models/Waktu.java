package com.aplikasi.absenAnak.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Waktu implements Parcelable {

    private String name;
    private String hari;
    private String status;

    public Waktu() {
    }

    public Waktu(String name, String hari, String status) {
        this.name = name;
        this.hari = hari;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.hari);
        dest.writeString(this.status);
    }

    protected Waktu(Parcel in) {
        this.name = in.readString();
        this.hari = in.readString();
        this.status = in.readString();
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
                "name='" + name + '\'' +
                ", hari=" + hari + + '\'' +
                ", status=" + status +
                '}';
    }
}
