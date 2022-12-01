package controller;

import model.Ejercicio;
import model.EjercicioCompletado;
import model.dao.EjercicioDAO;
import model.vo.EjercicioCompletadoVO;
import model.vo.EjercicioVO;

public class EjercicioController {
	
	private EjercicioDAO ejercicioDAO = new EjercicioDAO();
	private EjercicioCompletado ejercicioCompletado;
	private Ejercicio ejercicio;
	
	public EjercicioController() {
		ejercicioCompletado = new EjercicioCompletado(null,null,null,null);
		ejercicio = new Ejercicio(null, 0, 0, 0, 0, 0, null, null);
	}

	public Ejercicio getLogica() {
		return ejercicio;
	}
	
	public void agregarEjercicioCompletado(EjercicioCompletadoVO ejercicioCompletadoVO) {
		ejercicioCompletado.agregarEjercicioCompletado(ejercicioCompletadoVO);
	}
	
	public void marcarEjercicioCompletado(EjercicioVO ejercicioVO) {
		ejercicioVO.setEjercicioCompletado(true);
		
	}
	
	public EjercicioVO getEjercicio(String nombre) {
		return ejercicioDAO.getEjercicio(nombre);
	}

}
