package com.example.superheroes.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Superheroes.
 */
@Entity
@Table(name="superheroes")
@Getter
@Setter
public class Superheroes implements Serializable{
	
	/**
	 * The serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The Id.
	 */
	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Id del registro", name = "id", example = "1", required = true)
	private Long id;

	/**
	 * The nombre superheroe.
	 */
	@NotNull
	@ApiModelProperty(value = "Nombre del super heroe", name = "nombreSuperheroe", example = "Superman", required = true)
	private String nombreSuperheroe;

}
