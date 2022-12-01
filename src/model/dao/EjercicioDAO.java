package model.dao;

import java.util.ArrayList;
import java.util.Arrays;
import model.ExigenciaMuscular;
import model.GrupoMuscular;
import model.vo.EjercicioCompletadoVO;
import model.vo.EjercicioVO;

public class EjercicioDAO {
	
	private ArrayList<EjercicioVO> listaEjercicios;
	private ArrayList<EjercicioVO> ejerciciosBajarPeso;
	private ArrayList<EjercicioVO> ejerciciosMantenerFigura;
	private ArrayList<EjercicioVO> ejerciciosTonificarCuerpo;
	private ArrayList<EjercicioCompletadoVO> ejerciciosCompletados;
	public ArrayList<EjercicioCompletadoVO> getEjerciciosCompletados() {
		return ejerciciosCompletados;
	}
	
	public void agregarEjercicioCompletado(EjercicioCompletadoVO ejercicioCompletadoVO) {
		ejerciciosCompletados.add(ejercicioCompletadoVO);
		System.out.println(ejerciciosCompletados);
	}
	
	public EjercicioVO getEjercicio(String nombre) {
		ArrayList<EjercicioVO> listaEjercicios = this.getEjercicios();
		for (int i=0; i<listaEjercicios.size(); i++) {
			EjercicioVO ejercicio = listaEjercicios.get(i);
			if (ejercicio.getNombre().equals(nombre)) {
				// Se encontro el ejercicio, retornamos el VO.
				return ejercicio;
			}	
		}
		System.out.println("El ejercicio que buscas no existe");
		return null;

	}
	
	// Retorna todos los ejercicios.
	public ArrayList<EjercicioVO> getEjercicios() {		
		return listaEjercicios;
	} 
	// Retorna solo los ejercicios para bajar de peso.
	public ArrayList<EjercicioVO> getEjerciciosBajarPeso() {		
		return ejerciciosBajarPeso;
	} 
	// Retorna solo los ejercicios para mantener figura.
	public ArrayList<EjercicioVO> getEjerciciosMantenerFigura() {		
		return ejerciciosMantenerFigura;
	} 
	// Retorna solo los ejercicios para tonificar cuerpo.
	public ArrayList<EjercicioVO> getEjerciciosTonificarCuerpo() {		
		return ejerciciosTonificarCuerpo;
	} 
	
	public void cargaInicial() {
		ArrayList<EjercicioCompletadoVO> ejerciciosCompletados = new ArrayList<>();
		ArrayList<EjercicioVO> listaEjercicios = new ArrayList<>();
		ArrayList<EjercicioVO> ejerciciosBajarPeso = new ArrayList<>();
		ArrayList<EjercicioVO> ejerciciosMantenerFigura = new ArrayList<>();
		ArrayList<EjercicioVO> ejerciciosTonificarCuerpo = new ArrayList<>();
		
		// Ejercicios con objetivo "Bajar Peso"
		EjercicioVO ejercicioBajarPeso1 = new EjercicioVO("Flexiones", 3, 10, 0, 30, 5, Arrays.asList(GrupoMuscular.BRAZOS, GrupoMuscular.PECHO, GrupoMuscular.ESPALDA), ExigenciaMuscular.MEDIO);
		ejerciciosBajarPeso.add(ejercicioBajarPeso1);
		listaEjercicios.add(ejercicioBajarPeso1);
		EjercicioVO ejercicioBajarPeso2= new EjercicioVO("Zancadas con Peso", 3, 10, 3, 30, 5, Arrays.asList(GrupoMuscular.PIERNAS, GrupoMuscular.BRAZOS), ExigenciaMuscular.MEDIO);
		ejerciciosBajarPeso.add(ejercicioBajarPeso2);
		listaEjercicios.add(ejercicioBajarPeso2);
		EjercicioVO ejercicioBajarPeso3= new EjercicioVO("Sentadillas", 3, 10, 3, 30, 5, Arrays.asList(GrupoMuscular.PIERNAS, GrupoMuscular.ESPALDA), ExigenciaMuscular.BAJO);
		ejerciciosBajarPeso.add(ejercicioBajarPeso3);
		listaEjercicios.add(ejercicioBajarPeso3);
		this.ejerciciosBajarPeso = ejerciciosBajarPeso;

		
		// Ejercicios con objetivo "Mantener Figura"
		EjercicioVO ejercicioMantenerFigura1 = new EjercicioVO("Remo con Peso", 4, 16, 0, 20, 3, Arrays.asList(GrupoMuscular.BRAZOS, GrupoMuscular.PECHO, GrupoMuscular.ESPALDA), ExigenciaMuscular.MEDIO);
		ejerciciosMantenerFigura.add(ejercicioMantenerFigura1);
		listaEjercicios.add(ejercicioMantenerFigura1);
		EjercicioVO ejercicioMantenerFigura2 = new EjercicioVO("Jumping Jacks", 4, 16, 0, 20, 3, Arrays.asList(GrupoMuscular.BRAZOS, GrupoMuscular.PECHO, GrupoMuscular.ESPALDA), ExigenciaMuscular.ALTO);
		ejerciciosMantenerFigura.add(ejercicioMantenerFigura2);
		listaEjercicios.add(ejercicioMantenerFigura2);
		EjercicioVO ejercicioMantenerFigura3 = new EjercicioVO("Rodillas al Pecho", 4, 16, 0, 20, 3, Arrays.asList(GrupoMuscular.BRAZOS, GrupoMuscular.PECHO, GrupoMuscular.ESPALDA), ExigenciaMuscular.ALTO);
		ejerciciosMantenerFigura.add(ejercicioMantenerFigura3);
		listaEjercicios.add(ejercicioMantenerFigura3);
		this.ejerciciosMantenerFigura = ejerciciosMantenerFigura;
		
		// Ejercicios con objetivo "Tonificar"
		EjercicioVO ejercicioTonificar1 = new EjercicioVO("Dominadas", 4, 10, 0, 20, 3, Arrays.asList(GrupoMuscular.BRAZOS, GrupoMuscular.HOMBROS, GrupoMuscular.ESPALDA), ExigenciaMuscular.BAJO);
		ejerciciosTonificarCuerpo.add(ejercicioTonificar1);
		listaEjercicios.add(ejercicioTonificar1);
		EjercicioVO ejercicioTonificar2 = new EjercicioVO("Dips", 4, 15, 0, 20, 3, Arrays.asList(GrupoMuscular.BRAZOS, GrupoMuscular.PECHO, GrupoMuscular.HOMBROS), ExigenciaMuscular.MEDIO);
		ejerciciosTonificarCuerpo.add(ejercicioTonificar2);
		listaEjercicios.add(ejercicioTonificar2);
		EjercicioVO ejercicioTonificar3 = new EjercicioVO("Press de pecho", 3, 12, 0, 20, 3, Arrays.asList(GrupoMuscular.PECHO, GrupoMuscular.BRAZOS), ExigenciaMuscular.MEDIO);
		ejerciciosTonificarCuerpo.add(ejercicioTonificar3);
		listaEjercicios.add(ejercicioTonificar3);
		this.ejerciciosTonificarCuerpo = ejerciciosTonificarCuerpo;
		
		this.listaEjercicios = listaEjercicios;
		this.ejerciciosCompletados = ejerciciosCompletados;
		
	}

}

