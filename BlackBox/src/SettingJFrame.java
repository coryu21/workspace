import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JFrame;


public class SettingJFrame extends JFrame implements ActionListener{ // 환경설정 창
	private LinkedList list;
	private Container contentPane;
	private FileJPanel fijp;
	private PasswordJPanel pjp;
	private FolderJPanel fojp;
	private BtnJPanel bjp;
	private Boolean check = false;
	private String pw;
	private String path;
	private TrayBlackBox tbb;
	
	public SettingJFrame(LinkedList list, String pw, TrayBlackBox tbb){
		this.list = list;
		this.pw = pw;
		this.tbb = tbb;
		createInterface();
	}
	
	public String getPath(){
		return path;
	}
	
	public String getPw(){
		return pw;
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
		if(e.getSource() == bjp.getOK()){ // OK 버튼을 누르면 설정해놓은 값이 각 객체로 들어간다.
			pw = pjp.getPw().getText();
			tbb.setText(pw);
			System.out.println(pw);
			path = fojp.getFolder().getText();
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
