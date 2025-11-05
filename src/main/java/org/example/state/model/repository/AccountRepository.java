package org.example.state.model.repository;

import org.example.state.model.entity.Account;

import java.util.concurrent.ConcurrentHashMap;

// singleton
public class AccountRepository {
    static final private AccountRepository instance = new AccountRepository();
    public static AccountRepository getInstance() {
        return instance;
    }

    private AccountRepository() {}

    // Tomcat -> Thread => 안정적으로 처리하는 map
    private final ConcurrentHashMap<String, Account> map = new ConcurrentHashMap<>();

    public void save(Account account) {
        map.put(account.userId(), account);
    }

    public Account findById(String id) {
        return map.get(id);
    }
}