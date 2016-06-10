package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


public class Cliente {

	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private Integer dni;
	private String direccion;
	private String mail;
	private Date fechaDeIngreso;
	private Integer cuotasPagas;
	private List<ModeloVehiculo> autosAdjudicados;
	
	public Cliente() {
		setAutosAdjudicados(new ArrayList<ModeloVehiculo>());
		cuotasPagas = 0;
		fechaDeIngreso = new GregorianCalendar().getTime();
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
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Date getFechaDeIngreso() {
		return fechaDeIngreso;
	}
	public void setFechaDeIngreso(Date fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}
	public Integer getCuotasPagas() {
		return cuotasPagas;
	}
	public void setCuotasPagas(Integer cuotasPagas) {
		this.cuotasPagas = cuotasPagas;
	}

	public List<ModeloVehiculo> getAutosAdjudicados() {
		return autosAdjudicados;
	}

	public void setAutosAdjudicados(List<ModeloVehiculo> autosAdjudicados) {
		this.autosAdjudicados = autosAdjudicados;
	}
	
}
