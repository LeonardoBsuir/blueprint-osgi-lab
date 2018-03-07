package blueprint.osgi.lab.consumer;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import org.springframework.stereotype.Component;

@Component
public class ConsumerFrame extends JFrame {
	
	private static final long serialVersionUID = 8941649782243422946L;
	
	private JTextField textField;
	private JButton refreshButton;
	
	private RefreshListener refreshListener;
	
	public ConsumerFrame() {
		initialize();
	}
	
	public void setRefreshListener(RefreshListener refreshListener) {
		this.refreshListener = refreshListener;
	}
	
	private void initialize() {
		setSize(400, 200);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{53, 198, 43, 0, 0};
		gridBagLayout.rowHeights = new int[]{48, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		refreshButton = new JButton("Refresh");
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshButtonActionPerformed(e);
			}
		});
		GridBagConstraints gbc_refreshButton = new GridBagConstraints();
		gbc_refreshButton.gridx = 3;
		gbc_refreshButton.gridy = 1;
		getContentPane().add(refreshButton, gbc_refreshButton);
	}

	

	private void refreshButtonActionPerformed(ActionEvent e) {
		textField.setText("");
		textField.setText(refreshListener.refresh());
	}
}
