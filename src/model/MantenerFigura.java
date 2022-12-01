package model;

import model.vo.SocioVO;

public class MantenerFigura extends ObjetivoStrategy{
	
	private static int n = 10;

	@Override
	public boolean seCompleto(SocioVO socio) {
		int lastIndex = socio.getMedicion().size()-1;
		return (socio.getMedicion().get(0).getPeso() < socio.getMedicion().get(lastIndex).getPeso() + n || socio.getMedicion().get(0).getPeso() > socio.getMedicion().get(lastIndex).getPeso() - n);
	}
	
	public String toString() {
		return "Mantener Figura";
	}

}
