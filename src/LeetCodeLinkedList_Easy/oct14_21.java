/*
 * 开始没看懂题啊
 * 意思是两个sorted list，merge之后还是sorted list
 * 注意末尾情况！其中一个遍历完的时候，新list的尾巴一定指向遍历完的这个list的尾巴元素
 * */
public class oct14_21 {
	private static class ListNode{
		int val;
		ListNode next;
		public ListNode(int val){
			this.val = val;
		}
	}
	
	public static void main(String[] args){
		// test goes here
		ListNode p1 = new ListNode(1);
		ListNode p2 = new ListNode(3);
		ListNode p3 = new ListNode(5);
		ListNode q1 = new ListNode(2);
		ListNode q2 = new ListNode(4);
		
		p1.next = p2;
		p2.next = p3;
		q1.next = q2;
		
		ListNode newList = mergeTwoLists(p1, q1);
		while(newList!=null){
			System.out.println(newList.val);
			newList=newList.next;
		}
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null || l2==null){				// special case
			if(l1==null && l2==null)
				return null;
			if(l1==null)
				return l2;
			else
				return l1;
		}
		
		ListNode cur1 = l1;
		ListNode cur2 = l2;
		ListNode newHead = new ListNode(0);			// newHead要在if外面初始化！！不知为什么在if里面创建newHead的话会报错。。？大概是因为在if里面创建的话只能在if里面用。。？
		ListNode newCur = new ListNode(0);
		
		if(cur1.val < cur2.val){					// set the first val of the new list
			newHead = cur1;
			cur1 = cur1.next;
		}
		else{
			newHead = cur2;
			cur2 = cur2.next;
		}
		newCur = newHead;
		
		while(cur1!=null && cur2!=null){			// 其中一个遍历完的时候，新list的尾巴一定指向遍历完的这个list的尾巴元素
			if(cur1.val < cur2.val){
				newCur.next = cur1;
				newCur = newCur.next;
				cur1 = cur1.next;
			}
			else{
				newCur.next = cur2;
				newCur = newCur.next;
				cur2 = cur2.next;
			}
		}
		if(cur1==null)
			newCur.next = cur2;
		else
			newCur.next = cur1;
		return newHead;
    }
}
