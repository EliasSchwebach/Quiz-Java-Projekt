package quiz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Toolkit;

public class Gui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnAllg;
	private JButton btnVideoGames;
	private JButton btnMovie;
	private Controller controller;

	/**
	 * Create the frame.
	 */
	public Gui(Controller controller) {
		setFont(new Font("Cambria", Font.PLAIN, 17));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Home\\OneDrive - Berufliches Schulzentrum für Wirtschaft und Datenverarbeitung\\Dokumente\\GitHub\\Quiz-Java-Projekt\\JavaQuiz\\src\\Bilder\\Held_der_Steine.jpg"));
		setTitle("JAVA QUIZ VON ELIAS UND MARIAN");
		setBackground(new Color(245, 245, 245));
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		initialize();
		this.controller = controller;
	}

	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNewLabel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getBtnAllg());
		contentPane.add(getBtnVideoGames());
		contentPane.add(getBtnMovie());
		setVisible(true);
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Java Quiz Game");
			lblNewLabel.setFont(new Font("Minecraft", Font.PLAIN, 17));
			lblNewLabel.setBounds(147, 6, 158, 34);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Themen Gebiet Aussuchen");
			lblNewLabel_1.setFont(new Font("Minecraft", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(136, 32, 219, 34);
		}
		return lblNewLabel_1;
	}

	private JButton getBtnAllg() {
		if (btnAllg == null) {
			btnAllg = new JButton("Allgemein Wissen");
			btnAllg.setFont(new Font("Minecraft", Font.PLAIN, 13));
			btnAllg.setBounds(27, 78, 158, 60);
		}
		return btnAllg;
	}

	private JButton getBtnVideoGames() {
		if (btnVideoGames == null) {
			btnVideoGames = new JButton("Video Games");
			btnVideoGames.setFont(new Font("Minecraft", Font.PLAIN, 13));
			btnVideoGames.setBounds(238, 78, 158, 60);
		}
		return btnVideoGames;
	}

	private JButton getBtnMovie() {
		if (btnMovie == null) {
			btnMovie = new JButton("Filme");
			btnMovie.setFont(new Font("Minecraft", Font.PLAIN, 13));
			btnMovie.setBounds(27, 175, 158, 60);
		}
		return btnMovie;
	}
}
