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
        implementations = DependencyScanner.scan(packages);
    }

    public static <T> T newInstance(Class<T> clazz) {
        if (implementations == null) {
            throw new IllegalStateException("DependencyInjector not initialized. Call register method first.");
        }

        if (clazz == null) {
            throw new ClassInstantiationException(clazz);
        }

        try {
            T instance = clazz.getDeclaredConstructor().newInstance();
            DependencyInjector.resolveDependencies(instance);
            return instance;
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            throw new ClassInstantiationException(clazz, e);
        }
    }

    private static <T> void resolveDependencies(T instance) {
        Stream.of(instance.getClass().getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(InjectDependency.class))
                .forEach(field -> {
                    String labelValue = field.getAnnotation(InjectDependency.class).value();
                    Class<?> targetType = field.getType();
                    Class<?> implementation = Optional.ofNullable(implementations.get(targetType)).orElseThrow().get(labelValue);
                    Optional.ofNullable(implementation)
                            .ifPresentOrElse(impl -> injectImplementationIntoField(instance, field, impl),
                                             ()   -> throwNoImplementationFound(labelValue, targetType));
                });
    }

    private static final  String NO_IMPLEMENTATION_FOUND = "No implementation found for %s with label %s";
    private static void throwNoImplementationFound(String labelValue, Class<?> targetType) {
        throw new ClassInstantiationException(targetType,
                new IllegalArgumentException(String.format(NO_IMPLEMENTATION_FOUND, targetType, labelValue)));
    }

    private static <T> void injectImplementationIntoField(T instance, Field field, Class<?> implementation) {
        @SuppressWarnings("unchecked")
        T implementationInstance = newInstance((Class<T>) implementation);
        field.setAccessible(true); // NOSONAR
        try {
            field.set(instance, implementationInstance); // NOSONAR
        } catch (IllegalArgumentException | IllegalAccessException e) {
            throw new ClassInstantiationException(implementation, e);
        }
    }
}
