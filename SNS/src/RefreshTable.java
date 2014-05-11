import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class RefreshTable extends JPanel { 
	LinkedList<Information> list;
	DefaultTableModel model;

	public void refreshTable() { // 테이블을 다시 그리는 함수
		Iterator<Information> it = list.iterator();
		Information i;
		int count = 0;
		model.setNumRows(0); // 모델의 모든 로우 삭제
		while (it.hasNext()) { // 반복자를 사용하여 모델에 리스트의 모든 데이터를 추가한다
			i = it.next();
			Object temp[] = { i.getName(), i.getId(), i.getSns() };
			model.addRow(temp);
			count++;
		}
	}
}
