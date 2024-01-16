package com.pallavi.ds.adv;

import java.util.ArrayList;

class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) {
	    	  val = x;
	    	  left=null;
	    	  right=null;
	      }
}

public class TreeTraversal {
	
	public static void main(String[] args) {
		ArrayList<Integer> inorder = new ArrayList<Integer>();
		ArrayList<Integer> postOrder = new ArrayList<Integer>();
		inorder.add(4);
		inorder.add(2);
		inorder.add(5);
		inorder.add(1);
		inorder.add(6);
		inorder.add(3);
		inorder.add(7);
		
		postOrder.add(4);
		postOrder.add(5);
		postOrder.add(2);
		postOrder.add(6);
		postOrder.add(7);
		postOrder.add(3);
		postOrder.add(1);
		
		TreeNode rooTreeNode = buildTree(inorder, postOrder);
		System.out.print("Built the tree successfully");
	}
	
	public static TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
		
		TreeNode root = buildTree(A, B, 0, A.size()-1, 0, A.size()-1);
		return root;
	}
	
	public static TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B, 
			int inorderStartIdx, int inorderEndIdx, int postOrderStartIdx, int postOrderEndIdx) {
		if(inorderStartIdx > inorderEndIdx) {
			return null;
		}
		
		int rootVal = B.get(postOrderEndIdx);
		TreeNode root = new TreeNode(rootVal);
		int rootIdx = A.indexOf(rootVal);
		int count = rootIdx - inorderStartIdx;
		
		root.left = buildTree(A, B, inorderStartIdx, rootIdx-1, postOrderStartIdx, postOrderStartIdx + count -1);
		root.right = buildTree(A, B, rootIdx+1, inorderEndIdx, postOrderStartIdx+count, postOrderEndIdx-1);
		
		return root;
	}

}
