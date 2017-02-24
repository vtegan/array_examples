package org.vegan.algorithm;

public class Search {

	public Search() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		//look at the following with regard to explanation of the algorithm analysis.
		//https://www.khanacademy.org/computing/computer-science/algorithms/binary-search/a/running-time-of-binary-search
		
		int primes[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
		
		int target = 89;
		int resultIndexFromLinear = linearSearch(primes, target);
		
		System.out.println(primes[resultIndexFromLinear] + " was found at index " + resultIndexFromLinear);
		
		int resultIndexFromBinary = binarySearch(primes, target);
		
		System.out.println(primes[resultIndexFromBinary] + " was found at index " + resultIndexFromBinary);

	}

	
	
	/**
	 * Brute force search.  Keep looping through all elements of the array until you find your target value.
	 * 
	 * @param primes     An array of integers.
	 * @param target     The target value of the search.
	 * @return           array index of the target value.  Returns -1 if a match was not found.
	 */
	public static int linearSearch(int[] primes, int target) {
		for (int i = 0; i < primes.length; i++) {
			if(primes[i] == target)
				return i;
		} // end for loop
		return -1; // return -1 if the target value was not found in the array.
	}
	
	
	
	/**
	 * Fast search.  Each time your guess is wrong, the array gets cut in half, which has a huge impact on making your search faster.
	 * 
	 * @param primes     An array of integers.
	 * @param target     The target value of the search.
	 * @return           array index of the target value.  Returns -1 if a match was not found.
	 */
	public static int binarySearch(int[] primes, int target) {
		
		int min = 0;
		int max = primes.length-1;  // last element
		int guess = 0;
		
		while(min <= max){  // should we use = or <=?
			guess = (int) Math.floor((min + max)/2);
			if(primes[guess] == target)
				return guess;  // found the index of the target value.
			else if(primes[guess] < target)
				min = guess+1;
			else
				max = guess - 1;
		}
		
		return -1; // return -1 if the target value was not found in the array.
	}

}
