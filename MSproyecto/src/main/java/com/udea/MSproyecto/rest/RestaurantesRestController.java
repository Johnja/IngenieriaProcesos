package com.udea.MSproyecto.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.udea.MSproyecto.dao.RestaurantesDAO;
import com.udea.MSproyecto.dto.Restaurantes;
import com.udea.MSproyecto.excepciones.ExcepcionProyecto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

@CrossOrigin
@Controller

public class RestaurantesRestController {
	static final Logger log = Logger.getLogger(RestaurantesRestController.class);
	@Autowired
	RestaurantesDAO restaurantesDAO;

	@RequestMapping("restaurant/find/{id}")
	@ResponseBody
	public Restaurantes getRestaurantes(@PathVariable("id") long nit) throws ExcepcionProyecto {
		Restaurantes restaurantes = new Restaurantes();
		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j traza metodo find");
		try {
			restaurantes = restaurantesDAO.findByNit(nit);
			if (!restaurantes.equals(null)) {
				log.info("Log4j Se obtiene el restaurante con el codigo ingesado  ");
			}
		} catch (Exception e) {
			log.error("Log4j Error en Find " + e);
			throw new ExcepcionProyecto(e);
		}
		return restaurantes;
	}
	
	@RequestMapping("restaurants/findall")
	@ResponseBody
	public List<Restaurantes> getRestaurantesAll() throws ExcepcionProyecto {
		List<Restaurantes> restaurantes = new ArrayList<Restaurantes>();
		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j method find All for document");
		try {
			restaurantes = restaurantesDAO.findAll();
			if (restaurantes.equals(null)) {
				log.info("Log4j get the list documents ");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Log4j Error in method Find All for document " + e);
			throw new ExcepcionProyecto(e);
		}
		return restaurantes;
	}

	@RequestMapping(value = "restaurant/save", method = RequestMethod.POST)
	@ResponseBody
	public boolean setRestaurantes(@RequestBody Restaurantes restaurantes) throws ExcepcionProyecto {
		boolean validator= true;
		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j traza metodo save");
		try {
			restaurantesDAO.save(restaurantes);
		} catch (Exception e) {
			validator = false;
			log.error("Log4j Error en Save " + e);
			throw new ExcepcionProyecto(e);	
		}
		return validator;
	}

	@RequestMapping(method = RequestMethod.PUT, path = "restaurantes/edit/find/{id}")
	@ResponseBody
	public boolean getEditRestaurantes(@PathVariable("id") long nit, @RequestBody Restaurantes restaurantes) throws ExcepcionProyecto {
		boolean validator = true;
		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j traza metodo Update");
		try {
			restaurantesDAO.save(restaurantes);
		} catch (Exception e) {
			validator = false;
			log.error("Log4j Error en Update " + e);
			return validator;
		}
		return validator;
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "restaurantes/delete/{id}")
	@ResponseBody
	public boolean getDeleteRestaurante(@PathVariable("id") long nit) throws ExcepcionProyecto {
		boolean validator = true;
		PropertyConfigurator.configure("log4j.properties");
		log.info("Log4j traza metodo Delete");
		try {
			restaurantesDAO.delete(nit);
			
		} catch (Exception e) {
			validator = false ;
			log.error("Log4j Error en Delete " + e);
			return validator;
			
		}
		return validator;
	}
}
