import java.util.List;


public class PlanDeAhorro {

	Integer numeroDeGrupo;
	ModeloVehiculo modeloVehiculo;
	List<Cliente> listaParticipantes;
	
	
	
	
	public Integer getNumeroDeGrupo() {
		return numeroDeGrupo;
	}
	public void setNumeroDeGrupo(Integer numeroDeGrupo) {
		this.numeroDeGrupo = numeroDeGrupo;
	}
	public ModeloVehiculo getModeloVehiculo() {
		return modeloVehiculo;
	}
	public void setModeloVehiculo(ModeloVehiculo modeloVehiculo) {
		this.modeloVehiculo = modeloVehiculo;
	}
	public List<Cliente> getListaParticipantes() {
		return listaParticipantes;
	}
	public void setListaParticipantes(List<Cliente> listaParticipantes) {
		this.listaParticipantes = listaParticipantes;
	}
}
