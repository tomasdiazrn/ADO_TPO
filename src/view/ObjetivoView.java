package view;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.EntrenamientoController;
import controller.ObjetivoController;
import controller.RutinaController;
import model.vo.SocioVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ObjetivoView extends JFrame{
	
    private JPanel Contenedor;
    private ObjetivoController objetivo = new ObjetivoController();
    private RutinaController rutina = new RutinaController();
    private EntrenamientoController entrenamiento = new EntrenamientoController();
  
    // Recibiremos un socio por defecto que sera el que siempre estara autenticado.
    public ObjetivoView(SocioVO socio) {
        Contenedor = new JPanel();
        Contenedor.setAlignmentY(0.0f);
        Contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
        Contenedor.setLayout(null);
        setContentPane(Contenedor);
        setLocationByPlatform(true);
        setResizable(false);
        
        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("images/favicon.png"));
        setIconImage(logo.getImage());
       
   
        JLabel lblTitulo = new JLabel("Seleccionar Objetivo");
        lblTitulo.setFont(new Font("Manrope", Font.PLAIN, 15));
        lblTitulo.setBounds(55, 41, 251, 38);
        Contenedor.add(lblTitulo);

        JButton btnBajarPeso = new JButton("Bajar de Peso");
        btnBajarPeso.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		MenuSocio miVentana = new MenuSocio(socio, objetivo, entrenamiento, rutina);
        		miVentana.setVisible(true);
        		objetivo.getObjetivoBajarPeso();
        		objetivo.elegirEstrategia();
        		socio.setObjetivo(objetivo.getObjBajar());
        		socio.setEstrategia(objetivo.getEstrategiaBajar());
        		socio.setRutina(rutina.getRutina(socio));
        		dispose();
        	}
        });
        btnBajarPeso.setFont(new Font("Manrope", Font.PLAIN | Font.PLAIN, 15));
        btnBajarPeso.setBounds(199, 123, 182, 38);
        Contenedor.add(btnBajarPeso);
        
        JButton btnMantenerPeso = new JButton("Mantener Peso");
        btnMantenerPeso.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
 
        		MenuSocio miVentana = new MenuSocio(socio, objetivo, entrenamiento, rutina);
        		miVentana.setVisible(true);
        		objetivo.getObjetivoMantener();
        		objetivo.elegirEstrategia();
        		socio.setObjetivo(objetivo.getObjMantener());
        		socio.setEstrategia(objetivo.getEstrategiaMantener());
        		socio.setRutina(rutina.getRutina(socio));
        		dispose();
        
        	}
        });
        btnMantenerPeso.setFont(new Font("Manrope", Font.PLAIN | Font.PLAIN, 15));
        btnMantenerPeso.setBounds(188, 197, 205, 38);
        Contenedor.add(btnMantenerPeso);
        
        JButton btnTonificarCuerpo = new JButton("Tonificar Cuerpo");
        btnTonificarCuerpo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		MenuSocio miVentana = new MenuSocio(socio, objetivo, entrenamiento, rutina);
        		miVentana.setVisible(true);
        		objetivo.getObjetivoTonificar();
        		objetivo.elegirEstrategia();
        		socio.setObjetivo(objetivo.getObjTonificar());
        		socio.setEstrategia(objetivo.getEstrategiaTonificar());
        		socio.setRutina(rutina.getRutina(socio));

        		dispose();
        	}
        });
        btnTonificarCuerpo.setFont(new Font("Manrope", Font.PLAIN | Font.PLAIN, 15));
        btnTonificarCuerpo.setBounds(177, 269, 230, 38);
        Contenedor.add(btnTonificarCuerpo);

		JLabel Background = new JLabel(""); Background.setFocusable(false);
		Background.setHorizontalTextPosition(SwingConstants.CENTER);
		Background.setBounds(0, 0, 600, 600); 
		Background.setIcon(new ImageIcon(ObjetivoView.class.getResource("/images/Background600.png")));
		Contenedor.add(Background);
  
    }
}
