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

public class Video extends Thread{
	private IplImage frame = null;
	private CvCapture capture = null;
	private FrameGrabber grabber;
	private String fileName = "TEST.avi";
	private int sec = 100;
	
	public Video(String fileName, int sec) {
		grabber = new VideoInputFrameGrabber(0);
		this.fileName = fileName;
		this.sec = sec;
	}

	public void run(){
		capture();
	}
	
	public void capture() {
		try {
			System.out.println("촬영이 시작되었습니다.");
			grabber.start();
			FrameRecorder recorder = new OpenCVFrameRecorder(fileName, 640, 480);
			recorder.setVideoCodec(CV_FOURCC('M', 'J', 'P', 'G'));
			recorder.setPixelFormat(1);
			recorder.setFrameRate(22);

			recorder.start();

			for (int i = 0; i < sec; i++) {
				frame = grabber.grab();
				recorder.record(frame);
			}
			recorder.stop();
			grabber.stop();
			System.out.println("촬영이 완료되었습니다");

		} catch (Exception | com.googlecode.javacv.FrameRecorder.Exception e) {
			e.printStackTrace();
		}
	}
}
