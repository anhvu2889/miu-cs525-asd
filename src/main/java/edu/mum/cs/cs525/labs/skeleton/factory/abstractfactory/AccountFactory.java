package edu.mum.cs.cs525.labs.skeleton.factory.abstractfactory;

import edu.mum.cs.cs525.labs.skeleton.AccountDAO;
import edu.mum.cs.cs525.labs.skeleton.AccountService;

public interface AccountFactory {
    AccountService getAccountService();

    AccountDAO createAccountDAO();
}
