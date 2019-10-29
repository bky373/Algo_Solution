package study.dataStructure;

import java.util.EmptyStackException;

public class Test {
	public static void main(String[] args) {
		FixedMultiStacks ms = new FixedMultiStacks(5);
		try {
			ms.push(0, 1);
			ms.push(0, 2);
			ms.push(0, 3);
			ms.push(0, 4);
			ms.push(0, 5);
			ms.push(0, 6);

			ms.push(1, 11);
			ms.push(1, 12);
			ms.push(1, 13);
			ms.push(1, 14);
			ms.push(1, 15);
			
			ms.push(4, 4);
		} catch(FullStackException E) {
			System.out.println("It's full");
		}
	
		try {
			System.out.println("Stack #0: " + ms.isFull(0));
			System.out.println("Stack #0: " + ms.pop(0));
			System.out.println("Stack #0: " + ms.pop(0));
			System.out.println("Stack #0: " + ms.peek(0));
			System.out.println("Stack #0: " + ms.pop(0));
			System.out.println("Stack #0: " + ms.isEmpty(0));
			System.out.println("Stack #0: " + ms.pop(0));
			System.out.println("Stack #0: " + ms.pop(0));
			System.out.println("Stack #0: " + ms.isEmpty(0));

			System.out.println("Stack #1: " + ms.pop(1));
			System.out.println("Stack #1: " + ms.pop(1));
			System.out.println("Stack #1: " + ms.peek(1));
			System.out.println("Stack #1: " + ms.pop(1));
			System.out.println("Stack #1: " + ms.isEmpty(1));
			System.out.println("Stack #1: " + ms.pop(1));
			System.out.println("Stack #1: " + ms.pop(1));
			System.out.println("Stack #1: " + ms.isEmpty(1));
		} catch(EmptyStackException e) {
			System.out.println("It's empty");
		}
	
	}

	
	
	//	public static Node KthToLast(Node first, int k) {
//		Node n = first;
//		int total = 1;
//		while(n.next != null) {
//			total++;
//			n=n.next;
//		}
//		n=first;
//		for(int i =1; i<total-k+1;i++) {
//			n=n.next;
//		}
//		return n;
//	}

}
