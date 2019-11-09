package test.woo1th;

import java.util.Scanner;

// #4 포비와 크롱
public class Solution4 {
	public static void main(String[] args) {
		int[] pobi = { 131, 132 };
		int[] crong = { 211, 212 };
		System.out.println(solution(pobi, crong));
	}

	private static int solution(int[] pobi, int[] crong) {

		if (checkException(pobi, crong))
			return -1;

		int[] tmp_p = new int[2], tmp_c = new int[2];
		int max_p, max_c;

		// # 왼쪽페이지 계산
		tmp_p[0] = Math.max(plusPages(pobi[0]), multiPages(pobi[0]));
		tmp_c[0] = Math.max(plusPages(crong[0]), multiPages(crong[0]));

		// # 오른쪽페이지 계산
		tmp_p[1] = Math.max(plusPages(pobi[1]), multiPages(pobi[1]));
		tmp_c[1] = Math.max(plusPages(crong[1]), multiPages(crong[1]));

		// # 왼,오 중 max 구하기
		max_p = Math.max(tmp_p[0], tmp_p[1]);
		max_c = Math.max(tmp_c[0], tmp_c[1]);
		if (max_p > max_c)
			return 1;
		else if (max_p < max_c)
			return 2;
		else
			return 0;
	}

	private static boolean checkException(int[] pobi, int[] crong) {
		boolean res = false;
		if (pobi[0] == 1 || crong[0] == 1 || pobi[1] == 400 || pobi[1] == 400)
			return true;
		if (pobi[0] % 2 != 1 || pobi[1] % 2 != 0 || crong[0] % 2 != 1 || crong[1] % 2 != 0)
			return true;
		if (pobi[1] - pobi[0] != 1 || crong[1] - crong[0] != 1)
			return true;
		return res;
	}

	private static int plusPages(int page) {
		int res = 0;
		while (page != 0) {
			res += page % 10;
			page /= 10;
		}
		return res;
	}

	private static int multiPages(int page) {
		int res = 1;
		while (page != 0) {
			res *= page % 10;
			page /= 10;
		}
		return res;
	}
}
