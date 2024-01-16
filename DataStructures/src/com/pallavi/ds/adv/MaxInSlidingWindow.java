package com.pallavi.ds.adv;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class MaxInSlidingWindow {

	public static int[] slidingMaximum(final int[] A, int B) {
		List<Integer> ans = new ArrayList<Integer>();
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		for(int i=0; i<B; i++) {
			while(!queue.isEmpty() && A[i] > A[queue.getLast()]) {
				queue.removeLast();
			}
			queue.addLast(A[i]);
		}
		
        ans.add(A[queue.getFirst()]);
        int j=B;
        int window =1; //1 since we are now considering the window from 1 to B
        while(j<A.length){
            while(!queue.isEmpty() && A[j]>A[queue.getLast()]){
                queue.removeLast();
            }
            queue.addLast(j);
            if(window>queue.getFirst()){
                queue.removeFirst();
            }
            ans.add(A[queue.getFirst()]);

            j++;
            window++;
        }

        int[] arr = new int[ans.size()];
        for(int k=0;k<ans.size();k++){
            arr[k] = ans.get(k);
        }
        return arr;
    }
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,7,4,8};
		int[] ans = slidingMaximum(arr,2);
		
		for(int i=0; i<ans.length; i++) {
			System.out.println(ans[i]+" ");
		}
	}

}
