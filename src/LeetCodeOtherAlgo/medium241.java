package LeetCodeOtherAlgo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luoshalin on 12/30/15.
 */

// 参考:http://www.chenguanghe.com/different-ways-to-add-parentheses-%E5%AF%B9%E8%A1%A8%E8%BE%BE%E5%BC%8F%E6%B7%BB%E5%8A%A0%E6%8B%AC%E5%8F%B7%E8%83%BD%E6%9C%89%E5%87%A0%E7%A7%8D%E4%B8%8D%E5%90%8C%E7%AD%94%E6%A1%88/

public class medium241 {
    public List<Integer> diffWaysToCompute(String input) {

        List<Integer> res = new ArrayList<Integer>();
        if(input==null || input.length()==0)
            return res;

        boolean onlyOprd = true;
        String oprt = "+-*";
        for(int i=0; i<input.length(); i++){
            if(oprt.contains(""+input.charAt(i))){
                onlyOprd = false;
                List<Integer> leftRes = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightRes = diffWaysToCompute(input.substring(i+1));
                for(int left : leftRes){
                    for(int right : rightRes){
                        int newRes = 0;
                        if(input.charAt(i)=='+')
                            newRes = left+right;
                        else if(input.charAt(i)=='-')
                            newRes = left-right;
                        else if(input.charAt(i)=='*')
                            newRes = left*right;
                        res.add(newRes);
                    }
                }
            }
            if(onlyOprd)
                res.add(Integer.parseInt(input));
        }
        return res;
    }
}
