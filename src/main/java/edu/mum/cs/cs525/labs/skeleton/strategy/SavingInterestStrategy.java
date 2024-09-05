package edu.mum.cs.cs525.labs.skeleton.strategy;

public class SavingInterestStrategy implements InterestStrategy {

    public static final double LOW_INTEREST_RATE = 0.01;
    public static final double MEDIUM_INTEREST_RATE = 0.02;
    public static final double HIGH_INTEREST_RATE = 0.04;

    @Override
    public double calculateInterest(double balance) {
        double interestRate;
        if (balance < 1000) {
            interestRate = LOW_INTEREST_RATE;
        } else if (balance < 5000) {
            interestRate = MEDIUM_INTEREST_RATE;
        } else {
            interestRate = HIGH_INTEREST_RATE;
        }
        return interestRate * balance;
    }

    @Override
    public String getDescription() {
        return "SavingInterestStrategy";
    }
}
