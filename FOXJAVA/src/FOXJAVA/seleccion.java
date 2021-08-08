package FOXJAVA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class seleccion extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					seleccion frame = new seleccion();
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
	public seleccion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnvotantes = new JButton("Registro Votantes");
		btnvotantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				carga_votantes v = new carga_votantes (); 
				v.setVisible(true);
			}
		});
		btnvotantes.setBounds(42, 115, 141, 23);
		contentPane.add(btnvotantes);
		
		JButton btnelectores = new JButton("Registro Electores");
		btnelectores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				carga_candidatos c = new carga_candidatos (); 
				c.setVisible(true);
			}
		});
		btnelectores.setBounds(218, 115, 149, 23);
		contentPane.add(btnelectores);
		
		JLabel lblNewLabel = new JLabel("SELECCIONE LA ACCI\u00D3N QUE DESEA REALIZAR");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(59, 22, 308, 48);
		contentPane.add(lblNewLabel);
		
		JButton btnvotar = new JButton("Votar");
		btnvotar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlvotantes cv = new controlvotantes();
				cv.setVisible(true);
			}
		});
		btnvotar.setBounds(156, 166, 89, 23);
		contentPane.add(btnvotar);
	}

}
