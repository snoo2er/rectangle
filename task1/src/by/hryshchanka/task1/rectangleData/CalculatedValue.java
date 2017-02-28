package by.hryshchanka.task1.rectangleData;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.hryshchanka.task1.entity.Rectangle;
import by.hryshchanka.task1.listener.RectangleObserver;
import by.hryshchanka.task1.logic.RectangleLogic;

public class CalculatedValue extends RectangleObserver{
	private static final Logger LOGGER = LogManager.getLogger(CalculatedValue.class);
	private double rectanglePerimeter;
	private double rectangleArea;
	
	public CalculatedValue() {
		super();
	}
	public CalculatedValue(Rectangle rectangle) {
		super();
		this.rectanglePerimeter = RectangleLogic.calculatePerimeter(rectangle);
		this.rectangleArea = RectangleLogic.calculateArea(rectangle);;
	}
	public void valueChanged(Rectangle observed) {
		if (RectangleLogic.isRectangle(observed)) {
			CalculatedValueMap.getInstance().addCalculatedValues(new CalculatedValue(observed), observed.getId());
			LOGGER.trace("rectangle " + observed.getId() + " changed");
		} else {
			CalculatedValueMap.getInstance().removeCalculatedValues(observed.getId());
			LOGGER.trace("figure " + observed.getId() + " removed because not a rectangle");
		}
		LOGGER.trace("\n" + CalculatedValueMap.getInstance());
	}

	@Override
	public String toString() {
		return "perimeter=" + String.format("%.1f", rectanglePerimeter) + ", rectangleArea=" + String.format("%.1f", rectangleArea) + "]\n";
	}
}


