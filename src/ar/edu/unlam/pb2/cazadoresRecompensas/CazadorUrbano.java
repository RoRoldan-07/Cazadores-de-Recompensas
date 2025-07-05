package ar.edu.unlam.pb2.cazadoresRecompensas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class CazadorUrbano extends Cazador {


	public CazadorUrbano(String nombre, Integer experiencia) throws ValorInvalidoException, CazadorSinNombreException {
		super(nombre, experiencia);
	}

	@Override
	public boolean cazar(Profugo profugo1) throws ProfugoNuloException {
		
		 if (profugo1 == null) {
		        throw new ProfugoNuloException("No se puede cazar un profugo nulo.");
		    }

		if(this.experiencia > profugo1.getInocencia() && profugo1.esNervioso() == false) {
			profugosCapturados.add(profugo1);
			return true;
		}
		else {
			profugo1.reducirInocencia();
			profugo1.setNervioso(false);
			profugosIntimidados.add(profugo1);
	
			return false;
		}
	}
}
