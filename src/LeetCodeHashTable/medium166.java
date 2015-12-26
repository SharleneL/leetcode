package LeetCodeHashTable;

import java.util.HashMap;

/**
 * Created by luoshalin on 12/25/15.
 */
public class medium166 {
    public static void main(String[] args){
        // test goes here
        System.out.print(fractionToDecimal(-2147483648, -1));
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        long numerat = (long)numerator;
        long denominat = (long)denominator;
        if(denominat==0)
            return "0";
        if(numerator%denominat==0)
            return String.valueOf(numerat/denominat);

        boolean minus = false;
        if((long)numerator*(long)denominator<0){
            minus = true;
            numerat = Math.abs(numerat);
            denominat = Math.abs(denominat);
        }

        StringBuilder res = new StringBuilder();
        // if cannot be exactly divided
        StringBuilder numerical = new StringBuilder();      // save the numerical part of the result
        // get the integer part
        long quodient = numerat/denominat;
        long remainder = numerat%denominat;
        res.append(quodient).append(".");

        // get the numerical part
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();    // save value - index
        int startIndex = -1;
        int endIndex = -1;
        int i = 0;  // index
        while(true){
            if(remainder==0){
                break;
            }
            if(map.containsKey(remainder)){
                startIndex = map.get(remainder);
                endIndex = i-1;
                break;
            }else{
                map.put(remainder, i);
            }
            quodient = remainder*10 / denominat;
            numerical.append(quodient);
            remainder = remainder*10 % denominat;
            i++;
        }
        if(startIndex==-1){
            res.append(numerical);
        }
        else{
            res.append(numerical.substring(0, startIndex))
                .append("(")
                .append(numerical.substring(startIndex))
                .append(")");
        }
        if(minus)
            res.insert(0, '-');
        return res.toString();
    }
}

// equals to find the repeating parts in a string
//eg: 20 / 7
//    /   %
//20  2   6   2
//6   0   6   .
//
//60  8   4   8
//40  5   5   5
//50  7   1   7
//10  1   3   1
//30  4   2   4
//20  2   6   2
//60  8   4   8 [4 - find a repeat]