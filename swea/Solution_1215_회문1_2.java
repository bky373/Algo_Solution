package study.swea;

import java.util.*;

public class Solution_1215_회문1_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] arrChar = new char[8][8];

		for (int tc = 1; tc <= 10; tc++) {

			int len = sc.nextInt();

			for (int i = 0; i < 8; i++) {
				arrChar[i] = sc.next().toCharArray();
			}

			int cnt = 0;

			for (int s = 0; s < 8-len+1; s++) {
				boolean flag;
				for (int i = 0; i < 8; i++) {
					flag = true;
					for(int j=0;j<len/2;j++) { // 길이의 절반만큼만 확인
						if(arrChar[i][s+j] != arrChar[i][s+len-1-j]) {
							flag = false;
							break;
						}
					}
					if(flag) cnt++;
					flag = true;
					for(int j=0;j<len/2;j++) {
						if(arrChar[s+j][i] != arrChar[s+len-1-j][i]) {
							flag = false;
							break;
						}
					}
					if( flag ) cnt++;
				}
			}
			System.out.format("#%d %d\n", tc, cnt);
		}
		sc.close();
	}
}
