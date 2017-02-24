package org.vegan.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class contains array like operations, but uses collections instead.
 * Examples include converting an array to a list and converting a list to an array.
 * 
 * @author vegan
 * 
 * TODO:  Write code that removes an element from the array.
 * TODO:  Write code that rotates elements from an array.
 *
 */
public class CollectionArrayConversion {

	public static void main(String[] args) {

		//Create an array of strings.

		String[] values = {"2","3","4"};

		System.out.println("number of elements in an array:  " + values.length);

		String newValues[] = insertValueIntoArray(values, 0, "1");

		//String newValues[] = insertIntoArray(values, 0, "1");

		System.out.println("print new array:  \n");
		for (int i = 0; i < newValues.length; i++) {
			System.out.println(newValues[i]);
		}
	}


	/**
	 * Insert a new value into an array using an array list.
	 * TODO:  Could this be genericized?
	 * @deprecated   Use the method that accepts generic types, because it is much more flexible and reusable.
	 * 
	 * @param values    An array of Strings to be manipulated.
	 * @param index     The index or location where the new String will be added.
	 * @param element   The character value that will be added.
	 * @return          A new String array that contains the newly inserted element.
	 */
	public static String[] insertValueIntoArray(String[] values, int index, String element) {

		//convert array to an array list.
		//List<String> lstValues = Arrays.asList(values);  Note:  if you want to add an element to the list, then this won't work, you will get an "UnsupportedOperationException" error.  See http://stackoverflow.com/questions/2965747/why-i-get-unsupportedoperationexception-when-trying-to-remove-from-the-list 
		List<String> lstValues = new ArrayList<String>(Arrays.asList(values));

		lstValues.add(index, element);

		//Now convert back into an array of strings.
		return lstValues.toArray(new String[lstValues.size()]);	
	}
	
	
	/**
	 * Converts a list into an array.
	 * See http://stackoverflow.com/questions/4337187/creating-a-generic-array-instance-in-a-generic-method
	 * 
	 * @param list    A list that could contain any class type.
	 * @param c       Type that you want to pass in, because this method will accept any type, but you need to tell the method which type.
	 * @return        An array of the type that was specified from the class that was passed in.
	 */
	public static <T> T[] convertToArray(List<?> list, Class<T> c) {
	    @SuppressWarnings("unchecked")
	    T[] result = (T[]) Array.newInstance(c, list.size());
	    result = list.toArray(result);
	    return (T[]) result;
	}

	
	
	/**
	 * Inserts values into an an array using generics.  This method gives you the flexibility to add any type of array.
	 * 
	 * @param values     An array that could contain any class type.
	 * @param index      The location you want to insert the array element.
	 * @param element    The element that will get inserted.  You can add any type of class that you want, because the type is a generic.
	 * @return           The modified array that contains the newly inserted element.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T[] insertValueIntoArray(T[] values, int index, T element) {

		//convert array to an array list.
		//List<String> lstValues = Arrays.asList(values);  Note:  if you want to add an element to the list, then this won't work, you will get an "UnsupportedOperationException" error.  See http://stackoverflow.com/questions/2965747/why-i-get-unsupportedoperationexception-when-trying-to-remove-from-the-list 
		List<T> lstValues = new ArrayList<>(Arrays.asList(values));

		lstValues.add(index, element);

		//Now convert back into an array of strings.
		return (T[]) convertToArray(lstValues, element.getClass());	
	}


	/**
	 * Insert a value into an array.  Note:  Using the ArraysDemo or RawArrayDemo might be better.
	 * @deprecated
	 * @param array
	 * @param insertIndex
	 * @param newValue
	 * @return
	 */
	public static String[] insertIntoArray(
			String[] array, int insertIndex, String newValue){

		String[] newArray = new String[array.length + 1];

		System.out.println("Size of new array:  " + newArray.length);

		newArray = array.clone();

		System.out.println("Size of new array after clone:  " + newArray.length);

		//move elements below insertion point.
		for(int i=newArray.length; i > insertIndex; i++){
			newArray[i] = newArray[i+1];
		}

		//insert new value
		newArray[insertIndex] = newValue;

		return newArray;
	}

}
