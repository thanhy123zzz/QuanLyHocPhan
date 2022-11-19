package com.example.quanlyhocphan.Entities.Mapper;

import com.example.quanlyhocphan.Entities.Accounts;
import com.example.quanlyhocphan.Entities.ChuyenNganh;
import com.example.quanlyhocphan.Entities.QuanLy;
import com.example.quanlyhocphan.Entities.SinhVien;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuanLyMapper implements RowMapper<QuanLy> {
    @Override
    public QuanLy mapRow(ResultSet rs, int rowNum) throws SQLException {
        QuanLy sv = new QuanLy();
        sv.setMaQL(rs.getString("MaQL"));
        sv.setCCCD(rs.getString("CCCD"));
        sv.setDiaChi(rs.getString("DiaChi"));
        sv.setHo(rs.getString("Ho"));
        sv.setTen(rs.getString("Ten"));
        sv.setEmailPrivate(rs.getString("EmailPrivate"));
        sv.setEmailEdu(rs.getString("EmailEdu"));
        sv.setGioiTinh(rs.getInt("GioiTinh"));
        sv.setPhone(rs.getString("Phone"));
        sv.setAccounts(new Accounts(rs.getString("TaiKhoan")));
        return sv;
    }
}
