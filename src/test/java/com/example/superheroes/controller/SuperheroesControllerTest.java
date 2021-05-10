package com.example.superheroes.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.modules.junit4.PowerMockRunner;

import com.example.superheroes.entity.Superheroes;
import com.example.superheroes.model.GeneralResponse;
import com.example.superheroes.model.SuperheroesRequest;
import com.example.superheroes.model.SuperheroesResponse;
import com.example.superheroes.service.SuperheroesService;
import com.example.superheroes.web.SuperheroesController;
import com.fasterxml.jackson.core.JsonProcessingException;

@RunWith(PowerMockRunner.class)
@PowerMockIgnore({ "javax.management.*", "javax.script.*" })
public class SuperheroesControllerTest {
	
	@InjectMocks
	private SuperheroesController superheroesController;

	@Mock
	private SuperheroesService superheroesService;

	@Before
	public void init() {
		superheroesController = new SuperheroesController(superheroesService);
	}
	
	
	@Test
	public void getSuperheroesTest() throws JsonProcessingException {
		
		List<Superheroes> sh = new ArrayList<Superheroes>();
		Superheroes superheroes = new Superheroes();
		superheroes.setNombreSuperheroe("Superman");
		
		when(superheroesService.findAllSuperheroes()).thenReturn(sh);
		
		List<Superheroes> reponse = superheroesController.getSuperheroes();
		
		verify(superheroesService).findAllSuperheroes();
		verifyNoMoreInteractions(superheroesService);
		assertNotNull(reponse);
	}

	@Test
	public void getSuperheroeByIdTest() throws JsonProcessingException {
		Superheroes superheroes = new Superheroes();
		superheroes.setNombreSuperheroe("Superman");
		
		when(superheroesService.findSuperheroeById(Long.valueOf(1))).thenReturn(superheroes);
		
		SuperheroesResponse reponse = superheroesController.getSuperheroeById(Long.valueOf(1));
		
		verify(superheroesService).findSuperheroeById(Long.valueOf(1));
		verifyNoMoreInteractions(superheroesService);
		assertNotNull(reponse);
	}
	
	@Test
	public void getSuperheroeByNameTest() throws JsonProcessingException {
		List<Superheroes> sh = new ArrayList<Superheroes>();
		
		when(superheroesService.findAllSuperheroesValue("man")).thenReturn(sh);
		
		List<Superheroes> reponse = superheroesController.getSuperheroesByName("man");
		
		verify(superheroesService).findAllSuperheroesValue("man");
		verifyNoMoreInteractions(superheroesService);
		assertNotNull(reponse);
	}

	
	@Test
	public void updateSuperheroesTest() throws JsonProcessingException {
		SuperheroesRequest superheroesRequest = new SuperheroesRequest();
		superheroesRequest.setNombreSuperheroe("Spiderman");
		
		Superheroes superheroes = new Superheroes();
		superheroes.setId(Long.valueOf(1));
		superheroes.setNombreSuperheroe("Superman");
		
		when(superheroesService.updateSuperheroes(superheroes.getId(), superheroesRequest)).thenReturn(superheroes);
		
		Superheroes reponse = superheroesController.updateSuperheroe(Long.valueOf(1), superheroesRequest);
		
		verify(superheroesService).updateSuperheroes(Long.valueOf(1), superheroesRequest);
		verifyNoMoreInteractions(superheroesService);
		assertNotNull(reponse);
		
	}
	
	@Test
	public void deleteSuperheroeTest() throws Exception {
		Superheroes superheroe = new Superheroes();
		superheroe.setId(Long.valueOf(1));
		superheroe.setNombreSuperheroe("Spiderman");
		GeneralResponse generalResponse = new GeneralResponse(null, null);
		
		when(superheroesService.deleteSuperheroe(superheroe.getId())).thenReturn(generalResponse);
		
		GeneralResponse reponse = superheroesController.deleteSuperheroe(Long.valueOf(1));
		
		verify(superheroesService, times(1)).deleteSuperheroe(superheroe.getId());
		verifyNoMoreInteractions(superheroesService);
		assertNotNull(reponse);
	}
}
