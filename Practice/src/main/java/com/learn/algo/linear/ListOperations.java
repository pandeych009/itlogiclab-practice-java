package com.learn.algo.linear;

public interface ListOperations {
	
	public boolean add(int data);
	public boolean addAtPosition(int data, int position);
	public boolean remove(int data);
	public int removeFromPosition(int position);
	public int removeFromHead();
	public int size();
	public String snapShot();
	public void reverse();
	public boolean isEmpty();
	
	public void printMiddleLeft();
	
}
