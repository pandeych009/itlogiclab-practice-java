package com.learn.algo.nonlinear;

import com.learn.algo.nonlinear.operation.HeapOperation;

public class Heap implements HeapOperation {
	private int[] heap;
	private int count;
	private int capacity;
	private int heapType;

	//creating the heap
	public Heap(int capacity, int heapType) {
		super();
		this.capacity = capacity;
		this.heapType = heapType;

		heap = new int[capacity];
		this.count=0;
	}


	@Override
	public int parent(int index) {
		//Boundary condition: 
		if(index <= 0 || index >= count){
			return -1;
		}
		return index-1/2;
	}

	@Override
	public void insert(int data) {
		int index = 0;
		if(count == capacity){
			resizeHeap();
			index = count -1;
		}
		
		
		while(index >= 0 && data > heap[(index -1)/2]){
			heap[index]=heap[(index -1)/2];
			index = index-1/2;
		}
		heap[index]=data;
	}

	@Override
	public void resizeHeap() {
		int[] heap_temp = new int[capacity];
		System.arraycopy(heap, 0, heap_temp, 0, count-1);
		capacity=capacity*2;
		heap = new int[capacity];
		for(int index = 0; index < heap_temp.length; index++){
			heap[index]=heap_temp[index];
		}
	}

	@Override
	public void destroyHeap() {
		// TODO Auto-generated method stub

	}

	@Override
	public int deleteMax() {
		int max = heap[0];
		heap[0]=heap[count-1];
		count--;
		prelocateDown(0);
		return max;
	}

	@Override
	public void prelocateDown(int location) {
		int left = leftChild(location);
		int right  = rightChild(location);
		int max = location;

		if(left != -1 && heap[left] > heap[location]){
			max = left;	
		}
		if(right != -1 && heap[right] > heap[location]){
			max = right;
		}

		if(max != location){
			int temp = heap[location];
			heap[location]=heap[max];
			heap[max]=temp;
		}
		prelocateDown(max);
	}

	@Override
	public int leftChild(int location) {
		int left = 2*location+1;
		if(left == count){
			return -1;
		}
		return left;
	}

	@Override
	public int rightChild(int location) {
		int right = 2*location -1;
		if(right < 0 || right > count){
			return -1;
		}
		return right;
	}
	
	@Override
	public String printHeap() {
		StringBuilder builder = new StringBuilder();
		for(int index=0;index<heap.length;index++){
			builder.append(heap[index]);
			if(index < heap.length){
				builder.append(", ");
			}
		}
		return builder.toString();
	}
}
