package model.vo;

import java.time.LocalDate;

public class MedicionVO {
    private double peso;
    private double masaMuscular;
    private double grasa;
    private LocalDate fecha;
    
    public MedicionVO() {
    	
    }

    public MedicionVO(double peso, double masaMuscular, double grasa, LocalDate fecha) {
		this.peso = peso;
		this.masaMuscular = masaMuscular;
		this.grasa = grasa;
		this.fecha = fecha;
	}

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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

	@Override
	public String toString() {
		return "MedicionVO [peso=" + peso + ", masaMuscular=" + masaMuscular + ", grasa=" + grasa + ", fecha=" + fecha
				+ "]";
	}
    
    
    
    
}
