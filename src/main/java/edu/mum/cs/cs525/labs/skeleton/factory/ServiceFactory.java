package edu.mum.cs.cs525.labs.skeleton.factory;


import edu.mum.cs.cs525.labs.skeleton.AccountService;
import edu.mum.cs.cs525.labs.skeleton.AccountServiceImpl;

import java.security.Provider;

public abstract class ServiceFactory {

    public AccountService getAccountService(){
        return new AccountServiceImpl(createDAOFactory().createAccountDAO());
    }

    public abstract DAOFactory createDAOFactory();
}
