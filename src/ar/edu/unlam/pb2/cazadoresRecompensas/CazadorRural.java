package ar.edu.unlam.pb2.cazadoresRecompensas;

import java.util.HashSet;
import java.util.Set;


public class CazadorRural extends Cazador{

	
	public CazadorRural(String nombre, Integer experiencia) throws ValorInvalidoException, CazadorSinNombreException {
		super(nombre, experiencia);
	}


	@Override
	public boolean cazar(Profugo profugo1) throws ProfugoNuloException {

		 if (profugo1 == null) {
		        throw new ProfugoNuloException("No se puede cazar un profugo nulo.");
		    }
		 
		if(this.experiencia > profugo1.getInocencia() && profugo1.esNervioso() == true) {
			profugosCapturados.add(profugo1);
			return true;
		}
		else {
			profugo1.setNervioso(true);
			profugosIntimidados.add(profugo1);
			return false;
		}
	}
}
