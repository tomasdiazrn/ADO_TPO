package model;

import java.util.ArrayList;

import controller.RutinaController;
import model.dao.EntrenamientoDAO;
import model.dao.RutinaDAO;
import model.vo.EntrenamientoVO;
import model.vo.RutinaVO;
import model.vo.SocioVO;

public class Rutina {
	private static int duracion = 4;
	private EntrenamientoDAO entrenamientoDAO = RutinaController.getEntrenamientoDAO();
	private ArrayList<EntrenamientoVO> entrenamientos;
	private ArrayList<Trofeo> observadores;
	
	private EstrategiaObjetivo obj;
	RutinaDAO rutinaDao = new RutinaDAO();
	
	
	public Rutina() {
		ArrayList<EntrenamientoVO> entrenamientos = entrenamientoDAO.getEntrenamientos();
		this.entrenamientos = entrenamientos;
		this.observadores = new ArrayList<>();
		this.observadores.add(new TrofeoConstancia());
	}
	
	public ArrayList<EntrenamientoVO> getEntrenamientos(SocioVO socioVO) {
		
		if (obj.BAJAR_PESO == socioVO.getEstrategia()) {
			ArrayList<EntrenamientoVO> listaEntrenamientos = entrenamientoDAO.getEntrenamientosBajar(); 
			return listaEntrenamientos;
		}
		
		else if (obj.TONIFICAR_CUERPO == socioVO.getEstrategia()) {
			ArrayList<EntrenamientoVO> listaEntrenamientos = entrenamientoDAO.getEntrenamientosTonificar();
			return listaEntrenamientos;
		}
		
		else if (obj.MANTENER_FIGURA == socioVO.getEstrategia()) {
			ArrayList<EntrenamientoVO> listaEntrenamientos = entrenamientoDAO.getEntrenamientosMantener();
			return listaEntrenamientos;
		}
		
		return null;
	}
	
	
	public boolean seCompleto(SocioVO socioVO) {
		ArrayList<EntrenamientoVO> listaEntrenamientos = this.getEntrenamientos(socioVO);
		Entrenamiento entrenamiento = new Entrenamiento();
		if(!entrenamiento.marcarEntrenamientoCompletado(socioVO)) {
			return false;
		}
		for (int i=0; i < listaEntrenamientos.size();i++ ) {
			if (listaEntrenamientos.get(0).getEntrenamientoCompletado()) {
				RutinaVO rutina = socioVO.getRutina().get(0);
				rutina.setRutinaCompletada(true);
				System.out.println("Completaste la rutina!");
				return true;
			} 
				
		}
		return false;
		}
	
	public void rutinaCompletada(SocioVO socioVO) {
		notificar(socioVO);
	}
	
	public void notificar(SocioVO socioVO) {
		  for(Trofeo observador:observadores){
			  observador.setSocio(socioVO);
			  observador.setRutina(this);
			  System.out.println(this);
			  observador.verificarCumplimiento(); } }
	  

	public ArrayList<RutinaVO> getRutina(SocioVO usuario){
		if(usuario.getEstrategia()== obj.BAJAR_PESO) {
			return rutinaDao.getRutinasBajar();
		} else if(usuario.getEstrategia()== obj.MANTENER_FIGURA) {
			return rutinaDao.getRutinasMantener();
		} else if(usuario.getEstrategia()== obj.TONIFICAR_CUERPO) {
			return rutinaDao.getRutinasTonificar();
		}
		return null;

	}


	@Override
	public String toString() {
		return "Rutina [entrenamientos=" + entrenamientos +  "]";
	}


}
