package model;

import java.util.ArrayList;
import java.util.List;


public class Fabrica {

	private List<Planta> listaPlantas;
	
	public Fabrica()
	{
		listaPlantas = new ArrayList<Planta>();
	}
	
	public List<Planta> getPlantas() {
		return listaPlantas;
	}

	public void agregarPlanta(Planta planta) {
		this.listaPlantas.add(planta);
		
	}
	
	public void actualizarStockPlanta(ModeloVehiculo vehiculo){
		for(Planta p: listaPlantas){
			if(p.getStock().containsKey(vehiculo)){
				p.getStock().put(vehiculo, p.getStock().get(vehiculo) - 1);
			}
		}
	}
	
}
