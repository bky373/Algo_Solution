package study.sort;

import java.util.Arrays;

// O(n^2)
public class SelectionSort_Test { 
	private static void selectionSort(int[] arr) {
		selectionSort(arr, 0);
	}

	private static void selectionSort(int[] arr, int startIn) {
		if (startIn < arr.length - 1) {
			int minIn = startIn;
			for (int i = startIn; i < arr.length; i++) {
				if (arr[i] < arr[minIn])
					minIn = i;
			}
			swap(arr, startIn, minIn);
			selectionSort(arr, startIn + 1);
		}
	}

	private static void swap(int[] arr, int startIn, int minIn) {
		int temp = arr[startIn];
		arr[startIn] = arr[minIn];
		arr[minIn] = temp;

	}

	public static void main(String[] args) {
		int[] arr = { 3, 6, 1, 8, 2, 4 };
		System.out.println(Arrays.toString(arr));
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));

	}

}
