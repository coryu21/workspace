import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;

public class LeftTabPane extends JTabbedPane {
	SearchJPanel sp;
	InsertJPanel ip;
	UpdateJPanel up;
	DeleteJPanel dp;
	LinkedList list;
	DefaultTableModel model;
	
	public LeftTabPane(LinkedList list, DefaultTableModel model) {
		this.list = list;	
		this.model = model;
		createInterface();
	}

	public void createInterface() {
		sp = new SearchJPanel(list, model); // 각각의 객체 생성
		ip = new InsertJPanel(list, model);
		up = new UpdateJPanel(list, model);
		dp = new DeleteJPanel(list, model);
		
		add("검색", sp); // 각각의 객체 추가
		add("추가", ip);
		add("수정", up);
		add("삭제", dp);
	}
}
