package two;

import java.util.Random;

public class RotateArray {
	public static void main(String[] args) {
		int size = 10;
		int units = 3;
		int[] arr = new int[size];
		init(arr);
		printArr(arr);
		rotateBy(arr, units);
		printArr(arr);
	}
	public static void rotateBy(int[] arr, int k) {
		//reverse len - k to len - 1
		reverse(arr, arr.length-k, arr.length-1);
		//reverse 0 to len - k - 1
		reverse(arr, 0, arr.length-k-1);
		//reverse the whole arr
		reverse(arr, 0, arr.length-1);
	}
	private static void reverse(int[] arr, int b, int e) {
		if(b>=e) return;
		swap(arr, b, e);
		reverse(arr, b+1, e-1);
	}
	private static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	public static void init(int[] arr) {
		for(int i=0 ; i< arr.length ; i++) {
			arr[i] = new Random().nextInt(100);
		}
	}
	public static void printArr(int[] arr) {
		for(int i: arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
