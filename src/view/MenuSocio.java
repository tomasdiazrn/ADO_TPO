package view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.EntrenamientoController;
import controller.ObjetivoController;
import controller.RutinaController;
import model.vo.SocioVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuSocio extends JFrame {

    private JPanel Contenedor;
    private Login login;

    // Recibiremos un socio por defecto que sera el que siempre estara autenticado.
    public MenuSocio(SocioVO socio, ObjetivoController objetivo, EntrenamientoController entrenamientoController, RutinaController rutina) {
    
    	// Contenedor:
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

        // Botones:
        JButton entrenamientoButton = new JButton("Entrenamiento del Dia");
        entrenamientoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        entrenamientoButton.setHorizontalTextPosition(SwingConstants.CENTER);
        entrenamientoButton.setBounds(185, 180, 233, 34);
        entrenamientoButton.setFont(new Font("Manrope", Font.PLAIN, 17));
        entrenamientoButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Socio_OpcionRutina miVentana = new Socio_OpcionRutina(socio, objetivo, entrenamientoController, rutina);
                miVentana.llenarTablaPendientes(entrenamientoController, socio);
                miVentana.setVisible(true);
                dispose();
            }
        });

        JButton MedicionButton = new JButton("Registrar Medicion");
        MedicionButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        MedicionButton.setHorizontalTextPosition(SwingConstants.CENTER);
        MedicionButton.setBounds(185, 249, 233, 34);
        MedicionButton.setFont(new Font("Manrope", Font.PLAIN, 17));
        MedicionButton.setForeground(Color.BLACK);
        MedicionButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                Socio_OpcionMedicion miVentana = new Socio_OpcionMedicion(socio, objetivo, entrenamientoController, rutina);
                miVentana.setVisible(true);
            }
        });
        
        JButton btnFinalizarRutina = new JButton("Finalizar Rutina");
        btnFinalizarRutina.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
        		rutina.rutinaCompletada(socio);
        		
        	}
        });
        btnFinalizarRutina.setHorizontalTextPosition(SwingConstants.CENTER);
        btnFinalizarRutina.setForeground(Color.BLACK);
        btnFinalizarRutina.setFont(new Font("Manrope", Font.PLAIN, 17));
        btnFinalizarRutina.setBounds(185, 314, 233, 34);
        
        
        // Textos:
        login = new Login();
        JLabel Title = new JLabel("Hola " + socio.getNombre());
        Title.setBackground(Color.BLACK);
        Title.setBounds(203, 75, 195, 35);
        Title.setForeground(Color.BLACK);
        Title.setFont(new Font("Manrope Bold", Font.BOLD, 20));
        Title.setAlignmentY(0.0f);

        JLabel Subtitle = new JLabel("Seleccione una opci\u00F3n");
       
        Subtitle.setBackground(Color.BLACK);
        Subtitle.setBounds(194, 106, 213, 35);
        Subtitle.setAlignmentY(0.0f);
        Subtitle.setForeground(Color.BLACK);
        Subtitle.setFont(new Font("Manrope", Font.PLAIN, 20));

        JLabel AutorText = new JLabel("Equipo 01");
        AutorText.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        AutorText.setBackground(Color.BLACK);
        AutorText.setBounds(245, 448, 110, 35);
        AutorText.setForeground(Color.BLACK);
        AutorText.setFont(new Font("Manrope", Font.PLAIN, 20));
        AutorText.setAlignmentY(0.0f);
        AutorText.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Turno: Jueves 18hs | Equipo 01","Datos del equipo", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        JLabel Background = new JLabel("");
        Background.setFocusable(false);
        Background.setHorizontalTextPosition(SwingConstants.CENTER);
        Background.setBounds(0, 0, 600, 600);
        Background.setIcon(new ImageIcon(MenuSocio.class.getResource("/images/Background600.png")));

        Contenedor.add(entrenamientoButton);
        Contenedor.add(MedicionButton);
        Contenedor.add(btnFinalizarRutina);
        Contenedor.add(Title);
        Contenedor.add(Subtitle);
        Contenedor.add(AutorText);
        Contenedor.add(Background);
        
        
    }

}