package Basic;
import java.awt.Color;
import java.awt.Graphics;


public abstract class MyShape extends Object{
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private Color color;
	
	public MyShape(int firstX, int firstY, int secondX, int secondY, Color shapeColor){
		setX1(firstX);
		setY1(firstY);
		setX2(secondX);
		setY2(secondY);
		setColor(shapeColor);
	}
	
	public final void setX1(int x){
		this.x1 = x;
	}
	
	public final int getX1(){
		return this.x1;
	}
	
	public final void setX2(int x){
		this.x2 = x;
	}
	
	public final int getX2(){
		return this.x2;
	}
	
	public final void setY1(int y){
		this.y1 = y;
	}
	
	public final int getY1(){
		return this.y1;
	}
	
	public final void setY2(int y){
		this.y2 = y;
	}
	
	public final int getY2(){
		return this.y2;
	}
	
	public final void setColor(Color color){
		this.color = color;
	}
	
	public final Color getColor(){
		return this.color;
	}

	public abstract void draw(Graphics g);
}
