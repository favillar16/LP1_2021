package FOXJAVA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import javax.swing.UIManager;
import java.awt.Color;

public class controlusuario extends JFrame {
	public static final String URL = "jdbc:postgresql://localhost:5432/FOXJAVA";
	public static final String USERNAME = "postgres";
	public static final String PASSWORD = "271612";
	
	PreparedStatement ps;
	ResultSet rs ;
	
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = (Connection) DriverManager.getConnection(URL,USERNAME,PASSWORD);
			JOptionPane.showMessageDialog(null,"Conexion exitosa");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
		
	}

	private JPanel contentPane;
	private JPasswordField txtcontraseña;
	private JTextField txtusuario;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					controlusuario frame = new controlusuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public controlusuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtcontraseña = new JPasswordField();
		txtcontraseña.setBounds(111, 117, 155, 20);
		contentPane.add(txtcontraseña);
		
		txtusuario = new JTextField();
		txtusuario.setBounds(111, 73, 155, 20);
		contentPane.add(txtusuario);
		txtusuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBounds(28, 76, 73, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setBounds(28, 120, 81, 14);
		contentPane.add(lblNewLabel_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(427, 32, 59, 20);
		contentPane.add(passwordField_1);
		
		JLabel lblNewLabel_2 = new JLabel("CONTROL DE USUARIO");
		lblNewLabel_2.setFont(new Font("MV Boli", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 11, 180, 41);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Clave Auxiliar");
		lblNewLabel_3.setBounds(416, 63, 81, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btningresar = new JButton("Ingresar");
		btningresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
Connection con = null;
				
				try {
					con= getConnection();
					String pass,user;
					pass=String.valueOf(txtcontraseña.getPassword());
					user=txtusuario.getText();
					ps = con.prepareStatement("select * from usuarios where alias ='"+user+"' and clave ='"+pass+"'");
					rs = ps.executeQuery();
					
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Acceso concedido");
						menu m = new menu (); 
						m.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null,"Datos Icorrectos",
								user, JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (Exception e) {
					System.out.println(e);
				}
				
			}
		});
		btningresar.setBounds(67, 179, 89, 23);
		contentPane.add(btningresar);
		
		JButton btnsalir = new JButton("Salir");
		btnsalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnsalir.setBounds(199, 179, 89, 23);
		contentPane.add(btnsalir);
		
		JButton btnlimpiar = new JButton("Limpiar");
		btnlimpiar.setBounds(324, 179, 89, 23);
		contentPane.add(btnlimpiar);
	}
}
