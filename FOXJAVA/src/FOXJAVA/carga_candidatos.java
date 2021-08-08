package FOXJAVA;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

public class carga_candidatos extends JFrame {
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
		txtnombre.setText(null);
		txtopcion.setText(null);
		txtpartido.setText(null);
		txtcargo.setText(null);
	}

	private JPanel contentPane;
	private JTextField txtnombre;
	private JTextField txtpartido;
	private JTextField txtopcion;
	private JTextField txtcargo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					carga_candidatos frame = new carga_candidatos();
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
	public carga_candidatos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(107, 100, 170, 20);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);
		
		txtpartido = new JTextField();
		txtpartido.setBounds(107, 151, 170, 20);
		contentPane.add(txtpartido);
		txtpartido.setColumns(10);
		
		txtopcion = new JTextField();
		txtopcion.setBounds(107, 211, 170, 20);
		contentPane.add(txtopcion);
		txtopcion.setColumns(10);
		
		JButton btnguardar = new JButton("Guardar");
		btnguardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null ;
				try {
					con = getConnection();
					ps = con.prepareStatement("INSERT INTO CANDIDATOS(nombre,partido,opcion,cargo) values(?,?,?,?)");
					ps.setString(1,txtnombre.getText());
					ps.setString(2,txtpartido.getText());
					ps.setString(3,txtopcion.getText());
					ps.setString(4,txtcargo.getText());
					int res;
					res = ps.executeUpdate();
					
					if (res > 0) {
						JOptionPane.showMessageDialog(null,"Se Añadió al Candidato");
						limpiarcajas();
						
						
					}else {
						JOptionPane.showMessageDialog(null,"Un error ha Ocurrido");
						
					}
					
					con.close();
					
					}catch (Exception e ) {
					System.err.println(e);
			}
				
				
			
			}
		});
		btnguardar.setBounds(317, 148, 89, 23);
		contentPane.add(btnguardar);
		
		JLabel lblNewLabel = new JLabel("Registro de Candidatos");
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(119, 24, 182, 49);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(10, 103, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Partido:");
		lblNewLabel_2.setBounds(10, 154, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("N\u00BA de Opci\u00F3n:");
		lblNewLabel_3.setBounds(10, 214, 72, 14);
		contentPane.add(lblNewLabel_3);
		
		txtcargo = new JTextField();
		txtcargo.setBounds(107, 264, 170, 20);
		contentPane.add(txtcargo);
		txtcargo.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Cargo:");
		lblNewLabel_4.setBounds(10, 267, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnborrar = new JButton("Eliminar");
		btnborrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null;
				try {
					con= getConnection();
					ps = con.prepareStatement("delete from candidatos where nombre = ?");
					ps.setString(1,(txtnombre.getText()));
					int res = ps.executeUpdate();
					
					if (res > 0) {
						JOptionPane.showMessageDialog(null,"El votante fue eliminado");
						limpiarcajas();
						
						
						
					}else {
						JOptionPane.showMessageDialog(null,"No se a podido eliminar al votante");
						limpiarcajas();
					}
					
					con.close();
					
					}catch (Exception e ) {
					System.err.println(e);
					}
			}
		});
		btnborrar.setBounds(317, 210, 89, 23);
		contentPane.add(btnborrar);
	}
}
