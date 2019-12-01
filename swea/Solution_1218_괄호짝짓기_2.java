package study.swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution_1218_°ýÈ£Â¦Áþ±â_2 {
	static int T = 10, len;
	static boolean flag;
	static List<Character> brackets;
	static char[] arrClose = { ')', '}', ']', '>' };
	static Stack<Character> stack = new Stack<Character>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		int ans;

		for (int tc = 0; tc < T; tc++) {
			len = sc.nextInt();
			str = sc.next();

			ans = 0;
			brackets = new ArrayList<Character>();
			for (int i = 0; i < len; i++) {
				if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '<')
					stack.push(str.charAt(i));
			}
		}

		ans = brackets.isEmpty() ? 1 : 0;
	}
}
