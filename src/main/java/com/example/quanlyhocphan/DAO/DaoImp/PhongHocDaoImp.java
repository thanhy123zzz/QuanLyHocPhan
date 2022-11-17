package com.example.quanlyhocphan.Dao.DaoImp;

import com.example.quanlyhocphan.Dao.PhongHocDao;
import com.example.quanlyhocphan.Entities.Mapper.PhongHocMapper;
import com.example.quanlyhocphan.Entities.PhongHoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PhongHocDaoImp implements PhongHocDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public PhongHoc getPhongHoc(String maPhong) {
        String sql = "select*from PhongHoc where MaPhong ='"+maPhong+"'";
        return jdbcTemplate.query(sql,new PhongHocMapper()).get(0);
    }
}
