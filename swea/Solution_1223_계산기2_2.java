package study.swea;

import java.util.Scanner;
import java.util.Stack;

public class Solution_1223_°è»ê±â2_2 {
	static int T = 10;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=T; tc++) {
			int size = sc.nextInt();
			String infix = sc.next();
			
			String postfix = toPostfix(infix);
			System.out.printf("#%d %d\n", tc, (int)calc(postfix));
		}
	}
	
	private static String toPostfix(String infix) {
		StringBuilder postfix = new StringBuilder();
		char[] arrChar = infix.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0;i<arrChar.length;i++) {
			char ch = arrChar[i];
			if(Character.isDigit(ch))
					postfix.append(ch);
			else if(ch=='+' ||ch=='-' ||ch=='*' ||ch=='/') {
				int rank = toRank(ch);
				while(!stack.isEmpty()) {
					if( toRank(stack.peek()) < rank) break;
					postfix.append(stack.pop());
				}
				stack.push(ch);
			}
		}
		
		while(!stack.isEmpty()) 
			postfix.append(stack.pop());
		
		return postfix.toString();
	}
	
	private static int toRank(char ch) {
		if(ch=='*' ||ch=='/') return 2;
		else if (ch=='+' ||ch=='-') return 1;
		return 0;
	}
	
	private static int calc(String postifx) {
		char[] charArr = postifx.toCharArray();
		Stack<Integer> stack = new Stack<Integer>();
		int v1, v2;
		
		for(int i=0;i<charArr.length;i++) {
			char ch = charArr[i];
			if(Character.isDigit(ch))
				stack.push(ch -'0');

			switch(ch) {
			
			case '+' : 
				v1 = stack.pop();
				v2 = stack.pop();
				stack.push(v2 + v1);
				break;
				
			case '-' : 
				v1 = stack.pop();
				v2 = stack.pop();
				stack.push(v2 - v1);
				break;
				
			case '*' : 
				v1 = stack.pop();
				v2 = stack.pop();
				stack.push(v2 * v1);
				break;
				
			case '/' : 
				v1 = stack.pop();
				v2 = stack.pop();
				stack.push(v2 / v1);
				break;
			}
		}
		return stack.pop();
	}
}
