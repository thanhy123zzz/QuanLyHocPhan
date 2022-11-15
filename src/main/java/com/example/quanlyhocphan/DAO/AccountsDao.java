package com.example.quanlyhocphan.DAO;

import java.util.List;

import com.example.quanlyhocphan.Model.Accounts;

public interface AccountsDao {
    Accounts checkAccount(String username);
    int insertAccount(Accounts accounts);
    List<Accounts> showList();
}
