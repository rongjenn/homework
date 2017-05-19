package one;


import java.util.Random;

import org.junit.Test;

public class MergeSort {

	@Test
	public void test() {
		int size = 20;
		int[] arr = new int[size];
		for(int i=0; i< size ; i++) {
			arr[i] = new Random().nextInt(40);
		}
		printarr(arr);
		int[] result = mergesort(arr,0,arr.length-1);
		for(int i=0 ; i < result.length ; i++) {
			System.out.print(result[i] + " ");
		}
	}
	public int[] mergesort(int[] arr, int begin, int end) {
		int[] result = null;
		if(end - begin == 1) {
			if(arr[end] < arr[begin]) {
				result = new int[]{arr[end], arr[begin]};
			} else {
				result = new int[]{arr[begin], arr[end]};
			}
		} else if (end-begin==0) {
			result = new int[]{arr[begin]};
		}else if(end-begin > 1) {
			int middle = (end+begin)/2;
			int[] left = mergesort(arr, begin, middle);
			int[] right = mergesort(arr, middle+1, end);
			result = merge(left, right);
		}
		return result;
	}
	private int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length+right.length];
		int k = 0;
		int currentI = 0;
		int currentJ = 0;
 		while(currentI<=left.length && currentJ<=right.length) {
 			if(currentJ==right.length) {
 				result[k] = left[currentI];
 				k++;
 				currentI++;
 				
 			} else if(currentI==left.length) {
 				result[k] = right[currentJ];
 				k++;
 				currentJ++;
 				
 			} else {
	 			if( left[currentI] < right[currentJ]) {
	 				result[k] = left[currentI];
	 				k++;
	 				currentI++;
	 			} else {
	 				result[k] = right[currentJ];
	 				k++;
	 				currentJ++;
	 			}
 			}
			if(k == left.length + right.length) break;
		}
		return result;
	}
	private void printarr(int[] arr) {
		for (int i=0; i<arr.length ; i++) System.out.print(arr[i] + " ");
		System.out.println();
	}
}
