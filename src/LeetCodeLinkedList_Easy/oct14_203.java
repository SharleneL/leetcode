/*
 * 删除list中某个值的元素
 * 注意：考虑特殊情况：如果head需要被删除 怎么办？要先找到新的head！如果整个list都被删掉怎么办？
 * */
public class oct14_203 {

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
	
	public ListNode removeElements(ListNode head, int val) {
		if(head==null)
			return null;
		
		while(head!=null && head.val == val){		// delete all the elem == val at the list head & get the new head		
			head = head.next;
		}
		if(head == null)
			return null;
		ListNode cur = head;
		while(cur!=null && cur.next!=null){
			if(cur.next.val==val)
				cur.next = cur.next.next;
			else
				cur = cur.next;
		}
		return head;
    }
}
