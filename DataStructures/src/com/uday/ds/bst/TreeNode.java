package com.uday.ds.bst;

public class TreeNode {
	
	private int data; 
	
	public TreeNode left;
	
	public TreeNode right;
	
	public int distance;
	
	public TreeNode(int data){
		this.data = data;
		right = left = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	} 
	
	

}
