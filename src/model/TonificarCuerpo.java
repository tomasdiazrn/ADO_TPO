package model;

import model.vo.SocioVO;

public class TonificarCuerpo extends ObjetivoStrategy {

   
    @Override
    public boolean seCompleto(SocioVO socio) {
    	IAdapterMedicion medicion = new AdapterMedicion();
    	Double masaCorporalIdeal = medicion.getMasaIdeal(socio);
    	Double grasaCorporalIdeal = medicion.getPorcentajeGrasa(socio);
    	int lastIndex = socio.getMedicion().size()-1;
        return socio.getMedicion().get(lastIndex).getMasaMuscular() >= masaCorporalIdeal && socio.getMedicion().get(lastIndex).getGrasa() <= grasaCorporalIdeal;
    }

    
    public String toString() {
		return "Tonificar Cuerpo";
	}
}
