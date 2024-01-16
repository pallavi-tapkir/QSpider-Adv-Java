package com.pallavi.ds.adv.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    TreeNode node;
    int level;

    Pair(int level, TreeNode node){
        this.node = node;
        this.level = level;
    }
}

public class VerticalOrderTraversal {
	
	public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

        HashMap<Integer, ArrayList<TreeNode>> hm = new HashMap<Integer, ArrayList<TreeNode>>();
        Queue<Pair> queue = new LinkedList<Pair>();
        
        queue.add(new Pair(0,A));
        int minLevel = 0;
        int maxLevel = 0;

        while(!queue.isEmpty()){
            Pair p = queue.poll();

            minLevel = Math.min(minLevel, p.level);
            maxLevel = Math.max(maxLevel, p.level);
            
            if(hm.containsKey(p.level)){
                hm.get(p.level).add(p.node);
            }else{
                ArrayList<TreeNode> ls = new ArrayList<TreeNode>();
                ls.add(p.node);
                hm.put(p.level, ls);
            }
            
            if(p.node.left != null){
                queue.add(new Pair(p.level-1, p.node.left));
            }

            if(p.node.right != null){
                queue.add(new Pair(p.level+1, p.node.right));
            }
                      
        }

        for(int i=minLevel; i<=maxLevel; i++){
            ArrayList<Integer> row = new ArrayList<Integer>();
            for(TreeNode n : hm.get(i)){
                row.add(n.val);
            }
            ans.add(row);
        }

        return ans; 
    }

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(7);
		
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(9);
		
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.right = node5;
		
		ArrayList<ArrayList<Integer>> ans=verticalOrderTraversal(root);
		
		for(ArrayList<Integer> row : ans) {
			for(Integer i:row) {
				System.out.print(i+" ");
			}
			System.out.println();
		}

	}

}
