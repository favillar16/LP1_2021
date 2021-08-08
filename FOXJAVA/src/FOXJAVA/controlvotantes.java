package FOXJAVA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class controlvotantes extends JFrame {
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
	private JTextField txtci;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					controlvotantes frame = new controlvotantes();
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
	public controlvotantes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtci = new JTextField();
		txtci.setBounds(158, 119, 130, 20);
		contentPane.add(txtci);
		txtci.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("C\u00E9dula de Identidad");
		lblNewLabel.setBounds(33, 122, 115, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese su N\u00FAmero de C\u00E9dula");
		lblNewLabel_1.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(88, 25, 289, 47);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("INGRESAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
Connection con = null;
				
				try {
					con= getConnection();
					String pass;
					pass=(txtci.getText());
					ps = con.prepareStatement("select * from votantes where cedula ='"+pass+"'");
					rs = ps.executeQuery();
					
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Acceso concedido");
						votos m = new votos (); 
						m.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null,"Datos Icorrectos del Votante",
								pass, JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (Exception e) {
					System.out.println(e);
				}
				
			}
			
		});
		btnNewButton.setBounds(170, 168, 108, 23);
		contentPane.add(btnNewButton);
	}

}
