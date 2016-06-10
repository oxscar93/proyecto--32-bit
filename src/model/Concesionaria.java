package model;

import java.util.ArrayList;
import java.util.List;


public class Concesionaria {

	Fabrica fabrica;
	List<Cliente> clientes;
	private ArrayList<PlanDeAhorro> planesDeAhorro;
	
	public Concesionaria()
	{
		clientes = new ArrayList<Cliente>();
		planesDeAhorro = new ArrayList<PlanDeAhorro>();
	}
	
	public Fabrica getFabrica() {
		return fabrica;
	}

	public void setFabrica(Fabrica fabrica) {
		this.fabrica = fabrica;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<PlanDeAhorro> conocer10PlanesConMayorSuscripto() {
		//TODO
		return null;
	}
	
	public void ejecutarLasAdjudicaciones() {
		//TODO
	}
	
	public void actualizarStock() {
		//TODO
	}

	public void agregarCliente(Cliente cliente) {
		this.clientes.add(cliente);		
	}

	public void setPlanDeAhorro(PlanDeAhorro planDeAhorro) {
		this.planesDeAhorro.add(planDeAhorro);
		
	}

	public List<PlanDeAhorro> getPlanes() {
		
		return this.planesDeAhorro;
	}
	
	
	
	//EJERCICIOS ENTREGA
	
	//1. CONOCER LOS 10 PLANES CON MAYOR CANTIDAD DE SUBSCRIPTOS ORDENADOS DEMAYOR A MENOR
	
	public List<PlanDeAhorro> getNConMasSubscriptos(Integer n) {
		
		ArrayList<PlanDeAhorro> listaDePlanes = new ArrayList<PlanDeAhorro>();
		
		this.planesDeAhorro.forEach(p -> 
		
		agregarSiTieneMasQueNSubscriptos(p, listaDePlanes, n));
		
		this.ordenar(listaDePlanes);
		
		return listaDePlanes;
		
	}
	
	private void agregarSiTieneMasQueNSubscriptos(PlanDeAhorro p, ArrayList<PlanDeAhorro> listaDePlanes,
													Integer n){
		
		if(listaDePlanes.size() < n){
			listaDePlanes.add(p);
		}
		else{
			if(p.cantidadDeSubscriptos() > this.elPlanMenor(listaDePlanes).cantidadDeSubscriptos()){
				this.reemplazarMenorPor(listaDePlanes, p);
			}
		}
	}
	
	private void asignar(PlanDeAhorro menor, PlanDeAhorro p){
		menor = p;
	}
	
	private void reemplazarMenorPor(ArrayList<PlanDeAhorro> listaDePlanes, PlanDeAhorro q){
		PlanDeAhorro menor = this.elPlanMenor(listaDePlanes);
		
		listaDePlanes.forEach(p -> {if(p == menor) p = q;});
	}
	
	private PlanDeAhorro elPlanMenor(ArrayList<PlanDeAhorro> listaDePlanes){
		
		PlanDeAhorro menor = listaDePlanes.get(0);
		
		listaDePlanes.forEach(p -> 
		{if(p.cantidadDeSubscriptos() < menor.cantidadDeSubscriptos()) this.asignar(menor, p);});
		
		return menor;
	}
	
	private void ordenar(ArrayList<PlanDeAhorro> listaDePlanes){
		ArrayList<PlanDeAhorro> listaB = new ArrayList<PlanDeAhorro>();
		Integer n = listaDePlanes.size() - 1;
		while(n > 0){
			listaB.add(n, this.elPlanMenor(listaDePlanes));
			listaDePlanes.remove(n);
			n = listaDePlanes.size() - 1;
		}
		listaB.add(n, this.elPlanMenor(listaDePlanes));
		listaDePlanes = listaB;
	}
	
	
	//EJERCICIOS ENTREGA
	
	//2. EFECTUAR ADJUDICACIONES
	public void efectuarAdjudicaciones() {
		planesDeAhorro.forEach(p -> {
			p.getModoDeAdjudicacion().asignarAdjudicacion(p.getListaParticipantes(), p.getModeloVehiculo());
			fabrica.actualizarStockPlanta(p.getModeloVehiculo());
		});
	}
	
}
