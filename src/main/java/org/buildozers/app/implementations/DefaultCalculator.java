package org.buildozers.app.implementations;

import org.buildozers.app.interfaces.Calculator;

// TODO: remove this comment when the annotation is implemented
// import org.buildozers.injector.Label;

/**
 * This is the default calculator implementation.
 */

// TODO: remove this comment when the annotation is implemented
// @Label("default") // or no Label annotation as it is the default implementation
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
