package org.buildozers.app;

import org.buildozers.app.interfaces.Calculator;
// TODO: remove this comment when the annotation is implemented
// import org.buildozers.injector.InjectDependency; 

public class Application implements Runnable {

    // TODO: remove the following comment when the annotation is implemented
    //@InjectDependency
    private Calculator calculator;

    @Override
    public void run() {

        System.out.println("Tables of multiplication");
        for (int i = 1; i < 10; i++) {
            System.out.print("| ");
            for (int j = 1; j < 10; j++) {
                System.out.printf("%2d x %2d = %2d | ", i, j, calculator.multiply(i, j));
            }
            System.out.println();
        }
        
    }

}
