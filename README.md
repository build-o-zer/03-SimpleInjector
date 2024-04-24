# 03-SimpleInjector

## Description

This project is a simple example of how to code a simple DI framework library to inject dependencies into Java classes.

This is meant to be a coding dojo to practice the following concepts:
- Annotations
- Reflection
- Dependency Injection
- Java Generics
- Java Stream API
- Java Optional API    

## How to implement

1. create the two annotations called 
    - `@InjectDependency`  to mark the fields that will be injected
    - `@Label` to mark the class as an injectable class
    - each annotation should have a String `value` attribute to specify the name of the dependency to be injected.
    - the `value` attribute should have a default value as string `"default"`

2. implement the "DependencyScanner" class that will scan the classes in the project and find the classes that have the `@Label` annotation.
    - this class return a map of maps LIKE this JSON Structure (but its not a JSON Structure in memory, its a map of maps)

```json
{ "Calculator.class": 
  {
    "default": "org.buildozers.calculator.DefaultCalculator",
    "crazy" : "org.buildozers.calculator.CrazyCalculator",
    "lazy" : "org.buildozers.calculator.SimpleCalculator" 
  },
  "Logger.class":
  { 
    "default": "org.buildozers.logger.ScreenLogger",
    "http" : "org.buildozers.logger.HttpLogger" 
  }
}  
```

For example, the above JSON structure means that the interface `Calculator` has three implementations, and the class `Logger` has two implementations.
Each implementations has a `@Label` annotation with a value that specifies the name of the implementation.
For example, the `CrazyCalculator` class has a `@Label("crazy")` annotation.


3- implement the "DependencyInjector" class that will inject the dependencies into the classes that have the `@InjectDependency` annotation.
   
   - Just check the comments inside the class to know how to implement it.
   
4- Good Luck

## Where is the correct implementation?

Just checkout the branch `correction` to see the correct implementation.

Enjoy reading it.

## Author

- [François-Xavier Robin](https://github.com/fxrobin)