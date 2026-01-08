 package quiz;

public class Main {

	public static void main(String[] args) {
		// Set the system look and feel (on Windows this uses the Windows LAF if
		// available)
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// If setting the system L&F fails, print a stack trace and continue with
			// default L&F
			e.printStackTrace();
		}

		// Ensure GUI is created on the Event Dispatch Thread
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Controller();
			}
		});
	}

}