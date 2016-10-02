package de.robindev.easymcapi.random;

import java.util.List;
import java.util.Random;

/**
* @author RobinDEV (24.09.2016, 12:16:01)
*/
public abstract class Randoms {
	
	private static Random random = new Random();
	
	public static int getInt() {
		return random.nextInt();
	}
	
	public static int getIntMax(int max) {
		return getIntBetween(0, max);
	}
	
	public static int getIntBetween(int min, int max) {
		int i = getIntMax(max);
		
		while(i < min) {
			i = getIntMax(max);
		}
		
		return i;
	}
	
	public static <T> T getRandomListElement(List<T> list) {
		return list.get(random.nextInt(list.size()));
	}
}
