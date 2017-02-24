package org.egan.array;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



/**
 * Java program to convert array to Collection, List and Set in Java.
 * The program will demonstrate examples of converting String and Integer array to their
 * Collections Sets and Lists.
 *
 * @author vegan
 */
public class ArrayToCollectionExamples {

	public static void main(String args[]) {

		displayConversions();
	}
	

	/**
	 *  Prints the conversions between arrays and collections. 
	 */
	public static void displayConversions() {
		// Converting String array to Collection, Set and List in Java
		String[] operatingSystems = new String[]{"Windows", "Linux", "Android", "iOS", "Solaris"};
		System.out.println("Elements in array:  " + Arrays.toString(operatingSystems));

		// Convert array to Collection in Java
		Collection<String> collection = Arrays.asList(operatingSystems);
		System.out.println("Objects (Strings) in collection:  " + collection);

		// Convert String array to Set in Java
		Set<String> set = new HashSet<>(Arrays.asList(operatingSystems));
		System.out.println("Elements in Set:  " + set);


		// Convert String array to List in Java
		List<String> list = Arrays.asList(operatingSystems);
		System.out.println("List created from Array in Java : " + list);


		// Converting Integer array to Collection, List and Set in Java
		Integer[] scores = new Integer[]{101, 201, 301,401};
		System.out.println("Contents of Integer array : " + Arrays.toString(scores));

		// Creating Collection from Integer array in Java
		Collection<Integer> iCollection = Arrays.asList(scores);
		System.out.println("Java Collection created from Integer array: " + iCollection);

		// Creating List form Integer array in Java
		List<Integer> iList = Arrays.asList(scores);
		System.out.println("List created from integer array : " +iList);

		// Example of Converting Integer array to HashSet in Java
		Set<Integer> iSet = new HashSet<>(iList);
		System.out.println("Integer array to Set in Java:  " + iSet);
	}

}

