import java.util.ArrayList;
import java.util.Scanner;

public class Apr26_119 {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int rows = scan.nextInt();
		System.out.println(getRow(rows));
	}
	
    public static ArrayList<Integer> getRow(int rowIndex) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	if (rowIndex<=0)
    		return res;
    	
    	res.add(1);
    	for(int i=1; i<=rowIndex; i++){
    		for(int j=res.size()-2; j>=0; j--){
    			res.set(j+1,res.get(j)+res.get(j+1));  
    		}
    		res.add(1);
    	}
    	
    	return res;
    }
}	