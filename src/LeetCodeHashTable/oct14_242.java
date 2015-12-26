/*
 * String转化为charArr:
 * str.toCharArray()
 * 
 * charArr按照字母序排序：
 * Arrays.sort(charArr)
 * 
 * charArr转化为String：
 * String.valueOf(charArr) 
 * 
 * String相等：
 * str.equals(str2)
 * 
 * */

import java.util.Arrays;


public class oct14_242 {

	public static void main(String[] args){
		// test goes here
	}
	
	public boolean isAnagram(String s, String t) {
		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();
		
		Arrays.sort(sArr);
		Arrays.sort(tArr);
		
		return String.valueOf(sArr).equals(String.valueOf(tArr));
    }
}
