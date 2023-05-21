package com.learn.algo.linear;

public interface QueueOperations {
	
	public void enqueue(int data);
	
	public int dequeue();
	
	public void printQueue();
	
	public boolean isEmpty();
	
	public int size();
	
	public void enqueue(int data, boolean usePredefined);	
	public int dequeue(boolean usePredefined);	
	public void printQueue(boolean usePredefined);
	
	
}
