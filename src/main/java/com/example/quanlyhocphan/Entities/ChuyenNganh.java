package com.example.quanlyhocphan.Entities;

public class ChuyenNganh {
    private String maChuyenNganh;
    private String tenChuyenNganh;
    private Khoa khoa;

    public ChuyenNganh(String maChuyenNganh) {
        this.maChuyenNganh = maChuyenNganh;
    }
    public ChuyenNganh() {
    }
    public String getMaChuyenNganh() {
        return maChuyenNganh;
    }

    public void setMaChuyenNganh(String maChuyenNganh) {
        this.maChuyenNganh = maChuyenNganh;
    }

    public String getTenChuyenNganh() {
        return tenChuyenNganh;
    }

    public void setTenChuyenNganh(String tenChuyenNganh) {
        this.tenChuyenNganh = tenChuyenNganh;
    }

    public Khoa getKhoa() {
        return khoa;
    }

    public void setKhoa(Khoa khoa) {
        this.khoa = khoa;
    }
}
