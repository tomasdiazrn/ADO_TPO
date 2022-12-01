package model.dao;

import model.Medicion;
import model.vo.MedicionVO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MedicionDAO {


    private ArrayList<MedicionVO> mediciones = new ArrayList<MedicionVO>();
    
    public void llenarMedicion() {
    	 String fecha = "2022-10-10"; 
		  MedicionVO medicion1 = new MedicionVO(90, 60, 70, (LocalDate.parse(fecha)));
		  mediciones.add(medicion1); 
		 
    }


    public ArrayList<MedicionVO> getMediciones() {
		  return mediciones;
		 
    }
    public void addMedicion(MedicionVO medicionVO) {
        mediciones.add(medicionVO);
    }
}
