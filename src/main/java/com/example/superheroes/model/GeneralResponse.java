package com.example.superheroes.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * GeneralResponse model response
 *
 */
@Getter
@Setter
public class GeneralResponse {
	
	/**
	 * success
	 */
	@ApiModelProperty(value = "Valor del éxito de la operación", name = "success", example="true", required = false)
	private Boolean success;
	
	/**
	 * message
	 */
	@ApiModelProperty(value = "Mensaje de la operación", name = "message", example="Superheroe eliminado", required = false)
    private String message;
    
    /**
	 * Instantiates a new general response.
	 *
	 * @param success the success
	 * @param message the message
	 * 
	 */
    public GeneralResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

}
