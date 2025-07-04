package ar.edu.unlam.pb2.cazadoresRecompensas;

import java.util.HashSet;
import java.util.Set;

public abstract class Cazador {

	protected String nombre;
	protected Integer experiencia;
	protected Set<Profugo> profugosCapturados = new HashSet<Profugo>();
	protected Set<Profugo> profugosIntimidados = new HashSet<Profugo>();
	
	
	public Cazador(String nombre, Integer experiencia) {
		this.nombre = nombre;
		this.experiencia = experiencia;
	}
	
	public Integer getExperiencia() {
		return this.experiencia;
	}
	
	public Object buscarCapturado(Profugo profugo1) {
		if(profugosCapturados.contains(profugo1)) {
			return profugo1;
		}
		return null;
	}

	public Object buscarIntimidados(Profugo profugo1) {
		if(profugosIntimidados.contains(profugo1)) {
			return profugo1;
		}
		return null;
	}
	
	protected void sumarExperiencia() {
		Integer habilidadMinima = null;
		Integer totalProfugosCapturados = 0;
		
		for (Profugo p : profugosIntimidados) {
			
			if(habilidadMinima==null || p.getHabilidad() < habilidadMinima) {
				habilidadMinima = p.getHabilidad();
			}
		}
		totalProfugosCapturados = profugosCapturados.size();
		if(habilidadMinima==null) {
			habilidadMinima = 0;
		}
		this.experiencia += (habilidadMinima) + (2 * totalProfugosCapturados);
	}
	
	public void cazarEnZona(Zona zona) {
		for (Profugo profugo : zona.getProfugos()) {
			cazar(profugo);
		}
		zona.eliminarCapturados(profugosCapturados);
		sumarExperiencia();
	}

	public abstract boolean cazar(Profugo profugo);
	
}
