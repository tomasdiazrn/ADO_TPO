package model;

import javax.swing.JOptionPane;

public class AdapterFirebase implements IAdapterNotificacion {

	public void enviarCreido() {
		JOptionPane.showMessageDialog(null,"Has ganado el trofeo al Creido","Premio",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void enviarDedicacion() {
		JOptionPane.showMessageDialog(null,"Has ganado el trofeo al Dedicacion","Premio",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void enviarConstancia() {
		JOptionPane.showMessageDialog(null,"Has ganado el trofeo al Constancia","Premio",JOptionPane.INFORMATION_MESSAGE);
	}

}
