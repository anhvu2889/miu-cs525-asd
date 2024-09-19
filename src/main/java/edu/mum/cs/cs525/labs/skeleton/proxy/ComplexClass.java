package edu.mum.cs.cs525.labs.skeleton.proxy;

public class ComplexClass implements Complex {
    public ComplexClass() throws InterruptedException {
        super();
        Thread.sleep(3000);
    }

    public void veryComplicatedTask() {
        System.out.println("Very complicated task...");
    }
}
