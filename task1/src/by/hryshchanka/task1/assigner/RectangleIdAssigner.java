package by.hryshchanka.task1.assigner;

public class RectangleIdAssigner {
	private static long id;
	
	public static long assignId(){
		return id++;
	}
}
