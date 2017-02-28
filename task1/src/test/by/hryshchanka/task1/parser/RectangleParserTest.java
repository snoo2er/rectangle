package test.by.hryshchanka.task1.parser;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Test;

import by.hryshchanka.task1.parser.RectangleParser;


public class RectangleParserTest {
	private static List<String> lines = new ArrayList<String>();
	
	@After
	public void clearLines() {
		lines.clear();
	}
	
	@Test
	public void RectanglePointQuantityExceptionTest()  {
		lines.add("8 0 0 0 8 10 0 10");
		lines.add("-6 4 8 9");
		lines.add("8 0 0 0 8 10 0 10 5");
		ArrayList<Integer[]> list = RectangleParser.createCoordinateList(lines);
		boolean expected = false;
		boolean actual = list.size() > 1;
		assertEquals(expected, actual);
	}
	@Test
	public void numberFormatExceptionTest()  {
		lines.add("-9gg -8 5 4 -6 4 8 9");
		lines.add("8 0 0 0 8 10 0 10");
		lines.add("8 0 0 o 8 10 0 10");
		ArrayList<Integer[]> list = RectangleParser.createCoordinateList(lines);
		boolean expected = true;
		boolean actual = list.size() == 1;
		assertEquals(expected, actual);
	}
	@Test (expected = RuntimeException.class)
	public void createEmtyListTest() {
		lines.add("-6 4 8 9");
		lines.add("-9gg -8 5 4 -6 4 8 9");
		lines.add("8 0 0 o 8 10 0 10");
		RectangleParser.createCoordinateList(lines);
	}
	
}
