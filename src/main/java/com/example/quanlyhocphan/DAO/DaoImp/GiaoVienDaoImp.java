package com.example.quanlyhocphan.Dao.DaoImp;

import com.example.quanlyhocphan.Dao.GiaoVienDao;
import com.example.quanlyhocphan.Entities.GiaoVien;
import com.example.quanlyhocphan.Entities.Mapper.GiaoVienMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GiaoVienDaoImp implements GiaoVienDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public GiaoVien getGiaoVien(String maGV) {
        String sql = "select*from GiaoVien where MaGV ='"+maGV+"'";
        return jdbcTemplate.query(sql,new GiaoVienMapper()).get(0);
    }

    @Override
    public List<GiaoVien> getListGiaoVien() {
        return jdbcTemplate.query("select*from giaovien",new GiaoVienMapper());
    }
}
