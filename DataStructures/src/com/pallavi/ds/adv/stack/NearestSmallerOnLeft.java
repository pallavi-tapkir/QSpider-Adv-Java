package com.pallavi.ds.adv.stack;

import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallerOnLeft {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(5);
		A.add(10);
		A.add(15);
		A.add(13);
		ArrayList<Integer> ans = prevSmaller(A);
		ans.stream().forEach(e -> System.out.println(e));
	}

	public static ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0; i<A.size(); i++) {
			while(!stack.isEmpty() && stack.peek() >= A.get(i)) {
				stack.pop();			
			}
			if(stack.isEmpty()) {
				ans.add(-1);
			}else {
				ans.add(stack.peek());
			}
			stack.push(A.get(i));
		}
		return ans;
	}
}
