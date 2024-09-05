package edu.mum.cs.cs525.labs.skeleton.decorator;

import edu.mum.cs.cs525.labs.skeleton.strategy.InterestStrategy;

public class MilitaryVeteranPromotionInterestDecorator extends PromotionInterestDecorator {

    private static final double ADD_ON_INTEREST_RATE = 0.01;

    public MilitaryVeteranPromotionInterestDecorator(InterestStrategy interestStrategy) {
        super(interestStrategy);
    }


    @Override
    public double calculateInterest(double balance) {
        return getBaseInterestStrategy().calculateInterest(balance) * ADD_ON_INTEREST_RATE;
    }

    @Override
    public String getDescription() {
        return STR."""
        \{getBaseInterestStrategy().getDescription()}
        then decorated: MilitaryVeteranPromotionInterest""";
    }
}
