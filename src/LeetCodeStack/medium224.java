package LeetCodeStack;

import java.util.Stack;

/**
 * Created by luoshalin on 12/20/15.
 */
public class medium224 {
    public static void main(String[] args){
        // test goes here

        System.out.println(calculate(" 2-1 + 2 "));
    }
    public static int calculate(String s) {
        s = "("+s+")";
        // save s into oprtStack & oprdStack
        Stack<Integer> oprdStack = new Stack<Integer>();    // save operands
        Stack<Character> oprtStack = new Stack<Character>();  // save operators

        boolean isNum = false;
        int oprd = 0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch==' ')
                continue;
            if(Character.isDigit(ch)){          // if is a number
                oprd = oprd*10 + ch-'0';
                isNum = true;
            }
            else{                               // if not a number
                if(isNum)
                    oprdStack.push(oprd);
                if(ch==')'){                    // if ')', pop & calculate
                    int tmpRes = 0;
                    if(!oprtStack.isEmpty()){
                        char oprt = oprtStack.pop();
                        while(oprt!='('){
                            int fstOprd = oprdStack.pop();
                            if(oprt=='+')
                                tmpRes += fstOprd;
                            if(oprt=='-')
                                tmpRes -= fstOprd;
                            oprt = oprtStack.pop();
                        }
                        tmpRes += oprdStack.pop();
                    }
                    oprdStack.push(tmpRes);
                }
                else
                    oprtStack.push(ch);
                oprd = 0;
                isNum = false;
            }
        }
        return oprdStack.pop();
    }
}