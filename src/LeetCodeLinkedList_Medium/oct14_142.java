
public class oct14_142 {

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
	
	public ListNode detectCycle(ListNode head) {
		if(head==null)
			return null;
		ListNode fast = head;
		ListNode slow = head;
		ListNode meetNode = null;
		
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			
			if(fast == slow){
				meetNode = fast;
				break;
			}
		}
		if(meetNode==null)			// no cycle
			return null;
		
		while(head!=meetNode){
			head = head.next;
			meetNode = meetNode.next;
		}
		
		return meetNode;
    }
}
