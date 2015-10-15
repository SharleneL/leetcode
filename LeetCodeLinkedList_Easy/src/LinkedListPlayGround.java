

public class LinkedListPlayGround {

	private static class Node{
		int value;
		Node next;
		
		public Node(int value){
			this.value = value;
		}
	}
	
	public static void main(String[] args){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		n1.next = n2;
		n2.next = n3;
		
//		test goes here
	}

	// 1. get LL length
	public static int getListLength(Node head){
		if(head == null)
			return 0;
		
		int len = 1;
		Node cur = head;
		while(cur.next != null){
			cur = cur.next;
			len++;
		}
		
		return len;
	}
	
	// 2. reverse LL
	public static Node reverseList(Node head){
		if(head==null || head.next==null)
			return head;
		
		Node cur = null;		// start from null!! not from head!! think about the last elem
		Node next1 = head;
		Node next2 = head.next;	// keep
		while(next2!=null){
			next1.next = cur;
			cur = next1;
			next1 = next2;
			next2 = next1.next;
		}
		return next1;
	}

	// 2. reverse LL rec
	public static Node reverseListRec(Node head){
		if(head==null || head.next==null)
			return head;
		
		
	}
	
}
