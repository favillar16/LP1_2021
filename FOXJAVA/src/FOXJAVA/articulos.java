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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class articulos extends JFrame {
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
	private JTextField txtnombre;
	private JTextField txtcdb;
	private JTextField txtpdv1;
	private JTextField txtpdv2;
	private JTextField txtstock;
	private JTextField txtstockm;
	private JTextField txtpc;
	private JTextField txtcodigo;
	
	private void limpiarcajas() {
		//	txtcodigo.setText(null);
			txtnombre.setText(null);
			txtcodigo.setText(null);
			txtcdb.setText(null);
			txtpdv1.setText(null);
			txtpdv2.setText(null);
			txtstock.setText(null);
			txtstockm.setText(null);
			txtpc.setText(null);
			
		}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					articulos frame = new articulos();
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
	public articulos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sistema de Carga de Art\u00EDculos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 242, 35);
		contentPane.add(lblNewLabel);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(385, 89, 160, 20);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);
		
		txtcdb = new JTextField();
		txtcdb.setBounds(385, 345, 160, 20);
		contentPane.add(txtcdb);
		txtcdb.setColumns(10);
		
		txtpdv1 = new JTextField();
		txtpdv1.setBounds(385, 174, 160, 20);
		contentPane.add(txtpdv1);
		txtpdv1.setColumns(10);
		
		txtpdv2 = new JTextField();
		txtpdv2.setBounds(385, 216, 160, 20);
		contentPane.add(txtpdv2);
		txtpdv2.setColumns(10);
		
		txtstock = new JTextField();
		txtstock.setBounds(385, 259, 162, 20);
		contentPane.add(txtstock);
		txtstock.setColumns(10);
		
		txtstockm = new JTextField();
		txtstockm.setBounds(385, 305, 160, 20);
		contentPane.add(txtstockm);
		txtstockm.setColumns(10);
		
		txtpc = new JTextField();
		txtpc.setBounds(385, 130, 160, 20);
		contentPane.add(txtpc);
		txtpc.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(289, 92, 81, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Codigo de Barra:");
		lblNewLabel_2.setBounds(289, 348, 81, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Precio de Venta 1:");
		lblNewLabel_3.setBounds(289, 177, 100, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Precio de Venta 2:");
		lblNewLabel_4.setBounds(289, 219, 100, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Stock:");
		lblNewLabel_5.setBounds(289, 262, 60, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Stock M\u00EDnimo:");
		lblNewLabel_6.setBounds(289, 308, 100, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Precio de Costo:");
		lblNewLabel_7.setBounds(289, 133, 100, 14);
		contentPane.add(lblNewLabel_7);
		
		txtcodigo = new JTextField();
		txtcodigo.setBounds(482, 39, 53, 20);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Codigo Art\u00EDculo:");
		lblNewLabel_8.setBounds(354, 42, 118, 14);
		contentPane.add(lblNewLabel_8);
		
		JButton btnguardar = new JButton("Cargar");
		btnguardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null ;
				try {
					con = getConnection();
					ps = con.prepareStatement("INSERT INTO articulos(nombre,preciocosto,precioventa1,precioventa2,stock,stockm,cbarra) values(?,?,?,?,?,?,?)");
					ps.setString(1,txtnombre.getText());
					ps.setDouble(2,Double.parseDouble(txtpc.getText()));
					ps.setDouble(3,Double.parseDouble(txtpdv1.getText()));
					ps.setDouble(4,Double.parseDouble(txtpdv2.getText()));
					ps.setDouble(5,Double.parseDouble(txtstock.getText()));
					ps.setDouble(6,Double.parseDouble(txtstockm.getText()));
					ps.setString(7,txtcdb.getText());
					
int res = ps.executeUpdate();
					
					if (res > 0) {
						JOptionPane.showMessageDialog(null,"Artículo Añadido");
						limpiarcajas();
						
						
						
					}else {
						JOptionPane.showMessageDialog(null,"No se pudo agregar el artículo");
						limpiarcajas();
					}
					
					con.close();
					
				}catch (Exception e1 ) {
					System.err.println(e1);
			}
			
			}
		});
		btnguardar.setBounds(23, 216, 89, 38);
		contentPane.add(btnguardar);
		
		JButton btnactualizar = new JButton("Renovar");
		btnactualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null ;
				try {
					con = getConnection();
					ps = con.prepareStatement("update articulos set (nombre,preciocosto,precioventa1,precioventa2,stock,stockm,cbarra) values(?,?,?,?,?,?,?)\")");
					ps.setString(1,txtnombre.getText());
					ps.setDouble(2,Double.parseDouble(txtpc.getText()));
					ps.setDouble(3,Double.parseDouble(txtpdv1.getText()));
					ps.setDouble(4,Double.parseDouble(txtpdv2.getText()));
					ps.setDouble(5,Double.parseDouble(txtstock.getText()));
					ps.setDouble(6,Double.parseDouble(txtstockm.getText()));
					ps.setString(7,txtcdb.getText());
int res = ps.executeUpdate();
					
					if (res > 0) {
						JOptionPane.showMessageDialog(null,"Artículo Renovado");
			
						
					}else {
						JOptionPane.showMessageDialog(null,"Artículo no pudo ser Renovado");
					}
					
					con.close();
					
				}catch (Exception e ) {
					System.err.println(e);
				}
			}
		});
		btnactualizar.setBounds(23, 284, 89, 41);
		contentPane.add(btnactualizar);
		
		JButton btnborrar = new JButton("Eliminar");
		btnborrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null ;
				try {
					con = getConnection();
					ps = con.prepareStatement("delete from marcas where (cbarra) = ?");
					ps.setString(1,txtcdb.getText());
					
int res = ps.executeUpdate();
					
					if (res > 0) {
						JOptionPane.showMessageDialog(null,"Arículo no distribuído");
						
						
						
					}else {
						JOptionPane.showMessageDialog(null,"Error en la acción");
					}
					
					con.close();
					
				}catch (Exception e ) {
					System.err.println(e);
				}
			}
		});
		btnborrar.setBounds(122, 216, 102, 38);
		contentPane.add(btnborrar);
		
		JButton btnbuscar = new JButton("Mostrar");
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null;
				try {
					con= getConnection();
					ps=con.prepareStatement("select * from articulos where cbarra = ?");
					ps.setString(1, txtcdb.getText());
					rs = ps.executeQuery();
					if(rs.next()) {
						txtcodigo.setText(rs.getString("codigoa"));
						txtnombre.setText(rs.getString("nombre"));
						txtpdv1.setText(rs.getString("precioventa1"));
						txtpdv2.setText(rs.getString("precioventa2"));
						txtpc.setText(rs.getString("preciocosto"));
						txtstock.setText(rs.getString("stock"));
						txtstockm.setText(rs.getString("stockm"));
					}else {
						JOptionPane.showMessageDialog(null, "No Existe tal marca");
					}
				}catch (Exception e) {
					System.err.println(e);
				}
			}
		});
		btnbuscar.setBounds(122, 281, 102, 41);
		contentPane.add(btnbuscar);
	}
}
