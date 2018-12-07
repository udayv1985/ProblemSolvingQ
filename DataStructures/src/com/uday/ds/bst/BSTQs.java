package com.uday.ds.bst;

import java.util.*;

public class BSTQs {
	
	public static boolean isFoldable(BST bst){
		
		if(bst.getRoot()==null){
			return true;
		}
		else{
			return isFoldable(bst.getRoot().getRight(), bst.getRoot().getLeft());
		}
	}
	
	private static boolean isFoldable(TreeNode right, TreeNode left) {
		if(null==right && null==left){
			return true;
		}
		if(null!=right && null!=left){
			return isFoldable(left.getLeft(),right.getRight()) 
					&& isFoldable(left.getRight(),right.getLeft());
		}
		return false;
	}

	public static void printDiagonalView(BST bst){
		Map<Integer,List<TreeNode>> map = new LinkedHashMap<>();
		map = diagonalViewUtil(bst.getRoot(),0,map);
		map.forEach((k,v)-> {
			v.forEach(a -> System.out.print(a.getData() + " , ")); 
			System.out.println();
		});
	}
	
	private static Map<Integer,List<TreeNode>> diagonalViewUtil(
			TreeNode node, int d, Map<Integer,List<TreeNode>> map){
		if(null==node){
			return map;
		}
		if(null==map.get(d)){
			map.put(d, new LinkedList<TreeNode>());
		}
		map.get(d).add(node);
		map = diagonalViewUtil(node.getLeft(),d+1,map);
		map = diagonalViewUtil(node.getRight(),d,map);
		return map;
		
	}
	
	public static void printTopView(BST bst){
		Map<Integer,List<TreeNode>> map = new TreeMap<>();
		//map = printTopViewUtil(bst.getRoot(),0,map);
		
		Queue<TreeNode> q = new LinkedList<>();
		bst.getRoot().distance=0;
		q.add(bst.getRoot());
		while(!q.isEmpty()){
			TreeNode node = q.poll();
			if(null==map.get(node.distance)){
				map.put(node.distance, new LinkedList<TreeNode>());
				map.get(node.distance).add(node);
			}
			if(null!=node.left){
				node.left.distance = node.distance-1;
				q.add(node.left);
			}
			if(null!=node.right){
				node.right.distance = node.distance+1;
				q.add(node.right);
			}
		}
		map.forEach((k,v)-> {
			v.forEach(a -> System.out.print(a.getData() + " , ")); 
			System.out.println();
		} );
		
	}
	
	public static void printBottomView(BST bst){
		System.out.println("Bottom view of the given binary tree:"); 
		Map<Integer,TreeNode> map = new TreeMap<>();
		//map = printTopViewUtil(bst.getRoot(),0,map);
		
		Queue<TreeNode> q = new LinkedList<>();
		bst.getRoot().distance=0;
		q.add(bst.getRoot());
		while(!q.isEmpty()){
			TreeNode node = q.poll();
			map.put(node.distance, node);
			if(null!=node.left){
				node.left.distance = node.distance-1;
				q.add(node.left);
			}
			if(null!=node.right){
				node.right.distance = node.distance+1;
				q.add(node.right);
			}
		}
		map.forEach((k,v)-> {
			System.out.println(v.getData()); 
		} );
		
	}
	
	public static void verticalOrder(BST bst){
		// same as top except store all nodes for a distance instead of first one
		Map<Integer,List<TreeNode>> map = new TreeMap<>();
		Queue<TreeNode> q = new LinkedList<>();
		bst.getRoot().distance = 0;
		q.add(bst.getRoot());
		while(!q.isEmpty()){
			TreeNode n = q.poll();
			if(null==map.get(n.distance)){
				map.put(n.distance, new ArrayList<>());
			}
			map.get(n.distance).add(n);
			if(null!=n.getLeft()){
				n.getLeft().distance = n.distance-1;
				q.add(n.getLeft());
			}
			if(null!=n.getRight()){
				n.getRight().distance = n.distance+1;
				q.add(n.getRight());
			}
		}
		
		map.forEach((k,v)->{
			System.out.print("distance- "+k+"; ");
			v.forEach(a-> System.out.print(a.getData()+","));
			System.out.print(";Sum- "+v.stream().mapToInt(n -> n.getData()).sum());
			System.out.println();
		});
		
		
	}
	
	public static void zigZagTransversal(BST bst){
		Stack<TreeNode> sUse = new Stack<>();
		Stack<TreeNode> sNext = new Stack<>();
		boolean leftFirst = true; 
		sUse.push(bst.getRoot());
		while(!sUse.isEmpty()){
			TreeNode t = sUse.pop();
			if(null==t){
				continue;
			}
			System.out.print(t.getData()+" , ");
			if(leftFirst){
				sNext.push(t.getRight());
				sNext.push(t.getLeft());
			}
			else{
				sNext.push(t.getLeft());
				sNext.push(t.getRight());
			}
			if(sUse.isEmpty()){
				Stack<TreeNode> temp = sNext;
				sNext = sUse; 
				sUse = temp;
				leftFirst = !leftFirst;
			}
		}
	}
	
	public static void boundaryTransversal(BST bst){
		System.out.println(bst.getRoot());
		bst.printLeftView();
		bst.printRightView();
	}

	public static void main(String[] args){
		TreeNode root = new TreeNode(8); 
        root.left = new TreeNode(3); 
        root.right = new TreeNode(10); 
        root.left.left = new TreeNode(1); 
        root.left.right = new TreeNode(6); 
        root.right.right = new TreeNode(14); 
        root.right.right.left = new TreeNode(13); 
        root.left.right.left = new TreeNode(4); 
        root.left.right.right = new TreeNode(7); 
        
        BST bst = new BST(root);
        //printDiagonalView(bst); 
        //printTopView(bst);
        //System.out.println(isFoldable(bst));
        //verticalOrder(bst);
        
        TreeNode root2 = new TreeNode(20); 
        root2.left = new TreeNode(8); 
        root2.right = new TreeNode(22); 
        root2.left.left = new TreeNode(5); 
        root2.left.right = new TreeNode(3); 
        root2.right.left = new TreeNode(4); 
        root2.right.right = new TreeNode(25); 
        root2.left.right.left = new TreeNode(10); 
        root2.left.right.right = new TreeNode(14); 
        BST bst2 = new BST(root2); 
        
        //printBottomView(bst2);
        //zigZagTransversal(bst2);
        System.out.println(findLevel(bst2,14));
	}
	
	public static TreeNode lca(int n1, int n2, TreeNode root){
		if(null==root){
			return null;
		}
		if(root.getData() == n1 || root.getData() == n2){
			return root;
		}
		TreeNode l = lca(n1,n2,root.left);
		TreeNode r = lca(n1,n2,root.right);
		if(null!=l&&null!=r){
			return root;
		}
		return (null!=l?l:r);
	}
	
	public static int findLevel(BST bst, int d){
		return levelUtil(bst.getRoot(),d,0);
	}
	
	private static int levelUtil(TreeNode n, int d, int level){
		if(null==n){
			return -1;
		}
		if(n.getData()==d){
			return level;
		}
		int l = levelUtil(n.getLeft(),d,level+1);
		if(l==-1){
			return levelUtil(n.getRight(),d,level+1);
		}
		return l;
	}

}
