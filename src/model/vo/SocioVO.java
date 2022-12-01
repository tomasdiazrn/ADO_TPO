package model.vo;

import model.*;
import model.dao.SocioDAO;

import java.util.ArrayList;


public class SocioVO {

        private long id;
        private String nombre;
        private String apellido;
        private int altura;
        private ArrayList<RutinaVO> rutina;
        private Sexo sexo;
        private ObjetivoStrategy objetivo;
        private String user;
    	private String password; 
        private ArrayList<MedicionVO> medicion;
        private EstrategiaObjetivo estrategia;
        private ArrayList<Trofeo> observadores;
        private SocioDAO socioDAO;

		public SocioVO(long id, String nombre, String apellido, int altura, ArrayList<RutinaVO> rutina, Sexo sexo,
				ObjetivoStrategy objetivo, String user, ArrayList<MedicionVO> medicion, EstrategiaObjetivo estrategia,
				ArrayList<Trofeo> observadores) {
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

		public SocioVO() {
		}

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public String getApellido() {
                return apellido;
        }

        public void setApellido(String apellido) {
                this.apellido = apellido;
        }

        public int getAltura() {
                return altura;
        }

        public void setAltura(int altura) {
                this.altura = altura;
        }


        public ArrayList<RutinaVO> getRutina() {
                return rutina;
        }

        public void setRutina(ArrayList<RutinaVO> rutina) {
                this.rutina = rutina;
        }

        public Sexo getSexo() {
                return sexo;
        }

        public void setSexo(Sexo sexo) {
                this.sexo = sexo;
        }

        public ObjetivoStrategy getObjetivo() {
                return objetivo;
        }

        public void setObjetivo(ObjetivoStrategy objetivo) {
                this.objetivo = objetivo;
        }

        public ArrayList<MedicionVO> getMedicion() {
                return medicion;
        }

        public void setMedicion(ArrayList<MedicionVO> medicion) {
                this.medicion = medicion;
        }

        public ArrayList<Trofeo> getTrofeos() {
                return observadores;
        }

        public void setTrofeos(ArrayList<Trofeo> observadores) {
                this.observadores = observadores;
        }
        
		public String getUser() {
			return user;
		}

		public void setUser(String user) {
			this.user = user;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}


		public EstrategiaObjetivo getEstrategia() {
			return estrategia;
		}


		public void setEstrategia(EstrategiaObjetivo estrategia) {
			this.estrategia = estrategia;
		}

		@Override
		public String toString() {
			return "SocioVO [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", altura=" + altura
					+ ", rutina=" + rutina + ", sexo=" + sexo + ", objetivo=" + objetivo + ", user=" + user
					+ ", medicion=" + medicion + ", estrategia=" + estrategia + ", trofeos=" + observadores + "]";
		}
 
}

