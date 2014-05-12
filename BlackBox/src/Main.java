import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
	public static void main(String args[]) {
		MainJFrame mjf = new MainJFrame();
		try {
			UIManager
					.setLookAndFeel("net.infonode.gui.laf.InfoNodeLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
