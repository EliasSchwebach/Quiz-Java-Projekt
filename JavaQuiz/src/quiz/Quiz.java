package quiz;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class Quiz extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Quiz() {
		setToolTipText("");
		setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(20, 190, 97, 23);
		add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("New check box");
		chckbxNewCheckBox_1.setBounds(258, 190, 97, 23);
		add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("New check box");
		chckbxNewCheckBox_2.setBounds(20, 216, 97, 23);
		add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("New check box");
		chckbxNewCheckBox_3.setBounds(258, 216, 97, 23);
		add(chckbxNewCheckBox_3);
		
		JButton btnNewButton = new JButton("Prüfen");
		btnNewButton.setBounds(20, 259, 403, 30);
		add(btnNewButton);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(20, 11, 403, 147);
		add(textPane);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{chckbxNewCheckBox, chckbxNewCheckBox_1, chckbxNewCheckBox_2, chckbxNewCheckBox_3, btnNewButton, textPane}));

	}
}
