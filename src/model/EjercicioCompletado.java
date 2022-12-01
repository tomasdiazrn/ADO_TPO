package model;

import java.time.LocalDate;

import controller.RutinaController;
import model.dao.EjercicioDAO;
import model.vo.EjercicioCompletadoVO;

public class EjercicioCompletado {
	
	private LocalDate fecha;
	private Integer repeticiones;
	private Integer peso;
	private Integer series;
	
	
	public EjercicioCompletado(EjercicioCompletadoVO ejercicioCompletadoVO) {
		this.fecha = ejercicioCompletadoVO.getFecha();
		this.repeticiones = ejercicioCompletadoVO.getRepeticiones();
		this.peso = ejercicioCompletadoVO.getPesoAsignado();
		this.series = ejercicioCompletadoVO.getCantidadSeries();
	}
	
	public EjercicioCompletado(LocalDate fecha, Integer repeticiones, Integer peso, Integer series) {
		super();
		this.fecha = fecha;
		this.repeticiones = repeticiones;
		this.peso = peso;
		this.series = series;
	}
	
	public void agregarEjercicioCompletado(EjercicioCompletadoVO ejercicioCompletadoVO) {
		EjercicioDAO ejercicioDAO = RutinaController.getEjercicioDAO();
		ejercicioDAO.agregarEjercicioCompletado(ejercicioCompletadoVO);
	}

}


