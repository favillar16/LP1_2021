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

public class menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
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
	public menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnarticulos = new JButton("Articulos");
		btnarticulos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				articulos a = new articulos (); 
				a.setVisible(true);
			}
		});
		btnarticulos.setBounds(181, 171, 100, 23);
		contentPane.add(btnarticulos);
		
		JButton btnusuarios = new JButton("Usuarios");
		btnusuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuarios u = new usuarios();
				u.setVisible(true);
			}
		});
		btnusuarios.setBounds(326, 171, 100, 23);
		contentPane.add(btnusuarios);
		
		JButton btnclientes = new JButton("Clientes");
		btnclientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientes c = new clientes (); 
				c.setVisible(true);
			}
		});
		btnclientes.setBounds(181, 227, 100, 23);
		contentPane.add(btnclientes);
		
		JButton btnmarcas = new JButton("Marcas");
		btnmarcas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marcas m = new marcas (); 
				m.setVisible(true);
			}
		});
		btnmarcas.setBounds(326, 227, 100, 23);
		contentPane.add(btnmarcas);
		
		JLabel lblNewLabel = new JLabel("Bienvenido al Menu");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(181, 35, 259, 61);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione la acci\u00F3n que desea realizar");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		lblNewLabel_1.setBounds(158, 122, 329, 23);
		contentPane.add(lblNewLabel_1);
	}
}
