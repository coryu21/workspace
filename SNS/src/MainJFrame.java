import java.awt.BorderLayout;
import java.awt.Container;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class MainJFrame extends JFrame {
	Container contentPane;
	LinkedList<Information> list;
	DefaultTableModel model;

	Object column[] = {"Name", "ID", "SNS"}; // 컬럼 값
	Object[][] data;
	
	public MainJFrame() {
		createInterface();
	}
	
	public void createInterface(){
		list = new LinkedList<Information>();
		model = new DefaultTableModel(data, column);
		
		contentPane = this.getContentPane();
		contentPane.add(new LeftTabPane(list, model)); // list와 model을 매개변수로 넘겨줌
		contentPane.add(new RightJPanel(list, model), BorderLayout.EAST);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLocationRelativeTo(null); // 창을 가운데로 띄움
		this.setTitle("SNS 관리 프로그램");
		this.setSize(720, 480);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		MainJFrame mf = new MainJFrame();
	}
}
