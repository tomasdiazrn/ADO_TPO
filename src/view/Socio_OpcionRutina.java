package view;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import controller.EntrenamientoController;
import controller.ObjetivoController;
import controller.RutinaController;
import model.vo.SocioVO;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Socio_OpcionRutina extends JFrame {
	
	private SocioVO socio;
	private JPanel panelPrincipal;
	private RutinaController rutinaController;
	private JTable tabla;
	private ImageIcon logo;
	private JButton btnBackMenu;
	private JScrollPane scrollPane;
	private JLabel background;
	private JButton btnCompleto;

	public void setCoordinador(RutinaController miCoordinador) {
		this.rutinaController = miCoordinador;
	}
	
	public Socio_OpcionRutina(SocioVO socio, ObjetivoController objetivo, EntrenamientoController entrenamientoController, RutinaController rutina) {
		this.socio = socio;
		configurarPanel();
		configurarVentana();
		configurarBotonBackMenu(objetivo, entrenamientoController, rutina);
		configurarTabla();
		configurarScrollPane();
		configurarLabels();
		configurarBotonCompleto(socio, objetivo, entrenamientoController, rutina);
		configurarBackground();      
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
		this.setBounds(100, 100, 1200, 600);
        logo = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("images/favicon.png")));
        this.setIconImage(logo.getImage());
	}
	
	private void configurarBotonBackMenu(ObjetivoController objetivoController, EntrenamientoController entrenamientoController, RutinaController rutina) {
        btnBackMenu = new JButton("Volver al menu");
        btnBackMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnBackMenu.setHorizontalTextPosition(SwingConstants.CENTER);
        btnBackMenu.setFont(new Font("Manrope", Font.PLAIN, 15));
        btnBackMenu.setBounds(100, 494, 150, 34);
        btnBackMenu.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                MenuSocio miVentana = new MenuSocio(socio, objetivoController, entrenamientoController, rutina);
                miVentana.setVisible(true);
                dispose();
            }
        });
        panelPrincipal.add(btnBackMenu);
	}
    
	private void configurarTabla() {
        tabla = new JTable();
        tabla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tabla.setMaximumSize(new Dimension(250, 192));
        tabla.setRowHeight(25);
        tabla.setBounds(100, 82, 1000, 354);
        tabla.setFont(new Font("Manrope", Font.PLAIN, 15));
        tabla.setCellSelectionEnabled(true);
		tabla.setFillsViewportHeight(true);
		tabla.setRowSelectionAllowed(true);
		tabla.setColumnSelectionAllowed(false);
		tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int fila = tabla.getSelectedRow();
				if (fila == -1) {
					JOptionPane.showMessageDialog(null, "No se selecciono ninguna fila","fila inexistente",JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					
					// 
				}
			}});
        tabla.setModel(new DefaultTableModel(
    			new Object[][] {
    			},
    			new String[] {
    					"Ejercicio", "Series", "Repeticiones", "Peso", "Tiempo (seg)", "Nivel Aerobico", "Grupo", "Exigencia"
    			}
    		) {
    			boolean[] columnEditables = new boolean[] {
    				false, false, false, false, false, false, false, false, false
    			};
    			public boolean isCellEditable(int row, int column) {
    				return columnEditables[column];
    			}
    		});
    		
        tabla.setAlignmentX(CENTER_ALIGNMENT);
        tabla.getColumnModel().getColumn(0).setResizable(false);
        tabla.getColumnModel().getColumn(0).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(0).setMinWidth(200);
        tabla.getColumnModel().getColumn(0).setMaxWidth(200);
        tabla.getColumnModel().getColumn(1).setResizable(false);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(50);
        tabla.getColumnModel().getColumn(1).setMinWidth(50);
        tabla.getColumnModel().getColumn(1).setMaxWidth(50);
        tabla.getColumnModel().getColumn(2).setResizable(false);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(2).setMinWidth(80);
        tabla.getColumnModel().getColumn(2).setMaxWidth(80);
        tabla.getColumnModel().getColumn(3).setResizable(false);
        tabla.getColumnModel().getColumn(4).setResizable(false);
        tabla.getColumnModel().getColumn(5).setResizable(false);
        tabla.getColumnModel().getColumn(6).setResizable(false);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(300);
        tabla.getColumnModel().getColumn(6).setMinWidth(300);
        tabla.getColumnModel().getColumn(6).setMaxWidth(300);
        tabla.getColumnModel().getColumn(7).setResizable(false);     
        panelPrincipal.add(tabla);
	}

	private void configurarScrollPane() {
		scrollPane = new JScrollPane();
        scrollPane.setFont(new Font("Manrope Bold", Font.PLAIN, 15));
        scrollPane.setBounds(100, 82, 1000, 354);
        scrollPane.setViewportView(tabla);
        panelPrincipal.add(scrollPane);
	}

    private void configurarLabels() {
        JLabel Title = new JLabel("Rutina");
        Title.setForeground(Color.BLACK);
        Title.setBounds(100, 21, 110, 35);
        Title.setFont(new Font("Manrope Bold", Font.PLAIN, 20));
        Title.setBackground(Color.BLACK);
        Title.setAlignmentY(0.0f);

        JLabel Subtitle = new JLabel("Aca puede ver su rutina de entrenamiento");
        Subtitle.setForeground(Color.BLACK);
        Subtitle.setBounds(100, 48, 500, 35);
        Subtitle.setFont(new Font("Manrope", Font.PLAIN, 20));
        Subtitle.setBackground(Color.BLACK);
        Subtitle.setAlignmentY(0.0f);
        
    }
    

	private void configurarBotonCompleto(SocioVO socio, ObjetivoController objetivoController, EntrenamientoController entrenamientoController, RutinaController rutina) {
        btnCompleto = new JButton("Completado");
        btnCompleto.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		// Seleccionamos la fila
        		int fila = tabla.getSelectedRow();
        		// Seleccionamos el nombre del ejercicio
        		String NombreEjercicio = tabla.getValueAt(fila, 0) +"";
        		Rutina_EjercicioCompletoView VistaEjercicio = new Rutina_EjercicioCompletoView(NombreEjercicio, socio, objetivoController, entrenamientoController, rutina);
        		VistaEjercicio.setVisible(true);
        		dispose();
        	}
        });
        btnCompleto.setHorizontalTextPosition(SwingConstants.CENTER);
        btnCompleto.setFont(new Font("Manrope Bold", Font.BOLD, 15));
        btnCompleto.setBounds(950, 494, 150, 34);
        panelPrincipal.add(btnCompleto);
	}

	private void configurarBackground() {
		background = new JLabel("");
		background.setIcon(new ImageIcon(Socio_OpcionRutina.class.getResource("/images/Background600_1200.png")));
		background.setBounds(0, 0, 1200, 572);
		panelPrincipal.add(background);
	}  
	
    public void llenarTablaPendientes(EntrenamientoController entrenamientoController, SocioVO socioVo) {
		entrenamientoController.getEjerciciosPendientes(tabla, socioVo);
    }
    
}