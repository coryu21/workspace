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


public class UpdateJPanel extends ModifyJPanel {
	
	public UpdateJPanel(LinkedList list, DefaultTableModel model) {
		super();
		System.out.println("UpdateJPanel 객체 생성자!");
		this.list = list;
		this.model = model;
		createInterface();
	}
	
	public void createInterface(){
		btn.setText("UPDATE"); // 버튼의 이름을 바꿈
	}

	public void event() {
		System.out.println("UPDATE 버튼 이벤트 발생!");
		Iterator<Information> it = list.iterator();
		Information i;
		int count = 0;
		while (it.hasNext()) { 
			i = it.next();
			if(i.getName().equals(name_tf.getText())){ // 이름으로 수정
				list.get(count).setName(name_tf.getText());
				list.get(count).setId(id_tf.getText());
				list.get(count).setSns(ad_tf.getText());
			}
			else if(i.getId().equals(id_tf.getText())){ // 아이디로 수정
				list.get(count).setName(name_tf.getText());
				list.get(count).setId(id_tf.getText());
				list.get(count).setSns(ad_tf.getText());
			}
			else if(i.getName().equals(name_tf.getText()) && i.getId().equals(id_tf.getText())){ // 이름과 아이디로 수정
				list.get(count).setName(name_tf.getText());
				list.get(count).setId(id_tf.getText());
				list.get(count).setSns(ad_tf.getText());
			}
			count++;
		}
		refreshTable();
	}
}
