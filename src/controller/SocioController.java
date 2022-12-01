package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.AdapterLogin;
import model.ObjetivoAsignado;
import model.Socio;
import model.dao.SocioDAO;
import model.vo.MedicionVO;
import model.vo.SocioVO;

public class SocioController {
	private Socio socio;
	SocioDAO socioDAO = new SocioDAO();	
	AdapterLogin login = new AdapterLogin();
	private ObjetivoAsignado objetivoAsignado;

    public SocioController() {
    	socioDAO.getSocios();    	
    	objetivoAsignado = new ObjetivoAsignado();
    	socio = new Socio(0, null, null, 0, null, null, null, null, null, null, null);
	}
	
    public SocioVO getSocioVO(String user, char[] pass) {
    	SocioVO socio1 = Socio.getSocio(user);
    	if (login.autenticar(user, pass)) {
    		if(socio1== null) {
    			JOptionPane.showMessageDialog(null,"¡No tienes acceso al sistema!","Error",JOptionPane.ERROR_MESSAGE);
    		}
    		else {
    			socio = new Socio(socio1.getId(), socio1.getNombre(), socio1.getApellido(), socio1.getAltura(), socio1.getRutina(), socio1.getSexo(), socio1.getObjetivo(), socio1.getUser(), socio1.getMedicion(), socio1.getEstrategia(), socio1.getTrofeos());
    			objetivoAsignado.setSocio(socio);
    	    	return socio1;
    	    	
    		}
    	}
    	return null;   	
    }
    
    public void registrarMedicion(MedicionVO medicionVO, SocioVO socioVO){
    	socio = new Socio(socioVO);
    	socio.registrarMedicion(medicionVO, socioVO);
	}    
    
}
