package de.robindev.easymcapi.collection;

import java.util.List;

/**
* @author RobinDEV (25.09.2016, 11:54:44)
*/
public interface IRandomList<T> extends List<T> {
	
	public T getRandom();
}
