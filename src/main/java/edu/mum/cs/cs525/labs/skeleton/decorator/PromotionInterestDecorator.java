package edu.mum.cs.cs525.labs.skeleton.decorator;

import edu.mum.cs.cs525.labs.skeleton.strategy.InterestStrategy;


public abstract class PromotionInterestDecorator implements InterestStrategy {

    private InterestStrategy baseInterestStrategy;

    public PromotionInterestDecorator(InterestStrategy baseInterestStrategy) {
        this.baseInterestStrategy = baseInterestStrategy;
    }

    public InterestStrategy getBaseInterestStrategy() {
        return baseInterestStrategy;
    }
}
