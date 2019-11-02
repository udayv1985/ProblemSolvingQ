package com.uday.ds.bst;

import java.util.*;

public class BST {
	
	TreeNode root;

	public enum TREE_VIEW {
		RIGHT, LEFT;
	}
	
	public static int maxLevel = 0;
	
	public BST(TreeNode root) {
		this.root = root;	
	}

	public void printRightView(){
		System.out.println("RightView of Tree - ");
		BST.maxLevel = 0;
		this.printView(root,1,TREE_VIEW.RIGHT);
		System.out.println();
	}
	
	public void printLeftView(){
		System.out.println("LeftView of Tree - ");
		BST.maxLevel = 0;
		this.printView(root,1,TREE_VIEW.LEFT);
		System.out.println();
	}

	private void printView(TreeNode node, int level,TREE_VIEW view) {
		if(null == node){
			return;
		}
		if(maxLevel < level){
			System.out.print(node.getData()+ ", ");
			maxLevel = level;
		}
		if(view == TREE_VIEW.RIGHT){
			printView(node.getRight(),level+1,view);
			printView(node.getLeft(),level+1,view);
		}
		else if(view == TREE_VIEW.LEFT){
			printView(node.getLeft(),level+1,view);
			printView(node.getRight(),level+1,view);
		}
		
	}
	
	public int getHeight(){
		return this.getHeight(root);
	}
	
	public int getHeight(TreeNode node){
		
		if(null==node){
			return 0;
		}
		
		else{
			int rHeight = getHeight(node.getRight());
			int lHeight = getHeight(node.getLeft());
			if(lHeight>rHeight){
				return (lHeight+1);
			}
			else{
				return (rHeight+1);
			}
		}
		
	}
	
	public void levelTransversal(){
		System.out.println("Level Transversal of Tree - ");
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(this.root);
		while(!q.isEmpty()){
			TreeNode n = q.poll();
			if(null == n){
				continue;
			}
			System.out.print(n.getData() + ", ");
			q.add(n.getLeft());
			q.add(n.getRight());
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		TreeNode n1 = new TreeNode(6);
		n1.setRight(new TreeNode(9));
		n1.setLeft(new TreeNode(4));
		n1.getRight().setRight(new TreeNode(11));
		n1.getRight().setLeft(new TreeNode(7));
		n1.getLeft().setRight(new TreeNode(5));
		n1.getLeft().setLeft(new TreeNode(2));
		n1.getLeft().getRight().setLeft(new TreeNode(3));
		BST bst = new BST(n1);
		bst.printLeftView();
		bst.printRightView();
		bst.levelTransversal();
		bst.getHeight();
		System.out.println("Height - "+bst.getHeight());
		bst.levelTransversalWithoutQueue();
	}
	
	public void levelTransversalWithoutQueue(){
		System.out.println("Level Transversal of Tree without queue - ");
		int height = this.getHeight();
		for(int i =1; i<=height ; i++){
			printLevel(this.root,i);
		}
		System.out.println();
	}

	private void printLevel(TreeNode n, int level) {
		if(null==n){
			return;
		}
		else if (level == 1){
			System.out.print(n.getData()+", ");
		}
		else{
			printLevel(n.getLeft(),level-1);
			printLevel(n.getRight(),level-1);
		}
		
	}

	public void inOrderTransversal(){
		inOrderTransversal(this.root);
		System.out.println();
	}

	private void inOrderTransversal(TreeNode node){
		if(null == node){
			return;
		}
		inOrderTransversal(node.left);
		System.out.print(node.getData()+",");
		inOrderTransversal(node.right);
	}

	public void preOrderTransversal(){
		preOrderTransversal(this.root);
		System.out.println();
	}

	private void preOrderTransversal(TreeNode node){
		if(null == node){
			return;
		}
		System.out.print(node.getData()+",");
		preOrderTransversal(node.left);
		preOrderTransversal(node.right);
	}

	public void postOrderTransversal(){
		postOrderTransversal(this.root);
		System.out.println();
	}

	private void postOrderTransversal(TreeNode node){
		if(null == node){
			return;
		}
		postOrderTransversal(node.left);
		postOrderTransversal(node.right);
		System.out.print(node.getData()+",");
	}

	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public static int getMaxLevel() {
		return maxLevel;
	}

	public static void setMaxLevel(int maxLevel) {
		BST.maxLevel = maxLevel;
	}



}
