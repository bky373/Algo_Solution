package study.swea;

import java.util.Scanner;
import java.util.Stack;

public class Solution_1224_°è»ê±â3 {
	static int T = 10;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= T; tc++) {
			int size = sc.nextInt();
			String infix = sc.next();

			String postfix = toPostfix(infix);
			System.out.printf("#%d %d\n", tc, (int) calc(postfix));
		}
	}

	private static String toPostfix(String infix) {
		StringBuilder postfix = new StringBuilder();
		char[] charArr = infix.toCharArray();
		Stack<Character> opers = new Stack<Character>();
		
		for (int i = 0; i < charArr.length; i++) {
			char ch = charArr[i];
			if (Character.isDigit(ch))
				postfix.append(ch);
			
			else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				int newRank = toRank(ch);
				while (!opers.isEmpty()) {
					int oldRank = toRank(opers.peek());
					if ( newRank > oldRank )
						break;
					postfix.append(opers.pop());
				}
				opers.push(ch);
			}
			
			else if (ch == '(')
                opers.push(ch);
            
            else if ( ch == ')'){
            	while(opers.size()>0){
                    char x = opers.pop();
                    if(x == '(')
                        break;
                	postfix.append(x);
                }
            }
		}

		while (!opers.isEmpty()) {
			postfix.append(opers.pop());

		}
//		System.out.println(postfix);
		return postfix.toString();
	}

	private static int toRank(char ch) {
		if (ch == '*' || ch == '/')
			return 2;
		else if (ch == '+' || ch == '-')
			return 1;
		return 0;
	}

	private static int calc(String postifx) {
		char[] charArr = postifx.toCharArray();
		Stack<Integer> stack = new Stack<Integer>();
		int v1, v2;

		for (int i = 0; i < charArr.length; i++) {
			char ch = charArr[i];
			if (Character.isDigit(ch))
				stack.push(ch - '0');

			switch (ch) {

			case '+':
				v1 = stack.pop();
				v2 = stack.pop();
				stack.push(v2 + v1);
				break;

			case '-':
				v1 = stack.pop();
				v2 = stack.pop();
				stack.push(v2 - v1);
				break;

			case '*':
				v1 = stack.pop();
				v2 = stack.pop();
				stack.push(v2 * v1);
				break;

			case '/':
				v1 = stack.pop();
				v2 = stack.pop();
				stack.push(v2 / v1);
				break;
			}
		}
		return stack.pop();
	}
}
