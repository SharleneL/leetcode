package LeetCodeStack;

import java.util.LinkedList;

/**
 * Created by luoshalin on 12/20/15.
 */
public class easy225 {
    public static void main(String[] args){
        // test goes here
    }

    class MyStack {
        private LinkedList<Integer> q = new LinkedList<Integer>();
        // Push element x onto stack.
        public void push(int x) {
            q.add(x);
            int size = q.size();
            if(size > 1){
                // iterate size-1 times
                for(int i=0; i<size-1; i++){
                    q.add(q.poll());
                }
            }
        }

        // Removes the element on top of the stack.
        public void pop() {
            q.pop();
        }

        // Get the top element.
        public int top() {
            return q.peek();
        }

        // Return whether the stack is empty.
        public boolean empty() {
            return q.size()==0;
        }
    }
}
