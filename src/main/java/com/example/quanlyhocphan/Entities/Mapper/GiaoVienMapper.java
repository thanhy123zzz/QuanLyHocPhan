package com.example.quanlyhocphan.Entities.Mapper;

import com.example.quanlyhocphan.Entities.GiaoVien;
import com.example.quanlyhocphan.Entities.Khoa;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GiaoVienMapper implements RowMapper<GiaoVien> {
    @Override
    public GiaoVien mapRow(ResultSet rs, int rowNum) throws SQLException {
        GiaoVien giaoVien = new GiaoVien();
        giaoVien.setMaGV(rs.getString("MaGV"));
        giaoVien.setCCCD(rs.getString("CCCD"));
        giaoVien.setKhoa(new Khoa(rs.getString("MaKhoa")));
        giaoVien.setDiaChi(rs.getString("DiaChi"));
        giaoVien.setHo(rs.getString("Ho"));
        giaoVien.setTen(rs.getString("Ten"));
        giaoVien.setEmailPrivate(rs.getString("EmailPrivate"));
        giaoVien.setEmailEdu(rs.getString("EmailEdu"));
        giaoVien.setGioiTinh(rs.getInt("GioiTinh"));
        giaoVien.setPhone(rs.getString("Phone"));
        return giaoVien;
    }
}
