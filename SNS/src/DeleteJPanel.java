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

public class DeleteJPanel extends ModifyJPanel {

	public DeleteJPanel(LinkedList list, DefaultTableModel model) {
		super();
		System.out.println("DeleteJPanel 객체 생성자!");
		this.list = list;
		this.model = model;
		createInterface();
	}

	public void createInterface() {
		btn.setText("DELETE"); // 버튼의 이름을 바꿈
	}

	public void event() {
		System.out.println("DELETE 버튼 이벤트 발생!");
		Iterator<Information> it = list.iterator();
		Information i;
		int count = 0;
		try {
			while (it.hasNext()) {
				i = it.next();
				if (i.getName().equals(name_tf.getText()) // 이름으로 삭제
						&& id_tf.getText().equals("")) {
					list.remove(count);
				} else if (i.getId().equals(id_tf.getText()) // 아이디로 삭제
						&& name_tf.getText().equals("")) {
					list.remove(count);
				} else if (i.getName().equals(name_tf.getText()) // 이름과 아이디로 삭제
						&& i.getId().equals(id_tf.getText())) {
					list.remove(count);
				}
				count++;
			}
		} catch (Exception e) {
		}
		refreshTable();
	}
}
