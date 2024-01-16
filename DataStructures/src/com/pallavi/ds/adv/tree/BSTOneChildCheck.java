package com.pallavi.ds.adv.tree;

public class BSTOneChildCheck {

	public static void main(String[] args) {
		int[] A = {1, 5, 6, 4};
		solve(A);
	}
	
	 public static String solve(int[] A) {
	        int n = A.length;
	        int minLeftVal = Integer.MIN_VALUE;
	        int maxRightVal = Integer.MAX_VALUE;
	        String ans = "YES";

	        for (int i = 0; i < n - 1; i++) {
	            int current = A[i];

	            // Check the BST condition (L < N < R)
	            if (current <= minLeftVal || current >= maxRightVal) {
	                return "NO";
	            }

	            // Update the variables
	            if (A[i + 1] < current) {
	                maxRightVal = current;
	            } else {
	                minLeftVal = current;
	            }
	        }
	        // Check the last element against the allowed range
	        if (A[n - 1] <= minLeftVal || A[n - 1] >= maxRightVal) {
	            return "NO";
	        }

	        return ans;
	    }

}
