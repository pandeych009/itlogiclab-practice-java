package com.learn.algo.nonlinear.operation;

public interface HeapOperation {
	
	//whose parent we want to look it up
	public int parent(int index);
	
	public void insert(int data);
	
	public void resizeHeap();
	
	public void destroyHeap();
	
	public int deleteMax();
	
	public void prelocateDown(int location);
	
	public int leftChild(int location);
	
	public int rightChild(int location);
	
	
	public String printHeap();
	
}
