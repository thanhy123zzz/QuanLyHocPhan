package com.example.quanlyhocphan.Service.ServiceImp;

import com.example.quanlyhocphan.Dao.KhoaDao;
import com.example.quanlyhocphan.Entities.Khoa;
import com.example.quanlyhocphan.Service.KhoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhoaServiceImp implements KhoaService {
    @Autowired
    KhoaDao khoaDao;
    @Override
    public List<Khoa> getListKhoa() {
        return khoaDao.getListKhoa();
    }
}
