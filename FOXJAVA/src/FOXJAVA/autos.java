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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
public class autos extends JFrame {
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
		txtmarca.setText(null);
		txtchasis.setText(null);
		txtcolor.setText(null);
		txtprecio.setText(null);
		txtcodigo.setText(null);
		txtmotor.setText(null);
		txtchapa.setText(null);
		txtan.setText(null);
		txtmarca.setText(null);
		txtmodelo.setText(null);
		txtkilometraje.setText(null);
		
	}
	private JPanel contentPane;
	private JTextField txtkilometraje;
	private JTextField txtchasis;
	private JTextField txtcolor;
	private JTextField txtprecio;
	private JTextField txtcodigo;
	private JTextField txtnombre;
	private JTextField txtmotor;
	private JTextField txtchapa;
	private JTextField txtan;
	private JTextField txtmarca;
	private JTextField txtmodelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					autos frame = new autos();
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
	public autos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registro de Autos");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(208, 11, 233, 60);
		contentPane.add(lblNewLabel);
		
		txtkilometraje = new JTextField();
		txtkilometraje.setHorizontalAlignment(SwingConstants.TRAILING);
		txtkilometraje.setBounds(84, 115, 108, 20);
		contentPane.add(txtkilometraje);
		txtkilometraje.setColumns(10);
		
		txtchasis = new JTextField();
		txtchasis.setHorizontalAlignment(SwingConstants.CENTER);
		txtchasis.setBounds(84, 160, 108, 20);
		contentPane.add(txtchasis);
		txtchasis.setColumns(10);
		
		txtcolor = new JTextField();
		txtcolor.setHorizontalAlignment(SwingConstants.CENTER);
		txtcolor.setBounds(84, 206, 108, 20);
		contentPane.add(txtcolor);
		txtcolor.setColumns(10);
		
		txtprecio = new JTextField();
		txtprecio.setHorizontalAlignment(SwingConstants.CENTER);
		txtprecio.setBounds(84, 254, 108, 20);
		contentPane.add(txtprecio);
		txtprecio.setColumns(10);
		
		txtcodigo = new JTextField();
		txtcodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtcodigo.setBounds(84, 70, 64, 20);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		txtnombre = new JTextField();
		txtnombre.setHorizontalAlignment(SwingConstants.CENTER);
		txtnombre.setBounds(435, 70, 108, 20);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);
		
		txtmotor = new JTextField();
		txtmotor.setHorizontalAlignment(SwingConstants.CENTER);
		txtmotor.setBounds(435, 115, 108, 20);
		contentPane.add(txtmotor);
		txtmotor.setColumns(10);
		
		txtchapa = new JTextField();
		txtchapa.setHorizontalAlignment(SwingConstants.CENTER);
		txtchapa.setBounds(435, 160, 108, 20);
		contentPane.add(txtchapa);
		txtchapa.setColumns(10);
		
		txtan = new JTextField();
		txtan.setHorizontalAlignment(SwingConstants.CENTER);
		txtan.setBounds(435, 206, 108, 20);
		contentPane.add(txtan);
		txtan.setColumns(10);
		
		txtmarca = new JTextField();
		txtmarca.setHorizontalAlignment(SwingConstants.CENTER);
		txtmarca.setBounds(435, 254, 108, 20);
		contentPane.add(txtmarca);
		txtmarca.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo");
		lblNewLabel_1.setBounds(28, 73, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Kilometraje");
		lblNewLabel_2.setBounds(10, 118, 64, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Chasis");
		lblNewLabel_3.setBounds(10, 163, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Color");
		lblNewLabel_4.setBounds(10, 209, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Nombre");
		lblNewLabel_5.setBounds(379, 73, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Motor");
		lblNewLabel_6.setBounds(379, 118, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Chapa");
		lblNewLabel_7.setBounds(379, 163, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("A\u00F1o");
		lblNewLabel_8.setBounds(379, 209, 46, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Precio");
		lblNewLabel_9.setBounds(10, 257, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Marca");
		lblNewLabel_10.setBounds(379, 257, 46, 14);
		contentPane.add(lblNewLabel_10);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Connection con = null ;
				try {
					con = getConnection();
					ps = con.prepareStatement("INSERT INTO autos(nombre,marca,kilometraje,color,año,motor,precio,chasis,modelo,chapa) values(?,?,?,?,?,?,?,?,?,?)");
					ps.setString(1,txtnombre.getText());
					ps.setString(2,txtmarca.getText());
					ps.setDouble(3,Double.parseDouble(txtkilometraje.getText()));
					ps.setString(4,txtcolor.getText());
					ps.setDate(5,Date.valueOf(txtan.getText()));
					ps.setInt(6,Integer.parseInt(txtmotor.getText()));
					ps.setDouble(7,Double.parseDouble(txtprecio.getText()));
					ps.setString(8,txtchasis.getText());
					ps.setString(9,txtmodelo.getText());
					ps.setString(10,txtchapa.getText());
					int res;
						res = ps.executeUpdate();
					
					
					if (res > 0) {
						JOptionPane.showMessageDialog(null,"El automóvil se ha Registrado");
						limpiarcajas();
						
						
					}else {
						JOptionPane.showMessageDialog(null,"El automovil no pudo ser registrado");
						
					}
					
					con.close();
					
					}catch (Exception e ) {
					System.err.println(e);
			}
			}
		});
		btnNewButton.setBounds(84, 338, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Mostrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null;
				try {
					con= getConnection();
					ps=con.prepareStatement("select * from autos where chapa = ?");
					ps.setString(1,txtchapa.getText());
					rs = ps.executeQuery();
					if(rs.next()) {
						txtcodigo.setText(rs.getString("codigo"));
						txtnombre.setText(rs.getString("nombre"));
						txtmarca.setText(rs.getString("marca"));
						txtmodelo.setText(rs.getString("modelo"));
						txtchapa.setText(rs.getString("chapa"));
						txtchasis.setText(rs.getString("chasis"));
						txtprecio.setText(rs.getString("precio"));
						txtan.setText(rs.getString("año"));
						txtcolor.setText(rs.getString("color"));
						ps.setDouble(3,Double.parseDouble(txtkilometraje.getText()));
						txtmotor.setText(rs.getString("motor"));
						
						
					}else {
						JOptionPane.showMessageDialog(null, "No Existe tal automovil");
					}
				}catch (Exception e) {
					System.err.println(e);
				}
				
			}
		});
		btnNewButton_1.setBounds(208, 338, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Borrar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null ;
				try {
					con = getConnection();
					ps = con.prepareStatement("delete from autos where (chapa) = ?");
					ps.setString(1,txtchapa.getText());
					
int res = ps.executeUpdate();
					
					if (res > 0) {
						JOptionPane.showMessageDialog(null,"Auto Eliminado de la Lista");
						
						
						
					}else {
						JOptionPane.showMessageDialog(null,"Error en la acción");
					}
					
					con.close();
					
				}catch (Exception e ) {
					System.err.println(e);
				}
			}
		});
		btnNewButton_2.setBounds(84, 390, 89, 23);
		contentPane.add(btnNewButton_2);
		
		txtmodelo = new JTextField();
		txtmodelo.setBounds(435, 306, 108, 20);
		contentPane.add(txtmodelo);
		txtmodelo.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Modelo");
		lblNewLabel_11.setBounds(379, 312, 46, 14);
		contentPane.add(lblNewLabel_11);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Connection con = null ;
				try {
					con = getConnection();
					ps = con.prepareStatement("update autos set marca=?,kilometraje=?,color=?,año=?,motor=?,precio=?,chasis=?,modelo=?,chapa=? where nombre = ?");
					ps.setString(1,txtnombre.getText());
					ps.setString(2,txtmarca.getText());
					ps.setDouble(3,Double.parseDouble(txtkilometraje.getText()));
					ps.setString(4,txtcolor.getText());
					ps.setDate(5,Date.valueOf(txtan.getText()));
					ps.setInt(6,Integer.parseInt(txtmotor.getText()));
					ps.setDouble(7,Double.parseDouble(txtprecio.getText()));
					ps.setString(8,txtchasis.getText());
					ps.setString(9,txtmodelo.getText());
					ps.setString(10,txtchapa.getText());
					int res;
						res = ps.executeUpdate();
					
					
					if (res > 0) {
						JOptionPane.showMessageDialog(null,"El automóvil se ha Registrado");
						limpiarcajas();
						
						
					}else {
						JOptionPane.showMessageDialog(null,"El automovil no pudo ser registrado");
						
					}
					
					con.close();
					
					}catch (Exception e ) {
					System.err.println(e);
			}
			}
			
		});
		btnActualizar.setBounds(208, 390, 89, 23);
		contentPane.add(btnActualizar);
	}
}
