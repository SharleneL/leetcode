//import java.util.LinkedList;
//
///*
// * Java中定义queue可以用链表：LinkedList<Integer> queue1 = new LinkedList<Integer>();
// * 将queue设为private，写在DS的最后
// * */
//
//public class Jul28_225 {
//	LinkedList<Integer> q1 = new LinkedList<Integer>();
//	LinkedList<Integer> q2 = new LinkedList<Integer>();
//
//	// Push element x onto stack.
//    public void push(int x) {
//        if(q1.empty())
//        	q1.push(x);
//        else{
//        	while(!q1.empty()){
//        		q2.push(q1.front());
//        		q1.pop();
//        	}
//        	q1.push(x);
//        }
//    }
//
//    // Removes the element on top of the stack.
//    public void pop() {
//        q1.pop();
//    }
//
//    // Get the top element.
//    public int top() {
//        return q1.front();
//    }
//
//    // Return whether the stack is empty.
//    public boolean empty() {
//        return q1.empty();
//    }
//}
