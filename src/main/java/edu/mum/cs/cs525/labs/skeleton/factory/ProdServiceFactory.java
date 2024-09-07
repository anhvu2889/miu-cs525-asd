package edu.mum.cs.cs525.labs.skeleton.factory;

public class ProdServiceFactory extends ServiceFactory {
    @Override
    public DAOFactory createDAOFactory() {
        return new InMemoryDAOFactory();
    }
}
