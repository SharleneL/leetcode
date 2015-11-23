/*
 * while的条件是fast!=null&&fast.next!=null
 * */
public class oct14_141 {

	private static class ListNode{
		int val;
		ListNode next;
		public ListNode(int val){
			this.val = val;
		}
	}
	
	public static void main(String[] args){
		// test goes here
	}
	
	public boolean hasCycle(ListNode head) {
        if(head == null)
        	return false;
        
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
        	fast = fast.next.next;
        	slow = slow.next;
        	if(fast == slow)
        		return true;
        }
        return false;
    }
}
