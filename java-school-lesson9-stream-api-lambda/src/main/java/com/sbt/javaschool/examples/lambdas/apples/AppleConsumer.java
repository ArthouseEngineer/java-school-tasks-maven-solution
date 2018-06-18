package com.sbt.javaschool.examples.lambdas.apples;

import java.util.logging.Logger;

public class AppleConsumer implements IAppleConsumer {
    @Override
    public void acept(Apple a) {
        System.out.println(a);
    }
}
