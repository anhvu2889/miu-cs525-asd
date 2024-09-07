package edu.mum.cs.cs525.labs.skeleton.factory;

public class InMemoryServiceFactory extends ServiceFactory {
    @Override
    public DAOFactory createDAOFactory() {
        return new InMemoryDAOFactory();
    }
}
