package com.example.quanlyhocphan.Service;

import java.util.List;

import com.example.quanlyhocphan.Model.Accounts;

public interface ManagerService {
    int insertAccount(Accounts accounts);
    boolean checkAccount(String userName);
    List<Accounts> showList();
}
