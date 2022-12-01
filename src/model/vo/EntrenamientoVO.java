package model.vo;

import model.EstrategiaObjetivo;
import model.ObjetivoStrategy;
import model.dao.EjercicioDAO;

import java.util.ArrayList;

public class EntrenamientoVO {

    private ArrayList<EjercicioVO> ejercicios = new ArrayList();
    private ObjetivoStrategy objetivo;
    private EstrategiaObjetivo estrategia;
	EjercicioDAO ejercicioDao = new EjercicioDAO();
	private boolean entrenamientoCompletado = false;
    
    
    public EntrenamientoVO(ArrayList<EjercicioVO> ejercicios, EstrategiaObjetivo estrategia) {
		this.ejercicios = ejercicios;
		this.estrategia = estrategia;
	}
    
    public EntrenamientoVO() {
		this.ejercicios = ejercicios;
		this.objetivo = objetivo;
	}

	// Getters & Setters
    public ArrayList<EjercicioVO> getEjercicio(){
		  ArrayList<EjercicioVO> ejercicio= ejercicioDao.getEjercicios();
		  for (int i = 0; i < ejercicio.size(); i++) {
			  ejercicios.add(ejercicio.get(i));
			  
		  }
		return ejercicios;
		  
	  }

    public void setEjercicios(ArrayList<EjercicioVO> ejercicios) {
        this.ejercicios = ejercicios;
    }

    public ObjetivoStrategy getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(ObjetivoStrategy objetivo) {
        this.objetivo = objetivo;
    }
    
    public EstrategiaObjetivo getEstrategiaElegida() {
		return estrategia;
	}
    

	public void setEstrategia(EstrategiaObjetivo estrategia) {
		this.estrategia = estrategia;
	}
	
    public void setEntrenamientoCompletado(boolean estado) {
    	this.entrenamientoCompletado = estado;
    }
    
    public boolean getEntrenamientoCompletado() {
    	return entrenamientoCompletado;
    }

	@Override
	public String toString() {
		return "EntrenamientoVO [ejercicios=" + ejercicios +  ", estrategia=" + estrategia
				+ "]";
	}

    
    
    
    
    
}

