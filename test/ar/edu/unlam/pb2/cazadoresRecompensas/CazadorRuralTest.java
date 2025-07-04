package ar.edu.unlam.pb2.cazadoresRecompensas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CazadorRuralTest {

	@Test
	public void queSePuedaConocerLaExperienciaDelCazador() {
		CazadorRural cazadorRural = new CazadorRural("Juan", 40);
		
		assertEquals(Integer.valueOf(40), cazadorRural.getExperiencia());
	}
	@Test
	public void quePuedaCazarUnProfugoDeBajaInocenciaYQueSeaNervioso() {
		CazadorRural cazadorRural = new CazadorRural("Juan", 40);
		ProfugoBase profugo1 = new ProfugoBase("Jorge", 30, 80, true);
		
		assertTrue(cazadorRural.cazar(profugo1));;
	}
	
	@Test
	public void queNoPuedaCazarUnProfugoDeMayorInocenciaQueExperiencia() {
		CazadorRural cazadorRural = new CazadorRural("Juan", 40);
		ProfugoBase profugo1 = new ProfugoBase("Jorge", 41, 80, true);
		
		assertFalse(cazadorRural.cazar(profugo1));;
	}
	@Test
	public void queNoPuedaCazarUnProfugoQueNoSeaNervioso() {
		CazadorRural cazadorRural = new CazadorRural("Juan", 50);
		ProfugoBase profugo1 = new ProfugoBase("Jorge", 1, 80, false);
		
		assertFalse(cazadorRural.cazar(profugo1));

	}
	
	@Test
	public void queNoPuedaCazarUnProfugoYLoPuedaIntimidar() {
		CazadorRural cazadorRural = new CazadorRural("Juan", 50);
		ProfugoBase profugo1 = new ProfugoBase("Jorge", 40, 80, false);
		cazadorRural.cazar(profugo1);

		assertTrue(profugo1.esNervioso());

	}
	
	@Test
	public void queAlCazarUnProfugoSeAgregeAUnaLaListaDeCapturados() {
		CazadorRural cazadorRural = new CazadorRural("Juan", 40);
		ProfugoBase profugo1 = new ProfugoBase("Jorge", 30, 80, true);
		cazadorRural.cazar(profugo1);
		
		assertNotNull(cazadorRural.buscarCapturado(profugo1));
	}
	
	@Test
	public void queAlIntimidarUnProfugoSeAgregeAUnaLaListaDeIntimidados() {
		CazadorRural cazadorRural = new CazadorRural("Juan", 40);
		ProfugoBase profugo1 = new ProfugoBase("Jorge", 30, 80, false);
		cazadorRural.cazar(profugo1);
		
		assertNotNull(cazadorRural.buscarIntimidados(profugo1));
	}
	
	@Test
	public void quePuedaCazarEnUnaZonaEspecificaUnConjuntoDeProfugos() throws ZonaVaciaException {
		CazadorRural cazadorRural = new CazadorRural("Juan", 50);
		ProfugoBase profugo1 = new ProfugoBase("Jorge", 40, 80, true);
		ProfugoBase profugo2 = new ProfugoBase("Martin", 40, 80, true);
		ProfugoBase profugo3 = new ProfugoBase("Lucas", 40, 80, false);
		ArrayList<Profugo> listaDeProfugos = new ArrayList<Profugo>();
		listaDeProfugos.add(profugo1);
		listaDeProfugos.add(profugo2);
		listaDeProfugos.add(profugo3);
		Zona zona1 = new Zona("Moron", listaDeProfugos);
		
		cazadorRural.cazarEnZona(zona1);
		
		//El unico que no puede ser capturado es "Lucas" ya que nervioso = true;
		assertNotNull(cazadorRural.buscarCapturado(profugo1));
		assertNotNull(cazadorRural.buscarCapturado(profugo2));
		assertNull(cazadorRural.buscarCapturado(profugo3));
	}
	
	@Test
	public void quePuedaCazarEnUnaZonaEspecificaUnConjuntoDeProfugosYSumeExperiencia() throws ZonaVaciaException {
		CazadorRural cazadorRural = new CazadorRural("Juan", 50);
		ProfugoBase profugo1 = new ProfugoBase("Jorge", 40, 80, true);
		ProfugoBase profugo2 = new ProfugoBase("Martin", 40, 80, true);
		ArrayList<Profugo> listaDeProfugos = new ArrayList<Profugo>();
		listaDeProfugos.add(profugo1);
		listaDeProfugos.add(profugo2);
		Zona zona1 = new Zona("Moron", listaDeProfugos);
		
		cazadorRural.cazarEnZona(zona1);
		
		
		assertEquals(Integer.valueOf(54), cazadorRural.getExperiencia());
	}
	
	@Test
	public void queAlIntimidarNoSumeExperiencia() {
		CazadorRural cazadorRural = new CazadorRural("Martin", 50);
		ProfugoBase profugo = new ProfugoBase("Jorge", 100, 30, true); 

		cazadorRural.cazar(profugo);

		assertEquals(Integer.valueOf(50), cazadorRural.getExperiencia());
	}
	
	@Test
	public void quePuedaCazarEnUnaZonaEspecificaUnConjuntoDeProfugosYQueLaZonaQuedeLimpia() throws ZonaVaciaException {
		CazadorRural cazadorRural = new CazadorRural("Juan", 50);
		ProfugoBase profugo1 = new ProfugoBase("Jorge", 40, 80, true);
		ProfugoBase profugo2 = new ProfugoBase("Martin", 40, 80, true);
		ProfugoBase profugo3 = new ProfugoBase("Lucas", 40, 80, true);
		ArrayList<Profugo> listaDeProfugos = new ArrayList<Profugo>();
		listaDeProfugos.add(profugo1);
		listaDeProfugos.add(profugo2);
		listaDeProfugos.add(profugo3);
		Zona zona1 = new Zona("Moron", listaDeProfugos);
		
		cazadorRural.cazarEnZona(zona1);
		
		assertFalse(zona1.getProfugos().contains(profugo1));
		assertFalse(zona1.getProfugos().contains(profugo2));
		assertFalse(zona1.getProfugos().contains(profugo3));
	}
	
}
