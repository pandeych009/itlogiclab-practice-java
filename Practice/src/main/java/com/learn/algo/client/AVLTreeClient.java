package com.learn.algo.client;

import java.util.Arrays;
import java.util.List;

import com.learn.algo.nonlinear.AVLTree;
import com.learn.algo.nonlinear.operation.TreeOperation;

public class AVLTreeClient {
	
	public static void main(String[] args) {
		List<Integer> inputs = Arrays.asList(8,5,2,3,6,7);
		
		TreeOperation oper = new AVLTree();
		inputs.forEach(input -> oper.add(input));
		oper.preOrderTraversal();
		
	}

}
