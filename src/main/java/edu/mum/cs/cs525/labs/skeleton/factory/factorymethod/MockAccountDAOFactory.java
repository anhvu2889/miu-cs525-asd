package edu.mum.cs.cs525.labs.skeleton.factory.factorymethod;

import edu.mum.cs.cs525.labs.skeleton.AccountDAO;
import edu.mum.cs.cs525.labs.skeleton.factory.MockAccountDAOImpl;

public class MockAccountDAOFactory extends AccountDAOFactory {
    @Override
    public AccountDAO createAccountDAO() {
        return new MockAccountDAOImpl();
    }
}
