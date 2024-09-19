package edu.mum.cs.cs525.labs.skeleton.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class ComplexClassInvocationHandler implements InvocationHandler {
    private static volatile Complex complexThingInstance;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if (method.getName().equals("veryComplicatedTask")) {
                return method.invoke(getComplexThingInstance(), args);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Complex getComplexThingInstance() throws InterruptedException {
        if (complexThingInstance == null) {
            synchronized (ComplexClassInvocationHandler.class) {
                complexThingInstance = new ComplexClass();
                System.out.println("Creating complex object");
            }
        }
        return complexThingInstance;
    }
}
