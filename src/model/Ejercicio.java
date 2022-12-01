package model;
import java.util.ArrayList;

public class Ejercicio {
	
	public static boolean consultaEjercicio=false;
	public static boolean modificaEjercicio=false;
	private String nombre;
	private int cantidadSeries;
	private int repeticiones;
	private int pesoAsignado;
	private int tiempo;
	private int nivelAerobico;
	private ArrayList<GrupoMuscular> grupoMuscular;
	private ExigenciaMuscular exigenciaMuscular;
	
	public Ejercicio(String nombre, int cantidadSeries, int repeticiones, int pesoAsignado, int tiempo, int nivelAerobico, ArrayList<GrupoMuscular> grupoMuscular, ExigenciaMuscular exigenciaMuscular) {
		this.nombre = nombre;
		this.cantidadSeries = cantidadSeries;
		this.repeticiones = repeticiones;
		this.pesoAsignado = pesoAsignado;
		this.tiempo = tiempo;
		this.nivelAerobico = nivelAerobico;
		this.grupoMuscular = grupoMuscular;
		this.exigenciaMuscular = exigenciaMuscular;
	}
	
}
