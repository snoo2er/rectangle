package by.hryshchanka.task1.rectangleData;


import java.util.HashMap;
import java.util.Map;



public class CalculatedValueMap {
	private Map<Long, CalculatedValue> allValues = new HashMap<Long, CalculatedValue>();
	
	private CalculatedValueMap() {
	}
	
	public void removeCalculatedValues(Long key) {
		allValues.remove(key);
	}
	private static class SingletonHelper{
	    private static final CalculatedValueMap INSTANCE = new CalculatedValueMap();
	}
	   
	public static CalculatedValueMap getInstance(){
	    return SingletonHelper.INSTANCE;
	}
	
	public void addCalculatedValues(CalculatedValue cvm, long id) {
		allValues.put(id, cvm);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Long, CalculatedValue> entry: allValues.entrySet()) { 
			Long key = (Long)entry.getKey(); 
			CalculatedValue value = (CalculatedValue)entry.getValue(); 
			sb.append("Rectangle " + key +"\n"+ value + "\n");
			} 
		return sb.toString();
	}
	
}
