package test.by.hryshchanka.task1.logic;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import by.hryshchanka.task1.entity.Point;
import by.hryshchanka.task1.entity.Rectangle;
import by.hryshchanka.task1.logic.RectangleLogic;

public class RectangleLogicTest {
	private static Rectangle testRectangle;
	@BeforeClass
	public static void initTestRectangle() {
		testRectangle = new Rectangle(new Point(12,0), new Point(0,0), new Point(12,10), new Point(0,10));
	}
	
	@Test
	public void calculatePerimeterTest() {
		double expected = 44.0;
		double actual = RectangleLogic.calculatePerimeter(testRectangle);
		assertEquals(expected, actual, 0.001);
	}
	
	@Test
	public void calculateAreaTest() {
		double expected = 120.0;
		double actual = RectangleLogic.calculateArea(testRectangle);
		assertEquals(expected, actual, 0.001);
	}
	
	@Test
	public void isRectangleTest() {
		boolean expected = true;
		boolean actual = RectangleLogic.isRectangle(testRectangle);
		assertEquals(expected, actual);
	}
	
	@Test
	public void isQuadrateTest() {
		boolean expected = false;
		boolean actual = RectangleLogic.isQuadrate(testRectangle);
		assertEquals(expected, actual);
	}
}
