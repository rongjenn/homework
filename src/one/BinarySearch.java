package one;

import static org.junit.Assert.*;


import org.junit.Test;

public class BinarySearch {

	@Test
	public void test() {
		int[] arr = {1,2,3,4,5,6,7};
		assertTrue(binarySearch(arr,0,6,7));
	}
	public boolean binarySearch(int[] arr, int begin, int end, int searched) {
		boolean result = false;
		int middle = (begin+end)/2;
		System.out.println("array[" +middle+"]=" + arr[middle] + ", " +begin+ " " + end);
		if(arr[middle]>searched) {
			result = binarySearch(arr, begin, middle - 1, searched);
		} else if (arr[middle]<searched) {
			result = binarySearch(arr, middle + 1, end, searched);
		} else {
			System.out.println(".....");
			result = true;
		}
		return result;
	}
}
