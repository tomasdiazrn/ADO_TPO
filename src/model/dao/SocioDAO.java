package model.dao;

import java.util.ArrayList;

import model.Medicion;
import model.ObjetivoStrategy;
import model.Rutina;
import model.Sexo;
import model.Socio;
import model.vo.MedicionVO;
import model.vo.RutinaVO;
import model.vo.SocioVO;

public class SocioDAO {
	
    private static ArrayList<SocioVO> socios= new ArrayList();
    private RutinaDAO rutina = new RutinaDAO();
    private MedicionDAO medicion = new MedicionDAO();

    public ArrayList<SocioVO> getSocios(){
    	medicion.llenarMedicion();
    	SocioVO socioOriginal = new SocioVO(1, "Matias", "Stricagnoli", 176, null, Sexo.MASCULINO, null, "Matias", medicion.getMediciones(), null, null);
    	socios.add(socioOriginal);
    	return socios;	
    }
    
    public SocioVO getSocio(String user) {	
    	
    	for (int i=0;i<socios.size();i++) {
    		SocioVO socioVO = socios.get(i);
    		if (socioVO.getUser().equals(user)) {
    			return socioVO;
    		}
    	}
    	return null;
    }
    
}
