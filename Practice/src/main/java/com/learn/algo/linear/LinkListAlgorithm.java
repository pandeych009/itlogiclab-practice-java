package com.learn.algo.linear;

import java.util.Set;

import com.learn.utils.PracticeUtils;

public class LinkListAlgorithm {
	
	public static void reverseFirstFewElementInLinkList(int position, Queue queue){
		if(queue.isEmpty()){
			return ;
		}
		
		if(queue.size() < position){
			throw new RuntimeException("Invalid position");
		}
		
		StackOperation stack = new Stack();
		for(int index = 0; index < position; index++ ){
			stack.push(queue.dequeue());
		}
		
		queue.printQueue();
		
		while(!stack.isEmpty()){
			queue.enqueue(stack.pop());
		}
		queue.printQueue();
		
	}
	
	public static void main(String[] args) {
		Queue queue = new Queue();
		Set<Integer> inputList = PracticeUtils.generateNumber(8, 50);
		inputList.forEach(input -> queue.enqueue(input));
		queue.printQueue();
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^");
		reverseFirstFewElementInLinkList(5, queue);
	}

}
