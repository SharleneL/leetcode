
public class oct14_206 {
	
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
		n1.next = n2;
		
		ListNode reHead = reverseList(n1);
		while(reHead != null){
			System.out.println(reHead.val);
			reHead = reHead.next;
		}
		
	}
	
	public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
        	return head;
        
        ListNode preCur = null;
        ListNode cur = head;
        ListNode nextCur = head.next;
        while(nextCur != null){
        	cur.next = preCur;
        	preCur = cur;
        	cur = nextCur;
        	nextCur = nextCur.next;
        }
        cur.next = preCur;
        return cur;
	}
}
