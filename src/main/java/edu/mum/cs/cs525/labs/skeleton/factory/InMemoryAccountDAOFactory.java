package edu.mum.cs.cs525.labs.skeleton.factory;

import edu.mum.cs.cs525.labs.skeleton.AccountDAO;
import edu.mum.cs.cs525.labs.skeleton.AccountDAOImpl;

public class InMemoryAccountDAOFactory extends AccountDAOFactory {
    @Override
    public AccountDAO createAccountDAO() {
        return new AccountDAOImpl();
    }
}
