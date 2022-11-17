package com.example.quanlyhocphan.Entities;

public class CaHoc {
    private String maCaHoc;
    private String caHoc;
    private String gioBatDau;
    private String gioKetThu;

    public CaHoc(String maCaHoc) {
        this.maCaHoc = maCaHoc;
    }

    public CaHoc() {
    }

    public String getMaCaHoc() {
        return maCaHoc;
    }

    public void setMaCaHoc(String maCaHoc) {
        this.maCaHoc = maCaHoc;
    }

    public String getCaHoc() {
        return caHoc;
    }

    public void setCaHoc(String caHoc) {
        this.caHoc = caHoc;
    }

    public String getGioBatDau() {
        return gioBatDau;
    }

    public void setGioBatDau(String gioBatDau) {
        this.gioBatDau = gioBatDau;
    }

    public String getGioKetThu() {
        return gioKetThu;
    }

    public void setGioKetThu(String gioKetThu) {
        this.gioKetThu = gioKetThu;
    }
}
