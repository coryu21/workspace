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

public class SearchJPanel extends ModifyJPanel {

	public SearchJPanel(LinkedList list, DefaultTableModel model) {
		super();
		System.out.println("SearchJPanel 객체 생성자!");
		this.list = list;
		this.model = model;
		createInterface();
	}

	public void createInterface() {
		btn.setText("SEARCH"); // 버튼의 이름을 바꿈
	}

	public void event() {
		System.out.println("SEARCH 버튼 이벤트 발생!");
		Iterator<Information> it = list.iterator();
		Information i;
		model.setNumRows(0); // 모델의 모든 로우 삭제
		while (it.hasNext()) { // 입력한 값에 해당하는 값들을 테이블에 추가
			i = it.next();
			if(i.getName().equals(name_tf.getText()) && id_tf.getText().equals("")){ // 이름으로 검색
				Object temp[] = { i.getName(), i.getId(), i.getSns()};
				model.addRow(temp);
			}
			else if(i.getId().equals(id_tf.getText()) && name_tf.getText().equals("")){ // 아이디로 검색
				Object temp[] = { i.getName(), i.getId(), i.getSns()};
				model.addRow(temp);
			}
			else if(i.getName().equals(name_tf.getText()) && i.getId().equals(id_tf.getText())){ // 이름과 아이디 모두로 검색
				Object temp[] = { i.getName(), i.getId(), i.getSns()};
				model.addRow(temp);
			}
		}
	}
}
