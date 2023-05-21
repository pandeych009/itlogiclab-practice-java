package com.learn.algo.linear;

public class Stack implements StackOperation {

	ListOperations oper = new LinkedList();
	
	@Override
	public boolean push(int data) {
		return oper.addAtPosition(data, 1);
	}

	@Override
	public int pop() {
		if(oper.isEmpty()){
			return Integer.MIN_VALUE;
		}
		int data = oper.removeFromHead();
		return data;
	}
	
	@Override
	public boolean isEmpty() {
		return oper.isEmpty();
	}
	
	
	@Override
	public String snapshot() {
		return oper.snapShot();
	}
	
	@Override
	public void reverse() {
		if(!isEmpty()){
			int data = pop();
			reverse();
			addElementAtBottom(data);
		}
	}
	
	private void addElementAtBottom(int data){
		if(isEmpty()){
			push(data);
		}else{
			int popedData = pop();
			addElementAtBottom(data);
			push(popedData);
		}
	}

}
