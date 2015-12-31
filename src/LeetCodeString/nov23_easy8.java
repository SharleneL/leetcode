package LeetCodeString;

/**
 * Created by luoshalin on 11/23/15.
 */
public class nov23_easy8 {

    public static void main(String[] args){
        // test goes here
//        System.out.println(Integer.parseInt("-0012a42"));
        System.out.println(myAtoi("-0012a42"));
    }

    public static int myAtoi(String str) {

        int res = 0;

        // special cases
        if(str==null || str.length()==0)
            return res;

        // pre process
        str = str.trim().split(" +")[0];
        if(str==null || str.length()==0)
            return res;

        StringBuilder resStr = new StringBuilder("");
        int start = 0;
        if(str.charAt(0)=='-' || str.charAt(0)=='+'){
            start=1;
            if(str.length()==1)
                return res;
        }
        for(int i=start; i<str.length(); i++){
            if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                resStr.append(str.charAt(i));
            }
            else
                break;
        }

        if(resStr.length()==0)
            return res;

        if(str.charAt(0)=='-'){
            resStr.insert(0, '-');
        }
        else if(str.charAt(0)=='+')
            resStr.insert(0, '+');

        try{
            res = Integer.parseInt(resStr.toString());
        } catch(NumberFormatException e){
            if(resStr.charAt(0)=='-')
                return Integer.MIN_VALUE;
            else
                return Integer.MAX_VALUE;
        }
        return res;
    }

}
