package study.swea;

import java.util.Scanner;

public class Solution_1222_����1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = 0;
		char[] arr = {};
		for (int tc = 0; tc < 10; tc++) {
			length = sc.nextInt();
			arr = sc.next().toCharArray();
			int ans = arr[0] - '0';
			// ���� ǥ������� ��ġ��
			for (int i = 0; i < length - 1; i++) {
				if (arr[i] == '+') {
					ans += arr[i + 1] - '0'; // ������ ������ �ǿ����ڸ� ���� �ǿ����ڿ� ���ϱ�
					swap(arr, i, i + 1); // �����ڴ� ���� �ǿ����� ������ �̵�
					i++;
				}
			}

			System.out.printf("#%d %d\n", tc + 1, ans);
		}
		// ���� ǥ��� ���
//		for(int i=0; i<arr.length;i++) {
//			System.out.print(arr[i]);
//		}
	}

	private static void swap(char[] charArr, int idx, int nidx) {
		char tmp = charArr[idx];
		charArr[idx] = charArr[nidx];
		charArr[nidx] = tmp;
	}
}
