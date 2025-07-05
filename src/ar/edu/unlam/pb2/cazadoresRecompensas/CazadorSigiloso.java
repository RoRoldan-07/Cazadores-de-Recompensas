package ar.edu.unlam.pb2.cazadoresRecompensas;

import java.util.HashSet;
import java.util.Set;

public class CazadorSigiloso extends Cazador{


	public CazadorSigiloso(String nombre, Integer experiencia) throws ValorInvalidoException, CazadorSinNombreException {
		super(nombre, experiencia);
		}

	@Override
	public boolean cazar(Profugo profugo1) throws ProfugoNuloException {
		
		 if (profugo1 == null) {
		        throw new ProfugoNuloException("No se puede cazar un profugo nulo.");
		    }
		 
		if(this.experiencia > profugo1.getInocencia() && profugo1.getHabilidad()<50) {
			profugosCapturados.add(profugo1);
			return true;
		}
		else {
			profugo1.reducirHabilidad(5);
			profugosIntimidados.add(profugo1);
	
			return false;
		}
	}
}
