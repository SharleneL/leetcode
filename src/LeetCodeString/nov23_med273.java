package LeetCodeString;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by luoshalin on 11/23/15.
 */
public class nov23_med273 {

    public static void main(String[] args){
        // test goes here
        System.out.println(numberToWords(1234567));
    }

    public static String numberToWords(int num) {
        if(num==0)
            return "Zero";

        Stack<String> outputStack = new Stack<>();
        String res = "";

        int inputNum = num;
        int threeDigitCount = 0;
        while(inputNum!=0){
            int threeDigitNum = inputNum % 1000;
            inputNum /= 1000;
            threeDigitNumToWords(threeDigitNum, outputStack, threeDigitCount);
            threeDigitCount++;
        }

        // convert stack to res string
        while(!outputStack.isEmpty()){
            res += outputStack.pop();
        }
        return res.trim();
    }

    public static void threeDigitNumToWords(int num, Stack<String> stack, int count){
        String[] digits = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        String[] ties = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] tens = {"", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] positions = {"Hundred", "Thousand", "Million", "Billion"};

        if(count>0 && num!=0)
            stack.push(positions[count] + " ");

        List<Integer> numList = new ArrayList<>();
        if(num==0)
            return;
        while(num != 0){
            numList.add(num%10);
            num /= 10;
        }

        int len = numList.size();
        if(len >= 2){
            if(numList.get(1)==1){
                stack.push(ties[numList.get(0)] + " ");
            }
            else{
                if(numList.get(0)!=0)
                    stack.push(digits[numList.get(0)-1] + " ");
                if(numList.get(1)!=0)
                    stack.push(tens[numList.get(1)-1] + " ");
            }
        }
        if(len >= 3){
            if(numList.get(2) != 0) {
                stack.push(positions[0] + " ");
                stack.push(digits[numList.get(2)-1] + " ");
            }
        }
        if(len == 1)
            stack.push(digits[numList.get(0)-1] + " ");




    }
}
