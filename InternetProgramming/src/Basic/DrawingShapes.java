package Basic;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class DrawingShapes extends JFrame{
	private JPanel controlsJPanel;
	private JComboBox shapeJComboBox;
	private JButton colorJButton;
	private PaintJPanel painterPaintJPanel;
	private String[] shapeTypes = {"Line", "Rectangle", "Oval"};
	
	public DrawingShapes(){
		createUserInterface();
	}
	
	private void createUserInterface(){
		Container contentPane = getContentPane();
		contentPane.setLayout(null);
		
		controlsJPanel = new JPanel();
		controlsJPanel.setBounds(0, 0, 400, 40);
		controlsJPanel.setLayout(null);
		contentPane.add(controlsJPanel);
		
		painterPaintJPanel = new PaintJPanel();
		painterPaintJPanel.setBounds(0, 40, 400, 340);
		painterPaintJPanel.setBackground(Color.WHITE);
		contentPane.add(painterPaintJPanel);
		
		shapeJComboBox = new JComboBox(shapeTypes);
		shapeJComboBox.setBounds(90, 2, 100, 24);
		controlsJPanel.add(shapeJComboBox);
		shapeJComboBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				shapeJComboBoxActionPerformed(event);
			}
		});
	
	colorJButton = new JButton();
	colorJButton.setBounds(210, 2, 80, 24);
	colorJButton.setText("Color");
	controlsJPanel.add(colorJButton);
	colorJButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
			colorJButtonActionPerformed(event);
		}
	});
	
	setTitle("Drawing Shpaes");
	setSize(408, 407);
	setVisible(true);
	}
	
	private void shapeJComboBoxActionPerformed(ActionEvent event){
		painterPaintJPanel.setCurrentShapeType((String)shapeJComboBox.getSelectedItem());
	}
	
	private void colorJButtonActionPerformed(ActionEvent event){
		Color selection = JColorChooser.showDialog(this, "Select a Color", Color.BLACK);
				
		if(selection != null){
			colorJButton.setBackground(selection);
			painterPaintJPanel.setCurrentColor(selection);
		}	
	}
	
	public static void main(String args[]){
		DrawingShapes application = new DrawingShapes();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
