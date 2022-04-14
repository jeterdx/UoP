/**
Result of execution 

Case1 (size:1000)
- Selection sort takes: 9 milliseconds.
- Arrays sort takes: 2 milliseconds.

Case2 (size:10000)
- Selection sort takes: 200 milliseconds.
- Arrays sort takes: 8 milliseconds.

Case3 (size:100000)
- Selection sort takes: 10320 milliseconds.
- Arrays sort takes: 93 milliseconds.
*/


import java.util.Arrays;
/**
 * BenchmarkingSortingAlgorithms measure a time to take use two types of sorting algorithms
 * @author GotaMitamura
 * @version 1.0
 */
public class BenchmarkingSortingAlgorithms {
	//main routine executes a measurement of sorting time with two algorithms preparing the same arrays	
	public static void main(String[] args) {
	final int sizeOfArray = 100000;
	int[] array1 = new int[sizeOfArray];
	
	//Input random numbers to array1.
	for (int i = 0 ; i < array1.length ; i++) {
		array1[i] = (int)(Integer.MAX_VALUE * Math.random());
	}
	
	//Copy a array1 to array2 with the identical elements.
	int[] array2;
	array2 = new int[array1.length];
	for (int i = 0; i < array1.length; i++) {
		array2[i] = array1[i];
		}
	
	//Start sorting and measure a time for each version
	long startTime1 = System.currentTimeMillis();
	selectionSort(array1);
	long runTime1 = System.currentTimeMillis() - startTime1;
	System.out.println("Selection sort takes: " + runTime1 + " milliseconds.");
	
	long startTime2 = System.currentTimeMillis();
	Arrays.sort(array2);
	long runTime2 = System.currentTimeMillis() - startTime2;
	System.out.println("Arrays sort takes: " + runTime2 + " milliseconds.");	
	}
	//selectionSort method
	static void selectionSort(int[] A) {
	      // Sort A into increasing order, using selection sort
	      
	   for (int lastPlace = A.length-1; lastPlace > 0; lastPlace--) {
	         // Find the largest item among A[0], A[1], ...,
	         // A[lastPlace], and move it into position lastPlace 
	         // by swapping it with the number that is currently 
	         // in position lastPlace.
	         
	      int maxLoc = 0;  // Location of largest item seen so far.
	      
	      for (int j = 1; j <= lastPlace; j++) {
	         if (A[j] > A[maxLoc]) {
	               // Since A[j] is bigger than the maximum we've seen
	               // so far, j is the new location of the maximum value
	               // we've seen so far.
	            maxLoc = j;  
	         }
	      }
	      
	      int temp = A[maxLoc];  // Swap largest item with A[lastPlace].
	      A[maxLoc] = A[lastPlace];
	      A[lastPlace] = temp;
	      
	   }  // end of for loop
	   
	}
	
	
}