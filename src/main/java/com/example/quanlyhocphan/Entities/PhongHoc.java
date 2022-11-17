package com.example.quanlyhocphan.Entities;

public class PhongHoc {
    private String maPhong;
    private String tenPhong;
    private int soGhe;

    public PhongHoc(String maPhong) {
        this.maPhong = maPhong;
    }
    public PhongHoc() {
    }
    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public int getSoGhe() {
        return soGhe;
    }

    public void setSoGhe(int soGhe) {
        this.soGhe = soGhe;
    }
}
