/*
 * 跪了。。。空list也算palindrome。。。
 * */
public class oc14_234 {

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
		ListNode n4 = new ListNode(1);
		ListNode n5 = new ListNode(1);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
//		n4.next = n5;
		
		System.out.println(isPalindrome(n1));
	}
	
    public static boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
        	return true;        	
        
        // find the mid point of the list
        ListNode tail = head;
        ListNode mid = head;
        ListNode midLeft = mid;
        ListNode midRight = mid;
        while(tail.next!=null){
        	if(tail.next.next!=null){
        		tail = tail.next.next;
        		mid = mid.next;
        	}
        	else
        		break;
        }
        if(tail.next != null){			// if list node total number is even 
        	tail = tail.next;
        	midLeft = mid;
        	midRight = mid.next;
        }
        else{
        	midLeft = mid;
        	midRight = mid;
        }
        
        // reverse the 2nd half of the list
        ListNode cur = midRight;
        if(cur.next!=null){				
        	if(cur.next.next==null)			// 2 elems in the right half
            	cur.next.next = cur;
        	else{							// >=3 elems in the right half
	        	ListNode preCur = cur;
	        	cur = cur.next;
	            ListNode nextCur = cur.next;
	            
	            while(cur.next!=null){
	            	cur.next = preCur;
	            	preCur = cur;
	            	cur = nextCur;
	            	nextCur = nextCur.next;
	            }
	            cur.next = preCur;			// remember to deal with the last elem
        	}
        }
        
        // compare the two halves
        while(head!=midLeft && tail!=midRight){
        	if(head.val != tail.val)
        		return false;
        	head = head.next;
        	tail = tail.next;
        }
        if(head.val == tail.val)
        	return true;
        else
        	return false;
    }
}
