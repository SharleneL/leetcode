package LeetCodeString;

/**
 * Created by luoshalin on 12/27/15.
 */
public class medium151 {

    public static void main(String[] args){
        System.out.print(reverseWords(" "));
    }
    public static String reverseWords(String s) {
        if(s==null || s.length()==0)
            return "";

        StringBuilder res = new StringBuilder();
        String arr[] = s.trim().split(" *");
        if(arr.length==0)
            return "";
        for(int i=arr.length-1; i>=0; i--){
            if(arr[i]!="")
                res.append(arr[i]).append(" ");
        }
        return res.deleteCharAt(res.length()-1).toString();
    }
}
