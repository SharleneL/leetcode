/*
 * Sort a linked list using insertion sort
 * */
public class oct14_147_undone {

	public static class ListNode{
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
		ListNode n3 = new ListNode(5);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		ListNode head = insertionSortList(n1);
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
	}
	
	public static ListNode insertionSortList(ListNode head) {
		if(head==null || head.next==null)
			return head;
		ListNode elem = head.next;	// the elem to be inserted
		while(elem!=null){		// insert one elem in one round; stop when all elems are inserted
			if(head.val > elem.val){		// if the elem should be inserted as the head
				ListNode tmp = head;
				head = elem;
				head.next = tmp;
				continue;
			}
			
			ListNode cur = head;			// if the elem should be inserted after the heads
			while(cur!=elem){
				if(cur.val<elem.val && cur.next.val>=elem.val){
					if(cur.next == elem){
						elem = elem.next;
						break;
					}
					ListNode tmp = elem;
					elem = elem.next;
					tmp.next = cur.next;
					cur.next = tmp;
					break;
				}
				cur = cur.next;
			}
		}
		return head;
    }
}
