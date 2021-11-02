package com.jerin.oracle.certification.common;

import java.util.HashMap;
import java.util.Map;

public class Generators {

	public static Map<Integer, String> getMap() {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");

		return map;
	}

}
