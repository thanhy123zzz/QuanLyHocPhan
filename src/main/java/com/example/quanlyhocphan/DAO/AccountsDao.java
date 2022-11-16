package com.example.quanlyhocphan.Dao;

import java.util.List;

import com.example.quanlyhocphan.Entities.Accounts;

public interface AccountsDao {
    Accounts checkAccount(String username);
    int insertAccount(Accounts accounts);
    List<Accounts> showList();
    List<Accounts> getListByEmailEdu(String email);
    int updatePassWord(String matkhau, String taikhoan);
}
