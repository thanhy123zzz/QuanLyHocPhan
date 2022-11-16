package com.example.quanlyhocphan.Service;

import java.util.List;

import com.example.quanlyhocphan.Entities.Accounts;

public interface ManagerService {
    int insertAccount(Accounts accounts);
    boolean checkAccount(String userName);
    List<Accounts> showList();
    List<Accounts> getListByEmailEdu(String email);
    int updatePassWord(String matkhau, String taikhoan);
}
