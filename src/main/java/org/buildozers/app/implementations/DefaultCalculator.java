package org.buildozers.app.implementations;

import org.buildozers.app.interfaces.Calculator;
import org.buildozers.injector.Label;

/**
 * This is the default calculator implementation.
 */

@Label("default")
public class DefaultCalculator implements Calculator {

    @Override
    public int substract(int a, int b) {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) {
        return a * b;
    }

    @Override
    public int divide(int a, int b) {
        return a / b;
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }
}
