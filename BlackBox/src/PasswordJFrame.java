import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class PasswordJFrame extends JFrame { // 블랙박스가 동작하면 올바른 비밀번호를 입력할 때까지 마우스와 키보드(비밀번호 입력 제외)의 사용을 못하게 한다.
	private Container contentPane;
	private JLabel pw_lb;
	private JPasswordField pw_tf;
	private String pw;
	private MouseNoMove mnm;
	private FocusThread ft;
	
	public PasswordJFrame(String pw) {
		this.pw = pw;
		createInterface();
		this.mnm = new MouseNoMove();
		this.ft = new FocusThread();
		mnm.start();
		ft.start();
	}

	public void createInterface() {

		contentPane = this.getContentPane();
		contentPane.setLayout(new FlowLayout());
		pw_lb = new JLabel("PASSWORD :");
		pw_tf = new JPasswordField(10);
		contentPane.add(pw_lb);
		contentPane.add(pw_tf);
		event();

		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);
	}

	public void event() {
		pw_tf.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					check();
				}
			}

			public void keyReleased(KeyEvent e) {
			}

			public void keyTyped(KeyEvent e) {
			}

		});

	}
	
	public JFrame getJFrame(){
		return this;
	}

	public void check() {
		if (pw_tf.getText().equals(pw)) {
			JOptionPane.showMessageDialog(null, "비밀번호가 일치합니다");
			mnm.stop();
			ft.stop();
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다");
			pw_tf.setText("");
		}

	}
	
	class FocusThread extends Thread{
		public void run(){
			while(true){
				getJFrame().toFront();
			}
		}
	}
}
