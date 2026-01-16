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
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Canvas;
import java.awt.Button;
import javax.swing.ImageIcon;

public class Gui extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnAllg;
	private JButton btnVideoGames;
	private JButton btnMovie;
	private Controller controller;
	private JButton btnAnmelden;
	private JButton btnAusloggen;
	private JPanel startAnsicht;
	private JLabel lblHelligkeit;
	private boolean istHell = false;

	public Gui(Controller controller)
	{
		setFont(new Font("Cambria", Font.PLAIN, 17));
		setIconImage(Toolkit.getDefaultToolkit().getImage(Gui.class.getResource("/Bilder/Held_der_Steine.jpg")));
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

	private void initialize()
	{
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
		contentPane.add(getBtnAnmelden());
		contentPane.add(getBtnAusloggen());
		this.startAnsicht = (JPanel) this.getContentPane();
		setVisible(true);
	}

	private JLabel getLblNewLabel()
	{
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Java Quiz Menü");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 48));
			lblNewLabel.setBounds(340, 40, 600, 60);
		}

		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1()
	{
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Themen Gebiet aussuchen");
			lblNewLabel_1.setForeground(new Color(160, 170, 190));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 24));
			lblNewLabel_1.setBounds(340, 110, 600, 40);
		}

		return lblNewLabel_1;
	}

	private JButton getBtnAllg()
	{
		if (btnAllg == null) {
			btnAllg = new JButton("Allgemein Wissen");
			btnAllg.setToolTipText("Allgemein Wissens Quiz");
			btnAllg.setFont(new Font("Arial", Font.BOLD, 22));
			btnAllg.setForeground(Color.WHITE);
			btnAllg.setContentAreaFilled(false);
			btnAllg.setOpaque(false);
			btnAllg.setBackground(new Color(35, 50, 75));
			btnAllg.setFocusPainted(false);
			btnAllg.setBorder(new LineBorder(new Color(0, 150, 200), 3, true));
			btnAllg.setBounds(80, 250, 460, 160);

			btnAllg.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseEntered(MouseEvent e)
				{
					btnAllg.setBackground(new Color(120, 130, 150));
					btnAllg.setBorder(new LineBorder(new Color(0, 150, 200), 3, true));
					btnAllg.setBounds(70, 240, 480, 180);
				}

				@Override
				public void mouseExited(MouseEvent e)
				{
					btnAllg.setBackground(new Color(100, 110, 130));
					btnAllg.setBorder(new LineBorder(new Color(0, 150, 200), 3, true));
					btnAllg.setBounds(80, 250, 460, 160);
				}
			});

			btnAllg.addActionListener(e -> {
				controller.loadAllgemeinwissenFragen();
				controller.zeigeAllgemeinwissen();
			});
		}

		return btnAllg;
	}

	private JButton getBtnVideoGames()
	{
		if (btnVideoGames == null) {
			btnVideoGames = new JButton("Video Games");
			btnVideoGames.setToolTipText("Video Games Quiz");
			btnVideoGames.setFont(new Font("Arial", Font.BOLD, 22));
			btnVideoGames.setForeground(Color.WHITE);
			btnVideoGames.setContentAreaFilled(false);
			btnVideoGames.setOpaque(false);
			btnVideoGames.setBackground(new Color(35, 50, 75));
			btnVideoGames.setFocusPainted(false);
			btnVideoGames.setBorder(new LineBorder(new Color(0, 150, 200), 3, true));
			btnVideoGames.setBounds(740, 250, 460, 160);
			btnVideoGames.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseEntered(MouseEvent e)
				{
					btnVideoGames.setBackground(new Color(50, 70, 100));
					btnVideoGames.setBorder(new LineBorder(new Color(0, 180, 230), 4, true));
					btnVideoGames.setBounds(730, 240, 480, 180);
				}

				@Override
				public void mouseExited(MouseEvent e)
				{
					btnVideoGames.setBackground(new Color(35, 50, 75));
					btnVideoGames.setBorder(new LineBorder(new Color(0, 150, 200), 3, true));
					btnVideoGames.setBounds(740, 250, 460, 160);
				}
			});

			btnVideoGames.addActionListener(e -> {
				controller.loadVideoGamesFragen();
				controller.zeigeVideoGames();
			});
		}

		return btnVideoGames;
	}

	private JButton getBtnMovie()
	{
		if (btnMovie == null) {
			btnMovie = new JButton("Filme & Serien");
			btnMovie.setToolTipText("Filme & Serien Quiz");
			btnMovie.setFont(new Font("Arial", Font.BOLD, 22));
			btnMovie.setForeground(Color.WHITE);
			btnMovie.setBackground(new Color(35, 50, 75));
			btnMovie.setContentAreaFilled(false);
			btnMovie.setOpaque(false);
			btnMovie.setFocusPainted(false);
			btnMovie.setBorder(new LineBorder(new Color(0, 150, 200), 3, true));
			btnMovie.setBounds(394, 471, 460, 160);
			btnMovie.addMouseListener(new MouseAdapter()
			{

				@Override
				public void mouseEntered(MouseEvent e)
				{
					btnMovie.setBackground(new Color(50, 70, 100));
					btnMovie.setBorder(new LineBorder(new Color(0, 180, 230), 4, true));
					btnMovie.setBounds(384, 461, 480, 180);
				}

				@Override
				public void mouseExited(MouseEvent e)
				{
					btnMovie.setBackground(new Color(35, 50, 75));
					btnMovie.setBorder(new LineBorder(new Color(0, 150, 200), 3, true));
					btnMovie.setBounds(394, 471, 460, 160);
				}
			});

			btnMovie.addActionListener(e -> {
				controller.loadMovieFragen();
				controller.zeigeMovie();
			});
		}

		return btnMovie;
	}

	private JButton getBtnAnmelden()
	{
	    if (btnAnmelden == null) {
	        btnAnmelden = new JButton("Anmelden");
	        btnAnmelden.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                controller.zeigeAnmelden(); 
	            }
	        });
	       
	        
	        btnAnmelden.setToolTipText("Anmelden um den Punktestand zu sehen");
	        btnAnmelden.setOpaque(false);
	        btnAnmelden.setForeground(Color.WHITE);
	        btnAnmelden.setFont(new Font("Arial", Font.BOLD, 22));
	        btnAnmelden.setFocusPainted(false);
	        btnAnmelden.setContentAreaFilled(false);
	        btnAnmelden.setBorder(new LineBorder(new Color(0, 150, 200), 3, true));
	        btnAnmelden.setBackground(new Color(35, 50, 75));
	        btnAnmelden.setBounds(900, 44, 142, 71);
	    }
	    return btnAnmelden;
	}
	

	private JButton getBtnAusloggen()
	{
		if (btnAusloggen == null) {
			btnAusloggen = new JButton("Ausloggen");
			btnAusloggen.setToolTipText("Ausloggen (Daten bleiben bestehen)");
			btnAusloggen.setOpaque(false);
			btnAusloggen.setForeground(Color.WHITE);
			btnAusloggen.setFont(new Font("Arial", Font.BOLD, 22));
			btnAusloggen.setFocusPainted(false);
			btnAusloggen.setContentAreaFilled(false);
			btnAusloggen.setBorder(new LineBorder(new Color(0, 150, 200), 3, true));
			btnAusloggen.setBackground(new Color(35, 50, 75));
			btnAusloggen.setBounds(1074, 45, 142, 68);
		}
		return btnAusloggen;
	}

	public void setView(JPanel neuesPanel)
	{
		this.setContentPane(neuesPanel);
		this.revalidate();
		this.repaint();
	}

	public void zeigeHauptmenue()
	{
		this.setView(startAnsicht);
	}
}