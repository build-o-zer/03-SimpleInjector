package org.buildozers.injector;

import lombok.experimental.UtilityClass;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Optional;

import java.util.stream.Stream;

/**
 * this class is the entry point of the dependency injection system.
 * 
 * First, call the register method to scan the packages and register the classes
 * that implement the interfaces.
 * Then, call the newInstance method to create an instance of the class with the
 * dependencies injected.
 */
@UtilityClass
public class DependencyInjector {

    // Map of interfaces and their implementations. 
    // An implementation is identified by a @Label annotation and its value field.
    private static Map<Class<?>, Map<String, Class<?>>> implementations;

    public static void register(String... packages) {
        implementations = DependencyScanner.scan(packages); // call the scan method of DependencyScanner
    }

    public static <T> T newInstance(Class<T> clazz) {
        // precondition 1 : check that the register method has been called, so the implementations map is not null
        // precondition 2 : check that the class "clazz" is not null

        // 1- create a new instance of the class "clazz" using java reflection API, using the default constructor with no arguments.
        // 2- resolve the dependencies of the instance by injecting the implementations of the interfaces. tip : call resolveDependencies
        // 3- return the instance

        // 4- if any error occurs during the creation of the instance, throw an exception of ClassInstantiationException
        throw new NotImplementedException(); // just here to make the code compile
    }

    /**
     * This method resolves the dependencies of the instance by injecting the
     * implementations of the interfaces.
     * 
     * @param <T> instance instance to inject the dependencies
     */
    private static <T> void resolveDependencies(T instance) {
       // Get all fields of the instance, check if the annotation @InjectDependency is present
       // if yes, get the value of the annotation (field value)
       // then get the implementation of the interface from the map of implementations
       // then call injectImplementationIntoField on the detected 
       // if any error occurs during "lookup", throw an exception of ClassInstantiationException
       // see method throwNoImplementationFound
       throw new NotImplementedException();
    }


    @SuppressWarnings("unused")
    private static <T> void injectImplementationIntoField(T instance, Field field, Class<?> implementation) {
       // inject an new instance of the implementation into the field of the given instance (first argument)
       // tip : you may need to set the field accessible before setting the value
       // tip : you must call newInstance of DependencyInjector to create the instance of the implementation which can own dependencies as well. (recusive calls)
       throw new NotImplementedException();
    }

    private static final  String NO_IMPLEMENTATION_FOUND = "No implementation found for %s with label %s";
    @SuppressWarnings("unused")
    private static void throwNoImplementationFound(String labelValue, Class<?> targetType) {
        throw new ClassInstantiationException(targetType,
                new IllegalArgumentException(String.format(NO_IMPLEMENTATION_FOUND, targetType, labelValue)));
    }
}
