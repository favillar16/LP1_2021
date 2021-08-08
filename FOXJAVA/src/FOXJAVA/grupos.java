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
import javax.swing.SwingConstants;

public class grupos extends JFrame {
	
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
	private JTextField txtclave;
	private JTextField txtnombre;
	private JTextField txtid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					grupos frame = new grupos();
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
	public grupos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GRUPOS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setBounds(163, 11, 89, 26);
		contentPane.add(lblNewLabel);
		
		txtclave = new JTextField();
		txtclave.setBounds(108, 48, 229, 20);
		contentPane.add(txtclave);
		txtclave.setColumns(10);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(85, 94, 339, 20);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);
		
		txtid = new JTextField();
		txtid.setBounds(354, 11, 55, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JButton btnbuscar = new JButton("Buscar");
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null;
				try {
					con= getConnection();
					ps=con.prepareStatement("select * from grupos1 where nombre = ?");
					ps.setString(1, txtclave.getText());
					rs = ps.executeQuery();
					if(rs.next()) {
						txtid.setText(rs.getString("codigo"));
						
						txtnombre.setText(rs.getString("nombre"));
					}else {
						JOptionPane.showMessageDialog(null, "No Existe un grupo con ese nombre");
					}
				}catch (Exception e) {
					System.err.println(e);
				}
			}
		});
		btnbuscar.setBounds(364, 47, 89, 23);
		contentPane.add(btnbuscar);
		
		JButton btnguardar = new JButton("Guardar");
		btnguardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null ;
				try {
					con = getConnection();
					ps = con.prepareStatement("INSERT INTO grupos1(nombre) values(?)");
					ps.setString(1,txtnombre.getText());
					
int res = ps.executeUpdate();
					
					if (res > 0) {
						JOptionPane.showMessageDialog(null,"Grupo Guardado");
						
						
						
					}else {
						JOptionPane.showMessageDialog(null,"Error al Guardar Grupo");
					}
					
					con.close();
					
				}catch (Exception e ) {
					System.err.println(e);
				}
			}
		}
		);
		btnguardar.setBounds(10, 125, 75, 23);
		contentPane.add(btnguardar);
		
		JButton btnmodificar = new JButton("Modificar");
		btnmodificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null ;
				try {
					con = getConnection();
					ps = con.prepareStatement("update grupos1 set nombre = ? where nombre = ?");
					ps.setString(1,txtnombre.getText());
					ps.setString(2,txtclave.getText());
					
int res = ps.executeUpdate();
					
					if (res > 0) {
						JOptionPane.showMessageDialog(null,"Grupo Actualizado");
			
						
					}else {
						JOptionPane.showMessageDialog(null,"Error al actualizar Grupo");
					}
					
					con.close();
					
				}catch (Exception e ) {
					System.err.println(e);
				}
			}
		});
		btnmodificar.setBounds(95, 125, 75, 23);
		contentPane.add(btnmodificar);
		
		JButton btneliminar = new JButton("Eliminar");
		btneliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null ;
				try {
					con = getConnection();
					ps = con.prepareStatement("delete from grupos1 where (nombre) = ?");
					ps.setString(1,txtclave.getText());
					
int res = ps.executeUpdate();
					
					if (res > 0) {
						JOptionPane.showMessageDialog(null,"Grupo Eliminado");
						
						
						
					}else {
						JOptionPane.showMessageDialog(null,"Error al eliminar Grupo");
					}
					
					con.close();
					
				}catch (Exception e ) {
					System.err.println(e);
				}
			}
		
				
			
		});
		btneliminar.setBounds(177, 125, 75, 23);
		contentPane.add(btneliminar);
		
		JButton btnNewButton_4 = new JButton("Salir");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton_4.setBounds(262, 125, 75, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(39, 51, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBounds(39, 97, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ID:");
		lblNewLabel_3.setBounds(319, 11, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Clave");
		lblNewLabel_4.setBounds(39, 51, 46, 14);
		contentPane.add(lblNewLabel_4);
	}
}
