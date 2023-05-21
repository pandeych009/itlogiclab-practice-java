package com.learn.algo.nonlinear;

import java.util.Objects;

import org.apache.commons.lang.StringUtils;

import com.learn.algo.modal.TreeNode;
import com.learn.algo.nonlinear.operation.TreeOperation;

public class BinarySearchTree implements TreeOperation {

	private TreeNode root;

	@Override
	public void add(int data) {
		root = addData(root, data);
	}

	public TreeNode addData(TreeNode node, int data) {
		if(node == null){
			node = new TreeNode(data);
			return node;
		}
		if(data > root.getData()){
			node.setRight(addData(node.getRight(), data));			
		}else{
			node.setLeft(addData(node.getLeft(), data));
		}

		return node;
	}

	@Override
	public void delete(int data) {
		//delete operation: 
		TreeNode node = delete(root, data);
	}


	public TreeNode delete(TreeNode node, int data) {

		if(Objects.isNull(node)) {
			return node;
		}

		if(data < node.getData())
			node.setLeft(delete(node.getLeft(), data));
		else if (data > node.getData())
			node.setRight(delete(node.getRight(), data));
		else {
			//If left child is not present, return the right and vice versa.
			if(Objects.isNull(node.getLeft())) {
				return node.getRight();
			}else if(Objects.isNull(node.getRight())) {
				return node.getLeft();
			}

			//If both the child present; then find the minValue in order successor: 

			node.setData(minInOrderSuccessor(node.getRight())); 
			node.setRight(delete(node.getRight(), data));
		}
		return node;
	}


	private int minInOrderSuccessor(TreeNode node) {
		TreeNode tempNode = node;
		int minValue = node.getData();

		while(tempNode.getLeft() != null) {
			minValue = tempNode.getLeft().getData();
			tempNode=tempNode.getLeft();
		}
		return minValue;
	}

	@Override
	public void preOrderTraversal() {
		if(root != null) {
			StringBuilder builder = new StringBuilder();
			preOrderTraversal(builder, root);
			System.out.println("______________________PRINT_TREE_PRE_ORDER__________");
			System.out.println(builder.toString());
		}

	}
	
	@Override
	public void preOrderTraversal(boolean formatted) {
		if(root != null) {
			StringBuilder builder = new StringBuilder();
			//preOrderTraversal(builder,StringUtils.EMPTY ,StringUtils.EMPTY , root);
			traverseRootNode(builder, StringUtils.EMPTY ,StringUtils.EMPTY , root);
			System.out.println("______________________PRINT_TREE_PRE_ORDER__________");
			System.out.println(builder.toString());
		}

	}

	public void preOrderTraversal(StringBuilder builder, TreeNode node) {
		if(node != null) {
			builder.append(node.getData());
			builder.append("\n");
			preOrderTraversal(builder, node.getLeft());
			preOrderTraversal(builder, node.getRight());
		}
	}
	
	public void traverseRootNode(StringBuilder builder, String padding, String pointer, TreeNode node) {
		if(node != null) {
			builder.append(node.getData());
			
			String pointerRight = "└──";
		    String pointerLeft = (node.getRight() != null) ? "├──" : "└──";

		    traverseNodes(builder, StringUtils.EMPTY, pointerLeft, node.getLeft(), node.getRight() != null);
		    traverseNodes(builder, StringUtils.EMPTY, pointerRight, node.getRight(), false);
		}
	}
	
	public void traverseNodes(StringBuilder sb, String padding, String pointer, TreeNode node,  boolean hasRightSibling) {
		if (node != null) {
	        sb.append("\n");
	        sb.append(padding);
	        sb.append(pointer);
	        sb.append(node.getData());

	        StringBuilder paddingBuilder = new StringBuilder(padding);
	        if (hasRightSibling) {
	            paddingBuilder.append("│  ");
	        } else {
	            paddingBuilder.append("   ");
	        }

	        String paddingForBoth = paddingBuilder.toString();
	        String pointerRight = "└──";
	        String pointerLeft = (node.getRight() != null) ? "├──" : "└──";

	        traverseNodes(sb, paddingForBoth, pointerLeft, node.getLeft(), node.getRight() != null);
	        traverseNodes(sb, paddingForBoth, pointerRight, node.getRight(), false);
	    }
	}
	
	public void preOrderTraversal(StringBuilder builder, String padding, String pointer, TreeNode node) {
		if(node == null)
			return;
			
		builder.append(padding);
		builder.append(pointer);
		builder.append(node.getData());
		builder.append("\n");

        StringBuilder paddingBuilder = new StringBuilder(padding);
        paddingBuilder.append("│  ");

        String paddingForBoth = paddingBuilder.toString();
        String pointerForRight = "└──";
        String pointerForLeft = (node.getRight() != null) ? "├──" : "└──";
        
        preOrderTraversal(builder, paddingForBoth, pointerForLeft, node.getLeft());
        preOrderTraversal(builder, paddingForBoth, pointerForRight, node.getRight());
	}

	@Override
	public void postOrderTraversal() {
		StringBuilder builder = new StringBuilder();
		postOrderTraversal(builder, root);
		System.out.println(builder.toString());
		
	}

	private void postOrderTraversal(StringBuilder builder, TreeNode node) {
		if(node != null) {
			postOrderTraversal(builder, node.getLeft());
			postOrderTraversal(builder, node.getRight());
			builder.append(node.getData()+", ");
		}
		
	}

		
	
	@Override
	public void postOrderTraversal(boolean formatted) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inOrderTraversal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inOrderTraversal(boolean formatted) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTreeHeight() {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public int getTreeDepth(TreeNode targetNode) {
		
		return 0;
	}

	@Override
	public int getMaxDepth() {
		if(root == null)
			return 0;
		return getMaxDepth(root);
	}
	
	public int getMaxDepth(TreeNode node) {
		if(node != null) {
			int leftDepth = getMaxDepth(node.getLeft());
			int rightDepth = getMaxDepth(node.getRight());
			
			if(leftDepth > rightDepth)
				return leftDepth+1;
			return rightDepth+1;
		}
		return 0; 
	}
}
