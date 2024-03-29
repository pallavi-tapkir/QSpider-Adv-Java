package com.pallavi.ds.adv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class CarBuyTimeProfit{
	int buyTime;
	int profit;
	public CarBuyTimeProfit(int buyTime, int profit) {
		this.buyTime = buyTime;
		this.profit = profit;
	}
}

public class MaxProfitMinHeap {

	public static void main(String[] args) {
		System.out.println(solve(List.of(1,7,6,2,8,4,4,6,8,2), List.of(8,11,7,7,10,8,7,5,4,9)));
	}
	
	public static int solve(List<Integer> A, List<Integer> B) {
        int profit = 0;
        int time = 0;
        
        List<CarBuyTimeProfit> list = new ArrayList<CarBuyTimeProfit>(A.size());
        
        for(int i=0; i<A.size(); i++){
        	list.add(new CarBuyTimeProfit(A.get(i), B.get(i)));
        }
        
        Collections.sort(list, new Comparator<CarBuyTimeProfit>() {
        	public int compare(CarBuyTimeProfit c1, CarBuyTimeProfit c2) {
        		return c1.buyTime - c2.buyTime;
        	}
		});
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int i=0; i<list.size(); i++){
            if(time < list.get(i).buyTime){
                minHeap.add(list.get(i).profit);
                time++;
            }else{
                if(list.get(i).profit > minHeap.peek()){
                	minHeap.poll();
                    minHeap.add(list.get(i).profit);
                }
            }
        }

        while(!minHeap.isEmpty()){
            profit = profit+minHeap.poll() % 1000000007;
        }
        return profit;
    }

}
