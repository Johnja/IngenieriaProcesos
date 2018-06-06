package com.udea.MSproyecto;

import static org.junit.Assert.*;

import java.util.ArrayList;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.validation.ValidationException;

import org.hibernate.service.spi.ServiceException;

import com.udea.MSproyecto.dao.RestaurantesDAO;
import com.udea.MSproyecto.dto.Restaurantes;
import com.udea.MSproyecto.excepciones.ExcepcionProyecto;
import com.udea.MSproyecto.rest.RestaurantesRestController;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class RestaurantesTest {
	
	private Restaurantes restaurantes;

	@InjectMocks
	private RestaurantesRestController servicioRestaurantes = new RestaurantesRestController();
	
	@Mock
	private RestaurantesDAO restaurantesDAO;
	
	@Before
	public void init() throws ServiceException, ValidationException{
		restaurantes  = new Restaurantes();
		List<Restaurantes> todosLosRestaurantes = new ArrayList<Restaurantes>();
		todosLosRestaurantes.add(restaurantes);
		when(restaurantesDAO.findAll()).thenReturn(todosLosRestaurantes);
		when(restaurantesDAO.findByNit(anyInt())).thenReturn(restaurantes);
	}
	
	@Test
	public void testGetAllCustomers() throws ExcepcionProyecto {
		assertNotNull(servicioRestaurantes.getRestaurantesAll());		
	}
	
	@Test
	public void testGetCustomer() throws ExcepcionProyecto{
		assertNotNull(servicioRestaurantes.getRestaurantes(890910230));
	}
		
	@Test
	public void testSaveCustomer() throws ExcepcionProyecto{
		assertTrue(servicioRestaurantes.setRestaurantes(restaurantes));
	}

	@Test
	public void testDeleteCustomer() throws ExcepcionProyecto{
		assertEquals( true, servicioRestaurantes.getDeleteRestaurante(890910230));
	}
	
	@Test
	public void testEditCustomer() throws ExcepcionProyecto{
		assertEquals(true, servicioRestaurantes.getEditRestaurantes(890910230, restaurantes));
	}
}
