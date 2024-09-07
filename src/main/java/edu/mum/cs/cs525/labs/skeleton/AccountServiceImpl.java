package edu.mum.cs.cs525.labs.skeleton;

import edu.mum.cs.cs525.labs.skeleton.observer.AccountEventManager;
import edu.mum.cs.cs525.labs.skeleton.observer.AccountEventType;
import edu.mum.cs.cs525.labs.skeleton.strategy.InterestStrategy;

import java.util.Collection;

public class AccountServiceImpl implements AccountService {
    private final AccountDAO accountDAO;

    private AccountEventManager accountEventManager;

    @Override
    public void setInterestStrategy(InterestStrategy interestStrategy) {
        this.interestStrategy = interestStrategy;
    }

    private InterestStrategy interestStrategy;

    public AccountServiceImpl() {
        accountDAO = AccountDAOImpl.getInstance();
    }

    public AccountServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public void setAccountEventManager(AccountEventManager accountEventManager) {
        this.accountEventManager = accountEventManager;
    }

    public Account createAccount(String accountNumber, String customerName) {
        Account account = new Account(accountNumber);
        Customer customer = new Customer(customerName);
        account.setCustomer(customer);
        accountDAO.saveAccount(account);
        accountEventManager.triggerEvent(AccountEventType.ACCOUNT_OPENED);
        return account;
    }

    public void deposit(String accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.deposit(amount);
        accountDAO.updateAccount(account);
        accountEventManager.triggerEvent(AccountEventType.BALANCE_CHANGED);

    }

    public Account getAccount(String accountNumber) {
        Account account = accountDAO.loadAccount(accountNumber);
        return account;
    }

    public Collection<Account> getAllAccounts() {
        return accountDAO.getAccounts();
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.withdraw(amount);
        accountDAO.updateAccount(account);
        accountEventManager.triggerEvent(AccountEventType.BALANCE_CHANGED);
    }


    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
        Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
        Account toAccount = accountDAO.loadAccount(toAccountNumber);
        fromAccount.transferFunds(toAccount, amount, description);
        accountDAO.updateAccount(fromAccount);
        accountDAO.updateAccount(toAccount);
        accountEventManager.triggerEvent(AccountEventType.BALANCE_CHANGED);
    }

    @Override
    public void addInterest(String accountNumber) {
        Account account = accountDAO.loadAccount(accountNumber);
        double interest = interestStrategy.calculateInterest(account.getBalance());
        account.addInterest(interest);
        accountDAO.updateAccount(account);
        accountEventManager.triggerEvent(AccountEventType.BALANCE_CHANGED);

    }
}
