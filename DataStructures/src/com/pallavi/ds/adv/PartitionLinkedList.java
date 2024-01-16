package com.pallavi.ds.adv;

import java.util.LinkedList;
import java.util.List;

class ListNode {
	 public int val;
	 public ListNode next;
	 
	 ListNode(int x) 
	 { 
		 val = x; 
		 next = null; 
	 }
}

public class PartitionLinkedList {
	 
	 public static ListNode partition(ListNode A, int B) {
	        ListNode curr=A;
	        ListNode ans=null;
	        ListNode ansCurr=null;
	        ListNode listGrEqB=null;
	        ListNode listGrEqBCurr=null;
	        while(curr!=null){
	            if(curr.val<B){
	                if(ans==null){
	                    ans=curr;    
	                    ansCurr=curr;              
	                } else {
	                    ansCurr.next=curr;
	                    ansCurr=curr;                                        
	                }                              
	            } else {
	                 if(listGrEqB==null){
	                    listGrEqB=curr;    
	                    listGrEqBCurr=curr;          
	                } else {
	                    listGrEqBCurr.next=curr;
	                    listGrEqBCurr=curr;                                        
	                }    
	            }
	            curr=curr.next;
	        }
	        if(ans==null){
	            return A;
	        }
	        if(listGrEqBCurr!=null){
	        listGrEqBCurr.next=null;
	        }
	        ansCurr.next=listGrEqB;      
	        return ans;
	}
	 
	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		ListNode n1 = new ListNode(4);
		root.next = n1;
		ListNode n2 = new ListNode(3);
		n1.next = n2;
		ListNode n3 = new ListNode(2);
		n2.next = n3;
		ListNode n4 = new ListNode(5);
		n3.next = n4;
		ListNode n5 = new ListNode(2);
		n4.next = n5;
		
		root = partition(root, 3);
		
		ListNode temp = root;
		while(temp!=null) {
			System.out.print(temp.val + " "); 
			temp = temp.next;
		}

	}

}
