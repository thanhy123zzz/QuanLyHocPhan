package com.example.quanlyhocphan.Dao.DaoImp;

import com.example.quanlyhocphan.Dao.HocPhanDao;
import com.example.quanlyhocphan.Entities.HocPhan;
import com.example.quanlyhocphan.Entities.Mapper.HocPhanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class HocPhanDaoImp implements HocPhanDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<HocPhan> getListHocPhan(String MaKhoa) {
        String sql;
        if(MaKhoa==null){
            sql = "select * from HocPhan";
        }
        else{
            sql = "select*from HocPhan where MaKhoa='"+MaKhoa+"'";
        }

        return jdbcTemplate.query(sql,new HocPhanMapper());
    }

    @Override
    public String insertHocPhan(HocPhan hp) {
        String sql = "insert into HocPhan (`TenHocPhan`, `SoTinChi`, `MaKhoa`) values(?,?,?)";
        int kq = jdbcTemplate.update(sql,new Object[]{hp.getTenHocPhan(),hp.getSoTinChi(),hp.getKhoa().getMaKhoa()});
        if(kq!=0)
        return "Thêm thành công";
        else{
            return "Thêm thất bại";
        }
    }

    @Override
    public HocPhan getHocPhan(int MaHP) {
        String sql = "select*from HocPhan where MaHP ="+MaHP;

        return jdbcTemplate.query(sql,new HocPhanMapper()).get(0);
    }

    @Override
    public String updateHocPhan(HocPhan HP) {
        String sql = "update HocPhan set TenHocPhan = ? , SoTinChi = ?, MaKhoa = ? where MaHP = ?";
        int kq = jdbcTemplate.update(sql,new Object[]{HP.getTenHocPhan(),HP.getSoTinChi(),HP.getKhoa().getMaKhoa(),HP.getMaHocPhan()});
        if(kq!=0)
        return "Thay đổi thành công!";
        else
            return "THay đổi thất bại";
    }

    @Override
    public List<HocPhan> getListByMaSV(String masv){
        String sql = "select hp.`MaHP`,hp.`TenHocPhan`,hp.`SoTinChi`,hp.`MaKhoa` from hocphan hp join hocphanctdt hpcd on hp.mahp = hpcd.mahp join"+
        "chuongtrinhdaotao dt on dt.mactdt = hpcd.mactdt join chuyennganh cn on cn.machuyennganh = dt.machuyennganh join sinhvien sv on cn.machuyennganh = sv.machuyennganh"+
        "where sv.masv = '"+masv+"';";
        return jdbcTemplate.query(sql, new HocPhanMapper());
    }
}
