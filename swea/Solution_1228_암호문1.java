package study.swea;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution_1228_¾ÏÈ£¹®1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc < 11; tc++) {
			List<Integer> list = new LinkedList<Integer>();
			
			int n = sc.nextInt();
			for (int i = 0; i < n; i++)
				list.add(sc.nextInt());

			int cntOp = sc.nextInt();
			for (int i = 0; i < cntOp; i++) {
				char op = sc.next().charAt(0);
				if (op == 'I') {
					int index = sc.nextInt();
					int cntNum = sc.nextInt();
					int[] numbers = new int[cntNum];
					for (int j = 0; j < cntNum; j++) {
						numbers[j] = sc.nextInt();
						list.add(index + j, numbers[j]);
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 10; i++)
				sb.append(list.get(i) + " ");
			
			System.out.printf("#%d %s\n", tc, sb);
		}
	}
}
