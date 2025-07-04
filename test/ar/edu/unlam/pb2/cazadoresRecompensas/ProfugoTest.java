package ar.edu.unlam.pb2.cazadoresRecompensas;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ProfugoTest {

	@Test
	public void CreacionDeUnProfugoBaseYSeAgregaAlistaDeProfugos() {
		ProfugoBase profugo = new ProfugoBase("rodrigo", 20, 50, false);
		ArrayList<ProfugoBase> listaDeProfugos = new ArrayList<ProfugoBase>();
		listaDeProfugos.add(profugo);

		assertTrue(listaDeProfugos.add(profugo));

	}

	@Test
	public void CreacionDeUnProfugoQueSeLeAgregaArtesMarciales() {
		Profugo profugo = new ProfugoBase("rodrigo", 20, 20, true);
		Profugo profugoEvolucionado = new conArtesMarcialesAvanzadas(profugo);

		assertEquals(40, profugoEvolucionado.getHabilidad());
	}

	@Test
	public void CreacionDeUnProfugoQueSeLeAgregaEntrenamientoDeElite() {
		Profugo profugo = new ProfugoBase("rodrigo", 20, 20, true);
		Profugo profugoEvolucionado = new conEntrenamientoDeElite(profugo);

		assertFalse(profugoEvolucionado.esNervioso());

	}

	@Test
	public void CreacionDeUnProfugoQueSeLeAgregaProtecciónLegal() {
		Profugo profugo = new ProfugoBase("rodrigo", 20, 20, true);
		Profugo profugoEvolucionado = new conProteccionLegal(profugo);

		assertEquals(40, profugoEvolucionado.getInocencia());

	}

}
