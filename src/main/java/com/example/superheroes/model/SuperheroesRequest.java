package com.example.superheroes.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * SuperheroesRequest model request
 *
 */
@Getter
@Setter
public class SuperheroesRequest {

	/**
	 * nombreSuperheroe
	 */
	@ApiModelProperty(value = "Nombre del super heroe", name = "nombreSuperheroe", example="Superman", required = false)
    private String nombreSuperheroe;

}
