/*
 * s.legth() -> 从后向前遍历
 * 判断s.charAt(i)是否为空格，同时维持count++
 * 注意charAt(0)是string中第一个char
 * 
 * scanner输入string时：String input = scan.nextLine()
 * 
 * ？为什么一定要在for循环之后再来一次return
 * */

import java.util.Scanner;


public class Jul28_58 {

	//input 
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		System.out.println(lengthOfLastWord(input));
	}
	
    public static int lengthOfLastWord(String s) {
        int len = s.length();
        int count = 0;
        if(s==null || len==0)
        	return 0;
        for(int i=len-1; i>=0; i--){
        	if(s.charAt(i) != ' '){
        		count++;
        	}
        	if((s.charAt(i) == ' ') && count!=0) // 必须加上count不为零，排除最后一个字符是空的情况
        		return count;
        }
        return count;
    }
}
