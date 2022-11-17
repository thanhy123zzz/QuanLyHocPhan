package com.example.quanlyhocphan.Entities.Mapper;

import com.example.quanlyhocphan.Entities.CaHoc;
import com.example.quanlyhocphan.Entities.LichHoc;
import com.example.quanlyhocphan.Entities.NamHocHocKy;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LichHocMapper implements RowMapper<LichHoc> {
    @Override
    public LichHoc mapRow(ResultSet rs, int rowNum) throws SQLException {
        LichHoc lichHoc = new LichHoc();
        lichHoc.setNamHocHocKy(new NamHocHocKy(rs.getDate("DotHoc")));
        lichHoc.setCaHoc(new CaHoc(rs.getString("MaCaHoc")));
        lichHoc.setMaLichHoc(rs.getString("MaLichHoc"));
        lichHoc.setNgayBatDau(rs.getDate("NgayBatDau"));
        lichHoc.setNgayKetThuc(rs.getDate("NgayKetThuc"));
        return lichHoc;
    }
}
