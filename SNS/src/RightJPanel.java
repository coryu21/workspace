import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class RightJPanel extends RefreshTable{
	JTable table;
	JButton btn;
	JScrollPane scrollPane;
	DefaultTableCellRenderer dtcr; // 테이블셀 렌더러 객체를 생성.
			
	public RightJPanel(LinkedList list, DefaultTableModel model){
		this.list = list;
		this.model = model;
		createInterface();
	}
	
	public void createInterface(){
		dtcr = new DefaultTableCellRenderer(); 
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 컬럼과 로우의 값을 가운데로 정렬
		
		table = new JTable(model);
		table.getColumnModel().getColumn(0).setCellRenderer(dtcr); // 정렬 추가
		table.getColumnModel().getColumn(1).setCellRenderer(dtcr);
		table.getColumnModel().getColumn(2).setCellRenderer(dtcr);
		
		scrollPane = new JScrollPane(table);
		btn = new JButton("새로고침");
		
		btn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				refreshTable();
			}
		});
		
		TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel> (model); // 컬럼별로 정렬 시킴
		table.setRowSorter(sorter);
		
		this.setLayout(new BorderLayout());
		this.add(scrollPane, BorderLayout.NORTH);
		this.add(btn, BorderLayout.SOUTH);
	}
}
