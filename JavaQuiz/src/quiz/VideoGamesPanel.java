package quiz;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VideoGamesPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblTitel;
	protected JTextField textFieldFrage;
	protected JButton btnAntwort1;
	protected JButton btnAntwort2;
	protected JButton btnAntwort3;
	protected JButton btnAntwort4;
	private JButton btnBack;

	// Farben aus der Haupt-GUI
	private Color bgFarbe = new Color(26, 35, 52);
	private Color buttonFarbe = new Color(35, 50, 75);
	private Color hoverFarbe = new Color(50, 70, 100);
	private Color akzentFarbe = new Color(0, 150, 200);

	public VideoGamesPanel() {
		initialize();
	}

	private void initialize() {
		setBackground(bgFarbe);
		setLayout(null);
		setBounds(0, 0, 1280, 720);

		add(getLblTitel());
		add(getTextFieldFrage());
		add(getBtnAntwort1());
		add(getBtnAntwort2());
		add(getBtnAntwort3());
		add(getBtnAntwort4());
		add(getBtnBack());
	}

	private JLabel getLblTitel() 
	{
		if (lblTitel == null) {
			lblTitel = new JLabel("Video Games Quiz");
			lblTitel.setForeground(Color.WHITE);
			lblTitel.setHorizontalAlignment(SwingConstants.CENTER);
			lblTitel.setFont(new Font("Arial", Font.BOLD, 40));
			lblTitel.setBounds(340, 30, 600, 50);
		}
		return lblTitel;
	}

	protected JTextField getTextFieldFrage() {
		if (textFieldFrage == null) {
			textFieldFrage = new JTextField();
			textFieldFrage.setEditable(false);
			textFieldFrage.setText("Hier steht die Frage?");
			textFieldFrage.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldFrage.setFont(new Font("Arial", Font.PLAIN, 22));
			textFieldFrage.setForeground(Color.WHITE);
			textFieldFrage.setBackground(new Color(45, 55, 75));
			textFieldFrage.setBorder(new LineBorder(akzentFarbe, 1));
			textFieldFrage.setBounds(240, 120, 800, 100);
		}
		return textFieldFrage;
	}

	protected JButton getBtnAntwort1() {
		if (btnAntwort1 == null) {
			btnAntwort1 = styleButton(new JButton("Antwort 1"), 240, 280);
		}
		return btnAntwort1;
	}

	protected JButton getBtnAntwort2() {
		if (btnAntwort2 == null) {
			btnAntwort2 = styleButton(new JButton("Antwort 2"), 650, 280);
		}
		return btnAntwort2;
	}

	protected JButton getBtnAntwort3() {
		if (btnAntwort3 == null) {
			btnAntwort3 = styleButton(new JButton("Antwort 3"), 240, 420);
		}
		return btnAntwort3;
	}

	protected JButton getBtnAntwort4() {
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
			btnBack.setBackground(new Color(80, 40, 40)); 
			btnBack.setBorder(new LineBorder(Color.GRAY, 1));
			btnBack.setFocusPainted(false);
			btnBack.setBounds(20, 20, 120, 40);
			
		}
		return btnBack;
	}

	// Hilfsmethode, um den Hover-Effekt wie in der GUI anzuwenden
	private JButton styleButton(JButton btn, int x, int y) {
		btn.setFont(new Font("Arial", Font.BOLD, 18));
		btn.setForeground(Color.WHITE);
		btn.setBackground(buttonFarbe);
		btn.setFocusPainted(false);
		btn.setBorder(new LineBorder(akzentFarbe, 3, true));
		btn.setBounds(x, y, 390, 100);

		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn.setBackground(hoverFarbe);
				btn.setBounds(x - 5, y - 5, 400, 110); // Vergrößern
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn.setBackground(buttonFarbe);
				btn.setBounds(x, y, 390, 100); // Normalzustand
			}
		});
		return btn;
	}
}