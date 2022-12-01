package model;
import model.vo.SocioVO;

public abstract class ObjetivoStrategy {

    private String nombre;
    private int tiempo;
    

    public abstract boolean seCompleto(SocioVO socio);{
    	
    }
}
