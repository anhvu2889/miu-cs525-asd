package edu.mum.cs.cs525.labs.skeleton;

import java.util.ArrayList;
import java.util.Collection;

public class AccountDAOImpl implements AccountDAO {

    private static AccountDAOImpl uniqueInstance;

    private AccountDAOImpl() {

    }

    public static AccountDAOImpl getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new AccountDAOImpl();
        }
        return uniqueInstance;
    }

    Collection<Account> accounts = new ArrayList<Account>();

    public void saveAccount(Account account) {
        accounts.add(account); // add the new
    }

    public void updateAccount(Account account) {
        Account accountexist = loadAccount(account.getAccountNumber());
        if (accountexist != null) {
            accounts.remove(accountexist); // remove the old
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
