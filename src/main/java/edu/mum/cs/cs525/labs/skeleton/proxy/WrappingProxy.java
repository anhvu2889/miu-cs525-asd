package edu.mum.cs.cs525.labs.skeleton.proxy;

import java.lang.reflect.Proxy;

public class WrappingProxy implements Complex {
    private final Complex instance;

    public WrappingProxy() {
        System.out.println("Creating proxy by wrapping virtual proxy");
        instance = (Complex) Proxy.newProxyInstance(
                Complex.class.getClassLoader(),
                new Class[]{Complex.class},
                new ComplexClassInvocationHandler()
        );
    }

    @Override
    public void veryComplicatedTask() {
        System.out.println("Invoking Proxy: very complicated task");
        instance.veryComplicatedTask();
    }
}
