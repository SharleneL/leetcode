import java.util.Scanner;

public class Apr27_204 {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		System.out.println(countPrimes(input));
	}
	
	public static int countPrimes(int n) {
		if(n<=2)
			return 0;
		
		boolean[] primes = new boolean[n];
		for(int i=2; i<n; i++)
			primes[i] = true;
		for(int j=2; j<=Math.sqrt(n-1); j++){
			for(int k=j+j; k<n; k+=j){
				primes[k] = false;
			}
		}
		int count = 0;
		for(int m=2; m<n; m++){
			if(primes[m])
				count++;
		}
		return count;
	}
}
