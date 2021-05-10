package com.example.superheroes.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;
import lombok.Setter;

/**
 * The exception.
 */
@Getter
@Setter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	
	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The resource name.
	 */
	private String resourceName;
	
	/**
	 * The field name.
	 */
    private String fieldName;
    
    /**
	 * The field value.
	 */
    private Object fieldValue;

    /**
	 * Instantiates a new ResourceNotFoundException.
	 *
	 * @param resourceName the resourceName
	 * @param fieldName the fieldName
	 * @param fieldValue the fieldValue
	 * 
	 */
    public ResourceNotFoundException( String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

}
