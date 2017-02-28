package by.hryshchanka.task1.action;

import java.util.ArrayList;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.hryshchanka.task1.assigner.RectangleIdAssigner;
import by.hryshchanka.task1.entity.Point;
import by.hryshchanka.task1.entity.Rectangle;

import by.hryshchanka.task1.logic.RectangleLogic;

public class RectangleListCreator {
	private static final Logger LOGGER = LogManager.getLogger(RectangleListCreator.class);
	
	public static ArrayList<Rectangle> createRectangleList (ArrayList<Integer[]> coordinateList){
		ArrayList<Rectangle> rectangles = new ArrayList<>();
		
		for (int i = 0; i < coordinateList.size(); i++) {
			Rectangle current = (new Rectangle(new Point(coordinateList.get(i)[0], coordinateList.get(i)[1]), new Point(coordinateList.get(i)[2], coordinateList.get(i)[3]),
					new Point(coordinateList.get(i)[4], coordinateList.get(i)[5]), new Point(coordinateList.get(i)[6], coordinateList.get(i)[7])));
			if (RectangleLogic.isRectangle(current)) {
				current.setId(RectangleIdAssigner.assignId());
				rectangles.add(current);
			} else {
				LOGGER.log(Level.WARN, current + "not a rectangle");
			}
		}
		LOGGER.log(Level.TRACE, "RectangleList created\n" + rectangles);
		return rectangles;
	}
}
