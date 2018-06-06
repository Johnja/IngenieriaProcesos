
package com.udea.MSproyecto.dao;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;


import com.udea.MSproyecto.dto.Restaurantes;

import org.apache.log4j.Logger;

@Transactional
public interface RestaurantesDAO extends CrudRepository<Restaurantes, Long> {
	static final Logger log = Logger.getLogger(Restaurantes.class);

	public Restaurantes findByNit(long nit);
	
	public List<Restaurantes> findAll();

}
