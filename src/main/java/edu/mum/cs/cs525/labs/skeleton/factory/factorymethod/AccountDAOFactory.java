package edu.mum.cs.cs525.labs.skeleton.factory.factorymethod;

import edu.mum.cs.cs525.labs.skeleton.AccountDAO;

public abstract class AccountDAOFactory {
    public abstract AccountDAO createAccountDAO();
}
