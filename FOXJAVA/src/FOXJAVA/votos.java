package FOXJAVA;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class votos extends JFrame {
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
		txtcargo.setText(null);
	}


	private JPanel contentPane;
	private JTextField txtnombre;
	private JTextField txtcargo;
	private JTextField txtresultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					votos frame = new votos();
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
	public votos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VOTOS");
		lblNewLabel.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(211, 24, 111, 59);
		contentPane.add(lblNewLabel);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(110, 114, 160, 20);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);
		
		txtcargo = new JTextField();
		txtcargo.setBounds(110, 171, 160, 20);
		contentPane.add(txtcargo);
		txtcargo.setColumns(10);
		
		txtresultado = new JTextField();
		txtresultado.setBounds(503, 89, 86, 20);
		contentPane.add(txtresultado);
		txtresultado.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(24, 117, 76, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cargo:");
		lblNewLabel_2.setBounds(24, 174, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnvotar = new JButton("Votar");
		btnvotar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null ;
				try {
					con = getConnection();
					ps = con.prepareStatement("INSERT INTO VOTOS(nombre,cargo,voto) values(?,?,1)");
					ps.setString(1,txtnombre.getText());
					ps.setString(2,txtcargo.getText());
					int res;
					res = ps.executeUpdate();
					
					if (res > 0) {
						JOptionPane.showMessageDialog(null,"Se Registró el voto");
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
		btnvotar.setBounds(340, 170, 89, 23);
		contentPane.add(btnvotar);
		
		JLabel lblNewLabel_4 = new JLabel("Resultados");
		lblNewLabel_4.setBounds(407, 92, 86, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnresultados = new JButton("Resultados");
		btnresultados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dato = txtnombre.getText();
				Connection con = null;
				try {
					con= getConnection();
					ps = con.prepareStatement("select sum(voto) from votos where nombre= '"+dato+"'");
					rs = ps.executeQuery();
					if(rs.next()){
							txtresultado.setText(rs.getString(1));
							 
					}else {
						JOptionPane.showMessageDialog(null,"El Seleccionado no corresponde a ningún cargo",
								dato, JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (Exception e) {
					System.out.println(e);
				}
			}
				
		});
		btnresultados.setBounds(461, 170, 89, 23);
		contentPane.add(btnresultados);
	}
}
