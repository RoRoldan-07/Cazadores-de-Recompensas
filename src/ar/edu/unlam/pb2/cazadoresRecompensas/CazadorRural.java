package ar.edu.unlam.pb2.cazadoresRecompensas;

import java.util.HashSet;
import java.util.Set;

public class CazadorRural {

	private String nombre;
	private Integer experiencia;
	private Set<Profugo> profugosCapturados = new HashSet<Profugo>();
	private Set<Profugo> profugosIntimidados = new HashSet<Profugo>();

	public CazadorRural(String nombre, Integer experiencia) {
		this.nombre = nombre;
		this.experiencia = experiencia;
	}

	public Integer getExperiencia() {
		return this.experiencia;
	}

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
	
	private void sumarExperiencia() {
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

	public void cazarEnZona(Zona zona1) {
		for (Profugo profugo : zona1.getProfugos()) {
			cazar(profugo);
		}
		sumarExperiencia();
		zona1.eliminarCapturados(profugosCapturados);
		
	}

}
