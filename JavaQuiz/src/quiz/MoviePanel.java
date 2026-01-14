package quiz;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class MoviePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblTitel;
	protected JTextField textFieldFrage;
	protected JButton btnAntwort1;
	protected JButton btnAntwort2;
	protected JButton btnAntwort3;
	protected JButton btnAntwort4;
	private JButton btnBack;

	/**
	 * Create the panel.
	 */
	public MoviePanel() {

		initialize();
	}
	private void initialize() {
		setLayout(null);
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
			lblTitel = new JLabel("Movie Quiz");
			lblTitel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTitel.setBounds(137, 6, 174, 17);
		}
		return lblTitel;
	}
	protected JTextField getTextFieldFrage() {
		if (textFieldFrage == null) {
			textFieldFrage = new JTextField();
			textFieldFrage.setBounds(19, 34, 414, 83);
			textFieldFrage.setColumns(10);
		}
		return textFieldFrage;
	}
	protected JButton getBtnAntwort1() {
		if (btnAntwort1 == null) {
			btnAntwort1 = new JButton("");
			btnAntwort1.setBounds(19, 128, 161, 67);
		}
		return btnAntwort1;
	}
	protected JButton getBtnAntwort2() {
		if (btnAntwort2 == null) {
			btnAntwort2 = new JButton("");
			btnAntwort2.setBounds(19, 206, 161, 67);
		}
		return btnAntwort2;
	}
	protected JButton getBtnAntwort3() {
		if (btnAntwort3 == null) {
			btnAntwort3 = new JButton("");
			btnAntwort3.setBounds(272, 128, 161, 67);
		}
		return btnAntwort3;
	}
	protected JButton getBtnAntwort4() {
		if (btnAntwort4 == null) {
			btnAntwort4 = new JButton("");
			btnAntwort4.setBounds(272, 206, 161, 67);
		}
		return btnAntwort4;
	}
	private JButton getBtnBack() {
		if (btnBack == null) {
			btnBack = new JButton("Zurück");
			btnBack.setBounds(0, 1, 117, 29);
		}
		return btnBack;
	}
}
