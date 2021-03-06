public class oct14_83 {

	private static class ListNode{
		int val;
		ListNode next;
		public ListNode(int val){
			this.val = val;
		}
	}
	
	public static void main(String[] args){
		// test goes here
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		ListNode newHead = deleteDuplicates(n1);
		while(newHead!=null){
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
	}
	
	public static ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null)
        	return head;
        
        ListNode cur = head;
        while(cur.next!=null){
        	if(cur.val == cur.next.val){
        		cur.next = cur.next.next;
        	}
        	else{
        		cur = cur.next;
        	}
        }
        return head;
    }
	
	
}
