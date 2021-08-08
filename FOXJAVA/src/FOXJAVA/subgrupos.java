package FOXJAVA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class subgrupos extends JFrame {
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
			
		}

	private JPanel contentPane;
	private JTextField txtcodigo;
	private JTextField txtnombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run()  {
				try {
					subgrupos frame = new subgrupos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
		;
	

	/**
	 * Create the frame.
	 */
	public subgrupos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Subgrupos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(152, 11, 87, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Codigo:");
		lblNewLabel_1.setBounds(82, 86, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(57, 133, 87, 14);
		contentPane.add(lblNewLabel_2);
		
		txtcodigo = new JTextField();
		txtcodigo.setBounds(138, 83, 62, 20);
		contentPane.add(txtcodigo);
		txtcodigo.setColumns(10);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(138, 130, 210, 20);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);
		
		JButton btnguardar = new JButton("Guardar");
		btnguardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null ;
				try {
					con = getConnection();
					ps = con.prepareStatement("INSERT INTO subgrupos(nombre) values(?)");
					ps.setString(1,txtnombre.getText());
					
int res = ps.executeUpdate();
					
					if (res > 0) {
						JOptionPane.showMessageDialog(null,"Subgrupo Añadido");
						limpiarcajas();
						
						
					}else {
						JOptionPane.showMessageDialog(null,"El subgrupo no fue agregado");
					}
					
					con.close();
					
				}catch (Exception e ) {
					System.err.println(e);
				}
			}
				
			}
		);
		btnguardar.setBounds(34, 187, 89, 23);
		contentPane.add(btnguardar);
		
		JButton btnactualizar = new JButton("Actualizar");
		btnactualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null ;
				try {
					con = getConnection();
					ps = con.prepareStatement("update subgrupos set nombre = ? where nombre = ?");
					ps.setString(1,txtnombre.getText());
					ps.setString(2,txtcodigo.getText());
					
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
		btnactualizar.setBounds(133, 187, 89, 23);
		contentPane.add(btnactualizar);
		
		JButton btnborrar = new JButton("Borrar");
		btnborrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null ;
				try {
					con = getConnection();
					ps = con.prepareStatement("delete from subgrupos where (nombre) = ?");
					ps.setString(1,txtnombre.getText());
					
int res = ps.executeUpdate();
					
					if (res > 0) {
						JOptionPane.showMessageDialog(null,"El subgrupo se ha eliminado");
						
						
						
					}else {
						JOptionPane.showMessageDialog(null,"Error al eliminar Subgrupo");
					}
					
					con.close();
					
				}catch (Exception e ) {
					System.err.println(e);
				}
			}
		});
		btnborrar.setBounds(273, 187, 89, 23);
		contentPane.add(btnborrar);
		
		JButton btnbuscar = new JButton("Buscar");
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null;
				try {
					con= getConnection();
					ps=con.prepareStatement("select * from subgrupos where nombre = ?");
					ps.setString(1, txtnombre.getText());
					rs = ps.executeQuery();
					limpiarcajas();
					if(rs.next()) {
						txtcodigo.setText(rs.getString("codigo"));
						
						txtnombre.setText(rs.getString("nombre"));
					}else {
						JOptionPane.showMessageDialog(null, "No Existe un grupo con ese nombre");
					}
				}catch (Exception e) {
					System.err.println(e);
				}
			}
		});
		btnbuscar.setBounds(394, 187, 89, 23);
		contentPane.add(btnbuscar);
	}
}
