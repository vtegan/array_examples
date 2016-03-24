package org.egan.array;

import java.util.Arrays;


/**
 * Great utility class for arrays.  Also, the class is generic, so it can work on any type of array.
 * See:  http://codereview.stackexchange.com/questions/57457/program-to-insert-search-for-and-delete-an-element-from-an-array
 * @author vtegan
 *
 * @param <T>
 */
public class ArraysDemo<T> {

	private final T[] srcValues;
	private int size;

	private final T[] destValues;

	public ArraysDemo(T... values) {

		this.srcValues = values.clone();  // make sure you initialize the array by cloning it.
		this.size = values.length;

		//See http://stackoverflow.com/questions/529085/how-to-create-a-generic-array-in-java?rq=1
		destValues = Arrays.copyOf(values, values.length + 1);
	}

	/**
	 * @return
	 */
	public T[] getValues() {
		return srcValues;
	}

	public int indexOf(int value) {
		for (int i = 0; i < size; i++) {
			if (srcValues[i].equals(value)) {  // with generics, you need to use the equals method instead of the == operator.
				return i;
			}
		}
		return -1;
	}

	public boolean remove(int value) {
		for (int i = 0; i < size; i++) {
			if (srcValues[i].equals(value)) {
				--size;
				for (; i < size; ++i) {
					srcValues[i] = srcValues[i + 1];
				}
				return true;
			}
		}
		return false;
	}



	/**
	 * Inserts an element into an array.
	 * 
	 * @param element
	 * @param index
	 * @return
	 */
	public T[] insertElement(T element, int index) {
		int length = srcValues.length;

		System.arraycopy(srcValues, 0, destValues, 0, index);
		destValues[index] = element;
		System.arraycopy(srcValues, index, destValues, index
				+ 1, length - index);
		return destValues;
	}

	//Note:  This method did not really come from the original class.  This came from the following url:
	//http://www.tutorialspoint.com/javaexamples/arrays_insert.htm
	//TODO:  Try to make this method work with the class, and genericize it.


	/**
	 * @deprecated - See insertElement(int element, int index)
	 * With the method below works, but not with generics.
	 * @param original
	 * @param element
	 * @param index
	 * @return
	 */
	public static int[] insertElement(int original[],
			int element, int index) {
		int length = original.length;
		int destination[] = new int[length + 1];
		System.arraycopy(original, 0, destination, 0, index);
		destination[index] = element;
		System.arraycopy(original, index, destination, index
				+ 1, length - index);
		return destination;
	}




	public void print() {
		System.out.print("Elements in the array: ");
		for (int i = 0; i < size; ++i) {
			System.out.print(srcValues[i] + " ");
		}
		System.out.println();
	}

}
