import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TrayBlackBox implements ActionListener {

	// SystemTray클래스를 얻어옵니다.
	private SystemTray tray = SystemTray.getSystemTray();
	private TrayIcon tray_icon;
	MenuItem show;
	MenuItem hide;
	private JFrame main;
	private String pw;
	public TrayBlackBox(JFrame main, String pw) {
		this.pw = pw;
		this.main = main;
		initTray();
	}

	public void setText(String pw){
		this.pw = pw;
	}
	
	private void initTray() {
		Image image = Toolkit.getDefaultToolkit().getImage("images/Koala.jpg");

		tray_icon = new TrayIcon(image, "BlackBox", createPopupMenu());
		tray_icon.setImageAutoSize(true);

		try {
			tray.add(tray_icon);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public PopupMenu createPopupMenu() {
		PopupMenu menu = new PopupMenu();

		show = new MenuItem("SHOW");
		hide = new MenuItem("HIDE");

		show.addActionListener(this);
		hide.addActionListener(this);
		menu.add(show);
		menu.add(hide);

		return menu;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == hide){
			main.setVisible(false);
		}
		if(e.getSource() == show){
			String pw = JOptionPane.showInputDialog("비밀번호를 입력해주세요");
			if(this.pw.equals(pw)){
				main.setVisible(true);
			}
			else{
				JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않았습니다");
			}
		}
	}
}