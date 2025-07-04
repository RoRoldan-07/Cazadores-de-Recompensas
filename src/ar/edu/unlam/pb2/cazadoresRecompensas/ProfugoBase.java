package ar.edu.unlam.pb2.cazadoresRecompensas;

import java.util.Objects;

public class ProfugoBase implements Profugo {

	protected Integer inocencia;
	private Integer habilidad;
	private boolean nervioso;
	protected String nombre;

	public ProfugoBase(String nombre, Integer inocencia, Integer habilidad, boolean nervioso) {
		this.nombre = nombre;
		this.inocencia = inocencia;
		this.habilidad = habilidad;
		this.nervioso = nervioso;
	}

	public boolean esNervioso() {
		return this.nervioso;
	}

	public int getHabilidad() {
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
		ProfugoBase other = (ProfugoBase) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public void setNervioso(boolean valor) {
		this.nervioso = valor;

	}

	@Override
	public int getInocencia() {
		return this.inocencia;
	}

	@Override
	public void reducirInocencia() {

		this.inocencia = Math.max(0, this.inocencia - 2);
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.nombre;
	}

	@Override
	public void reducirHabilidad(int cantidad) {
		// TODO Auto-generated method stub
		if (cantidad < 0) {
			throw new IllegalArgumentException("Cantidad negativa no permitida");
		}
		this.habilidad = Math.max(0, this.habilidad - cantidad);

	}

}
