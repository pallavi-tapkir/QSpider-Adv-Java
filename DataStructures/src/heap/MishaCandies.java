package heap;

import java.util.List;
import java.util.PriorityQueue;

public class MishaCandies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solve(List.of(9,818,174,237,892,109,522,27,59,336,605,865,714,86,708,535,138,948,836,287,179,754,466,856,153,53,958,951,262,341,769,491,772,509,336,120,98,805,169,984,520,447,256,266,348,351,60,563,45,638,29,479,400)
				, 852));
	}
	
	public static int solve(List<Integer> A, int B) {
        PriorityQueue<Integer> minHip = new PriorityQueue<Integer>();
        for(int i=0; i<A.size(); i++){
            minHip.add(A.get(i));
        }

        int remainingCandies = 0;
        int ans = 0;

        while (!minHip.isEmpty()) {
            int minBoxCandies = minHip.poll();
            if (minBoxCandies <= B) {
                remainingCandies = (int) Math.floor(minBoxCandies / 2);
                ans = ans + remainingCandies;
            }else {
            	continue;
            }

            if (!minHip.isEmpty()) {
                int nextMinCandies = minHip.poll();
                int newCandies = nextMinCandies + (minBoxCandies - remainingCandies);
                minHip.add(newCandies);
            }
        }
        return ans;
      }

}
