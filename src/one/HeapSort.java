package one;

import java.util.Random;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

class HeapSort {
	static int capacity = 38;
	int[] data = new int[capacity];
	int size = 0;
	public static void main(String[] args) {
		HeapSort h = new HeapSort(capacity);
		for (int i=0 ; i<capacity ; i++) {
			h.add(new Random().nextInt(100));
		}
		System.out.println("heap: " + h);
		h.sort();
		System.out.print("sorted heap: ");
		h.printArray();
	}
	public HeapSort(int capacity) {
		this.capacity = capacity;
	}
	public void add(int i) {
		data[size] = i;
		bubbleup(size);
		size ++;
	}
	
	public void removeMin() {
		size = size -1;
		swap(data,0,size);
		if(size>2) bubbleDown(0);
	}
	
	public void sort() {
		while(size > 2) {
			removeMin();
		}
		if(data[0]<data[1]) {
			swap(data,0,1);		
		}
		//reverse sort
		for(int i=0; i<data.length/2; i++) {
			swap(data,i,data.length-1-i);
		}
	}
	public void bubbleDown(int index) {
		if(isLeaf(index)) return;
		int next = 0;
		if(has2Children(index)) {
			next = min(getFirstChildIndex(index), getSecondChildIndex(index));
		} else if (has1Child(index)) {
			next = getFirstChildIndex(index);
		}
		if(data[index] >= data[next]) {
			swap(data, index, next);
			bubbleDown(next);
		}
	}
	private boolean has1Child(int index) {
		return getFirstChildIndex(index) <= size-1 && getSecondChildIndex(index) > size-1;
	}
	private int getFirstChildIndex(int index) {
		return index*2+1;
	}
	private boolean has2Children(int index) {
		return getSecondChildIndex(index) <= size-1;
	}
	private int getSecondChildIndex(int index) {
		return index*2+2;
	}
	private boolean isLeaf(int index) {
		return getFirstChildIndex(index) > size-1;
	}
	private int min (int i , int j) {
		if (data[i] <= data[j])
			return i;
		else
			return j;
	}
	public void bubbleup(int index) {
		if(index == 0) return;
		int parentIndex = getParentIndex(index);
		if (data[index] < data[parentIndex]) {
			swap (data, index, parentIndex);
			bubbleup(parentIndex);
		}
	}
	@Override
	public String toString() {
		String result = "";
		for (int i=0 ; i<size ; i++) {
			result += data[i] + " ";
		}
		return result;
	}
	private void swap (int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	private int getParentIndex(int i) {
		return (i-1)/2;
	}
	
	public void printArray() {
		for(int i=0; i<data.length ; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
	}
}
