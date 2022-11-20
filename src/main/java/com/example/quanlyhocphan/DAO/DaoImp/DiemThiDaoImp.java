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
    public Double getDiemThi(String mssv, int maLop) {
        String sql = "select*from diemthi where MaSV = '"+mssv+"' && MaLop ="+maLop;
        List<DiemThi> diems = jdbcTemplate.query(sql,new DiemThiMapper());
        if(diems.size() > 0)
        return diems.get(0).getDiem();
        else return 0.0;
    }

    public int getLanHoc(String masv, int mahp){
        String sql = "select count(*) from diemthi where masv = '"+masv+"' and MaHP = "+mahp;
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    @Override
    public List<DiemThi> getListDiemThi(int maLop) {
        String sql = "select*from diemthi where MaLop =" +maLop;
        return jdbcTemplate.query(sql,new DiemThiMapper());
    }

    @Override
    public String insertDiemThi(DiemThi diemThi) {
        String sql = "insert into diemthi(`MaSV`,`DotHoc`,`LanHoc`,`Diem`,`MaHP`,`MaLop`) values(?,?,?,?,?,?)";
        int lh = getLanHoc(diemThi.getSinhVien().getMaSV(),diemThi.getHocPhan().getMaHocPhan());
        int kq = jdbcTemplate.update(sql,new Object[]{diemThi.getSinhVien().getMaSV(),diemThi.getNamHocHocKy().getDotHoc(),lh,diemThi.getDiem(),diemThi.getHocPhan().getMaHocPhan(),diemThi.getLopHocPhan().getMaLop()});
        if(kq>0) return "Thành công";
        return "Thất bại";
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

    @Override
    public List<DiemThi> getDiemThiByMaSV(String masv){
        String sql = "select * from sinhvien sv join diemthi dt on sv.MaSV = dt.MaSV where sv.MaSV = '"+masv+"'";
        return jdbcTemplate.query(sql, new DiemThiMapper());
    }

}
