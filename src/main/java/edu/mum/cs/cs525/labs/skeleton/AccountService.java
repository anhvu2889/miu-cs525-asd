package edu.mum.cs.cs525.labs.skeleton;

import edu.mum.cs.cs525.labs.skeleton.observer.AccountEventManager;
import edu.mum.cs.cs525.labs.skeleton.strategy.InterestStrategy;

import java.util.Collection;

public interface AccountService {
    Account createAccount(String accountNumber, String customerName);

    Account getAccount(String accountNumber);

    Collection<Account> getAllAccounts();

    void deposit(String accountNumber, double amount);

    void withdraw(String accountNumber, double amount);

    void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);

    void addInterest(String accountNumber);

    void setAccountEventManager(AccountEventManager accountEventManager);

    void setInterestStrategy(InterestStrategy interestStrategy);

    void undo();

    void redo();
}
