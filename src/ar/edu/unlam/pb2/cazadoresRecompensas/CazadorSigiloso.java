package ar.edu.unlam.pb2.cazadoresRecompensas;

import java.util.HashSet;
import java.util.Set;

public class CazadorSigiloso extends Cazador{


	public CazadorSigiloso(String nombre, Integer experiencia) {
		super(nombre, experiencia);
		}

	@Override
	public boolean cazar(Profugo profugo1) {
		if(this.experiencia > profugo1.getInocencia() && profugo1.getHabilidad()<50) {
			profugosCapturados.add(profugo1);
			return true;
		}
		else {
			profugo1.reducirHabilidad();
			profugosIntimidados.add(profugo1);
	
			return false;
		}
	}
}
