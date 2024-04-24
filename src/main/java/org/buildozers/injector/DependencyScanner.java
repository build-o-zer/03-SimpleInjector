package org.buildozers.injector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import io.github.classgraph.ClassGraph;
import io.github.classgraph.ClassInfoList;
import io.github.classgraph.ScanResult;
import lombok.experimental.UtilityClass;

/**
 * This class is responsible for scanning the packages and registering the classes that implement the interfaces.
 * This class is only used by the {@link DependencyInjector} class. It has package visibility only.
 */
@UtilityClass
class DependencyScanner {

    /**
     * this method scans the packages and returns a map of interfaces and their implementations.
     * Then for each implementation class, it stores the value of the @Label annotation in a map within the global implementation map.
     * 
     * It's a tree structure like this JSON Structure (WARNING, this is just for illustration purposes, the actual implementation is base on a Map of Maps:
     * 
     * <pre>
     * { "Calculator.class": 
     *          {
     *            "default": "org.buildozers.calculator.DefaultCalculator",
     *            "crazy" : "org.buildozers.calculator.CrazyCalculator",
     *            "lazy" : "org.buildozers.calculator.SimpleCalculator" 
     *          }
     *    "Logger.class":
     *          { 
     *            "default": "org.buildozers.logger.ScreenLogger",
     *            "http" : "org.buildozers.logger.HttpLogger" 
     *          }
     * }               
     * </pre>
     * 
     * @param packages
     * @return a map of interfaces and their implementations, indexed by the value of the @Label annotation
     */
    public static Map<Class<?>, Map<String, Class<?>>> scan(String... packages) {
        try (ScanResult scanResult = new ClassGraph().acceptPackages(packages).scan()) {
            List <Class<?>> interfaces = getInterfaces(scanResult); // first get the list of interfaces
            return registerClassesForInterfaces(scanResult, interfaces); // then smartly register the classes for the interfaces
        }
    }

    private static List<Class<?>> getInterfaces(ScanResult scanResult) {
        // return the list of interfaces found in the scan result
        throw new NotImplementedException();
    }

    private static  Map<Class<?>, Map<String, Class<?>>> registerClassesForInterfaces(ScanResult scanResult, List <Class<?>> interfaces) {
        // create the map of maps, containing the interfaces and their implementations, indexed by the value of the @Label annotation
        // tip: the scanResult can return the list of classes that implement an interface
        // tip: use the getImplementationsMap method to get each "submap" of implementations        
        throw new NotImplementedException();
    }

    private static Map<String, Class<?>> getImplementationsMap(List<Class<?>> classes) {
        // parse the list of classes (parameter) and return a map of implementations indexed by the value of the @Label annotation
        // if the @Label annotation is not present, use "default" as the key, otherwise use the value of the annotation as the key
        throw new NotImplementedException();
    }

}
