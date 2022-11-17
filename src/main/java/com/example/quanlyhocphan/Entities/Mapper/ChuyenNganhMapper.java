package com.example.quanlyhocphan.Entities.Mapper;

import com.example.quanlyhocphan.Entities.ChuyenNganh;
import com.example.quanlyhocphan.Entities.Khoa;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChuyenNganhMapper implements RowMapper<ChuyenNganh> {
    @Override
    public ChuyenNganh mapRow(ResultSet rs, int rowNum) throws SQLException {
        ChuyenNganh chuyenNganh = new ChuyenNganh();
        chuyenNganh.setTenChuyenNganh(rs.getString("TenChuyenNganh"));
        chuyenNganh.setKhoa(new Khoa(rs.getString("MaKhoa")));
        chuyenNganh.setMaChuyenNganh(rs.getString("MaChuyenNganh"));
        return chuyenNganh;
    }
}
