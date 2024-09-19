package edu.mum.cs.cs525.labs.skeleton.proxy;


public class VirtualProxyTest {
    public static void main(String[] args) throws InterruptedException {
        Complex complexThing = VirtualProxy.getInstance();
        complexThing.veryComplicatedTask();
        complexThing.veryComplicatedTask();
    }
}
