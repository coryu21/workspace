import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


public class FolderJPanel extends JPanel{
	JTextField folder_tf;
	JButton set_btn;
	TitledBorder title;
	JFileChooser chooser;
	String path;
	
	public FolderJPanel(){
		chooser = new JFileChooser();
		createInterface();
	}
	
	public void createInterface(){
		
		chooser.setFileSelectionMode( javax.swing.JFileChooser.DIRECTORIES_ONLY);
		
		folder_tf = new JTextField(20);
		set_btn = new JButton("SET");
		title = new TitledBorder("SET FOLDER");
		
		this.setBorder(title);
		this.add(folder_tf);
		this.add(set_btn);
		event();
	}
	
	public void event() {
		set_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setFolder();
			}
		});
	}
	
	public void setFolder(){
		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			path = chooser.getSelectedFile().getPath();
			folder_tf.setText(path);
		}
	}
}
