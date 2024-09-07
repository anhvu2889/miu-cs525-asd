package edu.mum.cs.cs525.labs.skeleton.factory;

import edu.mum.cs.cs525.labs.skeleton.AccountDAO;

public interface DAOFactory {
    AccountDAO createAccountDAO();
}
