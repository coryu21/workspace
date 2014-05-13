import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class MainJFrame extends JFrame implements ActionListener{ // 기본 화면
	private Container contentPane;
	private JButton start_btn, setting_btn, exit_btn;
	private SettingJFrame sjf;
	private WatchThread wt;
	private LinkedList list;
	private String pw;
	private Video video;
	private TrayBlackBox tbb;
	public MainJFrame(){
		list = new LinkedList();
		tbb = new TrayBlackBox(this, "1234");
		createInterface();
	}

	public void createInterface(){
		sjf = new SettingJFrame(list, pw, tbb);
		contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		start_btn = new JButton(new ImageIcon("images/start.png"));
		setting_btn = new JButton(new ImageIcon("images/setting.png"));
		exit_btn = new JButton(new ImageIcon("images/exit.png"));
		btnEvent();
		
		contentPane.add(start_btn);
		contentPane.add(setting_btn);
		contentPane.add(exit_btn);
		
		this.setUndecorated(true);
		this.setTitle("BLACK BOX");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public void btnEvent(){
		start_btn.addActionListener(this);
		setting_btn.addActionListener(this);
		exit_btn.addActionListener(this);
	}	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==start_btn){
			String fileName = sjf.getPath() + "\\BlackBox.avi";
			System.out.println(fileName);
			video = new Video(fileName, 300);
			wt = new WatchThread(list, sjf.getPw());
			wt.setVideo(video);
			wt.start();
			this.setVisible(false);
		}
		if(e.getSource()==setting_btn){
			sjf.setVisible(true);
		}
		if(e.getSource()==exit_btn){
			System.exit(0);
		}
		
	}
}
