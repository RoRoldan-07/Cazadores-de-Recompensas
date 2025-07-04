package ar.edu.unlam.pb2.cazadoresRecompensas;

import java.util.ArrayList;
import java.util.Set;

public class Zona {

	private String nombre;
	private ArrayList<Profugo> listaDeProfugos;

	public Zona(String nombre, ArrayList<Profugo> listaDeProfugos) {
		this.nombre = nombre;
		this.listaDeProfugos = listaDeProfugos;
	}

	public ArrayList<Profugo> getProfugos() {
		return this.listaDeProfugos;
	}

	public void eliminarCapturados(Set<Profugo> profugosCapturados) {
		listaDeProfugos.removeAll(profugosCapturados);
	}

}
