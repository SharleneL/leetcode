package LeetCode_DP;

/**
 * Created by luoshalin on 12/19/15.
 */

//start - 2:04

public class medium91 {
    public static void main(String[] args) {
        // test goes here
        System.out.print(numDecodings("12"));
    }

    public static int numDecodings(String s) {
        if (s.length() == 0 || s == null || s == "0")
            return 0;

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;

        if (isValid(s.substring(0, 1)))
            dp[1] = 1;
        else
            dp[1] = 0;

        for (int i = 2; i <= s.length(); i++) {
            if (isValid(s.substring(i - 1, i)))
                dp[i] += dp[i - 1];
            if (isValid(s.substring(i - 2, i)))
                dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }

    public static boolean isValid(String s) {
        if (s.charAt(0) == '0')
            return false;
        int code = Integer.parseInt(s);
        return code >= 1 && code <= 26;
    }
}


//s: X X X X X
//decode s[i]:
//    1. s[i] => 1 char
//    2. s[i-1]s[i] => 1 char
//
//way[0] = 0
//way[1] = 1
//i: [2, s.len]:
//if s[i-1]s[i] is valid char:
//    way[i] = way[i-1] + way[i-2]
//else
//    way[i] = way[i-1]
//
//return way[s.len]