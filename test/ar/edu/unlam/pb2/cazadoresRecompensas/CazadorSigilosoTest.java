package ar.edu.unlam.pb2.cazadoresRecompensas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CazadorSigilosoTest {

	@Test
	public void queSePuedaConocerLaExperienciaDelCazador() {
		CazadorSigiloso cazadorSigiloso = new CazadorSigiloso("Pedro", 50);
		
		assertEquals(Integer.valueOf(50), cazadorSigiloso.getExperiencia());
	}
	
	@Test
	public void quePuedaCazarUnProfugoDeBajaInocenciaYHabilidadMenorA50() {
		CazadorSigiloso cazadorSigiloso = new CazadorSigiloso("Pedro", 50);
		//String nombre, Integer inocencia, Integer habilidad, boolean nervioso
		ProfugoBase profugo1 = new ProfugoBase("Jorge", 40, 40, false);
		
		assertTrue(cazadorSigiloso.cazar(profugo1));
	}
	
	@Test
	public void queNoPuedaCazarUnProfugoDeMayorInocenciaQueExperiencia() {
		CazadorSigiloso cazadorSigiloso = new CazadorSigiloso("Pedro", 50);
		ProfugoBase profugo1 = new ProfugoBase("Jorge", 60, 40, false);
		
		assertFalse(cazadorSigiloso.cazar(profugo1));
	}
	@Test
	public void queNoPuedaCazarUnProfugoDeNivel50DeHabilidad() {
		CazadorSigiloso cazadorSigiloso = new CazadorSigiloso("Pedro", 50);
		ProfugoBase profugo1 = new ProfugoBase("Jorge", 40, 50, false);
		
		assertFalse(cazadorSigiloso.cazar(profugo1));
	}
	
	
	@Test
	public void queNoPuedaCazarUnProfugoPorHabilidadYLoPuedaIntimidar() {
		CazadorSigiloso cazadorSigiloso = new CazadorSigiloso("Pedro", 50);
		ProfugoBase profugo1 = new ProfugoBase("Jorge", 40, 50, false);
		cazadorSigiloso.cazar(profugo1);
		
		assertEquals(45, profugo1.getHabilidad());
	}
	
	@Test
	public void queLaHabilidadDelProfugoNoPuedaSerMenorACero() {
		CazadorSigiloso cazadorSigiloso = new CazadorSigiloso("Pedro", 50);
		ProfugoBase profugo1 = new ProfugoBase("Jorge", 60, 2, false);
		cazadorSigiloso.cazar(profugo1);
		
		assertEquals(0, profugo1.getHabilidad());
	}
	
	
	@Test
	public void queAlCazarUnProfugoSeAgregeAUnaLaListaDeCapturados() {
		CazadorSigiloso cazadorSigiloso = new CazadorSigiloso("Pedro", 50);
		ProfugoBase profugo1 = new ProfugoBase("Jorge", 40, 40, false);
		cazadorSigiloso.cazar(profugo1);
		
		assertNotNull(cazadorSigiloso.buscarCapturado(profugo1));
	}
	
	@Test
	public void queAlIntimidarNoSumeExperiencia() {
		CazadorSigiloso cazadorSigiloso = new CazadorSigiloso("Pedro", 50);
		ProfugoBase profugo1 = new ProfugoBase("Jorge", 50, 50, false);
		cazadorSigiloso.cazar(profugo1);
		
		assertEquals(Integer.valueOf(50), cazadorSigiloso.getExperiencia());
	}
	
	@Test
	public void queAlIntimidarUnProfugoSeAgregeAUnaLaListaDeIntimidados() {
		CazadorSigiloso cazadorSigiloso = new CazadorSigiloso("Pedro", 50);
		ProfugoBase profugo1 = new ProfugoBase("Jorge", 50, 50, false);
		cazadorSigiloso.cazar(profugo1);
		
		assertNotNull(cazadorSigiloso.buscarIntimidados(profugo1));
	}
	
	@Test
	public void quePuedaCazarEnUnaZonaEspecificaUnConjuntoDeProfugos() throws ZonaVaciaException {
		CazadorSigiloso cazadorSigiloso = new CazadorSigiloso("Martin", 50);
		ProfugoBase profugo1 = new ProfugoBase("Jorge", 40, 40, false);
		ProfugoBase profugo2 = new ProfugoBase("Martin", 40, 40, false);
		ProfugoBase profugo3 = new ProfugoBase("Lucas", 40, 80, false);
		ArrayList<Profugo> listaDeProfugos = new ArrayList<Profugo>();
		listaDeProfugos.add(profugo1);
		listaDeProfugos.add(profugo2);
		listaDeProfugos.add(profugo3);
		Zona zona1 = new Zona("Moron", listaDeProfugos);

		
		cazadorSigiloso.cazarEnZona(zona1);
		
		//El unico que no puede ser capturado es "Lucas" ya que la habilidad >50
		assertNotNull(cazadorSigiloso.buscarCapturado(profugo1));
		assertNotNull(cazadorSigiloso.buscarCapturado(profugo2));
		assertNull(cazadorSigiloso.buscarCapturado(profugo3));
	}
	
	@Test
	public void quePuedaCazarEnUnaZonaEspecificaUnConjuntoDeProfugosYQueLaZonaQuedeLimpia() throws ZonaVaciaException {
		CazadorSigiloso cazadorSigiloso = new CazadorSigiloso("Martin", 50);
		ProfugoBase profugo1 = new ProfugoBase("Jorge", 40, 40, true);
		ProfugoBase profugo2 = new ProfugoBase("Martin", 40, 40, false);
		ProfugoBase profugo3 = new ProfugoBase("Lucas", 40, 40, true);
		ArrayList<Profugo> listaDeProfugos = new ArrayList<Profugo>();
		listaDeProfugos.add(profugo1);
		listaDeProfugos.add(profugo2);
		listaDeProfugos.add(profugo3);
		Zona zona1 = new Zona("Moron", listaDeProfugos);

		
		cazadorSigiloso.cazarEnZona(zona1);
		
		
		assertFalse(zona1.getProfugos().contains(profugo1));
		assertFalse(zona1.getProfugos().contains(profugo2));
		assertFalse(zona1.getProfugos().contains(profugo3));
	}
}
