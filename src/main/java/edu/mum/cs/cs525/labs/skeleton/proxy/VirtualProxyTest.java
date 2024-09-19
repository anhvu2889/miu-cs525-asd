package edu.mum.cs.cs525.labs.skeleton.proxy;


public class VirtualProxyTest {
    public static void main(String[] args) throws InterruptedException {
        Complex proxy1 = new VirtualProxy();
        Complex proxy2 = new VirtualProxy();
        proxy2.veryComplicatedTask();
        proxy2.veryComplicatedTask();
        Complex proxy3 = new VirtualProxy();
        proxy3.veryComplicatedTask();

    }
}
