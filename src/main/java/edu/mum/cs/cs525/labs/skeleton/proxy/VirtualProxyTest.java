package edu.mum.cs.cs525.labs.skeleton.proxy;


public class VirtualProxyTest {
    public static void main(String[] args) throws InterruptedException {
        Complex complexButDoNothing = VirtualProxy.getInstance();
        Thread.sleep(5000);
        System.out.println("Trying to create another proxy");
        Complex complexThing = VirtualProxy.getInstance();
        complexThing.veryComplicatedTask();
        complexThing.veryComplicatedTask();

    }
}
