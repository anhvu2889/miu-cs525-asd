package edu.mum.cs.cs525.labs.skeleton.proxy;

public class VirtualProxy implements Complex {
    private static Complex instance;

    public VirtualProxy() {
        System.out.println("Creating proxy");
        if (instance == null) {
            synchronized (Complex.class) {
                instance = (Complex) java.lang.reflect.Proxy.newProxyInstance(
                        Complex.class.getClassLoader(),
                        new Class[]{Complex.class},
                        new ComplexClassInvocationHandler()
                );
            }
        }
    }

    @Override
    public void veryComplicatedTask() {
        System.out.println("Invoking Proxy: very complicated task");
        instance.veryComplicatedTask();
    }
}
