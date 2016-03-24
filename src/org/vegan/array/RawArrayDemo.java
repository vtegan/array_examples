/**
 * 
 */
package org.egan.array;

import java.util.Arrays;

/**
 * This class is designed to process arrays without the use of any of the Collections classes in Java.
 * @author tegan
 *
 */
public class RawArrayDemo {


	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int pos = 8;
		int srcArray[] = {1,2,3,4,5,6,7,8,9,10};
		removeElementFromArray(srcArray, pos);

	}



	/**
	 * Removes an element from an array of integers, without using any Java Collections.
	 * TODO:  Safeguard against bad elements and pos values that would cause an array index out of bounds exception.
	 * TODO:  Make sure this method will be able to handle less than three elements.  
	 * 
	 * @param srcArray     An array of integers that will be transformed.
	 * @param pos          The element that you wish to remove.
	 * @return             The transformed array of integers with the chosen element removed.
	 */
	public static int[] removeElementFromArray(int[] srcArray, int pos) {

		int[] destArray = new int[srcArray.length-1];  //since you cannot change the size of an array, create a new array and reduce the size by one.

		for (int i=0; i < srcArray.length; i++) {  

			if (i == pos) {  //I thought I could leave this out, but if we don't we will get an array out of bounds exception when we try to remove the last element.  This slot allows the loop to properly increment i.
				srcArray[i] = 0; // null the source  
			}else if(i >= pos) {// activity after the position.  We need to shift elements to the left, or else we will get an index array out of bounds exception.
				destArray[i-1] = srcArray[i];  //shift
			}else{  //activity before the position, proceed as normal.
				destArray[i] = srcArray[i];
			}  // end if/else clause

		}// end for

		return destArray;
	}


	/**
	 * Inserts an element into an array.
	 * See:  http://www.sanfoundry.com/java-program-insert-element-specified-position-given-array/
	 * 
	 * @param arr           Target array.
	 * @param pos           Position where you want to insert the element.
	 * @param element       Element that will be inserted into the array.
	 */
	public static int[] insertElementIntoArray(int[] srcArray,int pos, int element) {

		int n = srcArray.length - 1;

		int newArray[] = Arrays.copyOf(srcArray,srcArray.length+1);

		//Here we are decrementing i.
		//We are basically starting from the end of the array, and are continuing to shift to the right, until we land at the position.
		for(int i = (n-1); i >= (pos-1); i--){
			newArray[i+1] = newArray[i];  // perform the shifting
		}

		newArray[pos-1] = element;  // we are inserting our new value here at the desired position.
		// end insert section

		return newArray;
	}


	//See http://tutorials.jenkov.com/java/arrays.html#inserting-elements-into-an-array


	/**
	 * Insert elements into a fixed size array.
	 * See:  http://tutorials.jenkov.com/java/arrays.html#inserting-elements-into-an-array
	 * 
	 * @param array
	 * @param insertIndex
	 * @param newValue
	 */
	public static void insertIntoFixedArray(
			int[] array, int insertIndex, int newValue){

		//move elements below insertion point.
		for(int i=array.length-1; i > insertIndex; i--){
			array[i] = array[i-1];
		}

		//insert new value
		array[insertIndex] = newValue;
	}


	/**
	 * Rotates elements to the left.  Takes the first element of the array and sticks it to the end, then shifts 
	 * all of the remaining elements to the left.
	 * 
	 * @param list  An array that will get its values rotated.  
	 */
	public static void rotateLeft(int[] list) {

		int first = list[0];  //Get the first element.

		//Shift to the left.  Don't bother iterating to the last element, because we will insert the first variable to the last element.
		for (int i = 0; i < list.length - 1; i++) {
			list[i] = list[i + 1];  //This is where the shifting occurs.
		}

		list[list.length - 1] = first;  //Now that the elements have been shifted, take the first value of the array and insert it  to the last element.
	}



	/**
	 * Rotates elements to the right.  Takes the last element of the array and sticks it to the first element of the array, then shifts 
	 * all of the remaining elements to the right.
	 * 
	 * @param list  An array that will get its values rotated.  
	 */
	public static void rotateRight(int[] list) {
		
		int last = list[list.length - 1];  //Get the last element of the array.
		
		//In order to shift the values to the right, the for loop will decrement until it reaches the value of 1.
		//We wont' bother populating the first element until after the for loop has completed its execution. 
		for (int i = list.length - 1; i >= 1; i--) {
			list[i] = list[i - 1];  //Shift elements to the right.
		}
		
		list[0] = last;  //Now that the elements have been shifted, take the last value of the array and insert it  to the first element.
	}


}
