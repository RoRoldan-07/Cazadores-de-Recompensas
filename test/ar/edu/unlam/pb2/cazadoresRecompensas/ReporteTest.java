package ar.edu.unlam.pb2.cazadoresRecompensas;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

public class ReporteTest {

	@Test
	public void queSePuedaObtenerElListadoDeTodosLosProfugosCapturados() {
		Cazador c1 = new CazadorUrbano("Juan", 50);
		Cazador c2 = new CazadorRural("Pedro", 60);

		ProfugoBase p1 = new ProfugoBase("Carlos", 30, 60, false);
		ProfugoBase p2 = new ProfugoBase("Luis", 35, 65, true);
		ProfugoBase p3 = new ProfugoBase("Santi", 20, 50, true);

		c1.cazar(p1); // capturado
		c2.cazar(p2); // capturado
		c2.cazar(p3); // capturado

		AgenciaDeSeguridad agencia = new AgenciaDeSeguridad();
		agencia.agregarCazador(c1);
		agencia.agregarCazador(c2);

		Set<Profugo> capturados = agencia.obtenerTodosLosCapturados();

		assertTrue(capturados.contains(p1));
		assertTrue(capturados.contains(p2));
		assertTrue(capturados.contains(p3));
		assertEquals(3, capturados.size());
	}

	@Test
	public void queSePuedaObtenerProfugoMasHabilCapturado() {
		AgenciaDeSeguridad agencia = new AgenciaDeSeguridad();

		Cazador cazador = new CazadorUrbano("Ana", 60);
		Profugo p1 = new ProfugoBase("Juan", 30, 40, false);
		Profugo p2 = new ProfugoBase("Pedro", 20, 80, false);

		cazador.cazar(p1);
		cazador.cazar(p2);

		agencia.agregarCazador(cazador);

		Profugo masHabil = agencia.ProfugoMasHabilCapturado();
		assertEquals(p2, masHabil);
	}

	@Test
	public void queSePuedaObtenerElCazadorConMasCapturas() {
		AgenciaDeSeguridad agencia = new AgenciaDeSeguridad();

		Cazador cazador1 = new CazadorUrbano("Ana", 60);
		Cazador cazador2 = new CazadorUrbano("Luis", 70);

		Profugo p1 = new ProfugoBase("Juan", 30, 40, false);
		Profugo p2 = new ProfugoBase("Pedro", 20, 70, false);
		Profugo p3 = new ProfugoBase("Luis", 10, 70, false);

		cazador1.cazar(p1);
		cazador2.cazar(p2);
		cazador2.cazar(p3);

		agencia.agregarCazador(cazador1);
		agencia.agregarCazador(cazador2);

		Cazador masActivo = agencia.obtenerCazadorConMasCapturas();
		assertEquals(cazador2, masActivo);
	}

}
