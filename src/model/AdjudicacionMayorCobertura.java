package model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AdjudicacionMayorCobertura implements Adjudicacion {

	@Override
	public void asignarAdjudicacion(List<Cliente> participantes, ModeloVehiculo vehiculo) {
		Cliente cliente = Collections.max(participantes, Comparator.comparing(p -> p.getCuotasPagas()));
		cliente.getAutosAdjudicados().add(vehiculo);
	}

}
