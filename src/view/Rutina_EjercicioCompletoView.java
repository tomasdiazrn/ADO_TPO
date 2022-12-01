package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import controller.EjercicioController;
import controller.EntrenamientoController;
import controller.ObjetivoController;
import controller.RutinaController;
import model.dao.EjercicioDAO;
import model.vo.EjercicioCompletadoVO;
import model.vo.EjercicioVO;
import model.vo.SocioVO;

public class Rutina_EjercicioCompletoView extends JFrame {
	
	private EjercicioController ejercicioController = new EjercicioController();
	
	private JPanel panelPrincipal;
	private JTextField seriesField, repeticionesField, pesoField;
	private JButton btnRegistrar;
	private ImageIcon logo;
	JLabel background;
	JLabel lblTitulo, lblSeries, lblRepeticiones, lblPeso;

    public Rutina_EjercicioCompletoView(String NombreEjercicio, SocioVO socio, ObjetivoController objetivo, EntrenamientoController entrenamientoController, RutinaController rutina) {
		configurarPanel();
		configurarVentana();
		configurarLabels(NombreEjercicio);
		configurarFields();          
        configurarBoton(NombreEjercicio, socio, objetivo, entrenamientoController, rutina);
        configurarBackground();
        this.setVisible(true);
        
    }
    
    private void configurarPanel() {
        panelPrincipal = new JPanel();
        panelPrincipal.setFont(new Font("Manrope", Font.PLAIN, 15));
        panelPrincipal.setFocusable(false);
        panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
        panelPrincipal.setLayout(null);
        this.setContentPane(panelPrincipal);
    }
    
    private void configurarVentana() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(100, 100, 800, 600);
        logo = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/favicon.png")));
        this.setIconImage(logo.getImage());
    }
    
    private void configurarLabels(String NombreEjercicio) {
		lblTitulo = new JLabel("Ejercicio: " + NombreEjercicio);
		lblTitulo.setForeground(Color.BLACK);
		lblTitulo.setBounds(41, 31, 674, 35);
        lblTitulo.setFont(new Font("Manrope", Font.BOLD | Font.ITALIC, 26));
        lblTitulo.setBackground(Color.BLACK);
        lblTitulo.setAlignmentY(0.0f);
        panelPrincipal.add(lblTitulo);

        lblSeries = new JLabel("Series:");
        lblSeries.setForeground(Color.BLACK);
        lblSeries.setFont(new Font("Manrope", Font.PLAIN, 20));
        lblSeries.setBounds(100, 108, 150, 28);
        panelPrincipal.add(lblSeries);
        
        lblRepeticiones = new JLabel("Repeticiones:");
        lblRepeticiones.setForeground(Color.BLACK);
        lblRepeticiones.setFont(new Font("Manrope", Font.PLAIN, 20));
        lblRepeticiones.setBounds(100, 190, 150, 28);
        panelPrincipal.add(lblRepeticiones);
        
		lblPeso = new JLabel("Peso:");
		lblPeso.setForeground(Color.BLACK);
		lblPeso.setFont(new Font("Manrope", Font.PLAIN, 20));
		lblPeso.setBounds(100, 269, 150, 28);
        panelPrincipal.add(lblPeso);
    }
    
    private void configurarFields() {
    	
        seriesField = new JTextField();
        seriesField.setBounds(260, 108, 287, 28);
        panelPrincipal.add(seriesField);
        seriesField.setColumns(10);      
        
        repeticionesField = new JTextField();
        repeticionesField.setColumns(10);
        repeticionesField.setBounds(260, 269, 287, 28);
        panelPrincipal.add(repeticionesField);
        
        pesoField = new JTextField();
        pesoField.setColumns(10);
        pesoField.setBounds(260, 190, 287, 28);
        panelPrincipal.add(pesoField);
    }
    
    private void configurarBoton(String NombreEjercicio, SocioVO socio, ObjetivoController objetivo, EntrenamientoController entrenamientoController, RutinaController rutina) {
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg) {
        		if (arg.getSource() == btnRegistrar)
        		{
        			try {
        				EjercicioCompletadoVO ejercicioCompletadoVO = new EjercicioCompletadoVO(); 
        				ejercicioCompletadoVO.setFecha(LocalDate.now());
        				ejercicioCompletadoVO.setNombre(NombreEjercicio);
        				ejercicioCompletadoVO.setCantidadSeries(Integer.parseInt(seriesField.getText()));
        				ejercicioCompletadoVO.setRepeticiones(Integer.parseInt(repeticionesField.getText()));
        				ejercicioCompletadoVO.setPesoAsignado(Integer.parseInt(pesoField.getText()));       				
        				ejercicioController.agregarEjercicioCompletado(ejercicioCompletadoVO);
        				EjercicioDAO ejercicioDAO = RutinaController.getEjercicioDAO();
        				EjercicioVO ejercicioVO = ejercicioDAO.getEjercicio(NombreEjercicio);
        				ejercicioController.marcarEjercicioCompletado(ejercicioVO);
     
        				dispose();       				
        				Socio_OpcionRutina miVentana = new Socio_OpcionRutina(socio, objetivo, entrenamientoController, rutina);
                        miVentana.setVisible(true);
                        miVentana.llenarTablaPendientes(entrenamientoController, socio);
                        

        			}catch (NumberFormatException e) {
        				JOptionPane.showMessageDialog(SwingUtilities.getAncestorOfClass(getClass(), btnRegistrar),
        						"El ejercicio no tienen el formato deseado\n Tiene que ser numerico, sin puntos ni comas","number exception", JOptionPane.ERROR_MESSAGE);
        			}
        		}
        		
        	}
        });
        btnRegistrar.setFont(new Font("Manrope", Font.ITALIC, 16));
        btnRegistrar.setBounds(338, 402, 123, 35);
        panelPrincipal.add(btnRegistrar);
    }
    
    private void configurarBackground() {
        background = new JLabel("");
        background.setIcon(new ImageIcon(Socio_OpcionMedicion.class.getResource("/images/Background600_1200.png")));
        background.setBounds(0, 0, 1200, 572);
        panelPrincipal.add(background);
    }
}


