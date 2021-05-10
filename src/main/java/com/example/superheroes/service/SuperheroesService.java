package com.example.superheroes.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.superheroes.entity.Superheroes;
import com.example.superheroes.repository.SuperheroesRepository;
import com.example.superheroes.exception.ResourceNotFoundException;
import com.example.superheroes.model.GeneralResponse;
import com.example.superheroes.model.SuperheroesRequest;

/**
 * The type Superheroes service.
 */
@Service
public class SuperheroesService {

	/**
	 * The Superheroes repository.
	 */
	private SuperheroesRepository superheroesRepository;
	
	/**
	 * Instantiates a new Superheroes service.
	 *
	 * @param superheroesRepository    the superheroes repository
	 * 
	 */
	@Autowired
	public SuperheroesService(SuperheroesRepository superheroesRepository) {
		this.superheroesRepository = superheroesRepository;
	}
	
	/**
	 * The findAllSuperheroes.
	 * 
	 * @return List Superheroes
	 */
	@Cacheable("superheroes")
	public List<Superheroes> findAllSuperheroes() {
		return superheroesRepository.findAll();
	}
	
	/**
	 * The findSuperheroById.
	 * 
	 * @param superheroeId the superheroe Id
	 * @return the Superheroes
	 */
	@Cacheable("superheroes")
	public Superheroes findSuperheroeById(Long superheroeId) {
		return superheroesRepository.findById(superheroeId)
				.orElseThrow(() -> new ResourceNotFoundException("Super heroe", "ID", superheroeId));
	}
	
	/**
	 * The findAllSuperheroesValue.
	 * 
	 * @param value the value
	 * @return List Superheroes
	 */
	@Cacheable("superheroes")
	public List<Superheroes> findAllSuperheroesValue(String value) {
		List <Superheroes> totalSuperheroes = superheroesRepository.findAll();
		
		List<Superheroes> response = totalSuperheroes.stream()
                .filter(superheroes -> superheroes.getNombreSuperheroe().matches(".*" + value + ".*"))
                .collect(Collectors.toList());
		
		return response;
	}
	
	/**
	 * The updateSuperheroes.
	 * 
	 * @param id 				the id
	 * @param superheroRequest  the superheroRequest
	 * @return the Superheroes
	 */
	@Cacheable("superheroes")
	public Superheroes updateSuperheroes(Long id, SuperheroesRequest superheroRequest) {
		return superheroesRepository.findById(id).map(superheroe -> {
			superheroe.setNombreSuperheroe(superheroRequest.getNombreSuperheroe());			
			return superheroesRepository.save(superheroe);
		}).orElseThrow(() -> new ResourceNotFoundException("Super heroe modificado", "id", id));
	}
	
	/**
	 * The deleteSuperheroe.
	 * 
	 * @param id 				the id
	 * @return the GeneralResponse
	 */
	@Cacheable("superheroes")
	public GeneralResponse deleteSuperheroe(Long id) {
		return superheroesRepository.findById(id).map(superheroe -> {			
			superheroesRepository.delete(superheroe);
			return new GeneralResponse(true, "Super heroe eliminado");
		}).orElseThrow(() -> new ResourceNotFoundException("Super heroe eliminado", "id", id));
		
	}
}
