package edu.mum.cs.cs525.labs.skeleton.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class VirtualProxy implements InvocationHandler {
    private Complex complexThingInstance;

    private volatile static VirtualProxy instance;

    private VirtualProxy() {

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws InterruptedException {
        try {
            if (complexThingInstance == null) {
                complexThingInstance = new ComplexClass();
                System.out.println("Creating complex object");
            }
            if (method.getName().equals("veryComplicatedTask")) {
                return method.invoke(complexThingInstance, args);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Complex getInstance() {
        if (instance == null) {
            synchronized (VirtualProxy.class) {
                instance = new VirtualProxy();
            }
        }
        System.out.println("Creating proxy object");
        return (Complex) java.lang.reflect.Proxy.newProxyInstance(
                Complex.class.getClassLoader(),
                new Class[]{Complex.class},
                instance
        );
    }
}
