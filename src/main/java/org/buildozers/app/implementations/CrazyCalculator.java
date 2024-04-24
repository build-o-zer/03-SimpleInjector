package org.buildozers.app.implementations;

import java.util.Random;

import org.buildozers.app.interfaces.Calculator;

// TODO: remove this comment when the annotation is implemented
// import org.buildozers.injector.Label;

/**
 * This is a crazy calculator implementation, always returning a random number.
 */

// TODO: remove this comment when the annotation is implemented
// @Label("crazy")
public class CrazyCalculator implements Calculator {

    private Random random = new Random();

    @Override
    public int substract(int a, int b) {
        return random.nextInt();
    }

    @Override
    public int multiply(int a, int b) {
        return random.nextInt();
    }

    @Override
    public int divide(int a, int b) {
        return random.nextInt();
    }

    @Override
    public int add(int a, int b) {
        return random.nextInt();
    }
}
