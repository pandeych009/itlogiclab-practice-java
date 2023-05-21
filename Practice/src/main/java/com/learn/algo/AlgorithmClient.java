package com.learn.algo;


import java.util.stream.IntStream;

import com.learn.algo.linear.ListOperations;
import com.learn.algo.linear.LinkedList;
import com.learn.algo.linear.Stack;
import com.learn.algo.linear.StackOperation;
import com.learn.algo.nonlinear.Heap;

public class AlgorithmClient {
	public static void main(String[] args) {
		//System.out.println("STACK_OPERATIONS");
		//stackOperation();
		//System.out.println("LINKED_LIST_OPERATIONS");
		//LinkedListOperations();
		heapOperation();
	}
	
	private static void heapOperation(){
		final Heap heap = new Heap(5, 0);
		IntStream.rangeClosed(1,  5).forEach(input -> {
			//int element = ThreadLocalRandom.current().nextInt(input);
			System.out.println("\t"+input);
			heap.insert(input);
		});
		System.out.println(heap.printHeap());
		
	}

	private static void stackOperation() {
		StackOperation oper = new Stack();
		IntStream.rangeClosed(1, 6).forEach(input -> {
			oper.push(input);
		});
		System.out.println(oper.snapshot());
		oper.reverse();
		System.out.println("oper.reverse(): "+oper.snapshot());
		System.out.println("oper.pop(): "+oper.pop());
		System.out.println(oper.snapshot());
	}

	private static void LinkedListOperations() {
		final ListOperations oper = new LinkedList();
		IntStream.rangeClosed(1, 6).forEach(input -> {
			oper.add(input);
		});
		
		
		System.out.println(oper.snapShot());
		oper.addAtPosition(50, 17);
		System.out.println("oper.addAtPosition(50, 17): "+oper.snapShot());
		oper.addAtPosition(49, 18);
		System.out.println("oper.addAtPosition(49, 18): "+oper.snapShot());
		oper.removeFromPosition(1);
		System.out.println("oper.removeFromPosition(1): "+oper.snapShot());
		oper.remove(4);
		System.out.println("oper.remove(4): "+oper.snapShot());
		oper.reverse();
		System.out.println("oper.reverse(): "+oper.snapShot());
		
	}

}
