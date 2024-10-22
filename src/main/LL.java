package main;

import java.util.Objects;

public class LL<T> {
	Node<T> head;
	int size;

	public LL() {
		this.head = null;
		this.size = 0;
	}

	public LL(Node<T> node) {
		copyOver(node);
	}
	
	/**
	 * Copies over the linked list starting at node. 
	 * @param node
	 */
	private void copyOver(Node<T> node) {
		// copy the head node 		
		Node<T> orig_tmp = node;
		while (orig_tmp != null) {
			this.append(orig_tmp.getData());
			orig_tmp = orig_tmp.getNext();
		}
		
	}


	/**
	 * iterate thru list return the *node* at position idx
	 *
	 * (to get data) x.getData()
	 * 
	 * @return
	 */
	private Node<T> getNode(int idx) {
		if (this.isEmpty()) {
			return null;
		}
		if (idx == 0) {
			return head;
		}
		if (idx > size() - 1 || idx < 0) {
			throw new IllegalArgumentException("out of bounds!");
		}
		// node equal
		Node<T> tmp = head;
		for (int i = 0; i < idx; i++) {
			tmp = tmp.getNext();
		}

		return tmp;

	}

	public boolean isEmpty() {
		return this.head == null;
	}

	public void makeEmpty() {
		this.head = null;
	}

	public int size() {
		return this.size;
	}

	@Override
	public String toString() {
		String str = "";
		Node<T> tmp = head;
		while (tmp != null) {
			str += tmp.getData().toString();
			if (tmp.getNext() != null) {
				str += ", ";
			}
			tmp = tmp.getNext();
		}
		return str;
	}

	/**
	 * Given an element x, return x's index in the list or -1 if not found
	 * 
	 * @param x
	 * @return
	 */
	public int find(T x) {
		Node<T> tmp = head;
		int i = 0;
		while (tmp != null) {
			if (tmp.getData().equals(x)) {
				return i;
			}
			tmp = tmp.getNext();
			i++;
		}
		System.out.println("Item not found");
		return -1;
	}

	/**
	 * inserts data at position 1-idx
	 * 
	 * @param idx
	 * @param data
	 */
	public void insert(int idx, T data) {
		// check if idx out of bounds
		if (idx < 0 || idx > size) {
			throw new IllegalArgumentException("Index out of bounds");
		}

		// here is the new node
		Node<T> n = new Node<>(data);

		// switch case for where to insert.
		// 0: beginning
		// 1: middle/end
		
		int j = idx > 0 ? 1 : 0;
		switch (j) {
		case 0:
			n.setNext(head);
			head = n;
			break;
		case 1:
			Node<T> tmp = getNode(idx - 1);
			n.setNext(tmp.getNext());
			tmp.setNext(n);
			break;
		}
		size++;
	}

	/**
	 * removes element at location idx
	 * 
	 * @param idx
	 */
	public void delete(int idx) {

		// check if idx out of bounds
		if (idx < 0 || idx > size) {
			throw new IllegalArgumentException("Index out of bounds");
		}

		// switch case for where to delete.
		// 0: beginning
		// 1: middle/end

		int j = idx > 0 ? 1 : 0;
		switch (j) {
		case 0:
			head = head.getNext();
			break;
		case 1:
			Node<T> tmp = getNode(idx - 1);
			tmp.setNext(tmp.getNext().getNext());
			break;
		}
		size--;

	}

	public void remove(T data) {
		int i = find(data);
		if (i == -1) {
			return;
		}
		delete(i);
	}

	public void append(T data) {
		insert(size, data);
	}
	
	public Node<T> getHead(){
		return this.head;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(head, size);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LL<T> other = (LL<T>) obj;
		Node<T> tmp = head;
		Node<T> tmp2 = other.getHead();
		while (tmp != null && tmp2 != null) {
			if (!tmp.getData().equals(tmp2.getData()))
				return false;
			tmp = tmp.getNext();
			tmp2 = tmp2.getNext();
		}
		if (!(tmp == null && tmp == null))
			return false;
		return true;
	}

	/**
	 * Unions the list b with this list.
	 * Modifies this list.
	 * @param b
	 */
	public void union(LL<T> b) {
		throw new UnsupportedOperationException("Not yet implemented");
	}
	
	/** 
	 * Intersects the list b with this list. 
	 * Modifies this list.
	 * @param b
	 */
	public void intersect(LL<T> b) {
		throw new UnsupportedOperationException("Not yet implemented");
	}
	
	
	
}
