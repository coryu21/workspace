import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JFrame;


public class SettingJFrame extends JFrame implements ActionListener{
	LinkedList list;
	Container contentPane;
	FileJPanel fijp;
	PasswordJPanel pjp;
	FolderJPanel fojp;
	BtnJPanel bjp;
	Boolean check = false;
	String pw;
	String path;
	TrayBlackBox tbb;
	
	public SettingJFrame(LinkedList list, String pw, TrayBlackBox tbb){
		this.list = list;
		this.pw = pw;
		this.tbb = tbb;
		createInterface();
	}
	
	public void createInterface(){
		contentPane = this.getContentPane();
		fijp = new FileJPanel(list);
		pjp = new PasswordJPanel();
		fojp = new FolderJPanel();
		bjp = new BtnJPanel();
		
		contentPane.add(fijp, BorderLayout.NORTH);
		contentPane.add(pjp, BorderLayout.EAST);
		contentPane.add(fojp, BorderLayout.WEST);
		contentPane.add(bjp, BorderLayout.SOUTH);
		
		event();
		
		this.setTitle("SETTING");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setResizable(false);
	}
	
	public void event(){
		bjp.getOK().addActionListener(this);
		bjp.getCancle().addActionListener(this);
	}

	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == bjp.getOK()){
			pw = pjp.pw_tf.getText();
			tbb.setText(pw);
			System.out.println(pw);
			path = fojp.folder_tf.getText();
			check = true;
		}
		if(e.getSource() == bjp.getCancle()){
			check = false;
		}
		this.setVisible(false);
	}
	
	public Boolean getCheck(){
		return check;
	}
}
