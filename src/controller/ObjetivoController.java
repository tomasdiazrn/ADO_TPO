package controller;

import model.BajarPeso;
import model.IAdapterNotificacion;
import model.EstrategiaObjetivo;
import model.AdapterFirebase;
import model.MantenerFigura;
import model.Notificador;
import model.ObjetivoAsignado;
import model.ObjetivoStrategy;
import model.TonificarCuerpo;
import model.vo.EntrenamientoVO;
import model.vo.SocioVO;

public class ObjetivoController {
	private ObjetivoAsignado objetivoAsignado;
	private ObjetivoStrategy objetivoBajar;
	private ObjetivoStrategy objetivoTonificar;
	private ObjetivoStrategy objetivoMantener;
	private EntrenamientoVO entrenamiento = new EntrenamientoVO();
	private EstrategiaObjetivo estrategia;

	public ObjetivoController() {
		objetivoAsignado = new ObjetivoAsignado();
		objetivoBajar = new BajarPeso();
		objetivoTonificar = new TonificarCuerpo();
		objetivoMantener = new MantenerFigura();	
	}
	
	public void getObjetivoBajarPeso() {
		objetivoBajar = new BajarPeso();
		entrenamiento.setEstrategia(estrategia.BAJAR_PESO);	
	}
	
	public void getObjetivoTonificar() {
		objetivoTonificar = new TonificarCuerpo();
		entrenamiento.setEstrategia(estrategia.TONIFICAR_CUERPO);
	}
	
	public void getObjetivoMantener() {
		objetivoMantener = new MantenerFigura();
		entrenamiento.setEstrategia(estrategia.MANTENER_FIGURA);	
	}
	
	public void elegirEstrategia() {
    	switch(entrenamiento.getEstrategiaElegida()) {
    		case BAJAR_PESO: objetivoAsignado.setObjetivo(objetivoBajar); break;
    		case MANTENER_FIGURA: objetivoAsignado.setObjetivo(objetivoMantener); break;
    		case TONIFICAR_CUERPO: objetivoAsignado.setObjetivo(objetivoTonificar); break;
    	}
    }
	
	public boolean seCompleto(SocioVO socio) {
		if(objetivoAsignado.seCompleto(socio)) {
			objetivoAsignado.setObjetivo(objetivoMantener);
			return true;
		}
		else {
			return false;
		}
	}
	
	public ObjetivoStrategy getObjBajar() {
		return objetivoAsignado.getObjetivo();
	}
	
	public ObjetivoStrategy getObjMantener() {
		return objetivoAsignado.getObjetivo();
	}
	
	public ObjetivoStrategy getObjTonificar() {
		return objetivoAsignado.getObjetivo();
	}
	
	public EstrategiaObjetivo getEstrategiaBajar() {
		return estrategia.BAJAR_PESO;
	}
	
	public EstrategiaObjetivo getEstrategiaMantener() {
		return estrategia.MANTENER_FIGURA;
	}
	
	public EstrategiaObjetivo getEstrategiaTonificar() {
		return estrategia.TONIFICAR_CUERPO;
	}

}
