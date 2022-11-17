package com.example.quanlyhocphan.Entities.Mapper;

import com.example.quanlyhocphan.Entities.DangKyLopHocPhan;
import com.example.quanlyhocphan.Entities.LopHocPhan;
import com.example.quanlyhocphan.Entities.NamHocHocKy;
import com.example.quanlyhocphan.Entities.SinhVien;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DangKyLopHocPhanMapper implements RowMapper<DangKyLopHocPhan> {
    @Override
    public DangKyLopHocPhan mapRow(ResultSet rs, int rowNum) throws SQLException {
        DangKyLopHocPhan dangKyLopHocPhan = new DangKyLopHocPhan();
        dangKyLopHocPhan.setNamHocHocKy(new NamHocHocKy(rs.getDate("DotHoc")));
        dangKyLopHocPhan.setLopHocPhan(new LopHocPhan(rs.getInt("MaLop")));
        dangKyLopHocPhan.setSinhVien(new SinhVien(rs.getString("MaSV")));
        dangKyLopHocPhan.setNgayDangKy(rs.getDate("NgayDK"));
        return dangKyLopHocPhan;
    }
}
