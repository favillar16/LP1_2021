import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculadora extends JFrame {

	private JPanel contentPane;
	private JTextField txtvalor1;
	private JTextField txtvalor2;
	private JTextField txtresultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
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
	public Calculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Valor 1");
		lblNewLabel.setBounds(6, 77, 87, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor 2");
		lblNewLabel_1.setBounds(140, 81, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Resultado");
		lblNewLabel_2.setBounds(279, 81, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		txtvalor1 = new JTextField();
		txtvalor1.setBounds(6, 111, 86, 20);
		contentPane.add(txtvalor1);
		txtvalor1.setColumns(10);
		
		txtvalor2 = new JTextField();
		txtvalor2.setBounds(140, 111, 86, 20);
		contentPane.add(txtvalor2);
		txtvalor2.setColumns(10);
		
		txtresultado = new JTextField();
		txtresultado.setBounds(279, 111, 86, 20);
		contentPane.add(txtresultado);
		txtresultado.setColumns(10);
		
		JButton btnsumar = new JButton("sumar");
		btnsumar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a,b,c;
				a=Integer.parseInt(txtvalor1.getText());
				b=Integer.parseInt(txtvalor2.getText());
				c=a+b;
				String res=Integer.toString(c);
				txtresultado.setText(res);
			}
		});
		
		btnsumar.setBounds(23, 179, 89, 23);
		contentPane.add(btnsumar);
		
		JButton btnsalir = new JButton("salir");
		btnsalir.setBounds(323, 179, 89, 23);
		contentPane.add(btnsalir);
		
		JButton btnrestar1 = new JButton("restar");
		btnrestar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int a,b,c;
				a=Integer.parseInt(txtvalor1.getText());
				b=Integer.parseInt(txtvalor2.getText());
				c=a-b;
				String res=Integer.toString(c);
				txtresultado.setText(res);
				
			}
		});
		btnrestar1.setBounds(23, 216, 89, 23);
		contentPane.add(btnrestar1);
		
		JButton btnmultiplicar1 = new JButton("multiplicar");
		btnmultiplicar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a,b,c;
				a=Integer.parseInt(txtvalor1.getText());
				b=Integer.parseInt(txtvalor2.getText());
				c=a*b;
				String res=Integer.toString(c);
				txtresultado.setText(res);
			}
		});
		btnmultiplicar1.setBounds(132, 179, 89, 23);
		contentPane.add(btnmultiplicar1);
		
		JButton btndividir1 = new JButton("dividir");
		btndividir1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a,b,c;
				a=Integer.parseInt(txtvalor1.getText());
				b=Integer.parseInt(txtvalor2.getText());
				c=a/b;
				String res=Integer.toString(c);
				txtresultado.setText(res);
			}
		});
		btndividir1.setBounds(137, 216, 89, 23);
		contentPane.add(btndividir1);
	}
}
