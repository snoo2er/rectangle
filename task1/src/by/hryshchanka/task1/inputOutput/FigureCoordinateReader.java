package by.hryshchanka.task1.inputOutput;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class FigureCoordinateReader {
	private static final Logger LOGGER = LogManager.getLogger(FigureCoordinateReader.class);
	private static final String INPUT_PATH = "data//input.txt";
		
	public static List<String> readCoordinate() {
		List<String> lines = null;
		try {
			lines = Files.readAllLines(Paths.get(INPUT_PATH), StandardCharsets.UTF_8);
			if (lines.isEmpty()) {
				LOGGER.log(Level.FATAL,"File is empty");
		    	throw new RuntimeException();
			}
        }
	    catch (IOException e)
	    {
	    	LOGGER.log(Level.FATAL,"File not found");
	    	throw new RuntimeException();
	    }
		return lines;
	}
}
