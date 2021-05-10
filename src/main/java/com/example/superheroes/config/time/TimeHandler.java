package com.example.superheroes.config.time;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class TimeHandler {
	
	@Pointcut("within(@com.example.superheroes.config.annotation.SuperheroesAnnotation *)")
	public void timePoincut() {
	    // pointcut annotation. Todos los métodos de la clase anotada
	}
	
	@Around("timePoincut()")
	public Object interceptorControllerTrace(ProceedingJoinPoint joinPoint) throws Throwable {

        log.info("Entering method");

        long inicio = System.nanoTime();
        
        Object result = joinPoint.proceed();
        
        long fin = System.nanoTime();
        
        double tiempo = (double) ((fin - inicio)/1000000);

        log.info("Finished method: " + tiempo +" milisegundos");
        
        return result;
    }
}
