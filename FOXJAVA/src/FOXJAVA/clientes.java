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
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class clientes extends JFrame {
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
	private int calcularEdad() {
        java.util.Date date = new java.util.Date(Date.valueOf(txtfdn.getText()).getTime());
        java.util.Calendar fechaNacimiento = Calendar.getInstance();
        java.util.Calendar fechaActual = Calendar.getInstance();
        fechaNacimiento.setTime(date);
        int añoNacimiento = fechaNacimiento.get(Calendar.YEAR);
        int añoActual = fechaActual.get(Calendar.YEAR);
        int edad = añoActual-añoNacimiento;
        return edad;
       
	}
	
	private void limpiarcajas() {
		txtnombre.setText(null);
		txtapellido.setText(null);
		txtedad.setText(null);
		txtdirec.setText(null);
		txttelef.setText(null);
		txtcedul.setText(null);
		txtfdn.setText(null);
		txtcodic.setText(null);
		
	}

	private JPanel contentPane;
	private JTextField txtnombre;
	private JTextField txtapellido;
	private JTextField txtdirec;
	private JTextField txttelef;
	private JTextField txtcedul;
	private JTextField txtfdn;
	private JTextField txtedad;
	private JTextField txtcodic;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clientes frame = new clientes();
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
	public clientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CLIENTES");
		lblNewLabel.setFont(new Font("MV Boli", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(219, 11, 106, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("APELLIDO:");
		lblNewLabel_1.setBounds(25, 90, 78, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DIRECCION:");
		lblNewLabel_2.setBounds(25, 125, 89, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("TELEFONO:");
		lblNewLabel_3.setBounds(25, 160, 89, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("CEDULA:");
		lblNewLabel_4.setBounds(25, 200, 78, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("FECHA DE NACIMIENTO:");
		lblNewLabel_5.setBounds(10, 243, 157, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("NOMBRE:");
		lblNewLabel_6.setBounds(25, 57, 89, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("EDAD:");
		lblNewLabel_7.setBounds(25, 283, 78, 14);
		contentPane.add(lblNewLabel_7);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(177, 55, 288, 20);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);
		
		txtapellido = new JTextField();
		txtapellido.setBounds(177, 87, 288, 20);
		contentPane.add(txtapellido);
		txtapellido.setColumns(10);
		
		txtdirec = new JTextField();
		txtdirec.setBounds(177, 122, 288, 20);
		contentPane.add(txtdirec);
		txtdirec.setColumns(10);
		
		txttelef = new JTextField();
		txttelef.setBounds(177, 157, 288, 20);
		contentPane.add(txttelef);
		txttelef.setColumns(10);
		
		txtcedul = new JTextField();
		txtcedul.setBounds(177, 197, 288, 20);
		contentPane.add(txtcedul);
		txtcedul.setColumns(10);
		
		txtfdn = new JTextField();
		txtfdn.setBounds(177, 240, 288, 20);
		contentPane.add(txtfdn);
		txtfdn.setColumns(10);
		
		txtedad = new JTextField();
		txtedad.setBounds(143, 280, 86, 20);
		contentPane.add(txtedad);
		txtedad.setColumns(10);
		
		JButton btnguardar = new JButton("A\u00D1ADIR");
		btnguardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null ;
				try {
					con = getConnection();
					ps = con.prepareStatement("INSERT INTO clientes(nombre,apellido,telefono,direccion,fdn,cedula,edad) values(?,?,?,?,?,?,?)");
					ps.setString(1,txtnombre.getText());
					ps.setString(2,txtapellido.getText());
					ps.setInt(3,Integer.parseInt(txttelef.getText()));
					ps.setString(4,txtdirec.getText());
					ps.setDate(5,Date.valueOf(txtfdn.getText()));
					ps.setInt(6,Integer.parseInt(txtcedul.getText()));
					ps.setInt(7,Integer.parseInt(txtedad.getText()));
					int res;
					if(Integer.parseInt(txtedad.getText())>=18 ) {
						res = ps.executeUpdate();
					}else {
						if(Integer.parseInt(txtedad.getText()) != calcularEdad()) {
							JOptionPane.showMessageDialog(null,"La edad no concuerda con la fecha");
							res=0;
							txtedad.setText(null);
						}else {
							JOptionPane.showMessageDialog(null,"EL cliente no posee la edad suficiente para ser ingresado al sistema");
							res=0;
							txtedad.setText(null);
						}
					}
					
					if (res > 0) {
						JOptionPane.showMessageDialog(null,"Cliente Guardado en el Sistema");
						limpiarcajas();
						
						
					}else {
						JOptionPane.showMessageDialog(null,"EL CLIENTE NO SE HA PODIDO GUARDAR EN EL SISTEMA");
						
					}
					
					con.close();
					
					}catch (Exception e ) {
					System.err.println(e);
			}
				
				
				
		}
			
		
			
		});
		btnguardar.setBounds(25, 358, 89, 23);
		contentPane.add(btnguardar);
		
		JButton btnbuscar = new JButton("BUSCAR");
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null;
				try {
					con= getConnection();
					ps = con.prepareStatement("select * from clientes where cedula = ?");
					ps.setInt(1,Integer.parseInt(txtcedul.getText()));
					rs = ps.executeQuery();
					if(rs.next()) {
						txtcodic.setText(rs.getString("codigoc"));
						txtnombre.setText(rs.getString("nombre"));
						txtapellido.setText(rs.getString("apellido"));
						txtfdn.setText(rs.getString("fdn"));
						txtedad.setText(rs.getString("edad"));
						txttelef.setText(rs.getString("telefono"));
						txtdirec.setText(rs.getString("direccion"));
	
					}else {
						JOptionPane.showMessageDialog(null, "No existe ningun cliente con esos datos en el sistema");
					}
				} catch (Exception e) {
					System.out.println(e);
				}
				
			}
		});
		btnbuscar.setBounds(140, 358, 89, 23);
		contentPane.add(btnbuscar);
		
		JButton btnborrar = new JButton("ELIMINAR");
		btnborrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null;
				try {
					con= getConnection();
					ps = con.prepareStatement("delete from clientes where cedula = ?");
					ps.setInt(1,Integer.parseInt(txtcedul.getText()));
					int res = ps.executeUpdate();
					
					if (res > 0) {
						JOptionPane.showMessageDialog(null,"El cliente ha sido eliminado del sistema");
						limpiarcajas();
						
						
						
					}else {
						JOptionPane.showMessageDialog(null,"No se a podido eliminar al cliente del sistema");
						limpiarcajas();
					}
					
					con.close();
					
					}catch (Exception e ) {
					System.err.println(e);
					}
			}
		});
		btnborrar.setBounds(259, 358, 89, 23);
		contentPane.add(btnborrar);
		
		JButton btnactualizar = new JButton("RENOVAR");
		btnactualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null ;
				try {
					con = getConnection();
					ps = con.prepareStatement("update clientes set nombre = ?,apellido = ?,fdn = ?,edad = ?,telefono = ?,direccion = ? where cedula = ?");
					ps.setString(1,txtnombre.getText());
					ps.setString(2,txtapellido.getText());
					ps.setDate(3,Date.valueOf(txtfdn.getText()));
					ps.setInt(4,Integer.parseInt(txtedad.getText()));
					ps.setInt(5,Integer.parseInt(txttelef.getText()));
					ps.setString(6,txtdirec.getText());
					ps.setInt(7,Integer.parseInt(txtcedul.getText()));
					int res;
					if(Integer.parseInt(txtedad.getText())>=18 ) {
						res = ps.executeUpdate();
					}else {
							JOptionPane.showMessageDialog(null,"EL cliente no posee la edad suficiente para ser ingresado al sistema");
							res=0;
							txtedad.setText(null);
						}
						
					if (res > 0) {
						JOptionPane.showMessageDialog(null," Los datos del cliente han sido modificados");
						limpiarcajas();
						
						
					}else {
						JOptionPane.showMessageDialog(null,"No se a podido modificar los datos del cliente");
					}
					
					con.close();
					
				}catch (Exception e ) {
					System.err.println(e);
			}
			}
			});
		
		btnactualizar.setBounds(376, 358, 89, 23);
		contentPane.add(btnactualizar);
		
		txtcodic = new JTextField();
		txtcodic.setBounds(476, 51, 86, 20);
		contentPane.add(txtcodic);
		txtcodic.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Codigo Cliente");
		lblNewLabel_8.setBounds(476, 90, 86, 14);
		contentPane.add(lblNewLabel_8);
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
