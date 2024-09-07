package edu.mum.cs.cs525.labs.skeleton.factory;

import edu.mum.cs.cs525.labs.skeleton.AccountDAO;
import edu.mum.cs.cs525.labs.skeleton.AccountDAOImpl;

public class InMemoryDAOFactory implements DAOFactory {
    @Override
    public AccountDAO createAccountDAO() {
        return new AccountDAOImpl();
    }
}
