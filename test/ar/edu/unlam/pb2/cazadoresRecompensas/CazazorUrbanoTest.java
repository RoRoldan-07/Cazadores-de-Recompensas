package ar.edu.unlam.pb2.cazadoresRecompensas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CazazorUrbanoTest {

	@Test
	public void queSePuedaConocerLaExperienciaDelCazador() {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Martin", 50);
		
		assertEquals(Integer.valueOf(50), cazadorUrbano.getExperiencia());
	}
	
	@Test
	public void quePuedaCazarUnProfujoDeBajaInocenciaYNoNervioso() {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Martin", 50);
		Profugo profugo1 = new Profugo("Jorge", 40, 80, false);
		
		assertTrue(cazadorUrbano.cazar(profugo1));
	}
	@Test
	public void queNoPuedaCazarUnProfujoDeMayorInocenciaQueExperiencia() {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Martin", 50);
		Profugo profugo1 = new Profugo("Jorge", 51, 80, false);
		
		assertFalse(cazadorUrbano.cazar(profugo1));
		
	}
	
	@Test
	public void queNoPuedaCazarUnProfujoQueSeaNervioso() {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Martin", 50);
		Profugo profugo1 = new Profugo("Jorge", 1, 80, true);
		
		assertFalse(cazadorUrbano.cazar(profugo1));

	}
	
	@Test
	public void queNoPuedaCazarUnProfujoYLoPuedaIntimidar() {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Martin", 50);
		Profugo profugo1 = new Profugo("Jorge", 54, 80, true);
		cazadorUrbano.cazar(profugo1);

		assertEquals(Integer.valueOf(52), profugo1.getInocencia());
		assertFalse(profugo1.esNervioso());

	}
	
	@Test
	public void queLaInocenciaDelProfugoNoPuedaSerMenorACero() {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Martin", 50);
		Profugo profugo1 = new Profugo("Jorge", 1, 80, true);
		cazadorUrbano.cazar(profugo1);

		assertEquals(Integer.valueOf(0), profugo1.getInocencia());
	}
	@Test
	public void queAlCazarUnProfugoSeAgregeAUnaLaListaDeCapturados() {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Martin", 50);
		Profugo profugo1 = new Profugo("Jorge", 40, 80, false);
		cazadorUrbano.cazar(profugo1);
		
		assertNotNull(cazadorUrbano.buscarCapturado(profugo1));
	}
	@Test
	public void queAlIntimidarUnProfugoSeAgregeAUnaLaListaDeIntimidados() {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Martin", 50);
		Profugo profugo1 = new Profugo("Jorge", 40, 80, true);
		cazadorUrbano.cazar(profugo1);
		
		assertNotNull(cazadorUrbano.buscarIntimidados(profugo1));
	}
	
	@Test
	public void queCazarUnProfujoSumeExperiencia() {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Martin", 50);
		Profugo profugo1 = new Profugo("Jorge", 40, 2, false);
		cazadorUrbano.cazar(profugo1);
		
		//El cazador tiene 50 de experiencia, el profugo 2 de habilidad
		//Como no lo intimido antes, la suma de experienca va a dar 2.
		assertEquals( Integer.valueOf(52), cazadorUrbano.getExperiencia());
	}
	
	@Test
	public void queLuegoDeIntimidarCazeUnProfujoYSumeExperiencia() {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Martin", 50);
		Profugo profugo1 = new Profugo("Jorge", 40, 2, true);
		cazadorUrbano.cazar(profugo1);
		cazadorUrbano.cazar(profugo1);
		
		//El cazador tiene 50 de experiencia, el profugo 2 de habilidad
		//Como ya lo intimido antes la suma de experienca va a dar 4.
		assertEquals( Integer.valueOf(54), cazadorUrbano.getExperiencia());
	}
	
	@Test
	public void quePuedaCazarEnUnaZonaEspecificaUnConjuntoDeProfugos() {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Martin", 50);
		Profugo profugo1 = new Profugo("Jorge", 40, 80, false);
		Profugo profugo2 = new Profugo("Martin", 40, 80, false);
		Profugo profugo3 = new Profugo("Lucas", 40, 80, true);
		ArrayList<Profugo> listaDeProfugos = new ArrayList<Profugo>();
		listaDeProfugos.add(profugo1);
		listaDeProfugos.add(profugo2);
		listaDeProfugos.add(profugo3);
		Zona zona1 = new Zona("Moron", listaDeProfugos);

		
		cazadorUrbano.cazarEnZona(zona1);
		
		//El unico que no puede ser capturado es "Lucas" ya que nervioso = true;
		assertNotNull(cazadorUrbano.buscarCapturado(profugo1));
		assertNotNull(cazadorUrbano.buscarCapturado(profugo2));
		assertNull(cazadorUrbano.buscarCapturado(profugo3));
	}
	
	@Test
	public void quePuedaCazarEnUnaZonaEspecificaUnConjuntoDeProfugosYQueLaZonaQuedeLimpia() {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Martin", 50);
		Profugo profugo1 = new Profugo("Jorge", 40, 80, false);
		Profugo profugo2 = new Profugo("Martin", 30, 80, false);
		Profugo profugo3 = new Profugo("Lucas", 20, 80, false);
		ArrayList<Profugo> listaDeProfugos = new ArrayList<Profugo>();
		listaDeProfugos.add(profugo1);
		listaDeProfugos.add(profugo2);
		listaDeProfugos.add(profugo3);
		Zona zona1 = new Zona("Moron", listaDeProfugos);

		
		cazadorUrbano.cazarEnZona(zona1);
		
		assertFalse(zona1.getProfugos().contains(profugo1));
		assertFalse(zona1.getProfugos().contains(profugo2));
		assertFalse(zona1.getProfugos().contains(profugo3));
	}
		
}