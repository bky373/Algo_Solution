package study.swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1225_암호생성기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 0; tc < 10; tc++) {

			int n = sc.nextInt();
			Queue<Integer> q = new LinkedList<Integer>();

			for (int i = 0; i < 8; i++)
				q.offer(sc.nextInt());

			int last = -1;
			while (last != 0) {
				for (int i = 1; i < 6; i++) {
					last = q.poll() - i;
					if (last <= 0) {
						last = 0;
						q.offer(last);
						break;
					}
					q.offer(last);
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for (int c : q)
				sb.append(c + " ");
			
			System.out.printf("#%d %s\n", n, sb);
		}
	}
}
