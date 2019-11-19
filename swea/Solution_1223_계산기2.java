package study.swea;

import java.util.Scanner;

public class Solution_1223_°è»ê±â2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 0; tc < 1; tc++) {
			int length = sc.nextInt();
			char[] arr = sc.next().toCharArray();
			
			String str = new String();
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] == '+') {
					str += arr[++i]; 
					str += '+';
				} 
				else str += arr[i];
			}
			
			int ans = 0;
			for(int i=0; i<length; i++) {
				if(str.charAt(i) != '+')
					ans += str.charAt(i) - '0';
			}

			System.out.printf("#%d %d\n", tc + 1, ans);
		}
	}
}
