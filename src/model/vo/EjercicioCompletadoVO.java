package model.vo;

import java.time.LocalDate;

public class EjercicioCompletadoVO {
	
	private String nombre;
	private LocalDate fecha;
	private Integer repeticiones;
	private Integer peso;
	private Integer series;
	
	public EjercicioCompletadoVO(String nombre, LocalDate fecha, Integer repeticiones, Integer peso, Integer series) {
		this.nombre = nombre;
		this.fecha = fecha;
		this.repeticiones = repeticiones;
		this.peso = peso;
		this.series = series;
	}
	
	public EjercicioCompletadoVO() {
		
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Integer getRepeticiones() {
		return repeticiones;
	}
	public void setRepeticiones(Integer repeticiones) {
		this.repeticiones = repeticiones;
	}
	public Integer getPesoAsignado() {
		return peso;
	}
	public void setPesoAsignado(Integer peso) {
		this.peso = peso;
	}
	public Integer getCantidadSeries() {
		return series;
	}
	public void setCantidadSeries(Integer series) {
		this.series = series;
	}
	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "EjercicioCompletadoVO [nombre=" + nombre + ", fecha=" + fecha + ", repeticiones=" + repeticiones
				+ ", peso=" + peso + ", series=" + series + "]";
	}
	
	
	
	
}
