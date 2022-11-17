package com.example.quanlyhocphan.Dao.DaoImp;

import com.example.quanlyhocphan.Dao.DangKyLopHocPhanDao;
import com.example.quanlyhocphan.Entities.DangKyLopHocPhan;
import com.example.quanlyhocphan.Entities.Mapper.DangKyLopHocPhanMapper;
import com.example.quanlyhocphan.Entities.Mapper.SinhVienMapper;
import com.example.quanlyhocphan.Entities.SinhVien;
import org.apache.commons.math3.analysis.function.Sinh;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
}
