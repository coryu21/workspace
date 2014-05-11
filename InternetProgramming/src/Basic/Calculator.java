package Basic;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class Calculator extends JFrame {
	private JButton oneJButton, twoJButton, threeJButton, fourJButton,
			fiveJButton, sixJButton, sevenJButton, eightJButton, nineJButton,
			zeroJButton, doubleZeroJButton, plusJButton, minusJButton,
			timesJButton, divideJButton, equalsJButton, decimalJButton,
			clearJButton, clearAllJButton, offJButton;
	private JTextField displayJTextField;
	private JPanel numberJPanel, operationJPanel, clearJPanel;

	public Calculator() {
		createUserInterface();
	}

	private void createUserInterface() {
		Container contentPane = getContentPane();
		contentPane.setLayout(null);

		displayJTextField = new JTextField();
		displayJTextField.setText("0");
		displayJTextField.setBounds(16, 16, 480, 24);
		displayJTextField.setHorizontalAlignment(JTextField.RIGHT);
		contentPane.add(displayJTextField);

		numberJPanel = new JPanel();
		numberJPanel.setLayout(null);
		numberJPanel.setBounds(16, 62, 176, 224);
		numberJPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		contentPane.add(numberJPanel);

		oneJButton = new JButton();
		oneJButton.setText("1");
		oneJButton.setBounds(16, 16, 48, 48);
		numberJPanel.add(oneJButton);

		twoJButton = new JButton();
		twoJButton.setText("2");
		twoJButton.setBounds(64, 16, 48, 48);
		numberJPanel.add(twoJButton);

		threeJButton = new JButton();
		threeJButton.setText("3");
		threeJButton.setBounds(112, 16, 48, 48);
		numberJPanel.add(threeJButton);

		fourJButton = new JButton();
		fourJButton.setText("4");
		fourJButton.setBounds(16, 64, 48, 48);
		numberJPanel.add(fourJButton);

		fiveJButton = new JButton();
		fiveJButton.setText("5");
		fiveJButton.setBounds(64, 64, 48, 48);
		numberJPanel.add(fiveJButton);

		sixJButton = new JButton();
		sixJButton.setText("6");
		sixJButton.setBounds(112, 64, 48, 48);
		numberJPanel.add(sixJButton);

		sevenJButton = new JButton();
		sevenJButton.setText("7");
		sevenJButton.setBounds(16, 112, 48, 48);
		numberJPanel.add(sevenJButton);

		eightJButton = new JButton();
		eightJButton.setText("8");
		eightJButton.setBounds(64, 112, 48, 48);
		numberJPanel.add(eightJButton);

		nineJButton = new JButton();
		nineJButton.setText("9");
		nineJButton.setBounds(112, 112, 48, 48);
		numberJPanel.add(nineJButton);

		zeroJButton = new JButton();
		zeroJButton.setText("0");
		zeroJButton.setBounds(16, 160, 48, 48);
		numberJPanel.add(zeroJButton);

		doubleZeroJButton = new JButton();
		doubleZeroJButton.setText("00");
		doubleZeroJButton.setBounds(64, 160, 96, 48);
		numberJPanel.add(doubleZeroJButton);

		operationJPanel = new JPanel();
		operationJPanel.setLayout(null);
		operationJPanel.setBounds(224, 62, 144, 224);
		operationJPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		contentPane.add(operationJPanel);

		plusJButton = new JButton();
		plusJButton.setText("+");
		plusJButton.setBounds(16, 16, 48, 48);
		plusJButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		operationJPanel.add(plusJButton);

		minusJButton = new JButton();
		minusJButton.setText("-");
		minusJButton.setBounds(80, 16, 48, 48);
		minusJButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		operationJPanel.add(minusJButton);

		timesJButton = new JButton();
		timesJButton.setText("*");
		timesJButton.setBounds(80, 64, 48, 48);
		timesJButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		operationJPanel.add(timesJButton);

		divideJButton = new JButton();
		divideJButton.setText("/");
		divideJButton.setBounds(80, 112, 48, 48);
		divideJButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		operationJPanel.add(divideJButton);

		equalsJButton = new JButton();
		equalsJButton.setText("=");
		equalsJButton.setBounds(80, 160, 48, 48);
		equalsJButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		operationJPanel.add(equalsJButton);

		decimalJButton = new JButton();
		decimalJButton.setText(".");
		decimalJButton.setBounds(16, 160, 48, 48);
		decimalJButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
		operationJPanel.add(decimalJButton);

		clearJPanel = new JPanel();
		clearJPanel.setLayout(null);
		clearJPanel.setBounds(400, 62, 96, 224);
		clearJPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		contentPane.add(clearJPanel);

		clearJButton = new JButton();
		clearJButton.setText("C");
		clearJButton.setBounds(16, 16, 64, 48);
		clearJPanel.add(clearJButton);

		clearAllJButton = new JButton();
		clearAllJButton.setText("C/A");
		clearAllJButton.setBounds(16, 80, 64, 48);
		clearJPanel.add(clearAllJButton);

		offJButton = new JButton();
		offJButton.setText("OFF");
		offJButton.setBounds(16, 144, 64, 48);
		clearJPanel.add(offJButton);

		setTitle("Calculator");
		setSize(520, 330);
		setVisible(true);
	}

	public static void main(String args[]) {
		Calculator application = new Calculator();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
