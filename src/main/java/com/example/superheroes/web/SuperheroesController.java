package com.example.superheroes.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.superheroes.config.annotation.SuperheroesAnnotation;
import com.example.superheroes.entity.Superheroes;
import com.example.superheroes.model.GeneralResponse;
import com.example.superheroes.model.SuperheroesRequest;
import com.example.superheroes.model.SuperheroesResponse;
import com.example.superheroes.service.SuperheroesService;

import io.swagger.annotations.ApiOperation;

/**
 * The type Superheroes controller.
 */
@RestController
@RequestMapping(SuperheroesController.PATH)
@SuperheroesAnnotation
public class SuperheroesController {

	/**
	 * The constant PATH.
	 */
	public static final String PATH = "/api/v1/superheros";
	
	/**
	 * The constant PATH.
	 */
	public static final String PATH_FIND_BY_ID = "/{id}";
	
	/**
	 * The constant PATH.
	 */
	public static final String PATH_FIND_BY_NAME = "/consultation-names/{value}";
	
	/**
	 * The constant PATH.
	 */
	public static final String PATH_MODIFICAR = "/modifications/{id}";
	
	/**
	 * The constant PATH.
	 */
	public static final String PATH_DELETE = "/removes/{id}";
	
	/**
	 * The superheroes service.
	 */
	private SuperheroesService superheroesService;
	
	/**
	 * Instantiates a new superheroes controller.
	 *
	 * @param superheroesService the superheroes service
	 */
	@Autowired
	public SuperheroesController(SuperheroesService superheroesService) {
		this.superheroesService = superheroesService;
	}
	
	/**
	 * Ger all superheroes
	 *
	 * @return List Superheroes
	 */
	@GetMapping()
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener superheroes", notes = "Servicio para devolver todos los super heroes")
	public List<Superheroes> getSuperheroes() {
		return superheroesService.findAllSuperheroes();
	}
	
	/**
	 * Ger superheroes by Id
	 *
	 * @param id the id
	 * @return the superheroesResponse
	 */
	@GetMapping(value = SuperheroesController.PATH_FIND_BY_ID)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener superheroe por id", notes = "Servicio para devolver el super heroes por id")
	public SuperheroesResponse getSuperheroeById(@PathVariable Long id) {
		Superheroes superheroes = superheroesService.findSuperheroeById(id);
		return new SuperheroesResponse(superheroes.getNombreSuperheroe());
	}
	
	/**
	 * Ger superheroes by name
	 *
	 * @param value the value
	 * @return List Superheroes
	 */
	@GetMapping(value = SuperheroesController.PATH_FIND_BY_NAME)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Obtener superheroes por nombre", notes = "Servicio para devolver todos los super heroes que contengan el valor del párámetro enviado")
	public List<Superheroes> getSuperheroesByName(@PathVariable String value) {
		return superheroesService.findAllSuperheroesValue(value);
	}
	
	/**
	 * Update superheroe
	 *
	 * @param id 				 the id
	 * @param superheroesRequest the superheroesRequest
	 * @return the Superheroes
	 */
	@PutMapping(value = SuperheroesController.PATH_MODIFICAR)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Actualizar superheroe", notes = "Servicio para actualizar el super heroe por id")
	public Superheroes updateSuperheroe(@PathVariable Long id, @Valid @RequestBody SuperheroesRequest superheroesRequest) {
		return superheroesService.updateSuperheroes(id, superheroesRequest);
	}
	
	/**
	 * Delete superheroe
	 *
	 * @param id the id
	 * @return the GeneralResponse
	 */
	@DeleteMapping(value = SuperheroesController.PATH_DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Eliminar superheroe", notes = "Servicio para borrar el super heroe por id")
	public GeneralResponse deleteSuperheroe(@PathVariable Long id) {
		return superheroesService.deleteSuperheroe(id);
	}
	
}
