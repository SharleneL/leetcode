/*
 * NMD cannot pass. What ghost QAQ
 * s.replace() 和 s.replaceAll()的区别
 * java中 (int)3/2 = 1
 * s.charAt(index)
 * scanner.next()输入的是next token，也就是空格之前的所有；scanner.nextLine()输入的是下一行，包括空格
 * */

import java.util.Scanner;

public class Apr26_125 {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		System.out.println(isPalindrome(s));
	}
	
	public static boolean isPalindrome(String s){
//		if((s==null)||(s.length()==0))
//			return false;
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		System.out.println(s);
		
		if(s.length()<2)
			return false;
		for(int i=0; i<=s.length()/2; i++){
			if(s.charAt(i) != s.charAt(s.length()-1-i))
				return false;
		}
		return true;
	}
}
