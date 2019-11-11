package study.dataStructure;

import java.util.LinkedList;
import java.util.Stack;

class Graph_dfs {
	class Node {
		int data;
		LinkedList<Node> adjacent;
		boolean marked = false;

		Node(int data) {
			this.data = data;
			adjacent = new LinkedList<Node>();
		}
	}

	Node[] nodes;

	Graph_dfs(int size) {
		nodes = new Node[size];
		for (int i = 0; i < size; i++) {
			nodes[i] = new Node(i);
		}
	}

	void addEdge(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		if (!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		if (!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
	}

	void dfs() {
		dfs(0);
	}

	void dfs(int index) {
		Node root = nodes[index];
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		root.marked = true;
		while (!stack.isEmpty()) {
			Node r = stack.pop();
			for (Node n : r.adjacent) {
				if (n.marked == false) {
					n.marked = true;
					stack.push(n);
				}
			}
			visit(r);
		}
	}

	void dfsR(Node r) {
		if (r == null)
			return;
		r.marked = true;
		visit(r);
		for (Node n : r.adjacent) {
			if (n.marked == false) {
				dfsR(n);
			}
		}
	}

	void dfsR(int index) {
		Node r = nodes[index];
		dfsR(r);
	}

	void dfsR() {
		dfsR(0);
	}

	void visit(Node n) {
		System.out.print(n.data + " ");
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
}
public class Dfs_Test {
	public static void main(String[] args) {
		Graph_dfs graph = new Graph_dfs(9);
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
//		graph.dfs();
//		graph.dfsR();
		graph.dfsR(2);
		
	}
}
