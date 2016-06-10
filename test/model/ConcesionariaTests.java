package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class ConcesionariaTests {

	private Concesionaria concesionaria;
	private Cliente clienteganador;
	private Cliente clientePerdedor;
	private PlanDeAhorro planAhorro;
	private AdjudicacionMayorCobertura modoAdjudicacionCobertura;
	private AdjudicacionSorteo modoAdjudicacionSorteo;
	private ModeloVehiculo modeloVehiculo;
	private Fabrica fabrica;
	private Planta planta;
	private Planta planta2;
	private Random randomMock;

	@Before
	public void setUp() throws Exception {
		this.randomMock = mock(Random.class);
		
		this.concesionaria = new Concesionaria();
		clienteganador = new Cliente();
		clientePerdedor = new Cliente();
		planAhorro = new PlanDeAhorro();
		modoAdjudicacionCobertura = new AdjudicacionMayorCobertura();
		modoAdjudicacionSorteo = new AdjudicacionSorteo(this.randomMock);
		modeloVehiculo = new ModeloVehiculo();
		fabrica = new Fabrica();
		planta = new Planta();
		planta2 = new Planta();		
	}

	@Test
	public void test01AgregarClienteAConcesionaria() {
		
		Cliente clienteMock = mock(Cliente.class);
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(clienteMock);
		this.concesionaria.agregarCliente(clienteMock);
		
		assertEquals(this.concesionaria.getClientes(), clientes);		
	}
	
	@Test
	public void test02AgregarFabricaAConcesionaria(){
		
		Fabrica fabricaMock = mock(Fabrica.class);
		
        this.concesionaria.setFabrica(fabricaMock);
        
        assertEquals(this.concesionaria.getFabrica(), fabricaMock);     
	}

	@Test
	public void test03AgregarPlanDeAhorroAConcesionaria(){
		
		PlanDeAhorro planDeAhorroMock = mock(PlanDeAhorro.class);
		
		ArrayList<PlanDeAhorro> planesDeAhorro= new ArrayList<PlanDeAhorro>();
		planesDeAhorro.add(planDeAhorroMock);
		
        this.concesionaria.setPlanDeAhorro(planDeAhorroMock);
        
        assertEquals(this.concesionaria.getPlanes(), planesDeAhorro);     
	}
	
	@Test
	public void test04AgregarPlantaAFabrica(){
		
		Fabrica fabrica = new Fabrica();
		
		Planta plantaMock = mock(Planta.class);
		
		ArrayList<Planta> plantas = new ArrayList<Planta>();
		
		plantas.add(plantaMock);
		
		fabrica.agregarPlanta(plantaMock);
		
		assertEquals(fabrica.getPlantas(), plantas);
	}
	
	@Test
	public void test05AgregarModeloAPlanta(){
		
		Planta planta = new Planta();
		
		ModeloVehiculo vehiculoMock = mock(ModeloVehiculo.class);
		
		planta.agregarModeloVehiculo(vehiculoMock, 1);
		
		assertEquals(planta.getStock().values().size(), 1);
	}
	
		
	@Test
	public void test06AgregarModoAdjudicacionPorSorteoAPlan(){
		
		PlanDeAhorro plan = new PlanDeAhorro();
		Adjudicacion modoAdjudicacionMock = mock(AdjudicacionSorteo.class);
        plan.setModoDeAdjudicacion(modoAdjudicacionMock);
        
        assertEquals(plan.getModoDeAdjudicacion(), modoAdjudicacionMock);     
	}
	
	@Test
	public void test07AgregarModoFinanciacionCienPorciento(){
		
		PlanDeAhorro plan = new PlanDeAhorro();
		FormaFinanciacion formaFinanciacionMock = mock(FinanciacionCienPorCiento.class);
        plan.setFormaFinanciacion(formaFinanciacionMock);
        
        assertEquals(plan.getFormaFinanciacion(), formaFinanciacionMock);     
	}
	
	@Test
	public void test08AdjudicarPorMayorCobertura(){
		
		ModeloVehiculo modeloVehiculoMock = mock(ModeloVehiculo.class);
		
		concesionaria.setFabrica(fabrica);
		fabrica.agregarPlanta(planta);
		fabrica.agregarPlanta(planta2);
		planta.agregarModeloVehiculo(modeloVehiculoMock, 2);
		planta2.agregarModeloVehiculo(modeloVehiculoMock, 1);
		clienteganador.setCuotasPagas(10);
		clientePerdedor.setCuotasPagas(5);
		planAhorro.getListaParticipantes().add(clienteganador);
		planAhorro.getListaParticipantes().add(clientePerdedor);		
		planAhorro.setModoDeAdjudicacion(modoAdjudicacionCobertura);
		planAhorro.setModeloVehiculo(modeloVehiculoMock);
		concesionaria.setPlanDeAhorro(planAhorro);
		concesionaria.efectuarAdjudicaciones();
		assertTrue(clienteganador.getAutosAdjudicados().size() == 1);
		assertTrue(clientePerdedor.getAutosAdjudicados().isEmpty());
	}
	
	@Test
	public void test09AdjudicarPorSorteo(){
		
		ModeloVehiculo modeloVehiculoMock = mock(ModeloVehiculo.class);
		
		when(this.randomMock.nextInt(1)).thenReturn(0);
		
		concesionaria.setFabrica(fabrica);
		fabrica.agregarPlanta(planta);
		fabrica.agregarPlanta(planta2);
		planta.agregarModeloVehiculo(modeloVehiculoMock, 2);
		planta2.agregarModeloVehiculo(modeloVehiculoMock, 1);
		planAhorro.getListaParticipantes().add(clienteganador);	
		planAhorro.getListaParticipantes().add(clientePerdedor);	
		planAhorro.setModoDeAdjudicacion(modoAdjudicacionSorteo);
		planAhorro.setModeloVehiculo(modeloVehiculoMock);
		concesionaria.setPlanDeAhorro(planAhorro);
		concesionaria.efectuarAdjudicaciones();
		assertTrue(clienteganador.getAutosAdjudicados().size() == 1);
	}
}
