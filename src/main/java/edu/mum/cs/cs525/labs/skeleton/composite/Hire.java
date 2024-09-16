package edu.mum.cs.cs525.labs.skeleton.composite;

import java.util.function.Consumer;

public abstract class Hire {
    private String name;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public abstract void process(Consumer<Hire> action);
}
