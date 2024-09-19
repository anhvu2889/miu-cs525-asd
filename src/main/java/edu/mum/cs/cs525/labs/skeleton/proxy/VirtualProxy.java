package edu.mum.cs.cs525.labs.skeleton.proxy;

public class VirtualProxy implements Complex {
    private final Complex instance;

    public VirtualProxy() {
        System.out.println("Creating proxy");
        instance = (Complex) java.lang.reflect.Proxy.newProxyInstance(
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
