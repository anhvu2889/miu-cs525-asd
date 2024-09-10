package edu.mum.cs.cs525.labs.skeleton;

import java.util.ArrayList;
import java.util.Collection;

public class AccountDAOImpl implements AccountDAO {

    private volatile static AccountDAOImpl uniqueInstance;

    private AccountDAOImpl() {

    }

    public static AccountDAOImpl getInstance() {
        if (uniqueInstance == null) {
            synchronized (AccountDAOImpl.class) {
                uniqueInstance = new AccountDAOImpl();
            }
        }
        return uniqueInstance;
    }

    Collection<Account> accounts = new ArrayList<Account>();

    public void saveAccount(Account account) {
        accounts.add(account); // add the new
    }

    public void updateAccount(Account account) {
        Account existAccount = loadAccount(account.getAccountNumber());
        if (existAccount != null) {
            accounts.remove(existAccount); // remove the old
            accounts.add(account); // add the new
        }

    }

    public Account loadAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public Collection<Account> getAccounts() {
        return accounts;
    }

}
