package de.robindev.easymcapi.collection;

import java.util.ArrayList;

import de.robindev.easymcapi.random.Randoms;

/**
* @author RobinDEV (25.09.2016, 11:55:01)
*/
@SuppressWarnings("serial")
public class RandomArrayList<T> extends ArrayList<T> implements IRandomList<T> {

	@Override
	public T getRandom() {
		return Randoms.getRandomListElement(this);
	}
}
