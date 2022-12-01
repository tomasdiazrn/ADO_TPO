package model.dao;

import java.util.ArrayList;

import controller.RutinaController;
import model.vo.RutinaVO;


public class RutinaDAO {
	private ArrayList<RutinaVO> rutinaBajar=new ArrayList<>();
	private ArrayList<RutinaVO> rutinaMantener=new ArrayList<>();
	private ArrayList<RutinaVO> rutinaTonificar=new ArrayList<>();
	private ArrayList<RutinaVO> rutinas = new ArrayList<>();
	private EntrenamientoDAO entrenamiento = RutinaController.getEntrenamientoDAO();
	
	
	public ArrayList<RutinaVO> getRutinasBajar(){
		System.out.println(entrenamiento.getEntrenamientosBajar());
        RutinaVO rutina1 = new RutinaVO(entrenamiento.getEntrenamientosBajar());
        rutinaBajar.add(rutina1);
        return rutinaBajar;
        
    }
	

	public ArrayList<RutinaVO> getRutinasMantener(){
		System.out.println(entrenamiento.getEntrenamientosMantener());
        RutinaVO rutina1 = new RutinaVO(entrenamiento.getEntrenamientosMantener());
        rutinaMantener.add(rutina1);
        return rutinaMantener;
        
    }
	

	public ArrayList<RutinaVO> getRutinasTonificar(){
		System.out.println(entrenamiento.getEntrenamientosTonificar());
        RutinaVO rutina1 = new RutinaVO(entrenamiento.getEntrenamientosTonificar());
        rutinaTonificar.add(rutina1);
        return rutinaTonificar;
        
    }
	
	public ArrayList<RutinaVO> getRutinas(){
		 RutinaVO rutina1 = new RutinaVO(entrenamiento.getEntrenamientosMantener());
	     rutinas.add(rutina1);  
	     RutinaVO rutina2 = new RutinaVO(entrenamiento.getEntrenamientosBajar());
	     rutinas.add(rutina2);
	     RutinaVO rutina3 = new RutinaVO(entrenamiento.getEntrenamientosTonificar());
	     rutinas.add(rutina3);
	        
		return rutinas;
	}



}
