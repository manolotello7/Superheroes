package com.example.superheroes.config.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface SuperheroesAnnotation {
    /**
     *Interfaz con anotaciones de
     * bloqueo de operativas
     */
}
