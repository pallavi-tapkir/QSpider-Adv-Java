package com.pallavi.ds.adv;

import java.util.ArrayList;

public class TreeTraversal2 {

	public static void main(String[] args) {
		ArrayList<Integer> inorder = new ArrayList<Integer>();
		ArrayList<Integer> preOrder = new ArrayList<Integer>();
		inorder.add(4);
		inorder.add(2);
		inorder.add(5);
		inorder.add(1);
		inorder.add(6);
		inorder.add(3);
		inorder.add(7);
		
		preOrder.add(1);
		preOrder.add(2);
		preOrder.add(3);
		preOrder.add(4);
		preOrder.add(3);
		preOrder.add(6);
		preOrder.add(7);
		
		TreeNode rootTreeNode = buildTree(inorder, preOrder);
		System.out.print("Built the tree successfully");

	}

	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) {
	 *      val = x;
	 *      left=null;
	 *      right=null;
	 *     }
	 * }
	 */
    public static TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        return buildTree(A, B, 0, A.size()-1, 0, A.size()-1);
    }

    public static TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B, int inOrderStartIdx, int inOrderEndIdx, int preOrderStartIdx, int preOrderEndIdx) {
        if(inOrderStartIdx > inOrderEndIdx){
            return null;
        }

        int val = B.get(preOrderStartIdx);
        TreeNode root = new TreeNode(val);
        int rootIdx = A.indexOf(val);
        int count = rootIdx - inOrderStartIdx;

        root.left = buildTree(A, B, inOrderStartIdx, rootIdx-1, preOrderStartIdx+1, preOrderStartIdx+count);
        root.right = buildTree(A, B, rootIdx+1, inOrderEndIdx, preOrderStartIdx+count+1, preOrderEndIdx);

        return root;
    }

}
