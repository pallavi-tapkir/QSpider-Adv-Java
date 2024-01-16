package com.pallavi.ds.adv;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SortUsingStack {

	public static void main(String[] args) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		ans.add(1);
		ans.add(9);
		ans.add(17);
		ans.add(29);
		
		solve(ans);
		
	}
	
	public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i< A.size(); i++){
            ArrayList<Integer> arrList = new ArrayList<Integer>();
            if(!stack.isEmpty()){
                while(!stack.isEmpty() && stack.peek() < A.get(i)){
                    arrList.add(stack.pop());
                }
                stack.push(A.get(i));

                for(int j=arrList.size()-1; j>= 0; j--){
                    stack.push(arrList.get(j));
                }
            }else{
                stack.push(A.get(i));
            }
        }

        ArrayList<Integer> ans = new ArrayList<Integer>();
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        return ans;
    }

}
