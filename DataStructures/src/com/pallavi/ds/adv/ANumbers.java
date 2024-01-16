package com.pallavi.ds.adv;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ANumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//solve(11);
//		solve("abab"); //aab#
//		System.out.println("123");
		int[] A = {2, 5, -1, 7, -3, -1, -2};
		System.out.println(solve(A, 4));
	}
	
	public static int solve(int[] A, int B) {
        long sum=slidingMaxMinSum(A,B);
       return (int)(((sum)%1000000007)+1000000007)%1000000007;
   }
   public static long slidingMaxMinSum(final int[] A, int B) {
       Deque<Integer> dqueMax= new LinkedList<Integer>();
       Deque<Integer> dqueMin= new LinkedList<Integer>();
       int n=A.length;
       long ans=0;        
       for(int i=0;i<B;i++){
          while(!dqueMax.isEmpty() && A[i]>=A[dqueMax.peekLast()]){
              dqueMax.pollLast();
          }
          dqueMax.addLast(i);
           while(!dqueMin.isEmpty() && A[i]<=A[dqueMin.peekLast()]){
              dqueMin.pollLast();
          }
          dqueMin.addLast(i);
       }
       ans=A[dqueMax.peekFirst()]+A[dqueMin.peekFirst()];
       int l=1;
       int r=B;
       while(r<n){
           if(l-1==dqueMax.peekFirst()){
               dqueMax.pollFirst();
           }
           while(!dqueMax.isEmpty() && A[r]>=A[dqueMax.peekLast()]){
              dqueMax.pollLast();
           }
          dqueMax.addLast(r);
          if(l-1==dqueMin.peekFirst()){
               dqueMin.pollFirst();
           }
           while(!dqueMin.isEmpty() && A[r]<=A[dqueMin.peekLast()]){
              dqueMin.pollLast();
           }
          dqueMin.addLast(r);
          ans=(ans+A[dqueMax.peekFirst()]+A[dqueMin.peekFirst()]);
          l++;
          r++;
       }
       return ans;        
   }
	
	public static String solve(String A) {
        int[] freqArr = new int[26];
        Queue<Character> q = new LinkedList<Character>();

        StringBuilder ans = new StringBuilder();

        for(int i=0; i<A.length(); i++){
            char ch = A.charAt(i);
            freqArr[ch - 'a']++;
            q.add(ch);

            while(!q.isEmpty() && freqArr[q.peek()-'a'] >= 2){
                q.poll();
            } 
            if(q.isEmpty()){
                ans.append("#");
            }else{
                ans.append(q.peek());
            }

        }
        return ans.toString();
    }
	
	public static int[] solve(int A) {
        int max = 29500;
        int[] ans = new int[A];
        Queue<String> q = new LinkedList<String>();
        if(A > 0)   ans[0] = 1;
        if(A > 1)   ans[1] = 2;
        if(A > 2)   ans[2] = 3;
        if(A <= 3) return ans;
        
        q.add("1");
        q.add("2");
        q.add("3");
        int count = 2;

        

        while(count < A-1){
            String temp = q.poll();
            q.add(temp + "1");
            count++; 
            if(count > A-1){ 
                break;
            }
            ans[count] = Integer.parseInt(temp + "1");

            q.add(temp + "2"); 
            count++;
            if(count > A-1){ 
                break;
            }
            ans[count] = Integer.parseInt(temp + "2");
            q.add(temp + "3");
            count++;
            if(count > A-1){ 
                break;
            }
            ans[count] = Integer.parseInt(temp + "3");
        }
        return ans;
    }

}
