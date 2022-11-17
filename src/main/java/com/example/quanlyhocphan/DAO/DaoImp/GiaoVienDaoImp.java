package com.example.quanlyhocphan.Dao.DaoImp;

import com.example.quanlyhocphan.Dao.GiaoVienDao;
import com.example.quanlyhocphan.Entities.GiaoVien;
import com.example.quanlyhocphan.Entities.Mapper.GiaoVienMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GiaoVienDaoImp implements GiaoVienDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public GiaoVien getGiaoVien(String maGV) {
        String sql = "select*from GiaoVien where MaGV ='"+maGV+"'";
        return jdbcTemplate.query(sql,new GiaoVienMapper()).get(0);
    }
}
