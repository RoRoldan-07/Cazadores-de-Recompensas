package ar.edu.unlam.pb2.cazadoresRecompensas;

public class conProteccionLegal implements Profugo {
	private Profugo profugoComun;

	public conProteccionLegal(Profugo profugoComun) {
		this.profugoComun = profugoComun;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return profugoComun.getNombre();
	}

	@Override
	public int getInocencia() {
		// Nunca va ser menor 40.
		return Math.max(40, this.profugoComun.getInocencia());
	}

	@Override
	public int getHabilidad() {
		// TODO Auto-generated method stub
		return this.profugoComun.getHabilidad();
	}

	@Override
	public boolean esNervioso() {
		// TODO Auto-generated method stub
		return this.profugoComun.esNervioso();
	}

	@Override
	public void reducirInocencia() {
		// TODO Auto-generated method stub
		profugoComun.reducirInocencia();

	}

	@Override
	public void reducirHabilidad(int cantidad) {
		// TODO Auto-generated method stub
		profugoComun.reducirHabilidad(cantidad);

	}

	@Override
	public void setNervioso(boolean valor) {
		this.profugoComun.setNervioso(valor);
	}
}
