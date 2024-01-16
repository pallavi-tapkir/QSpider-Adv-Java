package com.pallavi.ds.adv.tree;

import java.util.ArrayList;

public class CommonNodesSum {

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(50);
		TreeNode root1N1 = new TreeNode(25);
		root1.left = root1N1;
		
		TreeNode root1N2 = new TreeNode(75);
		root1.right = root1N2;
		
		TreeNode N3 = new TreeNode(35);
		root1N1.right = N3;
		
		
		TreeNode root2 = new TreeNode(50);
		TreeNode root2N1 = new TreeNode(25);
		root2.left = root2N1;
		
		TreeNode root2N2 = new TreeNode(75);
		root2.right = root2N2;
		
		TreeNode N4 = new TreeNode(35);
		root2N1.right = N4;
		
		int ans = solve(root1, root2);
		System.out.println(ans);
	}
	
	public static int solve(TreeNode A, TreeNode B) {
        ArrayList<Integer> arr1 = inOrderMorrisTraverse(A);
        ArrayList<Integer> arr2 = inOrderMorrisTraverse(B);

        int i=0;
        int j=0;
        int sum = 0;

        while (i < arr1.size() && j < arr2.size()){
            if(arr1.get(i) == arr2.get(j)){
                sum = (sum+arr1.get(i)) % 1000000007;
                i++;
                j++;
            }else if(arr1.get(i) < arr2.get(j)){
                i++;
            }else {
                j++;
            }
        }
        return sum;
    }

    public static ArrayList<Integer> inOrderMorrisTraverse(TreeNode A){
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(A == null){
            return ans;
        }        
        TreeNode current = A;
        while (current != null){
            if(current.left == null){
                ans.add(current.val);
                current = current.right;
            }else{
                TreeNode temp = current.left;
                while(temp.right != null && temp.right != current){
                    temp = temp.right;
                }
                if(temp.right == null){
                    temp.right = current;
                    current = current.left;
                }else if(temp.right == current){
                    temp.right = null;
                    ans.add(current.val);
                    current = current.right;
                }
                
            }
        }
        return ans;
    }

}
