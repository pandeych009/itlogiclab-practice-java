package com.learn.algo.linear;

import com.learn.algo.modal.Node;

public class LinkedList implements ListOperations{

	private Node head;

	@Override
	public boolean add(int data) {
		if(head == null) {
			head = new Node(data);
		}else {
			Node tempHead = head;
			while(tempHead.getNext() != null) {
				tempHead=tempHead.getNext();
			}
			tempHead.setNext(new Node(data));
		}

		return true;
	}

	@Override
	public boolean addAtPosition(int data, int position) {
		int size = size();
		if(position > (size+1)) {
			System.out.println("Position "+position+" is greater then size: "+size+", element will be added at last");
		}else if(position == 0) {
			throw new RuntimeException("Position should starts with 1");
		}

		if(position == 1) {
			Node node = new Node(data);
			node.setNext(head);
			head = node;
			return true;
		}else {
			int finalPosition = position > size ? size+1 : position;
			Node temp = head;
			Node nextTemp = head.getNext();
			int count = 0;

			while(count <= finalPosition) {
				if(nextTemp.getNext() != null) {
					temp = temp.getNext();
					nextTemp = nextTemp.getNext();
				}
				count++;
			}

			Node newNode = new Node(data);
			if(position < size) {
				newNode.setNext(nextTemp);				
				temp.setNext(newNode);
			}else {
				nextTemp.setNext(newNode);
			}
		}

		return true;
	}

	@Override
	public int size() {
		int count = 0;
		if(head != null) {
			Node temp = head;
			while(temp != null) {
				temp = temp.getNext();
				count++;
			}
		}
		return count;
	}

	@Override
	public boolean remove(int data) {
		Node temp = head;
		Node prev = null;
		boolean removed = false;
		while(temp != null && temp.getData() == data) {
			head=temp.getNext();
			temp=head;
			removed=true;
		}

		while(temp != null) {
			while(temp != null && temp.getData() != data) {
				prev=temp;
				temp=temp.getNext();
			}
			if(temp != null) {
				prev.setNext(temp.getNext());
				temp = prev.getNext();
				removed=true;
			}

		}
		return removed;
	}

	@Override
	public int removeFromPosition(int position) {
		int size = size();
		if(position > size || position == 0) {
			throw new RuntimeException("Position is not valid");
		}
		int removedData = -1;
		if(position == 1) {
			removedData = head.getData();
			head = head.getNext();
		}else {
			Node temp = head;
			Node tempNext = head.getNext();

			int count = 1;
			while(tempNext.getNext() != null) {
				if((position-1) <= count) {
					break;
				}
				temp = temp.getNext();
				tempNext = tempNext.getNext();
				count++;
			}
			removedData = tempNext.getData();
			temp.setNext(tempNext.getNext());
		}


		return removedData;
	}

	@Override
	public int removeFromHead() {
		return removeFromPosition(1);
	}

	@Override
	public String snapShot() {
		StringBuilder builder = new StringBuilder();
		Node temp = head;
		while(temp != null) {
			builder.append(temp.getData());
			if(temp.getNext() != null)builder.append(", ");
			temp = temp.getNext();
		}
		return builder.toString();
	}
	
	@Override
	public void reverse() {
		Node prev = head;
		Node temp = null, tempNext= null;
		while(prev != null) {
			tempNext = prev.getNext();
			prev.setNext(temp);
			temp = prev;
			prev=tempNext;
		}
		head=temp;		
	}
	
	
	@Override
	public boolean isEmpty() {
		return size()==0;
	}
	
	@Override
	public void printMiddleLeft() {
		Node temp = head; 
		
	}
}
