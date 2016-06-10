package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Planta {

	private Integer distancia;
	private Map<ModeloVehiculo, Integer> stock;
	
	public Planta()
	{
		setStock(new HashMap<ModeloVehiculo, Integer>());
	}
	
	public Integer getDistancia() {
		return distancia;
	}
	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	public Map<ModeloVehiculo, Integer> getStock() {
		return stock;
	}

	public void setStock(Map<ModeloVehiculo, Integer> stock) {
		this.stock = stock;
	}

	public void agregarModeloVehiculo(ModeloVehiculo vehiculo, Integer cantidad) {
		if(stock.containsKey(vehiculo)){
			stock.put(vehiculo, stock.get(vehiculo) + cantidad);
		}else{
			stock.put(vehiculo, cantidad);
		}		
	}
}