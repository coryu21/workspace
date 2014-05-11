import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class PasswordJFrame extends JFrame {
	Container contentPane;
	JLabel pw_lb;
	JPasswordField pw_tf;
	String pw;
	MouseNoMove mnm;

	public PasswordJFrame(String pw) {
		this.pw = pw;
		createInterface();
		this.mnm = new MouseNoMove();
		mnm.start();
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

	public void check() {
		if (pw_tf.getText().equals(pw)) {
			JOptionPane.showMessageDialog(null, "비밀번호가 일치합니다");
			mnm.stop();
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다");
			pw_tf.setText("");
		}

	}
}
