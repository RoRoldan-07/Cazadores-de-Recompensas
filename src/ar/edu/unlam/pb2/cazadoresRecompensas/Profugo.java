package ar.edu.unlam.pb2.cazadoresRecompensas;

import java.util.Objects;

public class Profugo {

	private Integer inocencia;
	private Integer habilidad;
	private boolean nervioso;
	private String nombre;

	public Profugo(String nombre, Integer inocencia, Integer habilidad, boolean nervioso) {
		this.nombre = nombre;
		this.inocencia = inocencia;
		this.habilidad = habilidad;
		this.nervioso = nervioso;
	}

	public boolean esNervioso() {
		return this.nervioso;
	}

	public Integer getHabilidad() {
		return this.habilidad;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profugo other = (Profugo) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public Integer getInocencia() {
		return this.inocencia;
	}

	public void reducirInocencia() {
		if(this.inocencia >= 2) {
			this.inocencia = this.inocencia - 2;
		}
		else {
			this.inocencia = 0;
		}
	}

	public void setNervioso(boolean valor) {
		this.nervioso = valor;
		
	}

	public void reducirHabilidad() {
		if(this.habilidad >= 5) {
			this.habilidad = this.habilidad - 5;
		}
		else {
			this.habilidad = 0;
		}
		
		
	}

}
