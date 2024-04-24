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
 */
@UtilityClass
class DependencyScanner {

    public static Map<Class<?>, Map<String, Class<?>>> scan(String... packages) {
        try (ScanResult scanResult = new ClassGraph().acceptPackages(packages).scan()) {
            List <Class<?>> interfaces = getInterfaces(scanResult);
            return registerClassesForInterfaces(scanResult, interfaces);
        }
    }

    private static List<Class<?>> getInterfaces(ScanResult scanResult) {
        ClassInfoList widgetClassInfo = scanResult.getAllInterfaces();
        return widgetClassInfo.loadClasses().stream().toList();
    }

    private static  Map<Class<?>, Map<String, Class<?>>> registerClassesForInterfaces(ScanResult scanResult, List <Class<?>> interfaces) {

        Map<Class<?>, Map<String, Class<?>>> implementations = new HashMap<>();
        for (Class<?> interfaceClass : interfaces) {
            List<Class<?>> classes = scanResult.getClassesImplementing(interfaceClass.getCanonicalName()).loadClasses();
            Map<String, Class<?>> implementationsMap = getImplementationsMap(classes);
            implementations.put(interfaceClass, implementationsMap);
        }
        return implementations;
    }

    private static Map<String, Class<?>> getImplementationsMap(List<Class<?>> classes) {
        Map<String, Class<?>> implementationsMap = new HashMap<>();
        for (Class<?> clazz : classes) {
            Label annotation = clazz.getAnnotation(Label.class);
            String annotationValue = Optional.ofNullable(annotation).map(Label::value).orElse("default");
            implementationsMap.put(annotationValue, clazz);                
        }
        return implementationsMap;
    }

}
