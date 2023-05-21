package com.learn.algo.nonlinear.operation;

import org.apache.commons.lang.StringUtils;

import com.learn.algo.modal.TreeNode;

public interface TreeOperation {
	
	public void add(int data);
	
	public void delete(int data);
	
	public void postOrderTraversal();
	public void postOrderTraversal(boolean formatted);
	
	
	public void preOrderTraversal();
	public void preOrderTraversal(boolean formatted);
	
	
	
	public void inOrderTraversal();
	public void inOrderTraversal(boolean formatted);
	
	public int getTreeHeight();
	
	public default int getHeight(TreeNode targetNode) {
		return 0;	
	}
	
	
	public int getTreeDepth(TreeNode targetNode);
	
	public int getMaxDepth();
	
	public default void traverseRootNode(StringBuilder builder, String padding, String pointer, TreeNode node) {
		if(node != null) {
			builder.append(node.getData());
			
			String pointerRight = "└──";
		    String pointerLeft = (node.getRight() != null) ? "├──" : "└──";

		    traverseNodes(builder, StringUtils.EMPTY, pointerLeft, node.getLeft(), node.getRight() != null);
		    traverseNodes(builder, StringUtils.EMPTY, pointerRight, node.getRight(), false);
		}
	}
	
	public default void traverseNodes(StringBuilder sb, String padding, String pointer, TreeNode node,  boolean hasRightSibling) {
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
	
}
