package model;

import model.vo.SocioVO;

public class AdapterMedicion implements IAdapterMedicion{
	
	public Double getPesoIdeal(SocioVO socio) { 
		Double peso = Math.random()*(((socio.getMedicion().get(0).getPeso()-30)-(socio.getMedicion().get(0).getPeso()-40)))+(socio.getMedicion().get(0).getPeso()-40); //valor entre M y N
		return peso;
	}
	
	public Double getMasaIdeal(SocioVO socio) {
		Double masa = Math.random()*((socio.getMedicion().get(0).getMasaMuscular()+30)-(socio.getMedicion().get(0).getMasaMuscular()+15))+(socio.getMedicion().get(0).getMasaMuscular()+15); //valor entre M y N
		return masa;
	}
	public Double getPorcentajeGrasa(SocioVO socio) {
		Double grasa = Math.random()*((socio.getMedicion().get(0).getGrasa()-15)-(socio.getMedicion().get(0).getGrasa()-20))+(socio.getMedicion().get(0).getGrasa()-20); //valor entre M y N
		return grasa;
	}

	
	

}
