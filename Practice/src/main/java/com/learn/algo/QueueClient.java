package com.learn.algo;

import java.util.Set;

import com.learn.algo.linear.Queue;
import com.learn.algo.linear.QueueOperations;
import com.learn.utils.PracticeUtils;

public class QueueClient {
	
	public static void main(String[] args) {
		QueueOperations queue = new Queue();
		Set<Integer> inputList = PracticeUtils.generateNumber(5, 50);
		inputList.forEach(input -> queue.enqueue(input));
		queue.printQueue();
		int data = queue.dequeue();
		data = queue.dequeue();
		data = queue.dequeue();
		data = queue.dequeue();
		data = queue.dequeue();
	}

}
