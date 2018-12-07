package com.uday.ds.bst;

import java.util.Stack;

public class Practice {
	
	static int max_level = 0;
	
	public static void rightView(BST bst){
		
		viewUtil(bst.getRoot(),1);
		
	}
	
	private static void viewUtil(TreeNode n, int level){
		if(n==null){
			return;
		}
		if(max_level<level){
			System.out.println(n.getData());
			max_level = level;
		}
		viewUtil(n.getLeft(),level+1);
		viewUtil(n.getRight(),level+1);
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
		//rightView(bst);
		//levelT(bst);
		zigzag(bst);
	}
	
	public static int height(TreeNode n){
		if(null==n){
			return 0;
		}
		int l = height(n.getLeft());
		int r = height(n.right);
		if(l>r){
			return l+1;
		}
		else{
			return r+1;
		
		}		
	}
	
	public static void levelT(BST bst){
		int h = height(bst.getRoot());
		for(int i =1; i <= h; i++){
			printLevel(bst.getRoot(),i);
			System.out.println();
		}
	}

	private static void printLevel(TreeNode n, int level) {
		if(n==null){
			return;
		}
		else if(level==1){
			System.out.print(n.getData()+",");
		}
		else{
			printLevel(n.getLeft(),level-1);
			printLevel(n.getRight(),level-1);
		}
		
	}
	
	public static void zigzag(BST bst){
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(bst.getRoot());
		while(!s1.isEmpty() || !s2.isEmpty()){
			while(!s1.isEmpty()){
				TreeNode n = s1.pop();
				System.out.print(n.getData()+",");
				if(null!=n.getLeft()){
					s2.push(n.getLeft());
				}
				if(null!=n.getRight()){
					s2.push(n.getRight());
				}
			}
			System.out.println();
			while(!s2.isEmpty()){
				TreeNode n = s2.pop();
				System.out.print(n.getData()+",");
				if(null!=n.getRight()){
					s1.push(n.getRight());
				}
				if(null!=n.getLeft()){
					s1.push(n.getLeft());
				}
			}
			System.out.println();
		}
		
	}

}
