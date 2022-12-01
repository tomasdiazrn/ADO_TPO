package model;



public class TrofeoDedicacion extends Trofeo {

	  public void verificarCumplimiento() {  
		if (super.getObj().seCompleto(super.getSocio())) {
			this.enviarDedicacion();
		}
	  }
	  
	  public String toString() {
			return "Trofeo Dedicacion";
		}

}
