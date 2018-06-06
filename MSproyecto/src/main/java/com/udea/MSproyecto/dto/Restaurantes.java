
package com.udea.MSproyecto.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotNull;
import org.apache.log4j.Logger;

@Entity
@Table(name = "db_restaurants")
public class Restaurantes {
	static final Logger log = Logger.getLogger(Restaurantes.class);
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private long nit;

	@NotNull
	private String razonsocial;

	@NotNull
	private String razoncomercial;

	@NotNull
	private String ciudad;

	@NotNull
	private String barrio;

	@NotNull	
	private String direccion;
	
	@NotNull
	private String telefono;

	@NotNull
	private String email;

	@NotNull
	private double preciominimoplato;
	
	@NotNull
	private double preciomaximoplato;
	
	@NotNull
	private String tipomenu;
	
	@NotNull
	private int puntuacion;
	
	
	public Restaurantes() {

	}

	public Restaurantes(long nit, String razonsocial, String razoncomercial, String ciudad, String barrio, String direccion,
			String telefono, String email, double preciominimoplato, double preciomaximoplato, String tipomenu, int puntuacion) {
		super();
		this.nit = nit;
		this.razonsocial = razonsocial;
		this.razoncomercial= razoncomercial;
		this.ciudad = ciudad;
		this.barrio = barrio;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
		this.preciominimoplato = preciominimoplato;
		this.preciomaximoplato = preciomaximoplato;
		this.tipomenu = tipomenu;
		this.puntuacion = puntuacion;
		
	}
	
	public long getNit() {
		return nit;
	}

	public void setNit(long nit) {
		this.nit = nit;
	}

	public String getRazonsocial() {
		return razonsocial;
	}

	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}

	public String getRazoncomercial() {
		return razoncomercial;
	}

	public void setRazoncomercial(String razoncomercial) {
		this.razoncomercial = razoncomercial;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public double getPreciominimoplato() {
		return preciominimoplato;
	}

	public void setPreciominimoplato(double preciominimoplato) {
		this.preciominimoplato = preciominimoplato;
	}

	public double getPreciomaximoplato() {
		return preciomaximoplato;
	}

	public void setPreciomaximoplato(double preciomaximoplato) {
		this.preciomaximoplato = preciomaximoplato;
	}

	public String getTipomenu() {
		return tipomenu;
	}

	public void setTipomenu(String tipomenu) {
		this.tipomenu = tipomenu;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public static Logger getLog() {
		return log;
	}

	@Override
	public String toString() {
		return "Restaurante [nit=" + nit + ", razonsocial=" + razonsocial + ", " + "razoncomercial="
				+ razoncomercial+ ", ciudad=" + ciudad + ", barrio=" + barrio + ", direccion="
				+ direccion + ", telefono=" + telefono + ", email=" + email + ", preciominimoplato=" + preciominimoplato
				+ ", preciomaximoplato=" + preciomaximoplato + ", tipomenu=" + tipomenu + ", puntuacion=" + puntuacion + "]";
	}


}
