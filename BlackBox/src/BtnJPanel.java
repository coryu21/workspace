import javax.swing.JButton;
import javax.swing.JPanel;


public class BtnJPanel extends JPanel{
	JButton ok_btn;
	JButton cancle_btn;
	
	public BtnJPanel(){
		createInterface();
	}
	
	public void createInterface(){
		ok_btn = new JButton("OK");
		cancle_btn = new JButton("CANCLE");
		this.add(ok_btn);
		this.add(cancle_btn);
	}
	
	public JButton getOK(){
		return ok_btn;
	}
	
	public JButton getCancle(){
		return cancle_btn;
	}

}