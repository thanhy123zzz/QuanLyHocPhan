package com.example.quanlyhocphan.Dao.DaoImp;

import com.example.quanlyhocphan.Dao.QuanLyDao;
import com.example.quanlyhocphan.Entities.Mapper.QuanLyMapper;
import com.example.quanlyhocphan.Entities.QuanLy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class QuanLyDaoImp implements QuanLyDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public QuanLy getQLbyAccount(String taiKhoan) {
        String sql = "select*from quanly where taikhoan ='"+taiKhoan+"'";

        return jdbcTemplate.query(sql,new QuanLyMapper()).get(0);
    }
}
