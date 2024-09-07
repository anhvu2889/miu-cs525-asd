package edu.mum.cs.cs525.labs.skeleton.factory;

import edu.mum.cs.cs525.labs.skeleton.AccountDAO;

public class MockAccountDAOFactory extends AccountDAOFactory {
    @Override
    public AccountDAO createAccountDAO() {
        return new MockAccountDAOImpl();
    }
}
