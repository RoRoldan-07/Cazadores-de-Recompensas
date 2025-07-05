package ar.edu.unlam.pb2.cazadoresRecompensas;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class AgenciaDeSeguridad {
	private Set<Cazador> cazadores;

	public AgenciaDeSeguridad() {

		this.cazadores = new HashSet<>();
	}

	public Set<Profugo> obtenerTodosLosCapturados() {
		Set<Profugo> resultado = new HashSet<>();
		for (Cazador cazador : cazadores) {
			resultado.addAll(cazador.profugosCapturados);
		}
		return resultado;
	}

	public void agregarCazador(Cazador cazador) {
		// TODO Auto-generated method stub
		cazadores.add(cazador);

	}

	public Profugo ProfugoMasHabilCapturado() {
		// TODO Auto-generated method stub
		return obtenerTodosLosCapturados().stream().max(Comparator.comparingInt(Profugo::getHabilidad)).orElse(null);
	}

	public Cazador obtenerCazadorConMasCapturas() {
		// TODO Auto-generated method stub
		return cazadores.stream().max(Comparator.comparingInt(c -> c.getProfugosCapturados().size())).orElse(null);
	}
}
