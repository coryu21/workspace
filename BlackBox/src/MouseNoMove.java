import java.awt.AWTException;
import java.awt.Robot;

public class MouseNoMove extends Thread { // 마우스를 정지시키는 쓰레드
	private Robot robot;
	
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
