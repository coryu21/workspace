import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;


public class PasswordJPanel extends JPanel{
	JLabel pw_lb;
	JPasswordField pw_tf;
	TitledBorder title;
	
	public PasswordJPanel(){
		createInterface();
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
