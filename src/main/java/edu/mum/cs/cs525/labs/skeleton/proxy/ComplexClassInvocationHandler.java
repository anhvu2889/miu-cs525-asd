package edu.mum.cs.cs525.labs.skeleton.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ComplexClassInvocationHandler implements InvocationHandler {
    private Complex complexThingInstance;

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
}
