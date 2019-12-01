package study.swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1219_±Ê√£±‚ {
	static int T = 10;
	static int[][] tree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc, total;
		for (int n = 0; n < T; n++) {

			tc = sc.nextInt();
			total = sc.nextInt();
			
			tree = new int[100][2];
			for (int i = 0; i < total; i++) {
				int index = sc.nextInt();
				if (tree[index][0] == 0)
					tree[index][0] = sc.nextInt();
				else
					tree[index][1] = sc.nextInt();
			}
			System.out.format("#%d %d\n", tc, DFS());
		}
	}

	private static int DFS() {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[100];
		
		q.add(tree[0][0]);

		while (!q.isEmpty()) {
			int n = q.poll();
			visited[n] = true;

			if (tree[n][0] == 99 || tree[n][1] == 99)
				return 1;

			if (tree[n][0] != 0) {
				q.add(tree[n][0]);
			}
			if (tree[n][1] != 0) {
				q.add(tree[n][1]);
			}
		}
		return 0;
	}
}