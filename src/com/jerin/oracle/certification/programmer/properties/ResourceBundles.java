package com.jerin.oracle.certification.programmer.properties;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class ResourceBundles {

	public static void main(String[] args) {
		List<ResourceBundle> rbBundles = new ArrayList<ResourceBundle>();
//		Locale.setDefault(Locale.US);
		Locale.setDefault(Locale.ENGLISH);// This fails as there is not default RB the last fall back for italian
		System.out.println("Defaul locale " + getLocaleString(Locale.getDefault()));
		String s =ResourceBundle.getBundle("RB2", Locale.ITALIAN).getString("locale.name");
		String s2 =ResourceBundle.getBundle("RB2", Locale.ITALIAN).getString("locale.string");
		System.out.println(s +" " + s2);
//		rbBundles.add(ResourceBundle.getBundle("RB", Locale.UK));
//		rbBundles.add(ResourceBundle.getBundle("RB", Locale.FRENCH));
//		rbBundles.add(ResourceBundle.getBundle("RB", Locale.ITALIAN));
//
//		List<ResourceBundle> rb2Bundles = new ArrayList<ResourceBundle>();
//		rbBundles.add(ResourceBundle.getBundle("RB2", Locale.ENGLISH));
//		rbBundles.add(ResourceBundle.getBundle("RB2", Locale.FRENCH));
//		rbBundles.add(ResourceBundle.getBundle("RB2", Locale.ITALIAN));

	}

	private static String getLocaleString(Locale l) {
		return l.getLanguage() + "_" + l.getCountry();
	}
}


