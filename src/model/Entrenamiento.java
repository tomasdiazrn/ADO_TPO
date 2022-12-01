package model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import controller.EntrenamientoController;
import controller.ObjetivoController;
import controller.RutinaController;
import model.dao.EjercicioDAO;
import model.dao.EntrenamientoDAO;
import model.vo.EjercicioVO;
import model.vo.EntrenamientoVO;
import model.vo.SocioVO;

public class Entrenamiento {
	
	private ArrayList<EjercicioVO> ejercicios = new ArrayList<>();
    private ObjetivoStrategy objetivo; 
    private EstrategiaObjetivo estrategia;
	private int dia;
 
	public Entrenamiento(int dia, ArrayList<EjercicioVO> ejercicios, EstrategiaObjetivo estrategia) {
		super();
		this.ejercicios = ejercicios;
		this.estrategia = estrategia;
	}

	public Entrenamiento() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<EjercicioVO> getEjercicios(SocioVO socioVo) {
		EjercicioDAO ejercicioDAO = RutinaController.getEjercicioDAO();

		if(socioVo.getEstrategia() == estrategia.BAJAR_PESO) {
			 return ejercicioDAO.getEjerciciosBajarPeso();
		} else if(socioVo.getEstrategia() == estrategia.MANTENER_FIGURA) {
			return ejercicioDAO.getEjerciciosMantenerFigura();
		} else {
			return ejercicioDAO.getEjerciciosTonificarCuerpo();
		} 
	  }
	
	public ArrayList<EntrenamientoVO> getEntrenamiento(SocioVO socioVo) {
		
		EntrenamientoDAO entrenamientoDAO = RutinaController.getEntrenamientoDAO();

		if(socioVo.getEstrategia() == estrategia.BAJAR_PESO) {
			 return entrenamientoDAO.getEntrenamientosBajar();
			 //return ejercicioDao.getEjercicioPendiente();
		} else if(socioVo.getEstrategia() == estrategia.MANTENER_FIGURA) {
			return entrenamientoDAO.getEntrenamientosMantener();
		} else {
			return entrenamientoDAO.getEntrenamientosTonificar();
		}
		 
	  }
	
	  public void reforzarRutina(SocioVO socioVO) {
			for (EjercicioVO ejercicio : getEjercicios(socioVO)) {
				int series = ejercicio.getCantidadSeries()+5;
				int repes = ejercicio.getRepeticiones()+5;
				int peso = ejercicio.getPesoAsignado()+5;
				ejercicio.setCantidadSeries(series);
				ejercicio.setRepeticiones(repes);
				ejercicio.setPesoAsignado(peso);
			}
		}
			
	
	  public boolean marcarEntrenamientoCompletado(SocioVO socioVO) {
		  EntrenamientoVO entrenamientoVO = socioVO.getRutina().get(0).getEntrenamientoActual();
			ArrayList<EjercicioVO> listaEjercicios = this.getEjercicios(socioVO);
			while (!listaEjercicios.isEmpty()) {
				EjercicioVO ejercicioVO = listaEjercicios.get(0);
				
				if (ejercicioVO.getEjercicioCompletado() == true) {
					listaEjercicios.remove(0);
				} else {
					return false;
				}
			}
			
			if (listaEjercicios.isEmpty() == true) {
				entrenamientoVO.setEntrenamientoCompletado(true);
				System.out.println("LISTA VACIA!");
				return true;
			}
			return false;
		} 
	  
	  
	  
	  public ObjetivoStrategy getObjetivo(EntrenamientoVO entrenamiento) {
		  System.out.println(entrenamiento.getObjetivo());
		  return entrenamiento.getObjetivo();
	  }
	  

	public String toString() {
		return "Entrenamiento [ejercicios=" + ejercicios + ", objetivo=" + objetivo + "]";
	}

}

	    
	    
	  
