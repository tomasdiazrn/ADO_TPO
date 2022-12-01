package model;


public class Notificador {
	private IAdapterNotificacion estrategia = new AdapterFirebase();
	
	public void enviarCreido() {
		this.estrategia.enviarCreido();
	}
	
	public void enviarDedicacion() {
		this.estrategia.enviarDedicacion();
	}
	
	public void enviarConstancia() {
		this.estrategia.enviarConstancia();
	}
	

}
