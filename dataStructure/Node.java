package study.dataStructure;

// Node for SimplyLinkedList
class Node<T> {
	 T data;
	 Node<T> next = null;

	public Node(T data) {
		this.data = data;
	}

	public void append(T data) {
		Node<T> end = new Node<T>(data);
		Node<T> n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}

	public void delete(T data) {
		Node n = this;
		while (n.next != null) {
			if (n.next.data == data) {
				n.next = n.next.next;
			} else {
				n = n.next;
			}
		}
	}

	public void retrieve() {
		Node n = this;
		while (n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.println(n.data);
	}
}
