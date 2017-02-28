package by.hryshchanka.task1.action;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.hryshchanka.task1.entity.Rectangle;
import by.hryshchanka.task1.rectangleData.CalculatedValue;
import by.hryshchanka.task1.rectangleData.CalculatedValueMap;

public class CalculatedValueMapCreator {
	private static final Logger LOGGER = LogManager.getLogger(CalculatedValueMapCreator.class);
	
	public static void createCalculatedValuesMap (ArrayList<Rectangle> rectangles) {
		CalculatedValueMap cvm = CalculatedValueMap.getInstance();
		for (Rectangle rectangle : rectangles){
			
			cvm.addCalculatedValues(new CalculatedValue(rectangle), rectangle.getId());
		}
		LOGGER.trace("CalculatedValuesMap created\n" + cvm);
	}
}
