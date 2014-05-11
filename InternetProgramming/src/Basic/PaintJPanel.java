package Basic;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

public class PaintJPanel extends JPanel {
	private ArrayList shapesArrayList = new ArrayList();
	private MyShape currentShape;
	private String currentType = "Line";
	private Color currentColor = new Color(204, 204, 204);

	public PaintJPanel() {
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent event) {
				paintJPanelMousePressed(event);
			}
		});

		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent event) {
				paintJPanelMouseDragged(event);
			}
		});
	}

	public void setCurrentShapeType(String shape) {
		currentType = shape;
	}

	public void setCurrentColor(Color shapeColor) {
		currentColor = shapeColor;
	}

	public void paintJPanelMousePressed(MouseEvent event) {
		if (currentType.equals("Line")) {
			currentShape = new MyLine(event.getX(), event.getY(), event.getX(),
					event.getY(), currentColor);
			
		}
		if (currentType.equals("Rectangle")) {
			currentShape = new MyRectangle(event.getX(), event.getY(), event.getX(),
					event.getY(), currentColor);
		}
		if (currentType.equals("Oval")) {
			currentShape = new MyOval(event.getX(), event.getY(), event.getX(),
					event.getY(), currentColor);
		}
		shapesArrayList.add(currentShape);
	}

	public void paintJPanelMouseDragged(MouseEvent event){
		currentShape.setX2(event.getX());
		currentShape.setY2(event.getY());
		repaint();
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		MyShape nextShape;
		Iterator shapesIterator = shapesArrayList.iterator();
		
		while(shapesIterator.hasNext()){
			nextShape = (MyShape)shapesIterator.next();
			nextShape.draw(g);
		}
	}
}
