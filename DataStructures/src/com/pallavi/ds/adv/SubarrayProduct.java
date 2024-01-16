package com.pallavi.ds.adv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubarrayProduct {

	public static void main(String[] args) {
		System.out.println(colorful(23));
		System.out.println(lengthOfLongestSubstring("abcd"));
	}
	
	public static int lengthOfLongestSubstring(String A) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int maxDistance = 0;
        for(int i=0; i<A.length(); i++){
            char currentChar = A.charAt(i);
            if(map.containsKey(currentChar)){
                int prevIndex = map.get(currentChar);
                int currentLength = i - prevIndex + 1;
                maxDistance = Math.max(maxDistance, currentLength);
            }
            map.put(currentChar, i);
        }
        return maxDistance;
    }
	
	public static int colorful(int A) {
        List<Integer> set = new ArrayList<Integer>();
        int no = A;
        while(no > 0){
            int remainder = no % 10;
            if(set.contains(remainder)){
                return 0;
            }else{
                set.add(remainder);
            }
            no = no / 10;
        }
        
        int n = set.size();

        for(int i=0; i<n;i++){
            int product = 1;
            for(int j=i; j<n; j++){
                product = product * set.get(j);
                if(i!=j) {
	                if(set.contains(product)){
	                    return 0;
	                }
	                set.add(product);
                }
            }
        }
        return 1;
    }

}
