package com.example.quanlyhocphan.Dao.DaoImp;

import com.example.quanlyhocphan.Entities.LopHocPhan;
import com.example.quanlyhocphan.Entities.Mapper.LopHocPhanMapper;
import com.example.quanlyhocphan.Dao.LopHocPhanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LopHocPhanDaoImp implements LopHocPhanDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<LopHocPhan> getListLopHocPhan(String dotHoc) {
        String sql;
        if(dotHoc==null){
            sql = "SELECT * FROM quanlyhocphan.lophocphan where DotHoc = (select max(DotHoc) from namhochocky);";
        }
        else {
            sql = "SELECT * FROM quanlyhocphan.lophocphan where DotHoc = '" + dotHoc + "'";
        }
        return jdbcTemplate.query(sql,new LopHocPhanMapper());
    }

    @Override
    public LopHocPhan getLopHocPhan(int MaLop) {
        String sql = "select*from lophocphan where malop = "+ MaLop;
        return jdbcTemplate.query(sql,new LopHocPhanMapper()).get(0);
    }

}
