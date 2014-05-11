import java.awt.AWTException;
import java.awt.Robot;

public class MouseNoMove extends Thread {
	Robot robot;
	
	public MouseNoMove() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		while(true){
			robot.mouseMove(1000, 550);
		}
	}

}
