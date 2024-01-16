package com.pallavi.ds.adv.queue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxNumQueue {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int windowSize = 2;
		int k=windowSize;
		
//		A.add(20);
		A.add(5);
		A.add(9);
		A.add(11);
		A.add(1);
		A.add(3);
		int n=A.size();
		Deque<Integer> queue = new LinkedList<Integer>();
		int i=0;
		for(i=0; i< windowSize; i++) {
			while(!queue.isEmpty() && queue.peek() <= A.get(i)) {
				queue.poll();
			}
			queue.add(A.get(i));
		}
		
		int slideStart = 0;
		ans.add(queue.peek());
		
		while(k<n) {
			if(A.get(slideStart) == queue.peekFirst()) {
				queue.pollFirst();
			}
			while(!queue.isEmpty() && A.get(k) >= queue.peekFirst()) {
				queue.pollFirst();
			}
			queue.add(A.get(k));
				
			slideStart++;
			k++;
			
			ans.add(queue.peek());
		}
		
		System.out.println(queue.peek());
	}
	
}
