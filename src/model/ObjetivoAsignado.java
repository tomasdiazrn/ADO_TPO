package model;

import java.util.ArrayList;

import model.vo.SocioVO;

public class ObjetivoAsignado {
	private Socio socio;
	private ObjetivoStrategy objetivo;
	private ArrayList<Trofeo> observadores;
	
	public ObjetivoAsignado() {
		this.objetivo = objetivo;
		this.socio = socio;
		this.observadores = new ArrayList<>();
		this.observadores.add(new TrofeoDedicacion());
	}
	
	public void setObjetivo(ObjetivoStrategy objetivo) {
		this.objetivo = objetivo;
	}
	
	
	public ObjetivoStrategy getObjetivo() {
		return objetivo;
	}


	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}


	public boolean seCompleto(SocioVO socio) {
		boolean completado = objetivo.seCompleto(socio);
		notificar(socio);
		return completado;
	}
	
	
	
	  public void notificar(SocioVO socio) {
		  for(Trofeo observador:observadores){
			  observador.setObj(socio.getObjetivo());
			  observador.setSocio(socio);
			  observador.verificarCumplimiento(); } }
	  
	
	
	

}
