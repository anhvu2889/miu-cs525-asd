package edu.mum.cs.cs525.labs.skeleton.proxy;

import java.lang.reflect.Proxy;

public class VirtualProxyComplexFactory implements ComplexFactory {
    @Override
    public Complex createComplex() {
        System.out.println("Creating proxy by using factory");
        return (Complex) Proxy.newProxyInstance(
                Complex.class.getClassLoader(),
                new Class[]{Complex.class},
                new ComplexClassInvocationHandler()
        );
    }
}
