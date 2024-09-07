package edu.mum.cs.cs525.labs.skeleton.factory.abstractfactory;

import edu.mum.cs.cs525.labs.skeleton.AccountDAO;
import edu.mum.cs.cs525.labs.skeleton.AccountService;
import edu.mum.cs.cs525.labs.skeleton.AccountServiceImpl;
import edu.mum.cs.cs525.labs.skeleton.factory.factorymethod.AccountDAOFactory;
import edu.mum.cs.cs525.labs.skeleton.strategy.CheckingInterestStrategy;

public class CheckingAccountFactory implements AccountFactory {

    private AccountDAOFactory accountDAOFactory;

    public CheckingAccountFactory(AccountDAOFactory accountDAOFactory) {
        this.accountDAOFactory = accountDAOFactory;
    }

    @Override
    public AccountService getAccountService() {
        AccountService accountService = new AccountServiceImpl();
        accountService.setInterestStrategy(new CheckingInterestStrategy());
        return accountService;
    }

    @Override
    public AccountDAO createAccountDAO() {
        return accountDAOFactory.createAccountDAO();
    }
}
