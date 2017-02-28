package by.hryshchanka.task1.parser;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.hryshchanka.task1.exception.RectanglePointQuantityException;


public class RectangleParser {
	private static final Logger LOGGER = LogManager.getLogger(RectangleParser.class);
	private static final int POINT_QUANTITY = 8;
	
	public static ArrayList<Integer[]> createCoordinateList (List<String> lines) {
		ArrayList<Integer[]> coordinateList = new ArrayList<>();
		int wrongLineCounter = 0;
		for(String line: lines){
			Integer[] coordinate = new Integer[POINT_QUANTITY];
			String[] rect  = line.split("\\s+");
			if (rect.length == POINT_QUANTITY) {
				try {
			    	for (int i = 0; i < POINT_QUANTITY; i++) {
			    		coordinate[i] = Integer.valueOf(rect[i]);
			        }
			    	coordinateList.add(coordinate);
				}
				catch (NumberFormatException e) {
					LOGGER.log(Level.WARN, e.toString() + " | wrong data on line, " + (coordinateList.size() + 1 + wrongLineCounter++));
				}
			}
			else {
				try {
					throw new RectanglePointQuantityException();
				} catch (RectanglePointQuantityException e) {
					LOGGER.log(Level.WARN, e.toString() + " | wrong point quantity on line, " + (coordinateList.size() + 1 + wrongLineCounter++));
				}
			}
		}
		if (coordinateList.isEmpty()) {
			LOGGER.log(Level.FATAL, "all data is wrong");
			throw new RuntimeException();
		}
		return coordinateList;
	}
}

	
	
	
	
