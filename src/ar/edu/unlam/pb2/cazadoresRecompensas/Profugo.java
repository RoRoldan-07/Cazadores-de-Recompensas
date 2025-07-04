package ar.edu.unlam.pb2.cazadoresRecompensas;

public interface Profugo {

	String getNombre();

	int getInocencia();

	int getHabilidad();

	boolean esNervioso();

	void reducirInocencia();

	void reducirHabilidad(int cantidad);

	void setNervioso(boolean b);

}
