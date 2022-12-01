package controller;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Entrenamiento;
import model.dao.EjercicioDAO;
import model.vo.EjercicioVO;
import model.vo.EntrenamientoVO;
import model.vo.SocioVO;


public class EntrenamientoController {
	
	private Entrenamiento entrenamiento;

	public EntrenamientoController() {
		entrenamiento = new Entrenamiento();
	}

	public ArrayList<EjercicioVO> getEjerciciosVO(SocioVO socioVo){
		return entrenamiento.getEjercicios(socioVo);
	}

	public void getEjercicios(JTable table, SocioVO socioVO) {
		EjercicioDAO ejercicioDAO = RutinaController.getEjercicioDAO();
		ArrayList<EjercicioVO> ejercicios = ejercicioDAO.getEjercicios();
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		for (int i = 0; i < ejercicios.size(); i++) {
			EjercicioVO ejercicio = ejercicios.get(i);
			String nombre = ejercicio.getNombre();
			String series = String.valueOf(ejercicio.getCantidadSeries());
			String repeticiones = String.valueOf(ejercicio.getRepeticiones());
			String peso = String.valueOf(ejercicio.getPesoAsignado());
			String tiempo = String.valueOf(ejercicio.getTiempo());
			String nivelAerobico = String.valueOf(ejercicio.getNivelAerobico());
			String grupoMuscular = ejercicio.getGrupoMuscular().toString();
			String exigenciaMuscular = ejercicio.getExigenciaMuscular().name();
			Object[] objs = {nombre, series, repeticiones, peso, tiempo, nivelAerobico, grupoMuscular, exigenciaMuscular};
			tableModel.addRow(objs);		
		}
	}
	
	public void getEjerciciosPendientes(JTable table, SocioVO socioVo) {
		ArrayList<EjercicioVO> ejercicios =entrenamiento.getEjercicios(socioVo);
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		
		for (int i = 0; i < ejercicios.size(); i++) {
			EjercicioVO ejercicio = ejercicios.get(i);
			
			// Si el ejercicio no fue completado, se agrega a la tabla de ejercicios pendientes.
			if (ejercicio.getEjercicioCompletado() == false) {
				String nombre = ejercicio.getNombre();
				String series = String.valueOf(ejercicio.getCantidadSeries());
				String repeticiones = String.valueOf(ejercicio.getRepeticiones());
				String peso = String.valueOf(ejercicio.getPesoAsignado());
				String tiempo = String.valueOf(ejercicio.getTiempo());
				String nivelAerobico = String.valueOf(ejercicio.getNivelAerobico());
				String grupoMuscular = ejercicio.getGrupoMuscular().toString();
				String exigenciaMuscular = ejercicio.getExigenciaMuscular().name();
				Object[] objeto_ejercicio = {nombre, series, repeticiones, peso, tiempo, nivelAerobico, grupoMuscular, exigenciaMuscular};
				tableModel.addRow(objeto_ejercicio);
			}
		}
	}
}


			
		

