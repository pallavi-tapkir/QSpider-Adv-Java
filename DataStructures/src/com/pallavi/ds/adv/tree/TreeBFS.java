package com.pallavi.ds.adv.tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBFS {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		
		root.left = node1;
		root.right = node2;
		
		BFS(root);
		BFSLevel(root);
	}
	
	public static void BFS(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.print(node.val + " ");
			
			if(node.left != null) {
				queue.add(node.left);
			}
			
			if(node.right != null) {
				queue.add(node.right);
			}
		}
	}

	
	public static void BFSLevel(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int levelSize = 1;
		System.out.println("\n\nBFS Levelwise : ");
		
		while (!queue.isEmpty()) {
			levelSize = queue.size();
			
			for(int deleteSize = 1; deleteSize <= levelSize; deleteSize++) {
				TreeNode node = queue.poll();
				System.out.print(node.val + " ");
				
				if(node.left != null) {
					queue.add(node.left);
				}
				
				if(node.right != null) {
					queue.add(node.right);
				}
			}
			System.out.println();
		}
	}
}
