package study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_8658 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			String[] line = br.readLine().split(" ");
			int[] sumArr = new int[line.length];
			char[] cline = null;

			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < line.length; i++) {
				cline = line[i].toCharArray();
				int sum = 0;
				for (int j = 0; j < cline.length; j++) {
					sum += cline[j] - '0';
				}
				sumArr[i] = sum;
			}
			for (int i = 0; i < sumArr.length; i++) {
				if (max < sumArr[i]) {
					max = sumArr[i];
				}
				if (min > sumArr[i]) {
					min = sumArr[i];
				}
			}
			System.out.printf("#%d %d %d\n", tc+1, max, min);
		}
	}
}