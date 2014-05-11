import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_highgui.*;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;

import com.googlecode.javacv.FrameGrabber;
import com.googlecode.javacv.FrameGrabber.Exception;
import com.googlecode.javacv.VideoInputFrameGrabber;

public class Sample {
	private static IplImage frame = null;
	private static CvCapture capture = null;

	public static void main(String[] args) {
		//capture = cvCreateCameraCapture(0);
		 FrameGrabber grabber = new VideoInputFrameGrabber(0);
		 try {
			grabber.start();
			frame = grabber.grab();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		cvShowImage("JavaCV CAM Test (exit = esc)", frame);
		cvSaveImage("ddd.jpg", frame);
	}

}
