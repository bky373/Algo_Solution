package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] data = new int[1000];

		for (int tc = 0; tc < T; tc++) {
			int max = -1;
			int mode = 0;
			int[] freq = new int[101];
			
			int n = sc.nextInt();
			for (int i = 0; i < 1000; i++) {
				data[i] = sc.nextInt();
				freq[data[i]]++;
			}
			for (int i = 0; i < freq.length; i++) {
				if (max <= freq[i]) {
					max = freq[i];
					mode = i;
				}
			}
			System.out.printf("#%d %d\n", n, mode);
		}
	}
}
