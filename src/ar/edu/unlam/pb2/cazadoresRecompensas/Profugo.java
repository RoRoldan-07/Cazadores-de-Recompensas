package ar.edu.unlam.pb2.cazadoresRecompensas;

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

}
