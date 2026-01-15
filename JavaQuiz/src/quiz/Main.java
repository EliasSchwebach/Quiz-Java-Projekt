package quiz;

public class Main {

	public static void main(String[] args) {
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Controller();
			}
		});
	}

}