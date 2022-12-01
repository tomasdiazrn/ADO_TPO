package model;

import model.vo.RutinaVO;
import model.vo.SocioVO;

public abstract class Trofeo {
	private Notificador notificador = new Notificador();
	private SocioVO socio;
	private ObjetivoStrategy obj;
	private Rutina rutina;
	
	
	
	 public Rutina getRutina() {
		return rutina;
	}

	public void setRutina(Rutina rutina) {
		this.rutina = rutina;
	}

	public SocioVO getSocio() {
		return socio;
	}

	public void setSocio(SocioVO socio) {
		this.socio = socio;
	}

	public ObjetivoStrategy getObj() {
		return obj;
	}

	public void setObj(ObjetivoStrategy obj) {
		this.obj = obj;
	}

	public abstract void verificarCumplimiento();
	 
	 public void enviarCreido() {
		 notificador.enviarCreido();
	 }
	 

	 public void enviarDedicacion() {
		 notificador.enviarDedicacion();
	 }

	 public void enviarConstancia() {
		 notificador.enviarConstancia();
	 }
}
