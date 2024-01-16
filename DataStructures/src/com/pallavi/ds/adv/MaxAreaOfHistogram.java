package com.pallavi.ds.adv;

import java.util.Stack;

public class MaxAreaOfHistogram {

	public static void main(String[] args) {
		int[][] A = new int[3][3];
		A[0][0] = 1;
		A[0][1] = 1;
		A[0][2] = 1;
		
		A[1][0] = 1;
		A[1][1] = 1;
		A[1][2] = 1;
		
		A[2][0] = 1;
		A[2][1] = 0;
		A[2][2] = 0;
		
		MaxAreaOfHistogram m = new MaxAreaOfHistogram();
		System.out.println(m.maximalRectangle(A));
	}
	
	public int areaOfHistogram(int a[]){
        int n = a.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        for(int i = 0; i <= n; i++){
            while(!st.empty() && (i == n || a[st.peek()] >= a[i])){
                int height = a[st.pop()];
                int width;
                if(st.empty()){
                    width = i;
                }
                else{
                    width = i - st.peek() - 1;
                }
                maxArea = Math.max(maxArea, height * width);
            }
            st.push(i);
        }
        return maxArea;
    }
    public int maximalRectangle(int[][] A){
        int maxArea = areaOfHistogram(A[0]);
        for(int i = 1; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                if(A[i][j] == 1){
                    A[i][j] += A[i - 1][j];
                }
            }
            maxArea = Math.max(maxArea, areaOfHistogram(A[i]));
        }
        return maxArea;
    }
}
