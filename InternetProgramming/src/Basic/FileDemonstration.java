package Basic;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FileDemonstration extends JFrame {
	private JTextArea outputArea;
	private JScrollPane scrollPane;

	public FileDemonstration() {
		super("Testing class File");

		outputArea = new JTextArea();
		scrollPane = new JScrollPane(outputArea);
		add(scrollPane, BorderLayout.CENTER);
		setSize(400, 400);
		setVisible(true);

		analyzePath();
	}

	public File getFileOrDirectory() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int result = fileChooser.showOpenDialog(this);
		if(result == JFileChooser.CANCEL_OPTION)
			System.exit(1);
		
		File fileName = fileChooser.getSelectedFile();
		
		if((fileName == null) || (fileName.getName().equals(""))){
			JOptionPane.showMessageDialog(this, "Invalid Name", "Invalid Name", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		
		return fileName;
	}
	
	public void analyzePath(){
		File name = getFileOrDirectory();
		
		if(name.exists()){
			outputArea.setText(name.getName() + " exists\n");
			outputArea.append(name.isFile() ? " is a file" : "is not a file");
			outputArea.append(name.isDirectory() ? " is a Directory" : "is not a Directory");
			if(name.isDirectory()){
				String[] directory = name.list();
				outputArea.append("\n\nDirectory contents:\n");
				
				for(String directoryName : directory)
					outputArea.append(directoryName + "\n");
			}
		}
		else{
			JOptionPane.showMessageDialog(this, name+" does not exist.", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String args[]) {
		FileDemonstration application = new FileDemonstration();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}