package com.esercizio.posillipo.antonio.esercizio.utils;

import java.util.List;

public class ListToString<T> {
	
	public String convertListToString(List<T> list) {
		String retValue = "[";
		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {
				retValue += "{";
			} else {
				retValue += ",{";
			}
			retValue += list.get(i).toString();
			retValue += "}";
		}
		retValue += "]";
		return retValue;
	}
	
}
