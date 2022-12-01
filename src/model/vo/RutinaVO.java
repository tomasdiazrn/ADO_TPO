package model.vo;

import java.util.ArrayList;

public class RutinaVO {

    private static int duracion = 4;
    private ArrayList<EntrenamientoVO> entrenamientos = new ArrayList<EntrenamientoVO>();
    private boolean rutinaCompletada = false;

    
    public RutinaVO(ArrayList<EntrenamientoVO> entrenamientos) {
		this.entrenamientos = entrenamientos;
	}

	public ArrayList<EntrenamientoVO> getEntrenamientos() {
		return entrenamientos;
	}
	
	public EntrenamientoVO getEntrenamientoActual() {
		EntrenamientoVO entrenamientoVO = this.getEntrenamientos().get(0);
		return entrenamientoVO;
	}

	public void setEntrenamientos(ArrayList<EntrenamientoVO> entrenamientos) {
		this.entrenamientos = entrenamientos;
	}

	public int getDuracion() {
		return duracion;
	}

	@Override
	public String toString() {
		return "RutinaVO [entrenamientos=" + entrenamientos + "]";
	}
	
    public void setRutinaCompletada(boolean estado) {
    	this.rutinaCompletada = estado;
    }
    
    public boolean getRutinaCompletada() {
    	return rutinaCompletada;
    }
    
    
    
    
}
