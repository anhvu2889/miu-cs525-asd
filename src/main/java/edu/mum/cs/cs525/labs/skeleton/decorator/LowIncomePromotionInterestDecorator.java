package edu.mum.cs.cs525.labs.skeleton.decorator;

import edu.mum.cs.cs525.labs.skeleton.strategy.InterestStrategy;

public class LowIncomePromotionInterestDecorator extends PromotionInterestDecorator {

    public static final double ADD_ON_INTEREST_RATE = 0.02;

    public LowIncomePromotionInterestDecorator(InterestStrategy baseInterestStrategy) {
        super(baseInterestStrategy);
    }

    @Override
    public double calculateInterest(double balance) {
        return getBaseInterestStrategy().calculateInterest(balance) + balance * ADD_ON_INTEREST_RATE;
    }

    @Override
    public String getDescription() {
        return STR."""
        \{getBaseInterestStrategy().getDescription()}
        then decorated: LowIncomePromotionInterest""";
    }
}
