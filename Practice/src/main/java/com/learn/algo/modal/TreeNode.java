package com.learn.algo.modal;

public class TreeNode {
	
	private int data;
	private TreeNode right;
	private TreeNode left;
	
	private int depth;
	private int height;
	
	
	/**
	 * @return the depth
	 */
	public int getDepth() {
		return depth;
	}
	/**
	 * @param depth the depth to set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * @return the right
	 */
	public TreeNode getRight() {
		return right;
	}
	/**
	 * @param right the right to set
	 */
	public void setRight(TreeNode right) {
		this.right = right;
	}
	/**
	 * @return the left
	 */
	public TreeNode getLeft() {
		return left;
	}
	/**
	 * @param left the left to set
	 */
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}
	
	public TreeNode(int data) {
		super();
		this.data = data;
	}
	
	/**
	 * @param data the data to set
	 */
	public void setData(int data) {
		this.data = data;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TreeNode [data=" + data + ", right=" + right + ", left=" + left + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof TreeNode)) {
			return false;
		}
		TreeNode other = (TreeNode) obj;
		if (data != other.data) {
			return false;
		}
		if (left == null) {
			if (other.left != null) {
				return false;
			}
		} else if (!left.equals(other.left)) {
			return false;
		}
		if (right == null) {
			if (other.right != null) {
				return false;
			}
		} else if (!right.equals(other.right)) {
			return false;
		}
		return true;
	}
	
	
}
