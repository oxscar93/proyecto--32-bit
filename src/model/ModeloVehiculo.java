package model;

import java.util.Date;


public class ModeloVehiculo {

	String nombre;
	Date fechaLanzamiento;
	Integer cantidadPuertas;
	TipoEquipamiento equipamiento;
	Integer valor;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}
	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}
	public Integer getCantidadPuertas() {
		return cantidadPuertas;
	}
	public void setCantidadPuertas(Integer cantidadPuertas) {
		this.cantidadPuertas = cantidadPuertas;
	}
	public TipoEquipamiento getEquipamiento() {
		return equipamiento;
	}
	public void setEquipamiento(TipoEquipamiento equipamiento) {
		this.equipamiento = equipamiento;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
}
