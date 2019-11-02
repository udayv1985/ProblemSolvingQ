package com.uday.ds.bst;

import java.util.Stack;

public class Transversals {

    public static void inOrderIterative(BST bst) {
        Stack<TreeNode> stack = new Stack();
        TreeNode current = bst.root;
        while (null != current || !stack.isEmpty()) {
            while (null != current) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            current.printNodeWithComma();
            current = current.right;
        }
    }

    public static void preOrderrIterative(BST bst) {
        Stack<TreeNode> stack = new Stack();
        stack.push(bst.root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            node.printNodeWithComma();
            if (null != node.right) {
                stack.push(node.right);
            }
            if (null != node.left) {
                stack.push(node.left);
            }
        }
    }

    public static void postOrderIterative(BST bst) {
        Stack<TreeNode> stack = new Stack();
        Stack<TreeNode> output = new Stack();
        stack.push(bst.root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            output.push(node);
            if (null != node.left) {
                stack.push(node.left);
            }
            if (null != node.right) {
                stack.push(node.right);
            }
        }
        while(!output.isEmpty()){
            output.pop().printNodeWithComma();
        }
        System.out.println();
        bst.postOrderTransversal();
    }

    public static void main(String[] args) {
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
        postOrderIterative(bst2);
    }

}
