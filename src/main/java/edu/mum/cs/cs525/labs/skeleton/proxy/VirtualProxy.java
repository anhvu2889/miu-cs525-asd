package edu.mum.cs.cs525.labs.skeleton.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class VirtualProxy implements InvocationHandler {
    private Complex complexThing;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InterruptedException {
        try {
            if (complexThing == null) {
                complexThing = new ComplexClass();
                System.out.println("Creating complex object");
            }
            if (method.getName().equals("veryComplicatedTask")) {
                return method.invoke(complexThing, args);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Complex getInstance() {
        return (Complex) java.lang.reflect.Proxy.newProxyInstance(
                Complex.class.getClassLoader(),
                new Class[]{Complex.class},
                new VirtualProxy()
        );
    }
}
