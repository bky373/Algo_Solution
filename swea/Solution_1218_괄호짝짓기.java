package study.swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_1218_°ýÈ£Â¦Áþ±â {
	static int T = 10, len;
	static boolean flag;
	static List<Character> brackets;
	static char[] arrClose = { ')', '}', ']', '>' };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		int ans;

		for (int tc = 0; tc < T; tc++) {
			len = sc.nextInt();
			str = sc.next();

			ans = 0;
			brackets = new ArrayList<Character>();
			for (int i = 0; i < len; i++)
				brackets.add(str.charAt(i));
			
			check();
			
			ans = brackets.isEmpty() ? 1 : 0;
			System.out.format("#%d %d\n", tc + 1, ans);
		}
	}
	private static void check() {
		int i = 0;
		while(i!=len) {
			flag = false;
			switch (brackets.get(i)) {

			case '(':
				deletePair(i, 0);
				break;
			case '{':
				deletePair(i, 1);
				break;
			case '[':
				deletePair(i, 2);
				break;
			case '<':
				deletePair(i, 3);
				break;
			}
			i = flag? 0 : ++i;
		}
	}
	
	private static void deletePair(int i, int index) {
		
		for (int j = 0; j < len; j++) {
			if (brackets.get(j) == arrClose[index]) {
				if(i<j) {
					brackets.remove(j);
					brackets.remove(i);
				} else {
					brackets.remove(i);
					brackets.remove(j);
				}
				len = brackets.size();
				flag = true;
				break;
			}
		}
	}

}
