package com.example.superheroes.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * SuperheroesResponse model response
 *
 */
@Getter
@Setter
public class SuperheroesResponse {
	
	/**
	 * nombreSuperheroe
	 */
	@ApiModelProperty(value = "Nombre del super heroe", name = "nombreSuperheroe", example="Superman", required = false)
    private String nombreSuperheroe;

    /**
	 * Instantiates a new Superheroes response.
	 *
	 * @param nombreSuperheroe the nombreSuperheroe
	 * 
	 */
    public SuperheroesResponse(String nombreSuperheroe) {
        this.nombreSuperheroe = nombreSuperheroe;
    }
    
}
