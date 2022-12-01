package model.vo;

import model.ExigenciaMuscular;
import model.GrupoMuscular;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class EjercicioVO {
	private String nombre;
    private int cantidadSeries;
    private int repeticiones;
    private int pesoAsignado;
    private int tiempo;
    private int nivelAerobico;
    private List<GrupoMuscular> grupoMuscular;
    private ExigenciaMuscular exigenciaMuscular;
    
    
    private boolean ejercicioCompletado;

    public EjercicioVO(){

    }
    
    public EjercicioVO(String nombre, int cantidadSeries, int repeticiones, int pesoAsignado, int tiempo,
			int nivelAerobico, List<GrupoMuscular> grupoMuscular, ExigenciaMuscular exigenciaMuscular) {
		
		this.nombre = nombre;
		this.cantidadSeries = cantidadSeries;
		this.repeticiones = repeticiones;
		this.pesoAsignado = pesoAsignado;
		this.tiempo = tiempo;
		this.nivelAerobico = nivelAerobico;
		this.grupoMuscular = grupoMuscular;
		this.exigenciaMuscular = exigenciaMuscular;
	}

	// Getters & Setters
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
    	this.nombre = nombre;
    }
    
    public int getCantidadSeries() {
        return cantidadSeries;
    }

    public void setCantidadSeries(int cantidadSeries) {
        this.cantidadSeries = cantidadSeries;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public int getPesoAsignado() {
        return pesoAsignado;
    }

    public void setPesoAsignado(int pesoAsignado) {
        this.pesoAsignado = pesoAsignado;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getNivelAerobico() {
        return nivelAerobico;
    }

    public void setNivelAerobico(int nivelAerobico) {
        this.nivelAerobico = nivelAerobico;
    }

    public List<GrupoMuscular> getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(ArrayList<GrupoMuscular> grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public ExigenciaMuscular getExigenciaMuscular() {
        return exigenciaMuscular;
    }

    public void setExigenciaMuscular(ExigenciaMuscular exigenciaMuscular) {
        this.exigenciaMuscular = exigenciaMuscular;
    }
    
    public void setEjercicioCompletado(boolean estado) {
    	this.ejercicioCompletado = estado;
    }
    
    public boolean getEjercicioCompletado() {
    	return ejercicioCompletado;
    }

	@Override
	
	public String toString() {
		return new StringJoiner(", ", EjercicioVO.class.getSimpleName() + "[", "]").add("nombre='" + nombre + "'")
				.add("cantidadSeries='" + cantidadSeries + "'").add("repeticiones=" + repeticiones)
				.add("pesoAsignado='" + pesoAsignado + "'").add("tiempo=" + tiempo).add("nivelAerobico=" + nivelAerobico)
				.add("grupoMuscular=" + grupoMuscular).add("exigenciaMuscular=" + exigenciaMuscular).toString();
	}

    
}
