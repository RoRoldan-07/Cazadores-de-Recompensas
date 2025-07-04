package ar.edu.unlam.pb2.cazadoresRecompensas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class CazadorUrbanoTest {

	@Test
	public void queSePuedaConocerLaExperienciaDelCazador() throws ValorInvalidoException, CazadorSinNombreException {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Martin", 50);

		assertEquals(Integer.valueOf(50), cazadorUrbano.getExperiencia());
	}

	@Test
	public void quePuedaCazarUnProfugoDeBajaInocenciaYNoNervioso() throws ProfugoNuloException, ValorInvalidoException, CazadorSinNombreException {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Martin", 50);
		ProfugoBase profugo1 = new ProfugoBase("Jorge", 40, 80, false);

		assertTrue(cazadorUrbano.cazar(profugo1));
	}

	@Test
	public void queNoPuedaCazarUnProfugoDeMayorInocenciaQueExperiencia() throws ProfugoNuloException, ValorInvalidoException, CazadorSinNombreException {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Martin", 50);
		ProfugoBase profugo1 = new ProfugoBase("Jorge", 51, 80, false);

		assertFalse(cazadorUrbano.cazar(profugo1));

	}

	@Test
	public void queNoPuedaCazarUnProfugoQueSeaNervioso() throws ProfugoNuloException, ValorInvalidoException, CazadorSinNombreException {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Martin", 50);
		ProfugoBase profugo1 = new ProfugoBase("Jorge", 1, 80, true);

		assertFalse(cazadorUrbano.cazar(profugo1));

	}

	@Test
	public void queNoPuedaCazarUnProfugoYLoPuedaIntimidar() throws ProfugoNuloException, ValorInvalidoException, CazadorSinNombreException {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Martin", 50);
		ProfugoBase profugo1 = new ProfugoBase("Jorge", 54, 80, true);
		cazadorUrbano.cazar(profugo1);

		assertEquals(52, profugo1.getInocencia());
		assertFalse(profugo1.esNervioso());

	}

	@Test
	public void queLaInocenciaDelProfugoNoPuedaSerMenorACero() throws ProfugoNuloException, ValorInvalidoException, CazadorSinNombreException {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Martin", 50);
		ProfugoBase profugo1 = new ProfugoBase("Jorge", 1, 80, true);
		cazadorUrbano.cazar(profugo1);

		assertEquals(0, profugo1.getInocencia());
	}

	@Test
	public void queAlCazarUnProfugoSeAgregeAUnaLaListaDeCapturados() throws ProfugoNuloException, ValorInvalidoException, CazadorSinNombreException {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Martin", 50);
		ProfugoBase profugo1 = new ProfugoBase("Jorge", 40, 80, false);
		cazadorUrbano.cazar(profugo1);

		assertNotNull(cazadorUrbano.buscarCapturado(profugo1));
	}

	@Test
	public void queAlIntimidarUnProfugoSeAgregeAUnaLaListaDeIntimidados() throws ProfugoNuloException, ValorInvalidoException, CazadorSinNombreException {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Martin", 50);
		ProfugoBase profugo1 = new ProfugoBase("Jorge", 40, 80, true);
		cazadorUrbano.cazar(profugo1);

		assertNotNull(cazadorUrbano.buscarIntimidados(profugo1));
	}

	@Test
	public void queAlIntimidarNoSumeExperiencia() throws ProfugoNuloException, ValorInvalidoException, CazadorSinNombreException {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Martin", 50);
		ProfugoBase profugo = new ProfugoBase("Jorge", 100, 30, false);

		cazadorUrbano.cazar(profugo);

		assertEquals(Integer.valueOf(50), cazadorUrbano.getExperiencia());
	}

	@Test
	public void quePuedaCazarEnUnaZonaEspecificaUnConjuntoDeProfugos() throws ZonaVaciaException, ProfugoNuloException, ValorInvalidoException, CazadorSinNombreException {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Martin", 50);
		ProfugoBase profugo1 = new ProfugoBase("Jorge", 40, 80, false);
		ProfugoBase profugo2 = new ProfugoBase("Martin", 40, 80, false);
		ProfugoBase profugo3 = new ProfugoBase("Lucas", 40, 80, true);
		ArrayList<Profugo> listaDeProfugos = new ArrayList<Profugo>();
		listaDeProfugos.add(profugo1);
		listaDeProfugos.add(profugo2);
		listaDeProfugos.add(profugo3);
		Zona zona = new Zona("Moron", listaDeProfugos);

		cazadorUrbano.cazarEnZona(zona);

		// El unico que no puede ser capturado es "Lucas" ya que nervioso = true;
		assertNotNull(cazadorUrbano.buscarCapturado(profugo1));
		assertNotNull(cazadorUrbano.buscarCapturado(profugo2));
		assertNull(cazadorUrbano.buscarCapturado(profugo3));
	}

	@Test
	public void quePuedaCazarEnUnaZonaEspecificaUnConjuntoDeProfugosYQueLaZonaQuedeLimpia() throws ZonaVaciaException, ProfugoNuloException, ValorInvalidoException, CazadorSinNombreException {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Martin", 50);
		ProfugoBase profugo1 = new ProfugoBase("Jorge", 40, 80, false);
		ProfugoBase profugo2 = new ProfugoBase("Martin", 30, 80, false);
		ProfugoBase profugo3 = new ProfugoBase("Lucas", 20, 80, false);
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
	
	@Test(expected = ValorInvalidoException.class)
	public void queNoSePuedaCrearUnCazadorConExperienciaNegativa() throws ValorInvalidoException, CazadorSinNombreException {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Martin", -1);
	}
	
	@Test(expected = ValorInvalidoException.class)
	public void queNoSePuedaCrearUnCazadorConExperienciaNula() throws ValorInvalidoException, CazadorSinNombreException {
		CazadorUrbano cazadorUrbano = new CazadorUrbano("Martin", null);
	}
	
	@Test
	public void queSeLanceUnaExcepcionConElMensajeCorrectoCuandoLaExperienciaEsNegativa() throws CazadorSinNombreException {
	    try {
	        new CazadorUrbano("Jorge", -1);
	        fail("Se esperaba una excepción por experiencia inválida");
	    } catch (ValorInvalidoException e) {
	        assertEquals("La experiencia no puede ser nula ni negativa", e.getMessage());
	    }
	}
	
	@Test(expected = ZonaVaciaException.class)
	public void queNoSePuedaCazarEnUnaZonaVacia() throws ZonaVaciaException, ProfugoNuloException, ValorInvalidoException, CazadorSinNombreException {
	    CazadorUrbano cazador = new CazadorUrbano("Martin", 50);
	    ArrayList<Profugo> listaDeProfugos = new ArrayList<Profugo>();
	    Zona zonaVacia = new Zona("Moron", listaDeProfugos);

	    cazador.cazarEnZona(zonaVacia);
	}
	
	@Test(expected = ProfugoNuloException.class)
	public void queNoSePuedaCazarUnProfugoQueSeaNulo() throws ProfugoNuloException, ValorInvalidoException, CazadorSinNombreException {
	    CazadorUrbano cazador = new CazadorUrbano("Martin", 50);
	    cazador.cazar(null);
	}
	
	@Test
	public void queNoSePuedaCrearUnCazadorConNombreNuloYVerificarMensaje() {
	    try {
	        new CazadorUrbano(null, 50);
	        fail("Se esperaba una excepcion CazadorSinNombreException");
	    } catch (CazadorSinNombreException excepcion) {
	        assertEquals("El cazador debe tener un nombre valido", excepcion.getMessage());
	    }
	}

}