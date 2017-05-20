package one;

import java.util.Random;

public class BobbleSort {
	public static void main(String[] args) {
		int[] arr = new int[1000];
		for (int i=0; i<arr.length ; i++) {
			arr[i] = Math.abs(new Random().nextInt());
		}
		for (int i=0 ; i<arr.length ; i++) {
			for (int j=i+1 ; j<arr.length ; j++) {
				if (arr[i] > arr[j]) {
					swap(arr, i, j);
				}
			}
		}
		for (int i=0 ; i<arr.length ; i++) {
			System.out.println(arr[i] + " ");
		}
	}
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
