package com.udea.MSproyecto.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.udea.MSproyecto.dao.ClientesDAO;
import com.udea.MSproyecto.dto.Clientes;
import com.udea.MSproyecto.excepciones.ExcepcionProyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

@CrossOrigin
@Controller
public class ClientesRestController {
	static final Logger log = Logger.getLogger(ClientesRestController.class);
	@Autowired
	ClientesDAO clientesDAO;

	@RequestMapping("customer/find/{id}")
	@ResponseBody
	public Clientes getClientes(@PathVariable("id") long cedula) throws ExcepcionProyecto {
		Clientes clientes = new Clientes();
		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j traza metodo find");
		try {
			clientes = clientesDAO.findByCedula(cedula);
			if (!clientes.equals(null)) {
			}
		} catch (Exception e) {
			log.error("Log4j Error en Find " + e);
			throw new ExcepcionProyecto(e);
		}
		return clientes;
	}

	@RequestMapping("customers/findall")
	@ResponseBody
	public List<Clientes> getClientesAll() throws ExcepcionProyecto {
		List<Clientes> clientes = new ArrayList<Clientes>();
		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for document");
		try {
			clientes = clientesDAO.findAll();
			if (clientes.equals(null)) {
				log.info("Log4j get the list documents ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for document " + e);
			throw new ExcepcionProyecto(e);
		}		
		return clientes;
	}

	@RequestMapping(value = "customer/save", method = RequestMethod.POST)
	@ResponseBody
	public boolean setClientes(@RequestBody Clientes clientes) throws ExcepcionProyecto {
		boolean validator = true;
		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j traza metodo save");
		try {
			clientesDAO.save(clientes);
		} catch (Exception e) {
			validator = false;
			log.error("Log4j Error en Save " + e);
			return validator;		
		}
		return validator;
	}

	@RequestMapping(method = RequestMethod.PUT, path = "customer/edit/find/{id}")
	@ResponseBody
	public boolean getEditClientes(@PathVariable("id") long cedula, @RequestBody Clientes clientes) throws ExcepcionProyecto {
		boolean validator = true;
		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j traza metodo Update");
		try {
			clientesDAO.save(clientes);
		} catch (Exception e) {
			validator = false;
			log.error("Log4j Error en Update " + e);
			return validator;
		}
		return validator;
	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "customer/delete/{id}")
	@ResponseBody
	public boolean getDeleteClientes(@PathVariable("id") long cedula) throws ExcepcionProyecto {
		boolean validator= true;
		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j traza metodo Delete");
		try {
			clientesDAO.delete(cedula);
		} catch (Exception e) {
			validator = false;
			log.error("Log4j Error en Delete " + e);
			return validator;
		}
		return validator;
	}
}
