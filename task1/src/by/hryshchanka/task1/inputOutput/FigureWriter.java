package by.hryshchanka.task1.inputOutput;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class FigureWriter {
	private static final Logger LOGGER = LogManager.getLogger(FigureWriter.class);
	private static final String OUTPUT_PATH = "data//output.txt";
	 
    public static void writeFigure(String figureData) {
    	try (FileWriter writer = new FileWriter(OUTPUT_PATH)) {
    		writer.write(figureData);
    		LOGGER.log(Level.TRACE, "data wrote");
    	}
    	catch (IOException e) {
    		LOGGER.log(Level.WARN,e.toString() + " | write error");
    	}
    } 
}