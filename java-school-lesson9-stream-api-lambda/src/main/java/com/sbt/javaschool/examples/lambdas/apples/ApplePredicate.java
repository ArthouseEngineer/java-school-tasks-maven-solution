package com.sbt.javaschool.examples.lambdas.apples;

public class ApplePredicate implements IApplePredicate {
    @Override
    public boolean test(Apple a) {
        return a.getWeight() > 150;
    }
}
