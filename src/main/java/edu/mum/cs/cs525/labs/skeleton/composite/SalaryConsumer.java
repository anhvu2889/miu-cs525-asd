package edu.mum.cs.cs525.labs.skeleton.composite;

import java.util.function.Consumer;

public class SalaryConsumer implements Consumer<Hire> {
    private double totalSalary = 0;

    @Override
    public void accept(Hire hire) {
        totalSalary += hire.getSalary();
    }

    public double getTotalSalary() {
        return totalSalary;
    }
}
