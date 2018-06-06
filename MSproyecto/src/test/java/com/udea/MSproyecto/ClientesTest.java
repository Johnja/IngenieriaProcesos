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
import com.udea.MSproyecto.dao.ClientesDAO;
import com.udea.MSproyecto.dto.Clientes;
import com.udea.MSproyecto.excepciones.ExcepcionProyecto;
import com.udea.MSproyecto.rest.ClientesRestController;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ClientesTest {
	
	private Clientes clientes;

	@InjectMocks
	private ClientesRestController servicioClientes = new ClientesRestController();
	
	@Mock
	private ClientesDAO clientesDAO;
	
	@Before
	public void init() throws ServiceException, ValidationException{
		clientes  = new Clientes();
		List<Clientes> todosLosClientes = new ArrayList<Clientes>();
		todosLosClientes.add(clientes);
		when(clientesDAO.findAll()).thenReturn(todosLosClientes);
		when(clientesDAO.findByCedula(anyInt())).thenReturn(clientes);
	}
	
	@Test
	public void testGetAllCustomers() throws ExcepcionProyecto {
		assertNotNull(servicioClientes.getClientesAll());		
	}
	
	@Test
	public void testGetCustomer() throws ExcepcionProyecto{
		assertNotNull(servicioClientes.getClientes(3396760));
	}
		
	@Test
	public void testSaveCustomer() throws ExcepcionProyecto{
		assertTrue(servicioClientes.setClientes(clientes));
	}

	@Test
	public void testDeleteCustomer() throws ExcepcionProyecto{
		assertEquals( true, servicioClientes.getDeleteClientes(3396760));
	}
	
	@Test
	public void testEditCustomer() throws ExcepcionProyecto{
		assertEquals(true, servicioClientes.getEditClientes(3396760, clientes));
	}
}
