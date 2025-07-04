package ar.edu.unlam.pb2.cazadoresRecompensas;

public class conEntrenamientoDeElite implements Profugo {
	private Profugo profugoComun;

	public conEntrenamientoDeElite(Profugo profugoComun) {
		this.profugoComun = profugoComun;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return this.profugoComun.getNombre();
	}

	@Override
	public int getInocencia() {
		// TODO Auto-generated method stub
		return this.profugoComun.getInocencia();
	}

	@Override
	public int getHabilidad() {
		// TODO Auto-generated method stub
		return this.profugoComun.getHabilidad();
	}

	@Override
	public boolean esNervioso() {
		// nunca es nervioso
		return false;
	}

	@Override
	public void reducirInocencia() {
		profugoComun.reducirInocencia();

	}

	@Override
	public void reducirHabilidad(int cantidad) {
		// TODO Auto-generated method stub
		profugoComun.reducirHabilidad(cantidad);

	}

}
