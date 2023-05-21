package com.learn.algo.modal;

public class Node {
	
	private int data;
	private Node next;
	private Node prev;
	
	public Node(int data) {
		super();
		this.data = data;
	}

	
	/**
	 * @return the next
	 */
	public Node getNext() {
		return next;
	}


	/**
	 * @param next the next to set
	 */
	public void setNext(Node next) {
		this.next = next;
	}


	/**
	 * @return the prev
	 */
	public Node getPrev() {
		return prev;
	}


	/**
	 * @param prev the prev to set
	 */
	public void setPrev(Node prev) {
		this.prev = prev;
	}


	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Node [data=" + data + ", nextNode=" + next + ", prevNode=" + prev + "]";
	}
}
