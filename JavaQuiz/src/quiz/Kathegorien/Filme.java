package quiz.Kathegorien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JRadioButton;

public class Filme extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Filme frame = new Filme();
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
	public Filme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Filme");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 76, 25);
		contentPane.add(lblNewLabel);
		
		JTextPane textPaneFrage = new JTextPane();
		textPaneFrage.setBounds(10, 47, 400, 82);
		contentPane.add(textPaneFrage);
		
		JButton btnNewPruefen = new JButton("Prüfen");
		btnNewPruefen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewPruefen.setBackground(new Color(211, 211, 211));
		btnNewPruefen.setBounds(10, 192, 395, 58);
		contentPane.add(btnNewPruefen);
		
		JRadioButton rdbtnNewAntwort3 = new JRadioButton("New radio button");
		rdbtnNewAntwort3.setBounds(237, 136, 109, 23);
		contentPane.add(rdbtnNewAntwort3);
		
		JRadioButton rdbtnNewAntwort4 = new JRadioButton("New radio button");
		rdbtnNewAntwort4.setBounds(237, 162, 109, 23);
		contentPane.add(rdbtnNewAntwort4);
		
		JRadioButton rdbtnNewAntwort2 = new JRadioButton("New radio button");
		rdbtnNewAntwort2.setBounds(10, 162, 109, 23);
		contentPane.add(rdbtnNewAntwort2);
		
		JRadioButton rdbtnNewAntwort1 = new JRadioButton("New radio button");
		rdbtnNewAntwort1.setBounds(10, 136, 109, 23);
		contentPane.add(rdbtnNewAntwort1);

	}

}
