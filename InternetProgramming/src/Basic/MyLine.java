package Basic;
import java.awt.Color;
import java.awt.Graphics;

public class MyLine extends MyShape {
	public MyLine(int firstX, int firstY, int secondX, int secondY,
			Color shapeColor) {
		super(firstX, firstY, secondX, secondY, shapeColor);
	}

	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(getX1(), getY1(), getX2(), getY2());
	}
}
