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

public class Video{
	IplImage frame = null;
	CvCapture capture = null;
	FrameGrabber grabber;
	String fileName = "TEST.avi";
	int sec = 100;
	public Video(String fileName, int sec) {
		grabber = new VideoInputFrameGrabber(0);
		this.fileName = fileName;
		this.sec = sec;
		capture(this.fileName, this.sec);
	}

	public void capture(String fileName, int sec) {
		try {
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

		} catch (Exception | com.googlecode.javacv.FrameRecorder.Exception e) {
			e.printStackTrace();
		}
	}
}