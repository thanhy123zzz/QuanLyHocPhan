package com.example.quanlyhocphan.Dao.DaoImp;

import com.example.quanlyhocphan.Dao.DangKyLopHocPhanDao;
import com.example.quanlyhocphan.Entities.DangKyLopHocPhan;
import com.example.quanlyhocphan.Entities.LopHocPhan;
import com.example.quanlyhocphan.Entities.Mapper.DangKyLopHocPhanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DangkyLopHocPhanDaoImp implements DangKyLopHocPhanDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<DangKyLopHocPhan> getListSVformLopHocPhan(int MaLop) {
        String sql = "select*from dangkylophocphan where MaLop ="+MaLop;
        return jdbcTemplate.query(sql,new DangKyLopHocPhanMapper());
    }

    @Override
    public int insert(DangKyLopHocPhan dangKyLopHocPhan){
        String sql = "INSERT INTO `quanlyhocphan`.`dangkylophocphan`(`MaSV`,`DotHoc`,`NgayDK`,`MaLop`) VALUES (?,?,?,?);";
        return jdbcTemplate.update(sql, dangKyLopHocPhan.getSinhVien().getMaSV(),dangKyLopHocPhan.getNamHocHocKy().getDotHoc(),
        dangKyLopHocPhan.getNgayDangKy(),dangKyLopHocPhan.getLopHocPhan().getMaLop());
    }

    @Override
    public Boolean checkSVDKHP(String masv, String malop){
        String sql = "SELECT * FROM quanlyhocphan.dangkylophocphan where MaSV = '"+masv+"' and MaLop = "+Integer.parseInt(malop)+";";
        List<DangKyLopHocPhan> list = jdbcTemplate.query(sql, new DangKyLopHocPhanMapper());
        if(list.size() == 0){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public int getSLSinhVien(int malop) {
        String sql = "select count(Malop) as 'SL' from dangkylophocphan where malop = " + malop;
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public List<DangKyLopHocPhan> getSVDKHP(String masv, String malop){
        String sql = "SELECT * FROM quanlyhocphan.dangkylophocphan where MaSV = '"+masv+"' and MaLop = "+malop+";";
        List<DangKyLopHocPhan> list = jdbcTemplate.query(sql, new DangKyLopHocPhanMapper());
        return list;
    }

    @Override
    public int deleteDangKy(String masv,String malop){
        String sql = "Delete from quanlyhocphan.dangkylophocphan where masv = '"+masv+"' and malop = "+malop+";";
        return jdbcTemplate.update(sql);
    }
}
