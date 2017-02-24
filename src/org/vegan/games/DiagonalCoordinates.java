/**
 * 
 */
package org.vegan.games;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Class deals with diagonal coordinates.
 * @author tegan
 *
 */
public class DiagonalCoordinates {


	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int gridWidth = 4;

		int row = 4;

		for (int col = 1; col <= gridWidth; col++) {
			System.out.print("Source:  Row:  " + row + ", Col:  " + col + "-------");
			//findNegativeDiagStartingPoint(row, col, gridWidth);
			findPositiveDiagStartingPoint(row, col);
		}
	}



	/**
	 * Designed to create an efficient way to find the starting point for traversing a negative
	 * diagonal search.  This method prevents the client from having to traverse the entire grid in order
	 * to find the correct starting point for traversing a negative diagonal search.
	 * 
	 * @param row
	 * @param column
	 * @param gridWidth
	 */
	public static void findNegativeDiagStartingPoint(int row, int column, int gridWidth){

		int startRow;
		int startColumn;

		int result = row + column;  // the cool part about negative diagonals are all equal if you add them together.
		// this is how I was able to solve this tricky problem.  I saw a pattern.

		if(result < gridWidth + 1){
			startRow = 1;
			startColumn = result - startRow;	
		}else{
			startColumn = gridWidth;
			startRow = result - startColumn;
		}

		System.out.println("Starting Negative Diagonal Coordinates:  R=" + startRow + ", C=" + startColumn);
	}


	/**
	 * Designed to create an efficient way to find the starting point for traversing a positive
	 * diagonal search.  This method prevents the client from having to traverse the entire grid in order
	 * to find the correct starting point for traversing a positive diagonal search.
	 * 
	 * @param row
	 * @param column
	 */
	public static void findPositiveDiagStartingPoint(int row, int column){
		int reset = getReset(row, column);

		int startRow = row - reset;
		int startColumn = column - reset;

		System.out.println("Starting Positive Coordinates:  R=" + startRow + ", C=" + startColumn);
	}


	/**
	 * Helps us calculate starting coordinate space for diagonals. 
	 * 
	 * @param row
	 * @param column
	 * @return           An int that represents the reset values that will be used to calculate 
	 *                   the starting points for both the negative and positive diagonal starting points.
	 */
	private static int getReset(int row, int column) {
		//TODO:  Instead of using collections, just use the Math.min() method.
		List<Integer> lstCoordinates = Arrays.asList(new Integer(row), 
				new Integer(column));
		int reset = Math.abs(Collections.min(lstCoordinates) - 1);
		return reset;
	}
}
