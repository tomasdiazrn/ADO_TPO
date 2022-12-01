package model;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.vo.MedicionVO;
import model.vo.SocioVO;

public class TrofeoCreido extends Trofeo {

    public void verificarCumplimiento() {
        
        ArrayList<MedicionVO> medicion=  super.getSocio().getMedicion();

        for (int i = 0; i < medicion.size()-1; i++){
        	int count = 0;
        	for(int x=1; x<medicion.size(); x++) {
                if (medicion.get(i).getFecha().getMonthValue() == medicion.get(x).getFecha().getMonthValue()){
                    count++;
                    if (count >= 3){
                    	this.enviarCreido();
                        }
                }   
             }
         }
     }

    public String toString() {
		return "Trofeo Creido";
	}

}
