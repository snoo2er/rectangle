package test.by.hryshchanka.task1.action;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import by.hryshchanka.task1.action.RectangleListCreator;
import by.hryshchanka.task1.entity.Point;
import by.hryshchanka.task1.entity.Rectangle;

public class RectangleListCreatorTest {
	private static ArrayList<Integer[]> coordinateList = new ArrayList<>();;
		
	@BeforeClass
	public static void addTestCoordinates() {
		Integer[] quadrateCoordinatese = {5, 0, 0, 5, -5, 0, 0, -5};
		Integer[] rectangleCoordinates = {250, -5, 250, 112, -63, 112, -63, -5};
		Integer[] notRectangleCoordinatesOne = {0, 0, 0, 5, -5, 0, 0, -5};
		Integer[] notRectangleCoordinatesTwo = {12, -3, 0, -3, 12, 10, 0, 7};
		
		coordinateList.add(quadrateCoordinatese);
		coordinateList.add(rectangleCoordinates);
		coordinateList.add(notRectangleCoordinatesOne);
		coordinateList.add(notRectangleCoordinatesTwo);
	}
	
	@Test
	public void createRectangleListTest() {
		ArrayList<Rectangle> testRectangleList = RectangleListCreator.createRectangleList(coordinateList);
		boolean expected = true;
		boolean actual = (testRectangleList.size() == 2 && 
				testRectangleList.get(0).equals(new Rectangle(new Point(5, 0), new Point(0, 5), new Point(-5 ,0), new Point(0 ,-5))) &&
				testRectangleList.get(1).equals(new Rectangle(new Point(250, -5), new Point(250, 112), new Point(-63 ,112), new Point(-63 ,-5))));
		assertEquals(expected, actual);
	}
}
