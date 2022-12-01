package model.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controller.RutinaController;
import model.Entrenamiento;
import model.EstrategiaObjetivo;
import model.ObjetivoStrategy;
import model.vo.EjercicioVO;
import model.vo.EntrenamientoVO;

public class EntrenamientoDAO {
	
	private ArrayList<EntrenamientoVO> listaEntrenamientos;
	private ArrayList<EntrenamientoVO> entrenamientosBajar;
	private ArrayList<EntrenamientoVO> entrenamientosMantener;
	private ArrayList<EntrenamientoVO> entrenamientosTonificar;
	private EjercicioDAO ejercicioDao = RutinaController.getEjercicioDAO();
	

	public ArrayList<EntrenamientoVO> getEntrenamientosSegunObj(Integer option) {		
		
		if (option == 1) {
			return entrenamientosBajar;
		}
	
		else if (option == 2) {
			return entrenamientosMantener;
		}
		
		else if (option == 3) {
			return entrenamientosTonificar;
		}
		
		return null;
	} 
	

	// Retorna todos los entrenamientos.
	public ArrayList<EntrenamientoVO> getEntrenamientos() {		
		return listaEntrenamientos;
	} 
	
	// Retorna solo los entrenamientos para "Bajar de Peso".
	public ArrayList<EntrenamientoVO> getEntrenamientosBajar() {		
		return entrenamientosBajar;
	} 
	
	// Retorna solo los entrenamientos para "Mantener Figura".
	public ArrayList<EntrenamientoVO> getEntrenamientosMantener() {		
		return entrenamientosMantener;
	} 
	
	// Retorna solo los entrenamientos para "Tonificar Cuerpo".
	public ArrayList<EntrenamientoVO> getEntrenamientosTonificar() {		
		return entrenamientosTonificar;
	} 
	
	public void cargaInicial() {
		ArrayList<EntrenamientoVO> listaEntrenamientos = new ArrayList<>();
		ArrayList<EntrenamientoVO> entrenamientosBajar = new ArrayList<>();
		ArrayList<EntrenamientoVO> entrenamientosMantener = new ArrayList<>();
		ArrayList<EntrenamientoVO> entrenamientosTonificar = new ArrayList<>();
		
		// Entrenamientos con objetivo "Bajar Peso"
		EntrenamientoVO entrenamientoBajarPeso1 = new EntrenamientoVO(ejercicioDao.getEjerciciosBajarPeso(), EstrategiaObjetivo.BAJAR_PESO);
        entrenamientosBajar.add(entrenamientoBajarPeso1);
        listaEntrenamientos.add(entrenamientoBajarPeso1);
        this.entrenamientosBajar = entrenamientosBajar;
        
        // Entrenamientos con objetivo "Mantener Figura"
		EntrenamientoVO entrenamientoMantenerFigura1 = new EntrenamientoVO(ejercicioDao.getEjerciciosMantenerFigura(), EstrategiaObjetivo.MANTENER_FIGURA);
		entrenamientosMantener.add(entrenamientoMantenerFigura1);
		listaEntrenamientos.add(entrenamientoMantenerFigura1);
        this.entrenamientosMantener = entrenamientosMantener;
        
        // Entrenamientos con objetivo "Tonificar Cuerpo"
		EntrenamientoVO entrenamientoTonificarCuerpo1 = new EntrenamientoVO(ejercicioDao.getEjerciciosTonificarCuerpo(), EstrategiaObjetivo.TONIFICAR_CUERPO);
		entrenamientosTonificar.add(entrenamientoTonificarCuerpo1);
		listaEntrenamientos.add(entrenamientoTonificarCuerpo1);
        this.entrenamientosTonificar = entrenamientosTonificar;
        
        
        this.listaEntrenamientos = listaEntrenamientos;
	}
	
    public EstrategiaObjetivo getObjetivo(EntrenamientoVO entrenamiento) {
    	EstrategiaObjetivo estrategia = entrenamiento.getEstrategiaElegida();
    	//EstrategiaObjetivo estrategia = new EstrategiaObjetivo();
    	return estrategia;
    }
    
	/*
	public EntrenamientoVO getEntrenamiento(String nombre) {
		ArrayList<EntrenamientoVO> listaEntrenamientos = this.getEntrenamientos();
		for (int i=0; i<listaEntrenamientos.size(); i++) {
			EntrenamientoVO entrenamiento = listaEntrenamientos.get(i);
			if (entrenamiento.getNombre().equals(nombre)) {
				// Se encontro el entrenamiento, retornamos el VO.
				return entrenamiento;
			}	
		}
		System.out.println("El entrenamiento que buscas no existe");
		return null;
	}
	*/

}
