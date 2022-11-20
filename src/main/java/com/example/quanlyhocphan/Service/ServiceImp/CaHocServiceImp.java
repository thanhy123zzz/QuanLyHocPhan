package com.example.quanlyhocphan.Service.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quanlyhocphan.Dao.CaHocDao;
import com.example.quanlyhocphan.Entities.CaHoc;
import com.example.quanlyhocphan.Service.CaHocService;

@Service
public class CaHocServiceImp implements CaHocService{
    @Autowired
    CaHocDao cahocdao;

    @Override
    public CaHoc getCaHocByMaLopMaHP(int malop,int mahocphan){
        return cahocdao.getCaHocByMaLopMaHP(malop, mahocphan);
    }
}
