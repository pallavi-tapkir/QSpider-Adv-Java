package com.pallavi.ds.adv.tree;

public class DiameterOfTree {

	static int maxDiameter = 0;
	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(9);
		TreeNode treeNode1 = new TreeNode(6);
		TreeNode treeNode2 = new TreeNode(17);
		TreeNode treeNode3 = new TreeNode(23);
		TreeNode treeNode4 = new TreeNode(7);
		treeNode.left = treeNode1;
		treeNode.right = treeNode2;
		treeNode1.left = treeNode3;
		treeNode1.right = treeNode4;
//		System.out.println(solve(treeNode));
		System.out.println(sum(treeNode));
	}
	
	public static int solve(TreeNode A) {
        calDiameter(A);
        return maxDiameter;
    }

    public static int calDiameter(TreeNode A){
        if(A == null){
            return -1;
        }

        int left = calDiameter(A.left) + 1;
        int right = calDiameter(A.right) + 1;
        
        int currentDiameter = left + right;
        maxDiameter = Math.max(currentDiameter, maxDiameter);
        return  Math.max(left, right);
    }
    
    
    public static int sum(TreeNode A){
        if(A == null){
            return 0;
        }

        int leftSum = sum(A.left);
        int rightSum = sum(A.right);
        return leftSum + rightSum + A.val;
    }
}

