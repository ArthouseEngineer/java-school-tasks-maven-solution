package com.sbt.testing.examples;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class CalculatorTest {

    @Parameter
    public int a;

    @Parameter(1)
    public int b;

    @Parameter(2)
    public int expected;

    private Calculator calculator = new Calculator();

    @Parameters
    public static Iterable<Object[]> data() {

        return Arrays.asList(new Object[][]{{5, 2, 7}, {1, 1, 2}, {2, 1, 3}});
    }

    @Test
    public void testMultiply() {
        assertEquals(expected, calculator.multiply(a, b));
    }

}
