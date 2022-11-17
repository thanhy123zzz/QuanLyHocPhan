package com.example.quanlyhocphan.Entities.Mapper;

import com.example.quanlyhocphan.Entities.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SinhVienMapper implements RowMapper<SinhVien> {

    @Override
    public SinhVien mapRow(ResultSet rs, int rowNum) throws SQLException {
        SinhVien sv = new SinhVien();
        sv.setMaSV(rs.getString("MaSV"));
        sv.setCCCD(rs.getString("CCCD"));
        sv.setDiaChi(rs.getString("DiaChi"));
        sv.setHo(rs.getString("Ho"));
        sv.setTen(rs.getString("Ten"));
        sv.setEmailPrivate(rs.getString("EmailPrivate"));
        sv.setEmailEdu(rs.getString("EmailEdu"));
        sv.setGioiTinh(rs.getInt("GioiTinh"));
        sv.setPhone(rs.getString("Phone"));
        sv.setAccounts(new Accounts(rs.getString("TaiKhoan")));
        sv.setChuyenNganh(new ChuyenNganh(rs.getString("MaChuyenNganh")));
        return sv;
    }
}
