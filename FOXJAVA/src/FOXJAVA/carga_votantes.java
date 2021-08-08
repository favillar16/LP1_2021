package FOXJAVA;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class carga_votantes extends JFrame {
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
		txtci.setText(null);
		txtpartido.setText(null);
	}

	private JPanel contentPane;
	private JTextField txtnombre;
	private JTextField txtci;
	private JTextField txtpartido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					carga_votantes frame = new carga_votantes();
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
	public carga_votantes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Votantes");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		lblNewLabel.setBounds(148, 30, 177, 50);
		contentPane.add(lblNewLabel);
		
		JButton btnguardar = new JButton("Guardar");
		btnguardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null ;
				try {
					String pass;
					pass=(txtnombre.getText());
					con = getConnection();
					ps = con.prepareStatement("select * from votantes where cedula = ?");
					ps.setString(1, txtci.getText());
					rs = ps.executeQuery();
					if (rs.next()) {
						JOptionPane.showMessageDialog(null,"EL VOTANTE YA ESTÄ RESIGRADO",
								pass, JOptionPane.ERROR_MESSAGE);
						limpiarcajas();
					}else {	
					con = getConnection();
					ps = con.prepareStatement("INSERT INTO votantes(nombre,partido,cedula) values(?,?,?)");
					ps.setString(1,txtnombre.getText());
					ps.setString(2,txtpartido.getText());
					ps.setString(3,txtci.getText());
					}
int res = ps.executeUpdate();
					
					if (res > 0) {
						JOptionPane.showMessageDialog(null,"EL VOTANTE FUE REGISTRADO");
						limpiarcajas();
						
						
						
					}else {
						JOptionPane.showMessageDialog(null,"Error al Guardar votante");
					}
					
					con.close();
					
				}catch (Exception e ) {
					System.err.println(e);
			}
			}
		});
		btnguardar.setBounds(58, 258, 89, 23);
		contentPane.add(btnguardar);
		
		JButton btnborrar = new JButton("Eliminar");
		btnborrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null;
				try {
					con= getConnection();
					ps = con.prepareStatement("delete from votantes where cedula = ?");
					ps.setString(1,(txtci.getText()));
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
		btnborrar.setBounds(347, 258, 89, 23);
		contentPane.add(btnborrar);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(169, 113, 156, 20);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);
		
		txtci = new JTextField();
		txtci.setBounds(169, 164, 156, 20);
		contentPane.add(txtci);
		txtci.setColumns(10);
		
		txtpartido = new JTextField();
		txtpartido.setBounds(169, 220, 156, 20);
		contentPane.add(txtpartido);
		txtpartido.setColumns(10);
		
		JButton btnbuscar = new JButton("Consultar Registro");
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null;
				try {
					con= getConnection();
					ps = con.prepareStatement("select * from votantes where cedula = ?");
					ps.setString(1,txtci.getText());
					rs = ps.executeQuery();
					if(rs.next()) {
						txtnombre.setText(rs.getString("nombre"));
						txtpartido.setText(rs.getString("partido"));
	
					}else {
						JOptionPane.showMessageDialog(null, "No existe tal votante en el Padron");
					}
				} catch (Exception e) {
					System.out.println(e);
				}
				
			}
		});
		btnbuscar.setBounds(163, 258, 162, 23);
		contentPane.add(btnbuscar);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(84, 116, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("C.I:");
		lblNewLabel_2.setBounds(84, 167, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Partido:");
		lblNewLabel_3.setBounds(84, 223, 46, 14);
		contentPane.add(lblNewLabel_3);
	}

}
