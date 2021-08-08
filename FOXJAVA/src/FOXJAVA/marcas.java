package FOXJAVA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class marcas extends JFrame {
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
			txtnombre.setText(null);
			txtcodigo.setText(null);
			txtclave.setText(null);
			
		}
	private JPanel contentPane;
	private JTextField txtclave;
	private JTextField txtnombre;
	private JTextField txtcodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					marcas frame = new marcas();
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
	public marcas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MARCAS");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(155, 11, 174, 35);
		contentPane.add(lblNewLabel);
		
		JButton btnguardar = new JButton("Guardar");
		btnguardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null ;
				try {
					con = getConnection();
					ps = con.prepareStatement("INSERT INTO marcas(nombre) values(?)");
					ps.setString(1,txtnombre.getText());
					
int res = ps.executeUpdate();
					
					if (res > 0) {
						JOptionPane.showMessageDialog(null,"Marca ingresada");
						limpiarcajas();
						
						
					}else {
						JOptionPane.showMessageDialog(null,"La marca no fue ingresada");
					}
					
					con.close();
					
				}catch (Exception e ) {
					System.err.println(e);
				}
			}
		});
		btnguardar.setBounds(10, 30, 89, 23);
		contentPane.add(btnguardar);
		
		JButton btnbuscar = new JButton("Buscar");
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null;
				try {
					con= getConnection();
					ps=con.prepareStatement("select * from marcas where nombre = ?");
					ps.setString(1, txtclave.getText());
					rs = ps.executeQuery();
					if(rs.next()) {
						txtcodigo.setText(rs.getString("codigo"));
						
						txtnombre.setText(rs.getString("nombre"));
					}else {
						JOptionPane.showMessageDialog(null, "No Existe tal marca");
					}
				}catch (Exception e) {
					System.err.println(e);
				}
			}
		});
		btnbuscar.setBounds(10, 76, 89, 23);
		contentPane.add(btnbuscar);
		
		JButton btnborrar = new JButton("Borrar");
		btnborrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null ;
				try {
					con = getConnection();
					ps = con.prepareStatement("delete from marcas where (nombre) = ?");
					ps.setString(1,txtclave.getText());
					
int res = ps.executeUpdate();
					
					if (res > 0) {
						JOptionPane.showMessageDialog(null,"Marca descontinuada");
						
						
						
					}else {
						JOptionPane.showMessageDialog(null,"Marca no fue descontinuada");
					}
					
					con.close();
					
				}catch (Exception e ) {
					System.err.println(e);
				}
			}
		});
		btnborrar.setBounds(10, 121, 89, 23);
		contentPane.add(btnborrar);
		
		JButton btnactualizar = new JButton("Actualizar");
		btnactualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null ;
				try {
					con = getConnection();
					ps = con.prepareStatement("update marcas set nombre = ? where nombre = ?");
					ps.setString(1,txtnombre.getText());
					ps.setString(2,txtclave.getText());
					
int res = ps.executeUpdate();
					
					if (res > 0) {
						JOptionPane.showMessageDialog(null,"Marca renombrada");
						limpiarcajas();
			
						
					}else {
						JOptionPane.showMessageDialog(null,"Error al renombrar");
					}
					
					con.close();
					
				}catch (Exception e ) {
					System.err.println(e);
				}
			}
		});
		btnactualizar.setBounds(10, 169, 89, 23);
		contentPane.add(btnactualizar);
		
		txtclave = new JTextField();
		txtclave.setHorizontalAlignment(SwingConstants.CENTER);
		txtclave.setBounds(170, 93, 160, 20);
		contentPane.add(txtclave);
		txtclave.setColumns(10);
		
		txtnombre = new JTextField();
		txtnombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtnombre.setColumns(10);
		txtnombre.setBounds(170, 170, 160, 20);
		contentPane.add(txtnombre);
		
		JLabel lblNewLabel_1 = new JLabel("Clave");
		lblNewLabel_1.setBounds(222, 57, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBounds(222, 135, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Codigo");
		lblNewLabel_1_1.setBounds(399, 22, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		txtcodigo = new JTextField();
		txtcodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtcodigo.setColumns(10);
		txtcodigo.setBounds(376, 47, 85, 20);
		contentPane.add(txtcodigo);
	}

}
