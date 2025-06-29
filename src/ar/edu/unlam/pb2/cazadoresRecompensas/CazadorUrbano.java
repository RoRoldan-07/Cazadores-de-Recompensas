package ar.edu.unlam.pb2.cazadoresRecompensas;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CazadorUrbano {

	private String nombre;
	private Integer experiencia;
	private Set<Profugo> ProfugosCapturados = new HashSet<Profugo>();
	private ArrayList<Profugo> ProfugosIntimidados = new ArrayList<Profugo>();

	public CazadorUrbano(String nombre, Integer experiencia) {
		this.nombre = nombre;
		this.experiencia = experiencia;
	}

	public Object getExperiencia() {
		return this.experiencia;
	}

	public boolean cazar(Profugo profugo1) {
		if(this.experiencia > profugo1.getInocencia() && profugo1.esNervioso() == false) {
			ProfugosCapturados.add(profugo1);
			sumarExperiencia();
			return true;
		}
		else {
			profugo1.reducirInocencia();
			profugo1.setNervioso(false);
			ProfugosIntimidados.add(profugo1);
	
			return false;
		}
	}

	private void sumarExperiencia() {
		Integer habilidadMinima = null;
		Integer totalProfugosCapturados = 0;
		
		for(int i=0; i<ProfugosIntimidados.size(); i++) {
			
			if(habilidadMinima==null || ProfugosIntimidados.get(i).getHabilidad() < habilidadMinima) {
				habilidadMinima = ProfugosIntimidados.get(i).getHabilidad();
			}
		}
		totalProfugosCapturados = ProfugosCapturados.size();
		if(habilidadMinima==null) {
			habilidadMinima = 0;
		}
		this.experiencia += (habilidadMinima) + (2 * totalProfugosCapturados);
	}
	

	public Object buscarCapturado(Profugo profugo1) {
		if(ProfugosCapturados.contains(profugo1)) {
			return profugo1;
		}
		return null;
	}

	public Object buscarIntimidados(Profugo profugo1) {
		if(ProfugosIntimidados.contains(profugo1)) {
			return profugo1;
		}
		return null;
	}

}
