package study.swea;

import java.util.Scanner;

public class Solution_1217_°ÅµìÁ¦°ö {
	static int N, M ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc;
		for(int k = 0; k <10; k++) {
			tc = sc.nextInt();
			N = sc.nextInt();
			M = sc.nextInt();

			System.out.format("#%d %d\n",tc, power(N, M));
		}
	}
	
	private static int power(int N, int M) {
		if(M==0) return 1;
		return N * power(N, M-1);
	}

}
