package one;

import java.util.Random;

/**
 * 1. Pick an element, called a pivot, from the array.
 * 2. Partitioning: reorder the array so that all elements with values 
 * less than the pivot come before the pivot, while all elements with 
 * values greater than the pivot come after it (equal values can go either way).
 * After this partitioning, the pivot is in its final position. 
 * This is called the partition operation.
 * 3. Recursively apply the above steps to the sub-array of elements with smaller 
 * values and separately to the sub-array of elements with greater values.
 */
public class QuickSort {
	public static void main(String[] args) {
		int size = 20;
		int[] arr = new int[size];
		init(arr);
		printArr(arr);
		quickSort(arr, 0, arr.length - 1);
		printArr(arr);
	}
	public static void init(int[] arr) {
		for(int i=0 ; i < arr.length ; i++) {
			arr[i] = new Random().nextInt(100);
		}
	}
	public static void quickSort(int[] arr, int begin, int end) {
		if(begin >= end) return;
		if(end-begin == 1) {
			if (arr[begin] > arr[end]) {
				swap(arr, begin, end);
			}
			return;
		}
		int pivot = partition(arr, begin, end);
		quickSort(arr, begin, pivot -1);
		quickSort(arr, pivot + 1, end);
	}
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		return;
	}
	private static int partition(int[] arr, int begin, int end) {
		int pivot = begin;
		
		for(int i=begin+1 ; i<=end ; i++) {
			if(arr[pivot] > arr[i]) { 
				if( pivot == i-1) {
					swap(arr, pivot, i);
					pivot = i;
				} else {
					swap(arr, pivot+1, i);
					swap(arr, pivot, pivot+1);
					pivot = pivot + 1;
				}
			}
		}
		return pivot;
	}
	public static void printArr(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
