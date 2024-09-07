package edu.mum.cs.cs525.labs.skeleton.factory;

import edu.mum.cs.cs525.labs.skeleton.Account;
import edu.mum.cs.cs525.labs.skeleton.AccountDAO;
import edu.mum.cs.cs525.labs.skeleton.Customer;

import java.util.Collection;
import java.util.List;

public class MockAccountDAOImpl implements AccountDAO {

    public static final String MOCK_ACCOUNT_NUMBER = "123456";

    @Override
    public void saveAccount(Account account) {
        System.out.println("Mock saving account");
    }

    @Override
    public void updateAccount(Account account) {
        System.out.println("Mock updating account");
    }

    @Override
    public Account loadAccount(String accountNumber) {
        return createMockAccount();
    }

    @Override
    public Collection<Account> getAccounts() {
        Account mockAccount = createMockAccount();
        return List.of(mockAccount);
    }

    private Account createMockAccount() {
        Account mockAccount = new Account(MOCK_ACCOUNT_NUMBER);
        Customer mockCustomer = new Customer("Mock customer");
        mockAccount.deposit(300);
        mockAccount.withdraw(100);
        mockAccount.addInterest(20);
        mockAccount.setCustomer(mockCustomer);
        return mockAccount;
    }
}
