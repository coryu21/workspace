package Server;

import java.awt.Container;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClientReceive extends JFrame {
	Container contentPane;
	JPanel imagePanel;
	JLabel imageLabel;

	public ClientReceive() {
		super("Image Load");
		this.setSize(800, 600);

		contentPane = this.getContentPane();
		imagePanel = new JPanel();
		imageLabel = new JLabel();

		imagePanel.add(imageLabel);
		contentPane.add(imagePanel);
		this.setContentPane(contentPane);

		this.setVisible(true);
	}

	public void receiveImage(Socket socket) {
		try {
			BufferedImage image = ImageIO.read(socket.getInputStream());
			System.out.println(image.toString());
			this.imageLabel.setIcon(new ImageIcon(image));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
