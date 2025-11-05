package org.example.state.model.repository;

import org.example.state.model.entity.Account;

import java.util.concurrent.ConcurrentHashMap;

public class AccountRepository {
    // Tomcat -> Thread => 안정적으로 처리하는 map
    ConcurrentHashMap<String, Account> map = new ConcurrentHashMap<>();

    public void save(Account account) {
        map.put(account.userId(), account);
    }

    public Account findById(String id) {
        return map.get(id);
    }
}