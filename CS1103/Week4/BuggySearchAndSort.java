import java.util.Arrays;

/**
 * This class looks like it's meant to provide a few public static methods
 * for searching and sorting arrays.  It also has a main method that tests
 * the searching and sorting methods.
 * 
 * TODO: The search and sort methods in this class contain bugs that can
 * cause incorrect output or infinite loops.  Use the Eclipse debugger to 
 * find the bugs and fix them
 */
public class BuggySearchAndSort {
	
	public static void main(String[] args) {
		
		int[] A = new int[10];  
		for (int i = 0; i < 10; i++)
			A[i] = 1 + (int)(10 * Math.random());
		
		int[] B = A.clone();   
		int[] C = A.clone();
		int[] D = A.clone();
		
		System.out.print("The array is:");
		printArray(A);
		
		if (contains(A,5))
			System.out.println("This array DOES contain 5.");
		else
			System.out.println("This array DOES NOT contain 5.");
		
		Arrays.sort(A);  // Sort using Java's built-in sort method!
		System.out.print("Sorted by Arrays.sort():  ");
		printArray(A);   // (Prints a correctly sorted array.)

		bubbleSort(B);
		System.out.print("Sorted by Bubble Sort:    ");
		printArray(B);

		selectionSort(C);
		System.out.print("Sorted by Selection Sort: ");
		printArray(C);
		
		insertionSort(D);
		System.out.print("Sorted by Insertion Sort: ");
		printArray(D);
		
		System.out.print("This is the end of main");
	}
	
	/**
	 * Tests whether an array of ints contains a given value.
	 * @param array a non-null array that is to be searched
	 * @param val the value for which the method will search
	 * @return true if val is one of the items in the array, false if not
	 */
	public static boolean contains(int[] array, int val) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == val)
				return true;
			else
				return false;
		}
		return false;
	}
	
	/**
	 * Sorts an array into non-decreasing order.  This inefficient sorting
	 * method simply sweeps through the array, exchanging neighboring elements
	 * that are out of order.  The number of times that it does this is equal
	 * to the length of the array.
	 */
	public static void bubbleSort(int[] array) {	//Here is the comment that I wrote about how to fix each bug
		for (int i = 0; i < array.length -1; i++) { //Need to add minus 1 in order to finish the loop properly
			for (int j = i; j < array.length; j++) { // Change an increment variable from i to j, deleted minus 1 from condition, and also changed initialization of j from 0 to i
				if (array[i] > array[j]) { // Need to change an index to compare "i" and j
					int temp = array[j];
					array[j] = array[i]; //Change an index to swap j and j properly
					array[i] = temp; //The same as above. 
				}
			}
		}
	}
	
	/**
	 * Sorts an array into non-decreasing order.  This method uses a selection
	 * sort algorithm, in which the largest item is found and placed at the end of 
	 * the list, then the second-largest in the next to last place, and so on.
	 */
	public static void selectionSort(int[] array) {  //Here is the comment that I wrote about how to fix each bug
		for (int top = array.length - 1; top > 0; top--) {
			int positionOfMax = 0;
			for (int i = 1; i <= top; i++) {
				if (array[i] > array[positionOfMax]) //Changed an index from 1 to i
					positionOfMax = i;
			}
			int temp = array[top]; 
			array[top] = array[positionOfMax];
			array[positionOfMax] = temp;
		}
	}
	
	/**
	 * Sorts an array into non-decreasing order.  This method uses a standard
	 * insertion sort algorithm, in which each element in turn is moved downwards
	 * past any elements that are greater than it.
	 */
	public static void insertionSort(int[] array) { //Here is the comment that I wrote about how to fix each bug
		for (int top = 1; top < array.length; top++) {
			int temp = array[top];  
			int pos = top - 1;
			while (pos >= 0 && array[pos] > temp) { // Change a condition formula from > to >=
				array[pos+1] = array[pos];
				pos--;
			}
			array[pos+1] = temp;  // Change an index from pos to pos+1
		}
	}
	
	/**
	 * Outputs the ints in an array on one line, separated by spaces,
	 * with a line feed at the end.
	 */
	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(" ");
			System.out.print(array[i]);
		}
		System.out.println();
	}

}

