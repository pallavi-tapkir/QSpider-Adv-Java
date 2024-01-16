package heap;

import java.util.List;
import java.util.PriorityQueue;


class ListNode {
     public int val;
     public ListNode next;
	 ListNode(int x) { val = x; next = null; }
}

public class MinHeapLinkedListSorting {

	public static void main(String[] args) {
		ListNode h1 = new ListNode(5);
		ListNode h2 = new ListNode(1);
		
		ListNode result = solve(List.of(h1, h2));
		ListNode tempListNode = result;
		while (tempListNode != null) {
			System.out.println(tempListNode.val);
			tempListNode = tempListNode.next;
			
		}
	}
	
	public static ListNode solve(List<ListNode> list) {
		ListNode dummy = new ListNode(-1);
		PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(
				(l1, l2) -> l1.val - l2.val
			
		);
		
		for(int i=0; i < list.size(); i++) {
			ListNode currentNode = list.get(i);
			while(currentNode != null) {
				minHeap.add(currentNode);
				currentNode = currentNode.next;
			}
		}
		
		ListNode temp = null;
		while(!minHeap.isEmpty()) {
			ListNode current = minHeap.poll();
			if(dummy.next == null) {
				dummy.next = current;
			}else if(temp!= null){
				temp.next = current;
			}
			
			temp = current;
			
		}
		
		
		return dummy.next;
	}

}
