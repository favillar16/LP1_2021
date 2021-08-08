import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Logeo extends JFrame {

	private JPanel contentPane;
	private JTextField textusuario;
	private JPasswordField jpassClave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logeo frame = new Logeo();
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
	public Logeo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(151, 11, 82, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Usuario");
		lblNewLabel_1.setBounds(20, 65, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contrase\u00F1a");
		lblNewLabel_2.setBounds(20, 101, 70, 14);
		contentPane.add(lblNewLabel_2);
		
		textusuario = new JTextField();
		textusuario.setBounds(88, 62, 145, 20);
		contentPane.add(textusuario);
		textusuario.setColumns(10);
		
		JButton btningresar = new JButton("Ingresar");
		btningresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char [] clave = jpassClave.getPassword();
				String clavefinal=new String(clave);
				if (textusuario.getText().equals("ADMIN") && clavefinal.equals("12345") ) {
					dispose();
					JOptionPane.showMessageDialog(null,"BIENVENIDO AL SISTEMA","Lenguaje LP1",
					JOptionPane.INFORMATION_MESSAGE		);
					Principal p = new Principal ();
					p.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null,"Datos Icorrectos","Lenguaje LP1",
							JOptionPane.ERROR_MESSAGE		);
				}
			}
		});
		btningresar.setBounds(79, 144, 89, 23);
		contentPane.add(btningresar);
		
		JButton btnsalir = new JButton("Salir");
		btnsalir.setBounds(212, 144, 89, 23);
		contentPane.add(btnsalir);
		
		jpassClave = new JPasswordField();
		jpassClave.setBounds(88, 98, 145, 20);
		contentPane.add(jpassClave);
	}
}
