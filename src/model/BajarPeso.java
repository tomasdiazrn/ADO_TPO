package model;

import model.vo.SocioVO;

public class BajarPeso extends ObjetivoStrategy {
	IAdapterMedicion medicion = new AdapterMedicion();
	
    @Override
    public boolean seCompleto(SocioVO socio) {
    	double pesoIdeal = medicion.getPesoIdeal(socio);
    	int lastIndex = socio.getMedicion().size()-1;

    	return socio.getMedicion().get(lastIndex).getPeso() <= pesoIdeal;
    }
    
    // Calculo para el peso ideal
    // Mujeres:  Altura en cm - 100 - ((Altura en cm - 150) /2,5 )
    // Hombres: Altura en cm - 100 - ((Altura en cm - 150) /4 )
    
    public String toString() {
		return "Bajar de Peso";
	}

}
