package LeetCodeStack;

import java.util.Stack;

/**
 * Created by luoshalin on 12/20/15.
 */
public class easy155 {
    public static void main(String[] args){
        // test goes here
    }

    class MinStack {
        private Stack<Integer> stack = new Stack<Integer>();
        private Stack<Integer> minStack = new Stack<Integer>();

        public void push(int x) {
            stack.push(x);
            if(minStack.peek().equals(stack.peek()))    // DO NOT USE "==" HERE - stack contains Integer Obj, not int value
                minStack.push(x);
        }

        public void pop() {
            if(minStack.peek()==stack.peek())
                minStack.pop();
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
