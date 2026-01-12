package quiz;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AllgemeinwissenPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblTitel;
	private JTextField textFieldFrage;
	private JButton btnAntwort1;
	private JButton btnAntwort2;
	private JButton btnAntwort3;
	private JButton btnAntwort4;
	private JButton btnBack;

	// Design-Konstanten (passend zur Gui.java)
	private final Color BG_FARBE = new Color(26, 35, 52);
	private final Color BTN_FARBE = new Color(35, 50, 75);
	private final Color HOVER_FARBE = new Color(50, 70, 100);
	private final Color AKZENT_FARBE = new Color(0, 150, 200);

	public AllgemeinwissenPanel() {
		initialize();
	}

	private void initialize() {
		setBackground(BG_FARBE);
		setLayout(null);
		// Setze die Größe passend zum Hauptfenster (1280x720)
		setBounds(0, 0, 1280, 720);

		add(getLblTitel());
		add(getTextFieldFrage());
		add(getBtnAntwort1());
		add(getBtnAntwort2());
		add(getBtnAntwort3());
		add(getBtnAntwort4());
		add(getBtnBack());
		setVisible(true);
	}

	private JLabel getLblTitel() {
		if (lblTitel == null) {
			lblTitel = new JLabel("Allgemeinwissen Quiz");
			lblTitel.setForeground(Color.WHITE);
			lblTitel.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitel.setFont(new Font("Arial", Font.BOLD, 40));
			lblTitel.setBounds(340, 30, 600, 50);
		}
		return lblTitel;
	}

	private JTextField getTextFieldFrage() {
		if (textFieldFrage == null) {
			textFieldFrage = new JTextField();
			textFieldFrage.setEditable(false);
			textFieldFrage.setText("Hier steht die Frage?");
			textFieldFrage.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldFrage.setFont(new Font("Arial", Font.PLAIN, 22));
			textFieldFrage.setForeground(Color.WHITE);
			textFieldFrage.setBackground(new Color(45, 55, 75));
			textFieldFrage.setBorder(new LineBorder(AKZENT_FARBE, 1));
			textFieldFrage.setBounds(240, 120, 800, 100);
		}
		return textFieldFrage;
	}

	private JButton getBtnAntwort1() {
		if (btnAntwort1 == null) {
			btnAntwort1 = styleButton(new JButton("Antwort 1"), 240, 280);
		}
		return btnAntwort1;
	}

	private JButton getBtnAntwort2() {
		if (btnAntwort2 == null) {
			btnAntwort2 = styleButton(new JButton("Antwort 2"), 650, 280);
		}
		return btnAntwort2;
	}

	private JButton getBtnAntwort3() {
		if (btnAntwort3 == null) {
			btnAntwort3 = styleButton(new JButton("Antwort 3"), 240, 420);
		}
		return btnAntwort3;
	}

	private JButton getBtnAntwort4() {
		if (btnAntwort4 == null) {
			btnAntwort4 = styleButton(new JButton("Antwort 4"), 650, 420);
		}
		return btnAntwort4;
	}

	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("Zurück");
			btnBack.setFont(new Font("Arial", Font.BOLD, 14));
			btnBack.setForeground(Color.WHITE);
			btnBack.setBackground(new Color(80, 40, 40)); // Dunkelrot für "Zurück"
			btnBack.setBorder(new LineBorder(Color.GRAY, 1));
			btnBack.setFocusPainted(false);
			btnBack.setBounds(20, 20, 120, 40);
		}
		return btnBack;
	}

	/**
	 * Hilfsmethode für einheitliches Button-Styling und Animation
	 */
	private JButton styleButton(JButton btn, int x, int y) {
		btn.setFont(new Font("Arial", Font.BOLD, 18));
		btn.setForeground(Color.WHITE);
		btn.setBackground(BTN_FARBE);
		btn.setFocusPainted(false);
		btn.setBorder(new LineBorder(AKZENT_FARBE, 3, true));
		btn.setBounds(x, y, 390, 100);

		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn.setBackground(HOVER_FARBE);
				// Kleiner "Pop-out" Effekt
				btn.setBounds(x - 5, y - 5, 400, 110);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn.setBackground(BTN_FARBE);
				// Zurück zur Originalgröße
				btn.setBounds(x, y, 390, 100);
			}
		});
		return btn;
	}
}