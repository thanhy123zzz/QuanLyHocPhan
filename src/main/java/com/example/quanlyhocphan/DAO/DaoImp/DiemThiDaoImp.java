package com.example.quanlyhocphan.Dao.DaoImp;

import com.example.quanlyhocphan.Dao.DiemThiDao;
import com.example.quanlyhocphan.Entities.DiemThi;
import com.example.quanlyhocphan.Entities.Mapper.DiemThiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DiemThiDaoImp implements DiemThiDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public DiemThi getDiemThi(String mssv, int maLop) {
        String sql = "select*from diemthi where MaSV = '"+mssv+"' && MaLop ="+maLop;
        return jdbcTemplate.query(sql,new DiemThiMapper()).get(0);
    }

    @Override
    public List<DiemThi> getListDiemThi(int maLop) {
        String sql = "select*from diemthi where MaLop =" +maLop;
        return jdbcTemplate.query(sql,new DiemThiMapper());
    }

    @Override
    public String insertDiemThi(DiemThi diemThi) {

        return null;
    }

    @Override
    public String updateDiemThi(DiemThi diemThi) {
        String sql ="update diemthi set diem = ? where MaSV = ? and MaLop =?;";
        int kq = jdbcTemplate.update(sql,new Object[]{diemThi.getDiem(),diemThi.getSinhVien().getMaSV(),diemThi.getLopHocPhan().getMaLop()});
        if(kq!=0)
        return "Thành công";
        else
            return "Thất bại";
    }

}
