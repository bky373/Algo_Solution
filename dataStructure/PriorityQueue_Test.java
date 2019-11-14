package study.dataStructure;

import java.util.Collections;
import java.util.PriorityQueue;

class Puppy implements Comparable<Puppy>{
	String name;
	int weight;
	
	Puppy(String name, int weight){
		super();
		this.name = name;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Puppy target) {
		if(this.weight > target.weight) {
			return 1;
		} else if(this.weight < target.weight) {
			return -1;
		}
		return 0;
	}
}

public class PriorityQueue_Test {
	public static void main(String[] args) {
		
		PriorityQueue<Puppy> pQueue = getPriorityQueue();
		
		System.out.println("----------Normal Order");
		while(!pQueue.isEmpty()) {
			Puppy pf = pQueue.poll();
			System.out.print(pf.name+" ");
		}

		pQueue = getPriorityQueue();
		
		PriorityQueue<Puppy> reversedQueue = new PriorityQueue<Puppy>(pQueue.size(), Collections.reverseOrder());
		reversedQueue.addAll(pQueue);
		
		System.out.println();
		System.out.println("----------Reversed Order");
		while(!reversedQueue.isEmpty()) {
			Puppy rf = reversedQueue.poll();
			System.out.print(rf.name+" ");
		}
		
	}
	private static PriorityQueue<Puppy> getPriorityQueue(){
		Puppy p1 = new Puppy("a",10);
		Puppy p2 = new Puppy("b",100);
		Puppy p3 = new Puppy("c",30);
		Puppy p4 = new Puppy("d",90);
		Puppy p5 = new Puppy("e",70);
		Puppy p6 = new Puppy("f",90);
		
		PriorityQueue<Puppy> p = new PriorityQueue<Puppy>();
		
		p.offer(p1);
		p.offer(p2);
		p.offer(p3);
		p.offer(p4);
		p.offer(p5);
		p.offer(p6);
		
		return p;
	}

}
