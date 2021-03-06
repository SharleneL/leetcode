
public class oct14_160 {

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
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA==null || headB==null)
			return null;
		
		int lenA = 0;
		int lenB = 0;
		ListNode curA = headA;
		ListNode curB = headB;
		while(curA != null){
			curA = curA.next;
			lenA++;
		}
		while(curB != null){
			curB = curB.next;
			lenB++;
		}
		
		curA = headA;
		curB = headB;
		if(lenA > lenB){
			int i = 0;
			while(i<(lenA-lenB)){
				curA = curA.next;
				i++;
			}
		}
		if(lenA < lenB){
			int i = 0;
			while(i<(lenB-lenA)){
				curB = curB.next;
				i++;
			}
		}
		
		while(curA!=null){
			if(curA == curB)
				return curA;
			else{
				curA = curA.next;
				curB = curB.next;
			}
		}
		return null;
		
    }
}
