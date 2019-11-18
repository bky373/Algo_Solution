package study.swea;

import java.util.Scanner;

public class Solution_1222_계산기1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = 0;
		char[] arr = {};
		for (int tc = 0; tc < 10; tc++) {
			length = sc.nextInt();
			arr = sc.next().toCharArray();
			int ans = arr[0] - '0';
			// 후위 표기식으로 고치기
			for (int i = 0; i < length - 1; i++) {
				if (arr[i] == '+') {
					ans += arr[i + 1] - '0'; // 연산자 다음의 피연산자를 앞의 피연산자와 더하기
					swap(arr, i, i + 1); // 연산자는 다음 피연산자 앞으로 이동
					i++;
				}
			}

			System.out.printf("#%d %d\n", tc + 1, ans);
		}
		// 후위 표기식 출력
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
