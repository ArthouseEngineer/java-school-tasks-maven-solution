package com.sbt.javaschool.examples.lambdas.apples;

public class AppleConsumer implements IAppleConsumer {
    @Override
    public void acept(Apple a) {
        System.out.println(a);
    }
}
