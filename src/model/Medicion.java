package model;

import java.util.Date;

public class Medicion {
    private double peso;
    private double masaMuscular;
    private double grasa;
    private Date fecha;
    
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getMasaMuscular() {
		return masaMuscular;
	}
	public void setMasaMuscular(double masaMuscular) {
		this.masaMuscular = masaMuscular;
	}
	public double getGrasa() {
		return grasa;
	}
	public void setGrasa(double grasa) {
		this.grasa = grasa;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
    
    
	
}
