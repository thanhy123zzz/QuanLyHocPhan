package com.example.quanlyhocphan.Dao.DaoImp;

import com.example.quanlyhocphan.Dao.DangKyLopHocPhanDao;
import com.example.quanlyhocphan.Entities.DangKyLopHocPhan;
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
    public int getSLSinhVien(int malop) {
        String sql = "select count(Malop) as 'SL' from dangkylophocphan where malop = " + malop;
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
