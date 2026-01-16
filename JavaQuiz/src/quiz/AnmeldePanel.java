package quiz;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class AnmeldePanel extends JPanel
{

	private static final long serialVersionUID = 1L;
	private JLabel lblUberschrift;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private Controller controller;
	private JPasswordField textField_1;
	private JButton btnRegistrieren;
	private JButton btnAnmelden;

	public AnmeldePanel(Controller controller)
	{
		this.controller = controller;
		setBackground(new Color(26, 35, 52));
		setBounds(0, 0, 1280, 720);
		initialize();
	}

	private void initialize()
	{
		setLayout(null);
		add(getLblUberschrift());
		add(getLblNewLabel());
		add(getTextField());
		add(getLblNewLabel_1());
		add(getTextField_1());
		add(getBtnRegistrieren());
		add(getBtnAnmelden());
	}

	private JLabel getLblUberschrift()
	{
		if (lblUberschrift == null) {
			lblUberschrift = new JLabel("Anmeldung / Registrierung");
			lblUberschrift.setForeground(Color.WHITE);
			lblUberschrift.setFont(new Font("Arial", Font.BOLD, 40));
			lblUberschrift.setHorizontalAlignment(SwingConstants.CENTER);
			lblUberschrift.setBounds(340, 50, 600, 60);
		}
		return lblUberschrift;
	}

	private JLabel getLblNewLabel()
	{
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Name:");
			lblNewLabel.setForeground(new Color(160, 170, 190));
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 24));
			lblNewLabel.setBounds(440, 200, 150, 30);
		}
		return lblNewLabel;
	}

	private JTextField getTextField()
	{
		if (textField == null) {
			textField = new JTextField();
			textField.setBackground(new Color(35, 50, 75));
			textField.setForeground(Color.WHITE);
			textField.setFont(new Font("Arial", Font.PLAIN, 20));
			textField.setBorder(new LineBorder(new Color(0, 150, 200), 2));
			textField.setCaretColor(Color.WHITE);
			textField.setBounds(440, 240, 448, 45);
			textField.setColumns(10);
		}
		return textField;
	}

	private JLabel getLblNewLabel_1()
	{
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Passwort:");
			lblNewLabel_1.setForeground(new Color(160, 170, 190));
			lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 24));
			lblNewLabel_1.setBounds(440, 320, 150, 30);
		}
		return lblNewLabel_1;
	}

	private JPasswordField getTextField_1()
	{
		if (textField_1 == null) {
			textField_1 = new JPasswordField();
			textField_1.setToolTipText("Speicher es dir gut ab!");
			textField_1.setBackground(new Color(35, 50, 75));
			textField_1.setForeground(Color.WHITE);
			textField_1.setFont(new Font("Arial", Font.PLAIN, 20));
			textField_1.setBorder(new LineBorder(new Color(0, 150, 200), 2));
			textField_1.setCaretColor(Color.WHITE);
			textField_1.setBounds(440, 360, 448, 45);
			textField_1.setColumns(10);
		}
		return textField_1;
	}

	private JButton getBtnRegistrieren()
	{
		if (btnRegistrieren == null) {
			btnRegistrieren = new JButton("Registrieren");
			styleButton(btnRegistrieren, 440, 450, 180, 60);
		}
		return btnRegistrieren;
	}

	private JButton getBtnAnmelden()
	{
		if (btnAnmelden == null) {
			btnAnmelden = new JButton("Anmelden");
			styleButton(btnAnmelden, 660, 450, 180, 60);
		}
		return btnAnmelden;
	}

	private void styleButton(JButton btn, int x, int y, int width, int height)
	{
		btn.setFont(new Font("Arial", Font.BOLD, 18));
		btn.setForeground(Color.WHITE);
		btn.setBackground(new Color(35, 50, 75));
		btn.setBounds(x, y, width, height);
		btn.setFocusPainted(false);
		btn.setBorder(new LineBorder(new Color(0, 150, 200), 3, true));

		btn.setContentAreaFilled(false);
		btn.setOpaque(true);

		btn.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e)
			{
				btn.setBackground(new Color(50, 70, 100));
				btn.setBounds(x - 5, y - 5, width + 10, height + 10);
			}

			@Override
			public void mouseExited(MouseEvent e)
			{
				btn.setBackground(new Color(35, 50, 75));
				btn.setBounds(x, y, width, height);
			}
		});
	}
}