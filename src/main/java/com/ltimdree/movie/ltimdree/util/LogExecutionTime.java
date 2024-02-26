package com.ltimdree.movie.ltimdree.util;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used to mark methods for logging their execution time.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogExecutionTime {

    /**
     * Specifies the message to be logged along with the execution time.
     * @return the message to be logged
     */
    String value() default "";
}

