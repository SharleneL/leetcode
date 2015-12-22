//import java.util.HashMap;
//import java.util.HashSet;
//
//
//
//public class LinkedListPlayGround {
//	/*********************************/
//	private static class Node{
//		int val;
//		Node next;
//
//		public Node(int val){
//			this.val = val;
//		}
//	}
//	/*********************************/
//
//	public static void main(String[] args){
//		// test goes here
//	}
//
//	public static int getListLength(Node head){
//		int len = 0;
//		Node cur = head;
//		while(cur!=null){
//			len++;
//			cur = cur.next;
//		}
//		return len;
//	}
//
//	public static Node reverseList(Node head){
//		if(head==null)
//			return null;
//
//		// if only one node
//		if(head.next==null)
//			return head;
//		// if >= 2 nodes
//		Node last = null;
//		Node cur = head;
//		Node next = cur.next;
//		while(next!=null){
//			// reverse cur & last
//			cur.next = last;
//			last = cur;
//			cur = next;
//			next = cur.next;
//		}
//		// next == null
//		cur.next = last;
//		return cur;
//	}
//
//	public static Node getKthNode(Node head, int k){
//		if(head==null || k==0)
//			return null;
//
//		Node fast = head;
//		Node slow = head;
//		for(int i=0; i<k-1&&fast!=null; i++)
//			fast = fast.next;
//		while(fast.next!=null){
//			fast = fast.next;
//			slow = slow.next;
//		}
//		return slow;
//	}
//
//	public static Node mergeList(Node head1, Node head2){
//		if(head1==null)
//			return head2;
//		else if(head2==null)
//			return head1;
//
//		Node p1 = head1;
//		Node p2 = head2;
//		Node head = new Node(0);
//		if(p1.val<=p2.val)
//			head = p1;
//		else
//			head = p2;
//		while(p1!=null && p2!=null){
//			if(p1.val<=p2.val){
//				Node tmp = p1;
//				p1 = p1.next;
//				tmp.next = p2;
//				p2 = p2.next;
//			}
//			else{
//				Node tmp = p2;
//				p2 = p2.next;
//				tmp.next = p1;
//				p1 = p1.next;
//			}
//		}
//
//	}
//
//}
