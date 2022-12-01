package model;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.dao.MedicionDAO;
import model.dao.SocioDAO;
import model.vo.MedicionVO;
import model.vo.RutinaVO;
import model.vo.SocioVO;

public class Socio{

	private long id;
    private String nombre;
    private String apellido;
    private int altura;
    private ArrayList<RutinaVO> rutina;
    private Sexo sexo;
    private ObjetivoStrategy objetivo;
    private String user;
    private char[] password;
    private int edad;
    private ArrayList<MedicionVO> medicion;
    private IAdapterLogin adapter;
    private EstrategiaObjetivo estrategia;
    private ArrayList<Trofeo> observadores;
    
    
    
    public Socio(long id, String nombre, String apellido, int altura, ArrayList<RutinaVO> rutina, Sexo sexo,
			ObjetivoStrategy objetivo, String user, ArrayList<MedicionVO> medicion, EstrategiaObjetivo estrategia, ArrayList<Trofeo> observadores) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.altura = altura;
		this.rutina = rutina;
		this.sexo = sexo;
		this.objetivo = objetivo;
		this.user = user;
		this.medicion = medicion;
		this.estrategia = estrategia;
		this.observadores = new ArrayList<>();
		this.observadores.add(new TrofeoCreido());
	}


	public Socio(SocioVO socioVO){
        this.id = socioVO.getId();
        this.nombre = socioVO.getNombre();
        this.apellido = socioVO.getApellido();
        this.altura = socioVO.getAltura();
        this.rutina = socioVO.getRutina();
        this.sexo = socioVO.getSexo();
        this.objetivo = socioVO.getObjetivo();
        this.user = socioVO.getUser();
        this.medicion = socioVO.getMedicion();
        this.estrategia = socioVO.getEstrategia();
		this.observadores = socioVO.getTrofeos();
    }
    
	
    public boolean autenticar() {
		return adapter.autenticar(user, password);
	}
    
    public static SocioVO getSocio(String user) {
    	SocioDAO socioDAO = new SocioDAO();
    	return socioDAO.getSocio(user);  
  	}
    
    public void registrarMedicion(MedicionVO medicionVO, SocioVO socioVO){
        MedicionDAO medicionDAO= new MedicionDAO();
        medicionDAO.addMedicion(medicionVO);
        medicion.add(medicionVO);
        notificar(socioVO);

    }
	
	  public void notificar(SocioVO socioVO) {
		  for(Trofeo observador:observadores){
			  observador.setSocio(socioVO);
			  observador.verificarCumplimiento(); } }

	public ArrayList<MedicionVO> getMedicion() {
		return medicion;
	}


	@Override
	public String toString() {
		return "Socio [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", altura=" + altura + ", rutina="
				+ rutina + ", sexo=" + sexo + ", objetivo=" + objetivo + ", user=" + user + ", medicion=" + medicion + 
				", estrategia=" + estrategia + "]";
	}
    
    
	
}