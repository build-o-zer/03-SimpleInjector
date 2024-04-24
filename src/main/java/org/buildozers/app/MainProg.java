package org.buildozers.app;

import org.buildozers.injector.DependencyInjector;

public class MainProg {

    public static void main(String[] args) {
        
        DependencyInjector.register("org.buildozers.app");
        Runnable app = DependencyInjector.newInstance(Application.class);
        app.run();

    }

}
