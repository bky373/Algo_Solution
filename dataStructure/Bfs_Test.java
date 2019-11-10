package study.dataStructure;

import java.util.LinkedList;
import java.util.NoSuchElementException;

class Queue_bfs<T> {
	class Node<T> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
		}
	}

	Node<T> first;
	Node<T> last;

	void enqueue(T item) {
		Node<T> t = new Node<T>(item);

		if (last != null) {
			last.next = t;
		}
		last = t;
		if (first == null) {
			first = last;
		}
	}

	T dequeue() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		T data = first.data;
		first = first.next;

		if (first == null) {
			last = null;
		}
		return data;
	}

	public T peek() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		return first.data;
	}

	public boolean isEmpty() {
		return first == null;
	}
}

class Graph_bfs {
	class Node {
		int data;
		LinkedList<Node> adjacent;
		boolean marked;

		Node(int data) {
			this.data = data;
			this.marked = false;
			adjacent = new LinkedList<Node>();
		}
	}

	Node[] nodes;

	Graph_bfs(int size) {
		nodes = new Node[size];
		for (int i = 0; i < size; i++) {
			nodes[i] = new Node(i);
		}
	}
	
	void addEdge(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		if(!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		if(!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
	}
	
	void bfs() {
		bfs(0);
	}
	
	void bfs(int index) {
		Node root = nodes[index];
		Queue<Node> queue = new Queue<Node>();
		queue.enqueue(root);
		root.marked = true;
		while(!queue.isEmpty()) {
			Node r = queue.dequeue();
			for( Node n : r.adjacent) {
				if(n.marked == false) {
					n.marked = true;
					queue.enqueue(n);
				}
			}
			visit(r);
		}
	}
	
	void visit(Node n) {
		System.out.print(n.data + " ");
	}
}

/*
 * ------------------------- 
 *    0 
 *   / 
 *  1 -- 3    7 
 *  |  / | \ / 
 *  | /  |  5 
 *  2 -- 4   \ 6 - 8
 */

public class Bfs_Test {
	public static void main(String[] args) {
		Graph_bfs graph = new Graph_bfs(9);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 4);
		graph.addEdge(3, 5);
		graph.addEdge(5, 6);
		graph.addEdge(5, 7);
		graph.addEdge(6, 8);
		System.out.print("bfs °á°ú : ");
		graph.bfs();
		System.out.println();
//		graph.bfs(1);
	}

}
