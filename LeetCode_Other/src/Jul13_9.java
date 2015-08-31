import java.util.Scanner;


public class Jul13_9 {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		System.out.println(isPalindrome(input));
	}
	public static boolean isPalindrome(int x) {
	    if(x<0)
	    	return false;
	    // get int length
	    int len = 1;
	    while(x/len>=10)
	    	len = len*10;
	    // compare head and tail
	    while(x!=0){ //2 digit-number
	    	int tail = x % 10;
		    int head = x / len;
		    if(tail != head)
		    	return false;
		    x = (x%len)/10;
		    len/=100;
	    }
	    return true;
	}
}
