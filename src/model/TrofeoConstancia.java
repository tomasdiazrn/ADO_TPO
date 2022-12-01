package model;

import javax.swing.JOptionPane;

public class TrofeoConstancia extends Trofeo {

	  public void verificarCumplimiento() {
		  if(super.getRutina().seCompleto(super.getSocio())) {
			  this.enviarConstancia();
		  } else {
			  JOptionPane.showMessageDialog(null,"No se ha completado la Rutina","Rutina",JOptionPane.WARNING_MESSAGE);
		  }
		  
	  }
	  
	  
	  public String toString() {
			return "Trofeo Constancia";
		}

}
