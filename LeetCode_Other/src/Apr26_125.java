/*
 * NMD cannot pass. What ghost QAQ
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
