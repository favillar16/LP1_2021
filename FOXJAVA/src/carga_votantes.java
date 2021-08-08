import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class carga_votantes extends JFrame {

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
		btnguardar.setBounds(64, 258, 89, 23);
		contentPane.add(btnguardar);
		
		JButton btnborrar = new JButton("Eliminar");
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
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnbuscar.setBounds(179, 258, 133, 23);
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
