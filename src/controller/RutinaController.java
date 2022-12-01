package controller;

import java.util.ArrayList;

import model.EstrategiaObjetivo;
import model.ObjetivoStrategy;
import model.Rutina;
import model.dao.EjercicioDAO;
import model.dao.EntrenamientoDAO;
import model.dao.RutinaDAO;
import model.vo.EntrenamientoVO;
import model.vo.RutinaVO;
import model.vo.SocioVO;

public class RutinaController {
	private Rutina rutina;
	private RutinaDAO rutinaDAO = new RutinaDAO();
	private static EjercicioDAO ejercicioDAO = new EjercicioDAO();
	private static EntrenamientoDAO entrenamientoDAO = new EntrenamientoDAO();
	
	public RutinaController() {
		rutinaDAO.getRutinas();
		ejercicioDAO.cargaInicial();
		entrenamientoDAO.cargaInicial();
		rutina = new Rutina();
	}
	
	public ArrayList<RutinaVO> getRutina(SocioVO socio){
		return rutina.getRutina(socio);
	}
	
	public static EjercicioDAO getEjercicioDAO(){
		return ejercicioDAO;
		
	}
	
	public static EntrenamientoDAO getEntrenamientoDAO(){
		return entrenamientoDAO;	
	}
	
	public void rutinaCompletada(SocioVO socioVO) {
		rutina.rutinaCompletada(socioVO);
	}
	
}
