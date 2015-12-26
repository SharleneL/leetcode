import java.util.HashSet;

/*
 * 求一个数是不是happy number
 * 要点是，如果最后得不到1的话，会陷入一个［循环］，也就是说有相同的平方和。所以存在hashmap里就行
 * 参考：http://www.jiuzhang.com/solutions/happy-number/
 * 
 * */
public class oct14_202 {

	public static void main(String[] args){
		// test goes here
		System.out.println(isHappy(19));
	}
	
	public static boolean isHappy(int n) {
        int num = getNextHappyNum(n);
        HashSet<Integer> set = new HashSet<Integer>();		// hashset初始化
        while(num!=1){
        	if(set.contains(num))							// hashset contains
        		return false;
        	set.add(num);									// hashset add
        	num = getNextHappyNum(num);
        }
        return true;
    }
	
	public static int getNextHappyNum(int n){
		int sum = 0;
		while(n!=0){
			sum += Math.pow(n%10, 2);
			n /= 10;
		}
		return sum;
	}
}
