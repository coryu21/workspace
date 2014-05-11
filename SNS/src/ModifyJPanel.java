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


public abstract class ModifyJPanel extends RefreshTable{
	
	JTextField name_tf;
	JTextField id_tf;
	JLabel name_lb;
	JLabel id_lb;
	JTextField ad_tf;
	JLabel ad_lb;
	JButton btn;
	
	public ModifyJPanel(){ // 인터페이스 구현
		setLayout(null);

		name_lb = new JLabel("Name");
		name_lb.setFont(new Font("Dialog", Font.BOLD, 15));
		name_lb.setBounds(12, 10, 57, 32);
		add(name_lb);

		name_tf = new JTextField();
		name_tf.setBounds(81, 13, 146, 32);
		add(name_tf);
		name_tf.setColumns(10);

		id_lb = new JLabel("ID");
		id_lb.setFont(new Font("Dialog", Font.BOLD, 15));
		id_lb.setBounds(12, 55, 47, 32);
		add(id_lb);

		id_tf = new JTextField();
		id_tf.setColumns(10);
		id_tf.setBounds(81, 55, 146, 32);
		add(id_tf);
		
		ad_lb = new JLabel("Address");
		ad_lb.setFont(new Font("Dialog", Font.BOLD, 15));
		ad_lb.setBounds(12, 100, 70, 32);
		add(ad_lb);

		ad_tf = new JTextField();
		ad_tf.setColumns(10);
		ad_tf.setBounds(81, 97, 146, 32);
		add(ad_tf);

		btn = new JButton("Button");
		btn.setFont(new Font("Dialog", Font.BOLD, 15));
		btn.setBounds(119, 139, 108, 32);
		btnEvent();
		add(btn);
	}
	public void btnEvent() { // 버튼 이벤트 등록
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				event();
			}
		});
	}
	public abstract void createInterface(); // 버튼의 이름을 바꿔주는 함수 -> 자식들마다 버튼의 이름이 다르다
	public abstract void event(); // 검색, 추가, 수정, 삭제 버튼의 기능의 함수 -> 자식들마다 버튼의 기능이 다르다
}
