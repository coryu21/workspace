import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

public class FileJPanel extends JPanel {
	private JTextArea ta;
	private JButton search_btn;
	private TitledBorder title;
	private LinkedList list;
	private JFileChooser chooser;
	private JScrollPane scrollPane;

	public FileJPanel(LinkedList list) {
		this.list = list;
		chooser = new JFileChooser();
		createInterface();
	}

	public void createInterface() {
		ta = new JTextArea(10, 20);
		search_btn = new JButton("SEARCH");
		title = new TitledBorder("FILE LIST");
		scrollPane = new JScrollPane(ta);
		scrollPane
				.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.setBorder(title);
		this.add(scrollPane);
		this.add(search_btn);
		event();
	}

	public void event() {
		search_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile();
			}
		});
	}
	
	public void openFile(){
		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			ta.append(file.getName() + "\n");
			list.add(file);
			System.out.println(file);
		}
	}

}
