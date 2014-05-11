import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;
import static com.googlecode.javacv.cpp.opencv_highgui.*;

import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.FrameRecorder;
import com.googlecode.javacv.OpenCVFrameRecorder;
import com.googlecode.javacv.VideoInputFrameGrabber;
import com.googlecode.javacv.FrameGrabber.Exception;
import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_highgui.CvCapture;

public class VideoJFrame extends JFrame {
	Container contentPane;
	JLabel imagelb;
	IplImage frame = null;
	CvCapture capture = null;
	FrameGrabber grabber;

	public VideoJFrame() {
		grabber = new VideoInputFrameGrabber(0);
		imagelb = new JLabel();
		createInterface();
		capture();
	}

	public void createInterface() {
		contentPane = this.getContentPane();
		contentPane.add(imagelb);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); // 창을 가운데로 띄움
		this.setTitle("블랙박스");
		this.setSize(720, 480);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void capture() {
		try {
			grabber.start();
			String FILENAME = "TEST.avi";
			FrameRecorder recorder = new OpenCVFrameRecorder(FILENAME,  640, 480);
	        recorder.setVideoCodec(CV_FOURCC('M','J','P','G'));
	        recorder.setPixelFormat(1);
	        recorder.setFrameRate(22);
	       // recorder.setVideoBitrate(10 * 1024 * 1024);

	        recorder.start();
	           
	        
			for (int i = 0; i<100; i++) {
				frame = grabber.grab();
				recorder.record(frame);
				imagelb.setIcon(new ImageIcon(frame.getBufferedImage()));
			}
			recorder.stop();
	        grabber.stop();

		} catch (Exception | com.googlecode.javacv.FrameRecorder.Exception e) {
			System.out.println("!!!");
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		new VideoJFrame();
	}
}
