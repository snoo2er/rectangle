package by.hryshchanka.task1.entity;

import java.util.ArrayList;
import java.util.Iterator;
import by.hryshchanka.task1.listener.RectangleObserver;

public class Rectangle{
	
	private long id;
	private ArrayList<RectangleObserver> observerList = new ArrayList<>();
	private Point point1;
	private Point point2;
	private Point point3;
	private Point point4;
	
	public Rectangle(Point point1, Point point2, Point point3, Point point4) {
		super();
		this.point1 = point1;
		this.point2 = point2;
		this.point3 = point3;
		this.point4 = point4;
	}
	
	public Rectangle(Point point1, Point point2, Point point3, Point point4, RectangleObserver observer) {
		super();
		this.point1 = point1;
		this.point2 = point2;
		this.point3 = point3;
		this.point4 = point4;
		observerList.add(observer);
	}

	public void addObserver(RectangleObserver observer) {
		observerList.add(observer);
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Point getPoint1() {
		return point1;
	}
	
	public void setPoint1(Point point1) {
		this.point1 = point1;
	}
	
	public Point getPoint2() {
		return point2;
	}
	
	public void setPoint2(Point point2) {
		this.point2 = point2;
	}
	
	public Point getPoint3() {
		return point3;
	}
	
	public void setPoint3(Point point3) {
		this.point3 = point3;
	}
	
	public Point getPoint4() {
		return point4;
	}
	
	public void setPoint4(Point point4) {
		this.point4 = point4;
	}
	
	public void setPoints (Point point1, Point point2, Point point3, Point point4) {
		this.point1 = point1;
		this.point2 = point2;
		this.point3 = point3;
		this.point4 = point4;
		notifyObservers();
	}
	
	private void notifyObservers() {
		Iterator<RectangleObserver> it = observerList.iterator();
		while (it.hasNext()) {
			((RectangleObserver)it.next()).valueChanged(this);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((point1 == null) ? 0 : point1.hashCode());
		result = prime * result + ((point2 == null) ? 0 : point2.hashCode());
		result = prime * result + ((point3 == null) ? 0 : point3.hashCode());
		result = prime * result + ((point4 == null) ? 0 : point4.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		if (point1.getX() != other.point1.getX() || point1.getY() != other.point1.getY() || 
				point2.getX() != other.point2.getX() || point2.getY() != other.point2.getY() || 
				point3.getX() != other.point3.getX() || point3.getY() != other.point3.getY() || 
				point4.getX() != other.point4.getX() || point4.getY() != other.point4.getY())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rectangle " + id + " - [point1(" + point1 + "), point2(" + point2 + "), point3(" + point3 + "), point 4("
				+ point4 + ")]\n";
	}
	
}
