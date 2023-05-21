package com.learn.algo.client;

import com.learn.algo.nonlinear.BinarySearchTree;
import com.learn.algo.nonlinear.operation.TreeOperation;

public class BinaryTreeClient {
	
	public static void main(String[] args) {
		int array[] = {7,8,4,5,3,2,9};
		TreeOperation operation = new BinarySearchTree();
		for(int arr: array) {
			operation.add(arr);
		}
		
		
		operation.preOrderTraversal(true);
		System.out.println(operation.getMaxDepth());
		operation.delete(4);
		System.out.println(operation.getMaxDepth());
		operation.preOrderTraversal(true);
		operation.delete(8);
		System.out.println(operation.getMaxDepth());
		operation.preOrderTraversal(true);
		
	}

}
