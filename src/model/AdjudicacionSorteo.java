package model;

import java.util.List;
import java.util.Random;

public class AdjudicacionSorteo implements Adjudicacion {

	private Random random;
	
	public AdjudicacionSorteo(Random random){
	
		this.random = random;
	}
	
	@Override
	public void asignarAdjudicacion(List<Cliente> participantes, ModeloVehiculo vehiculo) {

		Cliente cliente = participantes.get(this.random.nextInt(participantes.size()));
		cliente.getAutosAdjudicados().add(vehiculo);
	}

}
