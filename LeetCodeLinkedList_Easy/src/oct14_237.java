/*
 * 啊这个题目好神奇
 * 把list中的某个点给你了，对的只给你这个node，让你把它给删了。。。
 * 解法就是，不用prenode！！把给你的这个node赋值成它的next不就得了！！
 * 原来这么简单。。。
 * */
public class oct14_237 {

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
	
    public void deleteNode(ListNode node) {
        if(node == null)
        	return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
	
}
