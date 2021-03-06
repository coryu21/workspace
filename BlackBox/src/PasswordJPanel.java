import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;


public class PasswordJPanel extends JPanel{ // 비밀번호를 설정하는 패널
	private JLabel pw_lb;
	private JPasswordField pw_tf;
	private TitledBorder title;
	
	public PasswordJPanel(){
		createInterface();
	}
	
	public JPasswordField getPw(){
		return pw_tf;
	}
	public void createInterface(){
		pw_lb = new JLabel("PASSWORD");
		pw_tf = new JPasswordField(10);
		title = new TitledBorder("PASSWORD");
		this.setBorder(title);
		this.add(pw_lb);
		this.add(pw_tf);
	}

}
