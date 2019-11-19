package study.swea;

import java.io.*;
import java.util.*;

public class Solution_1258_���ã�� {
	private static int T, n, k, cnt_subMatrix;
	private static int[][] map, arr_submatrixRC;
	private static int[] dx = { 0, 1 }; // �� ��
	private static int[] dy = { 1, 0 };

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			n = sc.nextInt();
			
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			arr_submatrixRC = new int[20][3];
			cnt_subMatrix = 0;
			k = 0;
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] != 0) {
						cnt_subMatrix++; // �κ���� ����
						cntEachMatrixRC(map, i, j); // �� �κ������ ��,�� ���� ����
						Search(new Dot(i, j)); // ȭ�й��� ����
					}
				}
			}
			// ������� ����
			if (isException(cnt_subMatrix)) {
				System.out.println(cnt_subMatrix);
				System.out.println(-1);
				return;
			}
			
			sortArrRC(arr_submatrixRC); // arr_subRC �����ϱ�
			
			String str = new String();
			for (int[] tmp : arr_submatrixRC)
				if (tmp[0] != 0)
					str += tmp[0] + " " + tmp[1] +" ";
			System.out.printf("#%d %d %s\n", tc + 1, cnt_subMatrix, str);
		}
	}

	private static boolean isException(int cnt_subMatrix) {
		if (80 < n && n <= 100)
			return (15 < cnt_subMatrix && cnt_subMatrix <= 20) ? false : true;
		else if (n > 60)
			return (10 < cnt_subMatrix && cnt_subMatrix <= 15) ? false : true;
		else if (n > 40)
			return (5 < cnt_subMatrix && cnt_subMatrix <= 10) ? false : true;
		else if (n > 10)
			return (5 < cnt_subMatrix && cnt_subMatrix <= 10) ? false : true;
		else
			return false;
	}

	private static void cntEachMatrixRC(int[][] map, int i, int j) {
		int x = i, y = j;
		if (k < 20) {
			while (x < n && map[x][y] != 0) {
				arr_submatrixRC[k][0] += 1;
				x += 1;
			}
			x = i;
			while (y < n && map[x][y] != 0) {
				arr_submatrixRC[k][1] += 1;
				y += 1;
			}
			k++;
			for (int n = 0; n < k; n++)
				arr_submatrixRC[n][2] = arr_submatrixRC[n][0] * arr_submatrixRC[n][1];
		}
	}

	private static void sortArrRC(int[][] arr_subRC) {
		Arrays.sort(arr_subRC, new Comparator<int[]>() {
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

			// ����ġ�� �������� ��,�� Ž��
			for (int i = 0; i < 2; i++) {
				int cur_x = d.x;
				int cur_y = d.y;

				// ����ġ�� �ִ� ȭ�й��� 0���� �� ��ȯ
				map[cur_x][cur_y] = 0;

				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				// Ž���Ϸ��� �ε����� ���� �ʰ��ϸ�, �ٸ� ���� Ž��
				if (nx >= n || ny >= n)
					continue;

				// ���������� ȭ�й��� ������ ť�� �߰�
				if (map[nx][ny] != 0) {
					q.add(new Dot(nx, ny));
					map[nx][ny] = 0; //*�� ��ġ�� �� �湮 ǥ�ø� ����� ��, ���ϸ� ��ġ�� �ߺ��Ǿ� �ᱹ �޸� �ʰ���
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
