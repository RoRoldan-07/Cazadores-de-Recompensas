package ar.edu.unlam.pb2.cazadoresRecompensas;

import java.util.HashSet;
import java.util.Set;

public class CazadorRural extends Cazador{

	
	public CazadorRural(String nombre, Integer experiencia) {
		super(nombre, experiencia);
	}

	@Override
	public boolean cazar(Profugo profugo1) {
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
