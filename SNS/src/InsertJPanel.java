import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class InsertJPanel extends ModifyJPanel {
	
	public InsertJPanel(LinkedList list, DefaultTableModel model) {
		super();
		System.out.println("InsertJPanel 객체 생성자!");
		this.list = list;
		this.model = model;
		createInterface();
	}
	
	public void createInterface(){
		btn.setText("INSERT"); // 버튼의 이름을 바꿈
	}
	
	public void event(){
		System.out.println("INSERT 버튼 이벤트 발생!");
		Information info = new Information(name_tf.getText(), id_tf.getText(), ad_tf.getText()); // 새로운 데이터 객체 생성
		System.out.println(" Name : " + info.getName() + "  ID : " + info.getId() + "  SNS : " + info.getSns());
		list.add(info); // 리스트에 추가
		print();
		refreshTable(); // 테이블을 다시 그림
	}
	
	public void print(){ // Console창을 통하여 리스트에 어떠한 값이 있는 지를 확인
		Iterator<Information> it = list.iterator();
		Information i;
		int count = 1;
		while (it.hasNext()) {
			i = it.next();
			System.out.println("[" + (count++) + "]" + " Name : " + i.getName() + "  ID : " + i.getId() + "  SNS : " + i.getSns());
		}
	}
	
	
}
