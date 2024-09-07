package edu.mum.cs.cs525.labs.skeleton.factory.abstractfactory;

import edu.mum.cs.cs525.labs.skeleton.AccountDAO;
import edu.mum.cs.cs525.labs.skeleton.AccountService;
import edu.mum.cs.cs525.labs.skeleton.AccountServiceImpl;
import edu.mum.cs.cs525.labs.skeleton.factory.factorymethod.AccountDAOFactory;
import edu.mum.cs.cs525.labs.skeleton.strategy.SavingInterestStrategy;

public class SavingAccountFactory implements AccountFactory {
    private AccountDAOFactory accountDAOFactory;

    public SavingAccountFactory(AccountDAOFactory accountDAOFactory) {
        this.accountDAOFactory = accountDAOFactory;
    }

    @Override
    public AccountService getAccountService() {
        AccountService accountService = new AccountServiceImpl();
        accountService.setInterestStrategy(new SavingInterestStrategy());
        return accountService;
    }

    @Override
    public AccountDAO createAccountDAO() {
        return accountDAOFactory.createAccountDAO();
    }
}
