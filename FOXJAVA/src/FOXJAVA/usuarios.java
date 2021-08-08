package FOXJAVA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;


public class usuarios extends JFrame {
	
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
	
	private void limpiarcajas() {
	//	txtcodigo.setText(null);
		textNombre.setText(null);
		textAlias.setText(null);
		textClave.setText(null);
		
	}

	
	

	private JPanel contentPane;
	//private JTextField txtnombre;
	private JLabel lblNewLabel_1;
	private JButton btnLimpiar;
	private JButton btnSalir;
	private JTextField textNombre;
	private JTextField textAlias;
	private JTextField textClave;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					usuarios frame = new usuarios();
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
	public usuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Usuarios");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(119, 11, 212, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setBounds(32, 96, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Alias:");
		lblNewLabel_3.setBounds(32, 136, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Clave:");
		lblNewLabel_4.setBounds(32, 171, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		textNombre = new JTextField();
		textNombre.setBounds(88, 93, 145, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textAlias = new JTextField();
		textAlias.setBounds(88, 133, 145, 20);
		contentPane.add(textAlias);
		textAlias.setColumns(10);
		
		textClave = new JTextField();
		textClave.setBounds(88, 168, 145, 20);
		contentPane.add(textClave);
		textClave.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null ;
				String usuario = (textAlias.getText());
				try {
					con = getConnection();
					ps = con.prepareStatement("INSERT INTO usuarios(nombre,alias,clave) values(?,?,?)");
					ps.setString(1,textNombre.getText());
					ps.setString(2,textAlias.getText());
					ps.setString(3,textClave.getText());
					
int res = ps.executeUpdate();
					
					if (res > 0) {
						JOptionPane.showMessageDialog(null,"Usuario Guardado");
						limpiarcajas();
						
						
						
					}else {
						JOptionPane.showMessageDialog(null,"Error al Guardar Usuario");
						limpiarcajas();
					}
					
					con.close();
					
				}catch (Exception e1 ) {
					System.err.println(e1);
			}
				
				
				
			}
		});
			
		btnGuardar.setBounds(272, 92, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLimpiar.setBounds(272, 136, 89, 23);
		contentPane.add(btnLimpiar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(272, 171, 89, 23);
		contentPane.add(btnSalir);
	}

}
