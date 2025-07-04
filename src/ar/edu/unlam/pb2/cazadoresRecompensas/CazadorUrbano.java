package ar.edu.unlam.pb2.cazadoresRecompensas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CazadorUrbano {

	private String nombre;
	private Integer experiencia;
	private Set<ProfugoBase> profugosCapturados = new HashSet<ProfugoBase>();
	private Set<ProfugoBase> profugosIntimidados = new HashSet<ProfugoBase>();

	public CazadorUrbano(String nombre, Integer experiencia) {
		this.nombre = nombre;
		this.experiencia = experiencia;
	}

	public Integer getExperiencia() {
		return this.experiencia;
	}

	public boolean cazar(ProfugoBase profugo1) {
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

	private void sumarExperiencia() {
		Integer habilidadMinima = null;
		Integer totalProfugosCapturados = 0;
		
		for (ProfugoBase p : profugosIntimidados) {
			
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
	

	public Object buscarCapturado(ProfugoBase profugo1) {
		if(profugosCapturados.contains(profugo1)) {
			return profugo1;
		}
		return null;
	}

	public Object buscarIntimidados(ProfugoBase profugo1) {
		if(profugosIntimidados.contains(profugo1)) {
			return profugo1;
		}
		return null;
	}

	public void cazarEnZona(Zona zona) {
		for (ProfugoBase profugo : zona.getProfugos()) {
			cazar(profugo);
		}
		zona.eliminarCapturados(profugosCapturados);
		sumarExperiencia();
	}

}
