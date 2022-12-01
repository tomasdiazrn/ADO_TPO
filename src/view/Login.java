package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import controller.SocioController;
import model.vo.SocioVO;

public class Login extends JFrame {

		private SocioController socioController = new SocioController();
	  	private JPanel Contenedor;
		private JTextField userTxt;
		private JLabel IniciarSesion;
		private JLabel TituloLabel;
		private JLabel userLabel;
		private JSeparator separator;
		private JLabel passLabel;
		private JPasswordField passTxt;
		private JLabel userError;
		private JLabel passError;
		
		public static final String USER_TEXT = "Ingrese su Nombre de Usuario";
		public static final String PASS_TEXT = "******************";
		public static final String EMPTY_STRING = "";
		public static final String FIELD_NOT_NULL = "**El campo no puede estar vacio**";

		
		public Login() {
	
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

			IniciarSesion = new JLabel("INICIAR SESION");
			IniciarSesion.setFont(new Font("Manrope Bold", Font.BOLD, 15));
			IniciarSesion.setBounds(34, 126, 356, 55);
			getContentPane().add(IniciarSesion);
			TituloLabel = new JLabel("GymPal");
			TituloLabel.setFont(new Font("Manrope Bold", Font.BOLD, 28));
			TituloLabel.setBounds(34, 52, 448, 73);
			getContentPane().add(TituloLabel);

			userLabel = new JLabel("Usuario");
			userLabel.setBounds(34, 194, 288, 33);
			getContentPane().add(userLabel);

			userTxt = new JTextField();
			userTxt.addCaretListener(new CaretListener() {
				public void caretUpdate(CaretEvent e) {
				}
			});
			userTxt.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if (userTxt.getText().equals(USER_TEXT)) {
						userTxt.setText(EMPTY_STRING);
						userTxt.setForeground(Color.BLACK);

					}
				userError.setVisible(false);
				}

				@Override
				public void focusLost(FocusEvent e) {
					if (userTxt.getText().isEmpty()) {
						userTxt.setText(USER_TEXT);
						userTxt.setForeground(Color.LIGHT_GRAY);
					}
				}
			});
			
			userTxt.setText(USER_TEXT);
			userTxt.setForeground(Color.LIGHT_GRAY);
			userTxt.setBounds(34, 223, 470, 40);
			userTxt.setBorder(null);
			getContentPane().add(userTxt);
			userTxt.setColumns(10);
			
			userError = new JLabel(FIELD_NOT_NULL);
			userError.setFont(new Font("Manrope", Font.PLAIN, 10));
			userError.setForeground(Color.RED);
			userError.setBounds(34, 265, 470, 12);
			userError.setVisible(false);
			getContentPane().add(userError);

			separator = new JSeparator();
			separator.setForeground(Color.DARK_GRAY);
			separator.setBounds(34, 258, 470, 12);
			getContentPane().add(separator);
			
			passError = new JLabel(FIELD_NOT_NULL);
			passError.setFont(new Font("Manrope", Font.PLAIN, 10));
			passError.setForeground(Color.RED);
			passError.setBounds(34, 357, 470, 12);
			passError.setVisible(false);
			getContentPane().add(passError);

			passLabel = new JLabel("Contraseña");
			passLabel.setBounds(34, 287, 288, 33);
			getContentPane().add(passLabel);
			
			passTxt = new JPasswordField();
			passTxt.addCaretListener(new CaretListener() {
				public void caretUpdate(CaretEvent e) {
				}
			});
			passTxt.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					if (String.valueOf(passTxt.getPassword()).equals(PASS_TEXT)) {
						passTxt.setText(EMPTY_STRING);
						passTxt.setForeground(Color.BLACK);
					}
				}

				@Override
				public void focusLost(FocusEvent e) {
					if (String.valueOf(passTxt.getPassword()).isEmpty()) {
						passTxt.setText(PASS_TEXT);
						passTxt.setForeground(Color.LIGHT_GRAY);
					}
				}
			});
			passTxt.setForeground(Color.LIGHT_GRAY);
			passTxt.setText(PASS_TEXT);
			passTxt.setBounds(34, 315, 470, 40);
			passTxt.setBorder(null);
			getContentPane().add(passTxt);

			JSeparator separator_1 = new JSeparator();
			separator_1.setForeground(Color.DARK_GRAY);
			separator_1.setBounds(34, 350, 470, 12);
			getContentPane().add(separator_1);
			
			JButton EntrarButton = new JButton("Ingresar");
			EntrarButton.setBackground(Color.WHITE);
	        EntrarButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        EntrarButton.setHorizontalTextPosition(SwingConstants.CENTER);
	        EntrarButton.setBounds(34, 427, 148, 34);
	        EntrarButton.setFont(new Font("Manrope", Font.BOLD | Font.ITALIC, 20));
	        EntrarButton.setForeground(Color.BLACK);
	        Contenedor.add(EntrarButton);
	        EntrarButton.addMouseListener(new MouseAdapter() {
	            public void mouseClicked(MouseEvent e) {
	               // Redirección a la ventana: MenuPrincipalAdmin / MenuPrincipalSocio.
	            	if (userTxt.getText().equals(USER_TEXT) || userTxt.getText().isEmpty()) {
	            		userError.setVisible(true);
	        		}
	            	if (String.valueOf(passTxt.getPassword()).equals(Login.PASS_TEXT) || String.valueOf(passTxt.getPassword()).isEmpty()) {
	        			passError.setVisible(true);
	        		}
	            	if (!(userTxt.getText().equals(USER_TEXT) || userTxt.getText().isEmpty())
	        				&& !(String.valueOf(passTxt.getPassword()).equals(PASS_TEXT) || String.valueOf(passTxt.getPassword()).isEmpty())) {
		    			//MenuSocio miVentana = new MenuSocio();
	        			SocioVO socioVo = new SocioVO();
	        			String user = userTxt.getText();   
	        			socioVo.setUser(user);
	        			socioVo = socioController.getSocioVO(user, passTxt.getPassword());
	        			
	        			//System.out.println("SocioVO: " + socioVo);
	        			ObjetivoView miVentana = new ObjetivoView(socioVo);
	        			if(socioVo ==null) {
	        				miVentana.setVisible(false);
	        				limpiar();
	        			} else {
	        				miVentana.setVisible(true);
							dispose();
							limpiar();
	        			}		
	        		}
	
	            }
	        });
	       
	      
			// Background: Fondo del contenedor:
	        JLabel Background = new JLabel("");
	        Background.setFocusable(false);
	        Background.setHorizontalTextPosition(SwingConstants.CENTER);
	        Background.setBounds(0, 0, 600, 600);
	        Background.setIcon(new ImageIcon(Login.class.getResource("/images/Background600.png")));
	        Contenedor.add(Background);
	        			
		}
		
		private void limpiar() 
		{
			userTxt.setText("");
			passTxt.setText("");
			
		}
		
		

}

