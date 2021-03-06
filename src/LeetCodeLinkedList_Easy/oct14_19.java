/*
 * 快慢指针：注意快的是前进n-1步不是n步！！
 * 注意特例： 1. head为null 2.list长度比n小 3.删除头的情况！！！
 * */
public class oct14_19 {
	private static class ListNode{
		int val;
		ListNode next;
		
		private ListNode(int val){
			this.val = val;
		}
	}
	
	public static void main(String[] args){
		// test goes here
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);

		n1.next = null;
//		n1.next = n2;
//		n2.next = n3;
//		n3.next = n4;
		
		ListNode head = removeNthFromEnd(n1, 1);
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
		
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
        	return null;
        ListNode fast = head;
        ListNode slow = head;
        ListNode preSlow = null;
        
        // move fast node to the nth position
        for(int i=0; i<n-1; i++){
        	fast = fast.next;
        	if(fast == null)			// if the length of list < n
        		return null;
        }
        
        while(fast.next != null){		// find the node to delete: slow
        	fast = fast.next;
        	preSlow = slow;
        	slow = slow.next;
        }
        
        if(preSlow == null)	{			// if we delete the head
        	head = head.next;
        	return head;
        }
        else{							// if the node to be deleted is not the head
            preSlow.next = slow.next;
            return head;
        }
    }
}
