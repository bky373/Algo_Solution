package study.swea;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_1230_¾ÏÈ£¹®3 {
	static Scanner sc = new Scanner(System.in);
	static List<Integer> message;

	public static void main(String[] args) {
		int n, cntCommand;

		for (int tc = 1; tc < 11; tc++) {
			message = new ArrayList<Integer>();
			
			n = sc.nextInt();
			for (int i = 0; i < n; i++)
				message.add(sc.nextInt());
			cntCommand = sc.nextInt();
			for (int i = 0; i < cntCommand; i++) {
				char command = sc.next().charAt(0);
				switch (command) {
				case 'I':
					insert();
					break;
				case 'D':
					delete();
					break;
				case 'A':
					add();
					break;
				}
			}
			System.out.format("#%d", tc);
			for (int i = 0; i < 10; i++) {
				System.out.format(" %d", message.get(i));
			}
			System.out.println();
		}
	}

	private static void insert() {
		int x = sc.nextInt();
		int y = sc.nextInt();
		int[] s = new int[y];
		for (int i = 0; i < y; i++)
			message.add(x + i, sc.nextInt());
	}

	private static void delete() {
		int x = sc.nextInt();
		int y = sc.nextInt();
		for (int i = 0; i < y; i++)
			message.remove(x);
	}
	
	private static void add() {
		int y = sc.nextInt();
		for (int i=0;i<y;i++)
			message.add(sc.nextInt());
	}
}
