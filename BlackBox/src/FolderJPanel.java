import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


public class FolderJPanel extends JPanel{ // 동영상 저장 폴더를 설정하는 패널
	private JTextField folder_tf;
	private JButton set_btn;
	private TitledBorder title;
	private JFileChooser chooser;
	private String path;
	
	public FolderJPanel(){
		chooser = new JFileChooser();
		createInterface();
	}
	
	public JTextField getFolder(){
		return folder_tf;
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
