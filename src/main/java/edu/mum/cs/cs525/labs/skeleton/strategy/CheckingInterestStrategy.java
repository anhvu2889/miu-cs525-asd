package edu.mum.cs.cs525.labs.skeleton.strategy;

public class CheckingInterestStrategy implements InterestStrategy {

    private static final double LOW_INTEREST_RATE = 0.015;
    private static final double HIGH_INTEREST_RATE = 0.025;

    @Override
    public double calculateInterest(double balance) {
        double interestRate;
        if (balance < 1000) {
            interestRate = LOW_INTEREST_RATE;
        } else {
            interestRate = HIGH_INTEREST_RATE;
        }
        return balance * interestRate;
    }
}
