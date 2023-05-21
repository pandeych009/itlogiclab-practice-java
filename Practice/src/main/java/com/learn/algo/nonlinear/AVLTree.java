package com.learn.algo.nonlinear;

import org.apache.commons.lang.StringUtils;

import com.learn.algo.modal.TreeNode;
import com.learn.algo.nonlinear.operation.TreeOperation;

/**
 * @author cpandey
 *
 */
public class AVLTree implements TreeOperation {

	private TreeNode root;


	@Override
	public void add(int data) {
		root = insert(root, data);
	}

	public TreeNode insert(TreeNode rootNode, int  data) {
		if(rootNode == null) {
			rootNode = new TreeNode(data);
		}else if(data < rootNode.getData()) {
			rootNode.setLeft(insert(rootNode.getLeft(), data));
		}else if(data > rootNode.getData()) {
			rootNode.setRight(insert(rootNode.getRight(), data));
		}
		rootNode.setHeight(getHeight(rootNode));
		preOrderTraversal();
		return rebalance(rootNode);
	}

	/**
	 * @param node
	 * @return
	 */
	public TreeNode rebalance(TreeNode node) {
		System.out.println("Start Rebalancing");
		
		//get the Balance: 
		if(getBalance(node) > 1) {
			if(getHeight(node.getRight().getRight()) > getHeight(node.getRight().getLeft())) {
				System.out.println("Rotate Left");
				//single rotation to left:
				node = singleRotateLeft(node);
			}else {
				//double rotation to left
				System.out.println("Double Rotate Right");
				node = doubleRotateWithRight(node);
			}
		}else if(getBalance(node) < -1) {
			if(getHeight(node.getLeft().getLeft()) > getHeight(node.getLeft().getRight())) {
				System.out.println("Rotate Right");
				//rotate right: 
				node = singleRotateRight(node);
			}else {
				System.out.println("Double Rotate Left");
				//double rotate to right:
				node = doubleRotateWithLeft(node);
			}
		}
		//update height of the node: 
		node.setHeight(getHeight(node));
		return node;
	}

	



	/**
	 * Node is inserted at right subtree of the right
	 * 
	 * @param right
	 * @return
	 */
	private TreeNode singleRotateLeft(TreeNode right) {
		//New root of the rotating node
		TreeNode newRoot = right.getRight();
		//left subtree of rotating node will be placed at the right of the new root
		newRoot.setRight(right.getLeft());
		//Rotating node would be placed at the left:
		newRoot.setLeft(right);


		int rightHeight = this.getHeight(right);
		int newRootHeight = this.getHeight(newRoot);

		//need to check this>> 
		right.setHeight(rightHeight);
		newRoot.setHeight(newRootHeight);
		return newRoot;
	}



	/**
	 * Node is inserted at the left subtree of the left node:
	 * Left node will become the new root:
	 * right subtree of newRoot would be placed at left subtree
	 * left node be placed at the right of new root
	 * 
	 * @param node
	 * @return
	 */
	private TreeNode singleRotateRight(TreeNode node) {
		TreeNode newRoot = node.getLeft();
		//
		node.setLeft(newRoot.getRight());
		newRoot.setRight(node);


		int newRootHeight = this.getHeight(newRoot);
		int nodeHeight = this.getHeight(node);

		node.setHeight(nodeHeight);
		newRoot.setHeight(newRootHeight);

		return newRoot;
	}

	/**
	 * An insertion is made at the right subtree of the left node
	 * right rotation of the left node. 
	 * left rotation of the actual node
	 * 
	 * @param node
	 * @return
	 */
	private TreeNode doubleRotateWithLeft(TreeNode node) {
		//single right rotate of the left node
		node.setLeft(singleRotateLeft(node.getLeft()));
		return singleRotateRight(node); 

	}

	/**
	 * An insertion is made at the left subtree of the right node
	 * right rotation of the left node. 
	 * left rotation of the actual node
	 * 
	 * @param node
	 * @return
	 */
	private TreeNode doubleRotateWithRight(TreeNode node) {
		node.setRight(singleRotateRight(node.getRight()));
		return singleRotateLeft(node); 
	}


	@Override
	public int getHeight(TreeNode targetNode) {
		if(targetNode == null)
			return -1;
		return (Math.max(getHeight(targetNode.getLeft()) ,  getHeight(targetNode.getRight())) + 1);
	}

	public int getBalance(TreeNode node) {
		return (node == null ? 0 : getHeight(node.getRight()) - getHeight(node.getLeft()));
	}





	@Override
	public void delete(int data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postOrderTraversal() {
		// TODO Auto-generated method stub

	}

	@Override
	public void postOrderTraversal(boolean formatted) {
		// TODO Auto-generated method stub

	}

	@Override
	public void preOrderTraversal() {
		if(root != null) {
			StringBuilder builder = new StringBuilder();
			traverseRootNode(builder, StringUtils.EMPTY ,StringUtils.EMPTY , root);
			System.out.println("______________________PRINT_TREE_PRE_ORDER__________");
			System.out.println(builder.toString());
		}

	}
	@Override
	public void preOrderTraversal(boolean formatted) {
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
		return 0;
	}

}
