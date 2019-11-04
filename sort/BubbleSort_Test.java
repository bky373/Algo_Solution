package study.sort;

import java.util.Arrays;

public class BubbleSort_Test {
	private static void bubbleSort(int[] arr) {
		bubbleSort(arr, arr.length - 1);
	}

	private static void bubbleSort(int[] arr, int last) {
		if (last > 0) {
			for (int i = 1; i <= last; i++) {
				if (arr[i - 1] > arr[i]) { // 오름차순
					swap(arr, i - 1, i);
				}
			}
			bubbleSort(arr, last - 1);
		}
	}

	private static void swap(int[] arr, int source, int target) {
		int tmp = arr[source];
		arr[source] = arr[target];
		arr[target] = tmp;
	}

	public static void main(String[] args) {
		int[] arr = {3,5,4,2,1};
		System.out.println(Arrays.toString(arr));
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
