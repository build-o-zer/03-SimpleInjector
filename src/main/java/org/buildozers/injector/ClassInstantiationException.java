package org.buildozers.injector;

/**
 * Exception thrown when a class cannot be instantiated.
 */
public class ClassInstantiationException extends RuntimeException {

    private static final String MESSAGE = "Unable to instantiate class";

    public ClassInstantiationException() {
        super(MESSAGE);
    }

    public ClassInstantiationException(Class<?> clazz) {
        super(generateMessage(clazz));
    }

    public ClassInstantiationException(Class<?> clazz, Throwable cause) {
        super(generateMessage(clazz), cause);
    }

    private static String generateMessage(Class<?> clazz) {
        return String.format("%s : %s", MESSAGE, clazz == null ? "<<NULL>>" : clazz.getCanonicalName());
    }

}
