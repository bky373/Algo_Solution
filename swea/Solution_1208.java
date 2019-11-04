package study.swea;

import java.util.Scanner;

public class Solution_1208 {
	private static void selectionSort(int[] a, int startIn) {
		if(startIn < a.length-1) {
			int minIn = startIn;
			for(int i = startIn; i<a.length; i++) {
				if(a[i] < a[minIn]) minIn = i;
			}
			swap(a, startIn, minIn);
			selectionSort(a, startIn+1);
		}
	}
	private static void swap(int[] a, int startIn, int minIn) {
		int tmp = a[startIn];
		a[startIn] = a[minIn];
		a[minIn] = tmp;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int boxLine = 100;
		int[] a = new int[boxLine];
		for (int tc = 1; tc <= 10; tc++) {
			int dumpCnt = sc.nextInt();
			for (int i = 0; i < boxLine; i++)
				a[i] = sc.nextInt();
			
			selectionSort(a, 0);
			
			int min = 101, max = 0, j = 0, k = 0;
			for (int c = 0; c < dumpCnt; c++) {
				for (int i = 0; i < boxLine; i++) {
					if (max <= a[i]) {
						j = i;
						max = a[j];
					}
					if (min >= a[i]) {
						k = i;
						min = a[k];
					}
				}
				if (a[k] < 100) {
					a[k]++;
					max = a[j];
				}
				if (a[j] > a[k]) {
					a[j]--;
					min = a[k];
				}
			}
			for (int i = 0; i < boxLine; i++) {
				if (max <= a[i]) {
					j = i;
					max = a[j];
				}
				if (min >= a[i]) {
					k = i;
					min = a[k];
				}
			}
			System.out.printf("#%d %d\n", tc, max - min);
		}
	}
}
