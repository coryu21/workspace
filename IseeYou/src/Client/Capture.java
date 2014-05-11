package Client;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.imageio.ImageIO;

public class Capture extends Thread {
	Robot robot;
	BufferedImage bufImage = null;
	Rectangle area;
	Socket socket;

	public Capture(Socket socket) {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		this.socket = socket;
		area = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
	}

	public BufferedImage capture() {
		bufImage = robot.createScreenCapture(area);
		return bufImage;
	}

	public void run() {
		while (true) {
			try{
				capture();
				ImageIO.write(this.bufImage, "PNG", this.socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

/*
 * Sender
 * 
 * BufferedImage image = ....; ImageIO.write(image, "PNG",
 * socket.getOutputStream()); Receiver
 * 
 * BufferedImage image = ImageIO.read(socket.getInputStream());
 */