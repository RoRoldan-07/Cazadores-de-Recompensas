package ar.edu.unlam.pb2.cazadoresRecompensas;

public interface Profugo {

	String getNombre();

	int getInocencia();

	int getHabilidad();

	boolean esNervioso();

	void reducirInocencia();

	void reducirHabilidad(int cantidad);

	public void reducirHabilidad() {
		if(this.habilidad >= 5) {
			this.habilidad = this.habilidad - 5;
		}
		else {
			this.habilidad = 0;
		}
		
		
	}

	void setNervioso(boolean b);

}
