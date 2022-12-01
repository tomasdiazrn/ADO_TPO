package view;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import controller.EntrenamientoController;
import controller.ObjetivoController;
import controller.RutinaController;
import controller.SocioController;
import model.vo.MedicionVO;
import model.vo.SocioVO;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Vector;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Socio_OpcionMedicion extends JFrame {
	
	private JPanel Contenedor;
	private JTextField pesoTxt;
	private JTextField grasaTxt, masaTxt;
	
    public Socio_OpcionMedicion(SocioVO socioVO, ObjetivoController objetivo, EntrenamientoController entrenamientoController, RutinaController rutina) {
    	// Contenedor
        Contenedor = new JPanel();
        Contenedor.setFont(new Font("Manrope", Font.PLAIN, 15));
        Contenedor.setFocusable(false);
        Contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
        Contenedor.setLayout(null);
        setContentPane(Contenedor);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBounds(100, 100, 800, 600);
        ImageIcon logo = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/favicon.png")));
        setIconImage(logo.getImage());
        
        JButton BackMenuButton = new JButton("Volver al Menu");
        BackMenuButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        BackMenuButton.setHorizontalTextPosition(SwingConstants.CENTER);
        BackMenuButton.setFont(new Font("Manrope", Font.ITALIC, 16));
        BackMenuButton.setBounds(100, 444, 150, 34);
        BackMenuButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                MenuSocio miVentana = new MenuSocio(socioVO, objetivo, entrenamientoController, rutina);
                miVentana.setVisible(true);
                dispose();
            }
        });


        // Textos
        JLabel Title = new JLabel("Medicion");
        Title.setForeground(Color.BLACK);
        Title.setBounds(41, 31, 164, 35);
        Title.setFont(new Font("Manrope", Font.BOLD | Font.ITALIC, 26));
        Title.setBackground(Color.BLACK);
        Title.setAlignmentY(0.0f);


        JLabel pesoLabel = new JLabel("Peso:");
        pesoLabel.setForeground(Color.BLACK);
        pesoLabel.setFont(new Font("Manrope", Font.PLAIN, 20));
        pesoLabel.setBounds(100, 108, 150, 28);
        Contenedor.add(pesoLabel);
        
        pesoTxt = new JTextField();
        pesoTxt.setBounds(260, 108, 287, 28);
        Contenedor.add(pesoTxt);
        pesoTxt.setColumns(10);
        
        
        JLabel masaLabel = new JLabel("Masa Muscular (%):");
        masaLabel.setForeground(Color.BLACK);
        masaLabel.setFont(new Font("Manrope", Font.PLAIN, 20));
        masaLabel.setBounds(100, 190, 150, 28);
        Contenedor.add(masaLabel);
        
        
        grasaTxt = new JTextField();
        grasaTxt.setColumns(10);
        grasaTxt.setBounds(260, 269, 287, 28);
        Contenedor.add(grasaTxt);
        
        JLabel grasaLabel = new JLabel("Grasa Corporal (%):");
        grasaLabel.setForeground(Color.BLACK);
        grasaLabel.setFont(new Font("Manrope", Font.PLAIN, 20));
        grasaLabel.setBounds(100, 269, 150, 28);
        Contenedor.add(grasaLabel);
        
        
        masaTxt = new JTextField();
        masaTxt.setColumns(10);
        masaTxt.setBounds(260, 190, 287, 28);
        Contenedor.add(masaTxt);
        
        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setForeground(Color.BLACK);
        lblFecha.setFont(new Font("Manrope", Font.PLAIN, 20));
        lblFecha.setBounds(100, 342, 150, 28);
        Contenedor.add(lblFecha);
        
       
        JLabel fechaLbl = new JLabel(LocalDate.now().toString());
        fechaLbl.setFont(new Font("Manrope", Font.PLAIN, 16));
        fechaLbl.setBounds(260, 342, 229, 28);
        Contenedor.add(fechaLbl);
        
        
        JButton registrarButton = new JButton("Registrar");
        registrarButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg) {
        		if (arg.getSource()==registrarButton)
        		{
        			try {
        				MedicionVO medicion=new MedicionVO();
        				medicion.setPeso(Double.parseDouble(pesoTxt.getText()));
        				medicion.setMasaMuscular(Double.parseDouble(masaTxt.getText()));
        				medicion.setGrasa(Double.parseDouble(grasaTxt.getText()));
        				medicion.setFecha(LocalDate.now());
                        SocioController socioController1 = new SocioController();
                        socioController1.registrarMedicion(medicion,socioVO);
                        
                        if (objetivo.seCompleto(socioVO)) {
                        	socioVO.setObjetivo(objetivo.getObjMantener());
                        	socioVO.setEstrategia(objetivo.getEstrategiaMantener());
                        	socioVO.setRutina(rutina.getRutina(socioVO));
                        	
                        	Socio_OpcionRutina ventanaRutina = new Socio_OpcionRutina(socioVO, objetivo, entrenamientoController, rutina);
                        	ventanaRutina.llenarTablaPendientes(entrenamientoController, socioVO);
                        	
                        }
                        dispose();
                        
        			}catch (NumberFormatException e) {
        				JOptionPane.showMessageDialog(SwingUtilities.getAncestorOfClass(getClass(), registrarButton),
        						"Las mediciones no tienen el formato deseado\n Tiene que ser numerico, sin puntos ni comas","number exception", JOptionPane.ERROR_MESSAGE);
        			}
        		}
        		
        	}
        });
        registrarButton.setFont(new Font("Manrope", Font.ITALIC, 16));
        registrarButton.setBounds(531, 444, 123, 34);
        Contenedor.add(registrarButton);
        
        JLabel Background = new JLabel("");
        Background.setIcon(new ImageIcon(Socio_OpcionMedicion.class.getResource("/images/Background600_1200.png")));
        Background.setBounds(0, 0, 1200, 572);
        Contenedor.add(BackMenuButton);
        Contenedor.add(Title);
        Contenedor.add(Background);
        
    }
}