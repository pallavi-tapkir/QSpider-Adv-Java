package com.pallavi.ds.adv.tree;

import java.util.ArrayList;

public class KthSmallestElement {

	public static void main(String[] args) {
		TreeNode A = new TreeNode(10);
		TreeNode B = new TreeNode(5);
		TreeNode c = new TreeNode(15);
		TreeNode dNode = new TreeNode(2);
		
		A.left = B;
		A.right = c;
		B.left = dNode;
		
//		System.out.println(kthsmallest(A, 2));
		ArrayList<Integer> ansArrayList = inOrderMorrisTraverse(A);
		ansArrayList.stream().forEach(e -> System.out.println(e + ", "));
	}
	
	static int count = 0;
    public static int kthsmallest(TreeNode A, int B) {
        return inOrderTraversal(A, B);
    }

    public static int inOrderTraversal(TreeNode A, int B){
    	int result = 0;
        if(A == null){
            return 0;
        }
        
        result=inOrderTraversal(A.left, B);
        count++;
        if(count == B){
            result = A.val;
        }
        if(count < B){
            result = inOrderTraversal(A.right, B);
        }

        return result;
    }
    
    public static ArrayList<Integer> inOrderMorrisTraverse(TreeNode A){
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(A == null){
            return ans;
        }     

        TreeNode current = A;
        while(current != null){
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
                }
                if(temp.right == current){
                    temp.right = null;
                    ans.add(current.val);
                    current = current.right;
                }
            }            
        }
        return ans;
    }
}
