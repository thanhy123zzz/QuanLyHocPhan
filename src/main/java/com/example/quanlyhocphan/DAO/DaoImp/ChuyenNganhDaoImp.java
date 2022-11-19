package com.example.quanlyhocphan.Dao.DaoImp;

import com.example.quanlyhocphan.Dao.ChuyenNganhDao;
import com.example.quanlyhocphan.Entities.ChuyenNganh;
import com.example.quanlyhocphan.Entities.Mapper.ChuyenNganhMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChuyenNganhDaoImp implements ChuyenNganhDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public ChuyenNganh getChuyenNganh(String MaCn) {
        String sql = "select*from chuyennganh where machuyennganh ='"+MaCn+"'";
        return jdbcTemplate.query(sql,new ChuyenNganhMapper()).get(0);
    }

    @Override
    public List<ChuyenNganh> getListChuyenNganh() {
        String sql = "select*from chuyenNganh";
        return jdbcTemplate.query(sql,new ChuyenNganhMapper());
    }

    @Override
    public List<ChuyenNganh> getListByMaSV(String masv){
        String sql = "Select cn.machuyennganh,cn.tenchuyennganh,cn.makhoa from chuyennganh cn join sinhvien sv on sv.machuyennganh = cn.machuyennganh where sv.masv ='"+masv+"';";
        return jdbcTemplate.query(sql, new ChuyenNganhMapper());
    }
}
