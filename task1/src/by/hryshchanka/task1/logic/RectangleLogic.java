package by.hryshchanka.task1.logic;

import java.util.Arrays;

import by.hryshchanka.task1.entity.Rectangle;

public class RectangleLogic {
	private static Double[] findSides (Rectangle rectangle) {
		double a = Math.hypot(rectangle.getPoint1().getX() - rectangle.getPoint2().getX(), rectangle.getPoint1().getY() - rectangle.getPoint2().getY());
		double b = Math.hypot(rectangle.getPoint1().getX() - rectangle.getPoint3().getX(), rectangle.getPoint1().getY() - rectangle.getPoint3().getY());
		double c = Math.hypot(rectangle.getPoint1().getX() - rectangle.getPoint4().getX(), rectangle.getPoint1().getY() - rectangle.getPoint4().getY());
		Double[] sides = {a, b ,c};
		Arrays.sort(sides);
		return sides;
	}

	public static double calculatePerimeter(Rectangle rectangle) {
		Double[] sides = findSides(rectangle);
		return 2 * (sides[0] + sides[1]);
	}
		
	public static double calculateArea (Rectangle rectangle) {
		Double[] sides = findSides(rectangle);
		return sides[0] * sides[1];
	}

	public static boolean isRectangle(Rectangle rectangle) {
		double a1 = Math.hypot(rectangle.getPoint1().getX() - rectangle.getPoint2().getX(), rectangle.getPoint1().getY() - rectangle.getPoint2().getY());
		double b1 = Math.hypot(rectangle.getPoint1().getX() - rectangle.getPoint3().getX(), rectangle.getPoint1().getY() - rectangle.getPoint3().getY());
		double c1 = Math.hypot(rectangle.getPoint1().getX() - rectangle.getPoint4().getX(), rectangle.getPoint1().getY() - rectangle.getPoint4().getY());
		
		double a2 = Math.hypot(rectangle.getPoint3().getX() - rectangle.getPoint4().getX(), rectangle.getPoint3().getY() - rectangle.getPoint4().getY());
		double b2 = Math.hypot(rectangle.getPoint2().getX() - rectangle.getPoint4().getX(), rectangle.getPoint2().getY() - rectangle.getPoint4().getY());
		double c2 = Math.hypot(rectangle.getPoint2().getX() - rectangle.getPoint3().getX(), rectangle.getPoint2().getY() - rectangle.getPoint3().getY());
		
		double diagonal = Math.max(Math.max(a1, b1), c1);
		
		if (a1 == diagonal && a1 != 0) {
			if (b1 == b2 && c1 == c2){
				return (a1 == a2); 
			} else {
				return false; 
			}
			
		} else if (b1 == diagonal && b1 != 0) {
			if (a1 == a2 && c1 == c2){
				return (b1 == b2); 
			} else {
				return false; 
			}
		} else {
			if (b1 == b2 && a1 == a2){
				return (c1 == c2); 
			} else {
				return false; 
			}
		}
	}
	
	public static boolean isQuadrate(Rectangle rectangle) {
		Double[] sides = findSides(rectangle);
		return sides[0] == sides[1];
	}
}
