package ar.edu.unlam.pb2.cazadoresRecompensas;

import java.util.ArrayList;
import java.util.Set;

public class Zona {

	private String nombre;
	private ArrayList<ProfugoBase> listaDeProfugos;

	public Zona(String nombre, ArrayList<ProfugoBase> listaDeProfugos) {
		this.nombre = nombre;
		this.listaDeProfugos = listaDeProfugos;
	}

	public ArrayList<ProfugoBase> getProfugos() {
		return this.listaDeProfugos;
	}

	public void eliminarCapturados(Set<ProfugoBase> profugosCapturados) {
		listaDeProfugos.removeAll(profugosCapturados);
	}

}
