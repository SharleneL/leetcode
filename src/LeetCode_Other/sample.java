import java.util.Scanner;


public class sample {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		// String input = scan.nextLine();
		System.out.println(func(input));
	}
	
	public static int func(int in){
		int i = in/2;
		return i;
	}
}
