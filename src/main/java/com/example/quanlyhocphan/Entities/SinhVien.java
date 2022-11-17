package com.example.quanlyhocphan.Entities;

public class SinhVien {
    private String maSV;
    private String ten;
    private String ho;
    private String emailPrivate;
    private String CCCD;
    private String Phone;
    private String emailEdu;
    private int GioiTinh;
    private String DiaChi;
    private Accounts accounts;

    private ChuyenNganh chuyenNganh;

    public ChuyenNganh getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(ChuyenNganh chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public SinhVien(String maSV) {
        this.maSV = maSV;
    }
    public SinhVien() {
    }
    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getEmailPrivate() {
        return emailPrivate;
    }

    public void setEmailPrivate(String emailPrivate) {
        this.emailPrivate = emailPrivate;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmailEdu() {
        return emailEdu;
    }

    public void setEmailEdu(String emailEdu) {
        this.emailEdu = emailEdu;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public Accounts getAccounts() {
        return accounts;
    }

    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }
}
