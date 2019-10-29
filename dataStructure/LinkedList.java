package study.dataStructure;

class LinkedList<T> {
	Node header;

	static class Node<T> {
		T data;
		Node next = null;
	}

	LinkedList() {
		header = new Node();
	}

	public void append(T data) {
		Node<T> end = new Node<T>();
		end.data = data;
		Node<T> n = header;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	public void delete(T data) {
		Node n = header;
		while (n.next != null) {
			if (n.next.data == data) {
				n.next = n.next.next;
			} else {
				n = n.next;
			}
		}
	}

	public void retrieve() {
		Node n = header.next;
		while (n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.println(n.data);
	}

	void removeDups() {
		Node n = header;
		while (n != null && n.next != null) {
			Node r = n;
			while (r.next != null) {
				if (n.data == r.next.data) {
					r.next = r.next.next;
				} else {
					r = r.next;
				}
			}
			n = n.next;
		}
	}
	
}
