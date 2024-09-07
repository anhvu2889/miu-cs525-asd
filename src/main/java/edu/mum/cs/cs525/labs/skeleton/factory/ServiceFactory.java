package edu.mum.cs.cs525.labs.skeleton.factory;


import edu.mum.cs.cs525.labs.skeleton.AccountService;
import edu.mum.cs.cs525.labs.skeleton.AccountServiceImpl;

public abstract class ServiceFactory {

    public final AccountService getAccountService() {
        return new AccountServiceImpl(createDAOFactory().createAccountDAO());
    }

    public abstract DAOFactory createDAOFactory();
}
