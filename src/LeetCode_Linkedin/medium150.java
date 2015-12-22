package LeetCode_Linkedin;

import java.util.Stack;

/**
 * Created by luoshalin on 12/15/15.
 */
public class medium150 {
    public static void main(String[] args){
        // test goes here
        String[] tokens = {"4", "13", "5", "/", "+"};
        System.out.print(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        int res = 0;
        if(tokens==null || tokens.length==0)                                    // format err
            return res;
        if(tokens.length==1){
            try{
                res = Integer.parseInt(tokens[0]);
            }
            catch (NumberFormatException e){                // format err: the only char is operator
                return 0;
            }
        }

        Stack<Integer> oprdStack = new Stack<Integer>();
        for(String str : tokens){
            int oprd = 0;
            if(str.equals("/")||str.equals("*")||str.equals("+")||str.equals("-")){
                int oprd1 = oprdStack.pop();
                int oprd2 = oprdStack.pop();
                if(str.equals("+")){
                    int curRes = oprd1 + oprd2;
                    oprdStack.push(curRes);
                } else if (str.equals("-")){
                    int curRes = oprd2 - oprd1;
                    oprdStack.push(curRes);
                } else if (str.equals("*")) {
                    int curRes = oprd1 * oprd2;
                    oprdStack.push(curRes);
                } else if (str.equals("/")) {
                    if(oprd1 == 0)
                        return 0;
                    int curRes = oprd2 / oprd1;
                    oprdStack.push(curRes);
                }
            }
            else {
                oprd = Integer.parseInt(str);
                oprdStack.push(oprd);
            }
        }
        res = oprdStack.pop();
        if(!oprdStack.isEmpty())                            // format err
            return 0;
        return res;
    }
}

//# clarification & corner cases
//tokens=null || tokens.size=0 => return ?
//tokens.size=1 => return directly
//invalid expression(not 2 operands) => return ?
//divide => contain decimals?
//divide by zero
//divide & minus => mind order
//
//# thought1
//// use a stack
//create a stack
//for each str in tokens:
//    if operator:
//        pop 2 from stack (if < 2 in stack return EXP)
//        calculate result
//        push result back to stack
//    if operand:
//        push to stack
//end for
//res = stack.pop
//if stack!empty:
//    return EXP
//end if
//return res