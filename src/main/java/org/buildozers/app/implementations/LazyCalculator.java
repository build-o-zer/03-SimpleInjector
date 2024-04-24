package org.buildozers.app.implementations;

import org.buildozers.app.interfaces.Calculator;
import org.buildozers.injector.Label;

/**
 * This is a lazy calculator implementation, always returning 0.
 */

@Label("lazy")
public class LazyCalculator implements Calculator {

    @Override
    public int substract(int a, int b) {
        return 0;
    }

    @Override
    public int multiply(int a, int b) {
        return 0;
    }

    @Override
    public int divide(int a, int b) {
        return 0;
    }

    @Override
    public int add(int a, int b) {
        return 0;
    }
}
