package model;

import model.vo.SocioVO;

public interface IAdapterMedicion {
	Double getPesoIdeal(SocioVO socio);
	Double getMasaIdeal(SocioVO socio);
	Double getPorcentajeGrasa(SocioVO socio);

}
