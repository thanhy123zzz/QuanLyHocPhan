package com.example.quanlyhocphan.Entities.Mapper;

import com.example.quanlyhocphan.Entities.Khoa;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class KhoaMapper implements RowMapper<Khoa> {
    @Override
    public Khoa mapRow(ResultSet rs, int rowNum) throws SQLException {
        Khoa k = new Khoa();
        k.setMaKhoa(rs.getString("MaKhoa"));
        k.setTenKhoa(rs.getString("TenKhoa"));
        return k;
    }
}
