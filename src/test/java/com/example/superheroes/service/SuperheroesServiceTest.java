package com.example.superheroes.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.superheroes.entity.Superheroes;
import com.example.superheroes.model.GeneralResponse;
import com.example.superheroes.model.SuperheroesRequest;
import com.example.superheroes.repository.SuperheroesRepository;
import com.fasterxml.jackson.core.JsonProcessingException;

@RunWith(SpringJUnit4ClassRunner.class)
public class SuperheroesServiceTest {
	
	@InjectMocks
	private SuperheroesService superheroesService;
	
	@Mock
	private SuperheroesRepository superheroesRepository;
	
	@Before
	public void init() {
		superheroesService = new SuperheroesService(superheroesRepository);
	}
	
	@Test
	public void findAllSuperheroesTest() throws JsonProcessingException {
		List<Superheroes> superheroesList = new ArrayList<Superheroes>();
		Superheroes superheroes = new Superheroes();
		superheroes.setId(Long.valueOf(1));
		superheroes.setNombreSuperheroe("Spiderman");
		superheroesList.add(superheroes);
		
		when(superheroesRepository.findAll()).thenReturn(superheroesList);
		
		List<Superheroes> response = superheroesService.findAllSuperheroes();
		assertNotNull(response);
		assertThat(response.get(0).getId()).isEqualTo(1);
		assertThat(response.get(0).getNombreSuperheroe()).isEqualTo("Spiderman");
	}
	
	@Test
	public void findSuperheroesByIdTest() throws JsonProcessingException {
		Superheroes superheroes = new Superheroes();
		superheroes.setId(Long.valueOf(1));
		superheroes.setNombreSuperheroe("Spiderman");
		
		when(superheroesRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(superheroes));
		
		Superheroes response = superheroesService.findSuperheroeById(superheroes.getId());
		assertNotNull(response);
		assertThat(response.getId()).isEqualTo(1);
		assertThat(response.getNombreSuperheroe()).isEqualTo("Spiderman");
		
		
	}
	
	@Test
	public void findAllSuperheroesValueTest() throws JsonProcessingException {
		List<Superheroes> superheroesList = new ArrayList<Superheroes>();
		Superheroes superheroes = new Superheroes();
		superheroes.setId(Long.valueOf(1));
		superheroes.setNombreSuperheroe("Spiderman");
		superheroesList.add(superheroes);
		
		when(superheroesRepository.findAll()).thenReturn(superheroesList);
		
		List<Superheroes> response = superheroesService.findAllSuperheroesValue("man");
		assertNotNull(response);
		assertThat(response.get(0).getId()).isEqualTo(1);
		assertThat(response.get(0).getNombreSuperheroe()).isEqualTo("Spiderman");
		
	}
	
	@Test
	public void updateSuperheroesTest() throws JsonProcessingException {
		SuperheroesRequest superheroRequest = new SuperheroesRequest();
		superheroRequest.setNombreSuperheroe("Batman");
		
		Superheroes superheroes = new Superheroes();
		superheroes.setId(Long.valueOf(1));
		superheroes.setNombreSuperheroe("Spiderman");
		
		when(superheroesRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(superheroes));
		when(superheroesRepository.save(superheroes)).thenReturn(superheroes);
		
		Superheroes response = superheroesService.updateSuperheroes(superheroes.getId(), superheroRequest);
		assertNotNull(response);
		assertThat(response.getId()).isEqualTo(1);
		assertThat(response.getNombreSuperheroe()).isEqualTo("Batman");
		
	}
	
	@Test
	public void deleteSuperheroeTest() throws JsonProcessingException {
		Superheroes superheroes = new Superheroes();
		superheroes.setId(Long.valueOf(1));
		superheroes.setNombreSuperheroe("Spiderman");
		
		when(superheroesRepository.findById(Long.valueOf(1))).thenReturn(Optional.of(superheroes));
		
		GeneralResponse response = superheroesService.deleteSuperheroe(superheroes.getId());
		assertNotNull(response);
		assertThat(response.getSuccess()).isEqualTo(true);
		
	}
	

}
