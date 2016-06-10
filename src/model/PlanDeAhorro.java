package model;

import java.util.ArrayList;
import java.util.List;


public class PlanDeAhorro {

	private Integer numeroDeGrupo;
	private ModeloVehiculo modeloVehiculo;
	private List<Cliente> listaParticipantes;
	private Adjudicacion modoDeAdjudicacion;
	private FormaFinanciacion formaFinanciacion;	
	
	public PlanDeAhorro() {
		listaParticipantes = new ArrayList<Cliente>();
	}
	
	
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
	public void setModoDeAdjudicacion(Adjudicacion modoAdjudicacion) {
		this.modoDeAdjudicacion = modoAdjudicacion;
		
	}
	public Adjudicacion getModoDeAdjudicacion() {
		return this.modoDeAdjudicacion;
	}
	public FormaFinanciacion getFormaFinanciacion() {
		return this.formaFinanciacion;
	}
	public void setFormaFinanciacion(FormaFinanciacion formaFinanciacion) {
		this.formaFinanciacion = formaFinanciacion;
		
	}
	
	public Integer cantidadDeSubscriptos(){
		return listaParticipantes.size();
	}
}
