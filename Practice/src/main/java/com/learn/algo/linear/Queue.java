package com.learn.algo.linear;

import com.learn.algo.modal.Node;

public class Queue implements QueueOperations{

	private Node frontNode;
	private Node rearNode; 
	
	private ListOperations linkList; 
	
	private int size;
	
	public Queue() {
		linkList = new LinkedList();
	}
	
	@Override
	public void enqueue(int data) {
		Node tempNode = new Node(data);
		size++;
		if(rearNode != null){
			rearNode.setNext(tempNode);
		}
		rearNode = tempNode;
		if(frontNode == null){
			frontNode=rearNode;
		}
		System.out.println(data+" is enqueued: snapshot as");
		printQueue();
	}

	@Override
	public int dequeue() {
		if(frontNode == null || rearNode == null)
			throw new RuntimeException("Queue is empty");
		
		int data = frontNode.getData();
		if(frontNode.getNext() != null)
			frontNode=frontNode.getNext();
		else{
			rearNode = null;
			frontNode = null;
		}
		
		System.out.println("Data dequeue from Queue: "+data);
		size--;
		printQueue();
		return data;
	}

	@Override
	public void enqueue(int data, boolean usePredefined) {
		linkList.addAtPosition(data, 1);		
	}

	@Override
	public int dequeue(boolean usePredefined) {
		int data = linkList.removeFromHead();
		return data;	
	}
	
	@Override
	public void printQueue() {
		StringBuilder builder = new StringBuilder();
		if(frontNode == null || rearNode == null)
			throw new RuntimeException("Queue is empty: ");
		Node tempNode = frontNode;
		while(tempNode.getNext() != null){
			builder.append(tempNode.getData()+", ");
			tempNode=tempNode.getNext();
		}
		builder.append(rearNode.getData());
		System.out.println(builder.toString());
	}
	
	@Override
	public void printQueue(boolean usePredefined) {
		linkList.snapShot();			
	}

	@Override
	public boolean isEmpty() {
		return frontNode == null && rearNode == null;
	}
	
	@Override
	public int size() {
		return size;
	}
}
