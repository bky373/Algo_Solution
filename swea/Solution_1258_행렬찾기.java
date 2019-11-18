package study.swea;

import java.util.*;

public class Solution_1258_���ã�� {
	static int T, n, k, cnt_subMatrix;
	static int[][] map, arrRC;
	static int[] rowArr, colArr;
	static int[] dx = { 0, 1 }; // �� ��
	static int[] dy = { 1, 0 };
	static HashMap<Integer, Integer> hm;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		T = sc.nextInt();
		n = sc.nextInt();

		// map
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		arrRC = new int[20][3];
		rowArr = new int[20];
		colArr = new int[20];
		cnt_subMatrix = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] != 0) {
					cntSubRCs(map, i, j); // �� �κ������ ��,�� ���� ����
					Search(new Dot(i, j)); // â�� ����
					cnt_subMatrix++; // �κ���� ��
				}
				// ������� ����
				if (isException(cnt_subMatrix)) {
					System.out.println(-1);
					return;
				}
			}
		}
		sortRC(arrRC);
		for (int[] i : arrRC) {
			if (i[0] != 0)
				System.out.print(i[0] + " " + i[1] + " ");
		}
//		System.out.println(Arrays.toString(arrRC[0]));
//		System.out.println(Arrays.toString(arrRC[1]));
//		System.out.println(Arrays.toString(arrRC[2]));
//		System.out.println(Arrays.toString(list));
		System.out.println(cnt_subMatrix);
	}

	private static boolean isException(int cnt_subMatrix) {
		if (80 < n && n <= 100)
			return (15 < cnt_subMatrix && cnt_subMatrix <= 20) ? false : true;
		else if (n > 40)
			return (10 < cnt_subMatrix && cnt_subMatrix <= 15) ? false : true;
		else if (n > 10)
			return (5 < cnt_subMatrix && cnt_subMatrix <= 10) ? false : true;
		else
			return false;
	}

	private static void cntSubRCs(int[][] map, int i, int j) {
		int x = i, y = j;
		if (k < 20) {
			while (x < n && map[x][y] != 0) {
				arrRC[k][0] += 1;
				rowArr[k] += 1;
				x += 1;
			}
			x = i;
			while (y < n && map[x][y] != 0) {
				arrRC[k][1] += 1;
				colArr[k] += 1;
				y += 1;
			}
			k++;
			for (int n = 0; n < k; n++)
				arrRC[n][2] = arrRC[n][0] * arrRC[n][1];
		}
	}

	private static void sortRC(int[][] arrRC) {
		Arrays.sort(arrRC, new Comparator<int[]>() {
			public int compare(int[] entry1, int[] entry2) {
				int v1 = entry1[2];
				int v2 = entry2[2];
				return v1 != v2 ? Integer.compare(v1, v2) : entry1[0] - entry2[1];
			}
		});
	}

	private static void Search(Dot d1) {
		Queue<Dot> q = new LinkedList<Dot>();
		q.offer(d1);
		while (!q.isEmpty()) {
			Dot d = q.poll();
			int k = 0;

			// ����ġ�� �������� ��,�� Ž��
			for (int i = 0; i < 2; i++) {
				int cur_x = d.x;
				int cur_y = d.y;

				// ȭ�й��� 0���� �� ��ȯ
				map[cur_x][cur_y] = 0;

				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				// Ž���Ϸ��� �ε����� ���� �ʰ��ϸ�, �ٸ� ���� Ž��
				if (nx >= n || ny >= n)
					continue;

				// ���������� ȭ�й��� ������ ť�� �߰�
				if (map[nx][ny] != 0) {
					q.add(new Dot(nx, ny));
				}
			}
		}

//		printMap();
	}

	private static void printMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}

class Dot {
	int x;
	int y;

	Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
