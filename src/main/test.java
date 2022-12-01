package main;
import java.awt.EventQueue;

import view.Login;

public class test {
	
	/* El usuario que tiene permisos para ingresar es el siguiente:
		- Usuario: Matias
	 	- Contraseña: Cualquiera
	*/
	 public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    Login frame = new Login();
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }
}



