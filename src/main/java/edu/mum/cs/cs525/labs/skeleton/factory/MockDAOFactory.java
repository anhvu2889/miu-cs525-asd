package edu.mum.cs.cs525.labs.skeleton.factory;

import edu.mum.cs.cs525.labs.skeleton.AccountDAO;

public class MockDAOFactory implements DAOFactory {
    @Override
    public AccountDAO createAccountDAO() {
        return new MockAccountDAOImpl();
    }
}
