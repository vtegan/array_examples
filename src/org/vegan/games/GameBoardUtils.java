package org.vegan.games;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import grids.GridUtils;

public class GameBoardUtils {

	public static void main(String[] args) {

		String board[][] = loadTheBoard();

		GridUtils.printTheBoard(board);

		int row = 2;
		int column = 3;

		System.out.println("square value:  " + board[row][column]);

		//boolean isSafe = isSafe(row,column);
		boolean isSafe = safe(board, row, column);

		System.out.println("Is is safe?  " + isSafe);


		displayArrayRowAndColumnLength();
	}




	/**
	 * Loads the values of the grid.
	 * @return A multi-dimensional array of integers that represents the values in the grid.
	 */
	public static String[][] loadTheBoard() {
		String [ ] [ ] board = {   
				{ "-","1", "2", "3", "4" },
				{ "1","*", "Q", "*", "*" },
				{ "2","*", "*", "*", "*" },
				{ "3","*", "*", "*", "*" },
				{ "4","Q", "*", "*", "*" }
		};
		return board;
	}

	//convenience method, so the client does not have to deal with indexing by array.
	/*
	public static boolean isSafe(int row, int column){
		return isSafe(row -1, column -1, loadTheBoard());
	}
	 */


	//Performs a check on the grid to see if a given spot on the grid is safe
	//from a Queen attack.
	/**
	 * @deprecated
	 * @param row
	 * @param column
	 * @param board
	 * @return
	 */
	public static boolean isSafe(int row, int column, String [ ] [ ] board){

		//Scan rows and columns
		for (int i = 1; i <=board.length-1; i++) { 
			if((board[row][i]).equalsIgnoreCase("Q") || board[i][column].equalsIgnoreCase("Q"))
				return false;
		}

		//Code below helps to make sure that we are using the correct starting point for a diagonal scan.
		//Really cool idea.
		List<Integer> lstCoordinates = Arrays.asList(new Integer(row), new Integer(column));
		int reset = Math.abs(Collections.min(lstCoordinates) - 1);

		//System.out.println("Reset = " + reset);

		//Scan diagonally from NW to SE
		for(int i = row-reset, j=column-reset; i<=board.length-1 && j<=board.length-1; i++, j++){
			if(board[i][j].equalsIgnoreCase("Q"))
				return false;
		}


		//Scan Diagonally from NE to SW
		for(int i = row-reset, j = (column -1)+reset; i <=board.length-1 && j >1; i++, j--){
			if(board[i][j].equalsIgnoreCase("Q"))
				return false;
		}

		return true;
	}



	//Designed to show you how you can display the length of each of the arrays dimensions.
	//See http://stackoverflow.com/questions/5958186/multidimensional-arrays-lengths-in-java?rq=1
	public static void displayArrayRowAndColumnLength(){
		int x[][] = new int[6][12];
		System.out.println(x.length + " " + x[1].length); // output should be 6 and 12.
	}


	



	/**
	 * @param row
	 * @param column
	 * @return
	 */
	private static int getReset(int row, int column) {
		List<Integer> lstCoordinates = Arrays.asList(new Integer(row), 
				new Integer(column));
		int reset = Math.abs(Collections.min(lstCoordinates) - 1);
		return reset;
	}
	
	
	
	
	// Check to see if a potential location (row, col) on the board is
    // "safe", which means that it cannot be taken by a queen already
    // on the board.
	//See http://cs.carleton.edu/faculty/dmusican/cs201w08/code/recursion/Queens.java
    public static boolean safe(String[][] board, int row, int col)
    {
        int i,j;

        int SIZE = board.length;
        // Check column
        for (i=0; i<SIZE; i++)
            if (board[i][col].equalsIgnoreCase("Q"))
                return false;

        // Check row
        for (j=0; j<SIZE; j++)
            if (board[row][j].equalsIgnoreCase("Q"))
                return false;

        // Check diagonal down and right
        for (i=row, j=col; i < SIZE && j < SIZE; i++, j++)
            if (board[i][j].equalsIgnoreCase("Q"))
                return false;

        // Check diagonal up and left
        for (i=row, j=col; i >=0 && j >=0 ; i--, j--)
            if (board[i][j].equalsIgnoreCase("Q"))
                return false;

        // Check diagonal up and right
        for (i=row, j=col; i >=0 && j < SIZE; i--, j++)
            if (board[i][j].equalsIgnoreCase("Q"))
                return false;

        // Check diagonal down and left
        for (i=row, j=col; i < SIZE && j >=0 ; i++, j--)
            if (board[i][j].equalsIgnoreCase("Q"))
                return false;

        // Must be safe
        return true;
    }


}
