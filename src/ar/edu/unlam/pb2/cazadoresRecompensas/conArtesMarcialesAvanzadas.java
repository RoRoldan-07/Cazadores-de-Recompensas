package ar.edu.unlam.pb2.cazadoresRecompensas;

public class conArtesMarcialesAvanzadas implements Profugo {
	private Profugo profugoComun;

	public conArtesMarcialesAvanzadas(Profugo profugoComun) {
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
		return Math.min(100, profugoComun.getHabilidad() * 2);
	}

	@Override
	public boolean esNervioso() {
		// TODO Auto-generated method stub

		return this.profugoComun.esNervioso();
	}

	@Override
	public void reducirInocencia() {
		// TODO Auto-generated method stub
		this.profugoComun.reducirInocencia();

	}

	@Override
	public void reducirHabilidad(int cantidad) {
		// TODO Auto-generated method stub
		this.profugoComun.reducirHabilidad(cantidad);
	}
	
	@Override
	public void setNervioso(boolean valor) {
		this.profugoComun.setNervioso(valor);
	}

}
