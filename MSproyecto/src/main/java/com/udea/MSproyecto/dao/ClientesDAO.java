package com.udea.MSproyecto.dao;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;


import com.udea.MSproyecto.dto.Clientes;

import org.apache.log4j.Logger;

@Transactional
public interface ClientesDAO extends CrudRepository<Clientes, Long> {
	static final Logger log = Logger.getLogger(Clientes.class);

	public Clientes findByCedula(long cedula);

	public List<Clientes> findAll();
}
