package edu.mum.cs.cs525.labs.skeleton.proxy;


public class VirtualProxyTest {
    public static void main(String[] args) throws InterruptedException {
        Complex proxy1 = new WrappingProxy();
        ComplexFactory complexFactory = new VirtualProxyComplexFactory();
        Complex proxy2 = complexFactory.createComplex();
        proxy2.veryComplicatedTask();
        proxy2.veryComplicatedTask();
        Complex proxy3 = complexFactory.createComplex();
        proxy3.veryComplicatedTask();

    }
}
