package com.example.quanlyhocphan.Entities;

import java.io.Serializable;

public class Accounts implements Serializable {
    private String TaiKhoan;
    private String MatKhau;
    private String MaRole;
    private Role role;


    public Accounts(String TaiKhoan, String MatKhau, String MaRole, Role role) {
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
        this.MaRole = MaRole;
        this.role = role;
    }
    

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        TaiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String matKhau) {
        MatKhau = matKhau;
    }

    public String getMaRole() {
        return MaRole;
    }

    public void setMaRole(String MaRole) {
        this.MaRole = MaRole;
    }

    public Accounts(String taiKhoan, String matKhau) {
        TaiKhoan = taiKhoan;
        MatKhau = matKhau;
    }

    public Accounts(String taiKhoan) {
        TaiKhoan = taiKhoan;
    }

    public Accounts() {
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
