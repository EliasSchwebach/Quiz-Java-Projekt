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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\willmsmarian\\OneDrive - Berufliches Schulzentrum für Wirtschaft und Datenverarbeitung\\Dokumente\\GitHub\\Quiz-Java-Projekt1\\JavaQuiz\\src\\Bilder\\Held_der_Steine.jpg"));
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
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(26, 35, 52));
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
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 48));
			lblNewLabel.setBounds(340, 40, 600, 60);
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Themen Gebiet Aussuchen");
			lblNewLabel_1.setForeground(new Color(160, 170, 190));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 24));
			lblNewLabel_1.setBounds(340, 110, 600, 40);
		}
		return lblNewLabel_1;
	}

	private JButton getBtnAllg() {
		if (btnAllg == null) {
			btnAllg = new JButton("Allgemein Wissen");
			btnAllg.setFont(new Font("Arial", Font.BOLD, 22));
			btnAllg.setForeground(Color.WHITE);
			btnAllg.setBackground(new Color(35, 50, 75));
			btnAllg.setFocusPainted(false);
			btnAllg.setBorder(new LineBorder(new Color(0, 150, 200), 3, true));
			btnAllg.setBounds(80, 250, 460, 160);

			// Hover-Effekt mit Größenänderung
			btnAllg.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnAllg.setBackground(new Color(120, 130, 150));
					btnAllg.setBorder(new LineBorder(new Color(0, 150, 200), 3, true));
					btnAllg.setBounds(70, 240, 480, 180);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnAllg.setBackground(new Color(100, 110, 130));
					btnAllg.setBorder(new LineBorder(new Color(0, 150, 200), 3, true));
					btnAllg.setBounds(80, 250, 460, 160);
				}
			});

			btnAllg.addActionListener(e -> controller.zeigeAllgemeinwissen());
		}
		return btnAllg;
	}

	private JButton getBtnVideoGames() {
		if (btnVideoGames == null) {
			btnVideoGames = new JButton("Video Games");
			btnVideoGames.setFont(new Font("Arial", Font.BOLD, 22));
			btnVideoGames.setForeground(Color.WHITE);
			btnVideoGames.setBackground(new Color(35, 50, 75));
			btnVideoGames.setFocusPainted(false);
			btnVideoGames.setBorder(new LineBorder(new Color(0, 150, 200), 3, true));
			btnVideoGames.setBounds(740, 250, 460, 160);

			// Hover-Effekt mit Größenänderung
			btnVideoGames.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnVideoGames.setBackground(new Color(50, 70, 100));
					btnVideoGames.setBorder(new LineBorder(new Color(0, 180, 230), 4, true));
					btnVideoGames.setBounds(730, 240, 480, 180);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnVideoGames.setBackground(new Color(35, 50, 75));
					btnVideoGames.setBorder(new LineBorder(new Color(0, 150, 200), 3, true));
					btnVideoGames.setBounds(740, 250, 460, 160);
				}
			});

			btnVideoGames.addActionListener(e -> controller.zeigeVideoGames());
		}
		return btnVideoGames;
	}

	private JButton getBtnMovie() {
		if (btnMovie == null) {
			btnMovie = new JButton("Filme");
			btnMovie.setFont(new Font("Arial", Font.BOLD, 22));
			btnMovie.setForeground(Color.WHITE);
			btnMovie.setBackground(new Color(35, 50, 75));
			btnMovie.setFocusPainted(false);
			btnMovie.setBorder(new LineBorder(new Color(0, 150, 200), 3, true));
			btnMovie.setBounds(360, 515, 460, 100);

			// Hover-Effekt mit Größenänderung
			btnMovie.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnMovie.setBackground(new Color(50, 70, 100));
					btnMovie.setBorder(new LineBorder(new Color(0, 180, 230), 4, true));
					btnMovie.setBounds(350, 505, 480, 120);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnMovie.setBackground(new Color(35, 50, 75));
					btnMovie.setBorder(new LineBorder(new Color(0, 150, 200), 3, true));
					btnMovie.setBounds(360, 515, 460, 100);
				}
			});

			btnMovie.addActionListener(e -> controller.zeigeMovie());
		}
		return btnMovie;
	}

	public void setView(JPanel neuesPanel) {
		this.setContentPane(neuesPanel);
		this.revalidate();
		this.repaint();
	}

}