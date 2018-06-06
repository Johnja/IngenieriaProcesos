package com.udea.MSproyecto.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import org.apache.log4j.Logger;

@Entity
@Table(name = "db_customer")
public class Clientes {
	static final Logger log = Logger.getLogger(Clientes.class);
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String nombre;

	@NotNull
	private String apellido;

	@NotNull
	private String tipoidentificacion;

	@NotNull
	private long cedula;

	@NotNull
	private String genero;

	@NotNull
	private Date fechanacimiento;
	
	@NotNull
	private String telefono;

	@NotNull
	private String email;


	public Clientes() {

	}

	public Clientes(String nombre, String apellido, String tipoidentificacion, long cedula, String genero, Date fechanacimiento,
			String telefono, String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoidentificacion = tipoidentificacion;
		this.cedula = cedula;
		this.genero = genero;
		this.fechanacimiento = fechanacimiento;
		this.telefono = telefono;
		this.email = email;

	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTipoidentificacion() {
		return tipoidentificacion;
	}

	public void setTipoidentificacion(String tipoidentificacion) {
		this.tipoidentificacion = tipoidentificacion;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static Logger getLog() {
		return log;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellido=" + apellido + ", " + "tipoidentificacion="
				+ tipoidentificacion + ", cedula=" + cedula + ", genero=" + genero + ", fechanacimiento="
				+ fechanacimiento + ", telefono=" + telefono + ", email=" + email + "]";
	}


}
