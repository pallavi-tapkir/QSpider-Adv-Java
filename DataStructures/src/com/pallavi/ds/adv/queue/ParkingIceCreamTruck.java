package com.pallavi.ds.adv.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ParkingIceCreamTruck {

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int windowSize = 3;
		int k=windowSize;
		
		int[] AA = {1, 3, -1, -3, 5, 3, 6, 7};
		
		A.add(1);
		A.add(3);
		A.add(-1);
		A.add(-3);
		A.add(5);
		A.add(3);
		A.add(6);
		A.add(7);
		slidingMaximum(AA, windowSize);
	}

	public static int[] slidingMaximum(final int[] A, int B) {
        List<Integer> ans = new ArrayList<>();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<B;i++){
            while(!queue.isEmpty() && A[i]>A[queue.getLast()]){
                queue.removeLast();
            }
            queue.addLast(i);
        }
        ans.add(A[queue.getFirst()]);
        int i=0;
        int j=B;
        int window =1; 
        while(j<A.length){
            while(!queue.isEmpty() && A[j]>A[queue.getLast()]){
                queue.removeLast();
            }
            queue.addLast(j);
            if(window>queue.getFirst()){
                queue.removeFirst();
            }
            ans.add(A[queue.getFirst()]);
            i++;
            j++;
            window++;
        }

        int[] arr = new int[ans.size()];
        for(int k=0;k<ans.size();k++){
            arr[k] = ans.get(k);
        }
        return arr;
    }
}
