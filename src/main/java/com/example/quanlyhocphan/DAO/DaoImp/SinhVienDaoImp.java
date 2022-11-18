package com.example.quanlyhocphan.Dao.DaoImp;

import com.example.quanlyhocphan.Dao.SinhVienDao;
import com.example.quanlyhocphan.Entities.Mapper.SinhVienMapper;
import com.example.quanlyhocphan.Entities.SinhVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SinhVienDaoImp implements SinhVienDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public SinhVien getSV(String MaSV) {
        String sql = "select*from SinhVien where MaSV = '" + MaSV + "'";
        return jdbcTemplate.query(sql, new SinhVienMapper()).get(0);
    }

    @Override
    public SinhVien getByAccount(String acc){
        String sql = "Select sv.MaSV,sv.Ten,sv.Ho,sv.EmailPrivate,sv.CCCD,sv.Phone,sv.EmailEdu,sv.GioiTinh,sv.DiaChi,sv.TaiKhoan,sv.MaChuyenNganh"+
        "from sinhvien sv join accounts ac on ac.Taikhoan = sv.taikhoan where ac.taikhoan = "+acc+";";
        return jdbcTemplate.query(sql, new SinhVienMapper()).get(0);
    }
}
