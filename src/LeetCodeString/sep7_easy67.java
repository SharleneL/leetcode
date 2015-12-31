/*
 * 题意：给两个二进制数的string，以string的形式输出他们的和
 * 参考：http://www.cnblogs.com/springfor/p/3889228.html
 * 思路：先以a,b中较大的长度作为和的长度，如果最后还有进位则在前面+"1"。其余就是普通的维持进位的二进制加法
 * 要点：注意二进制加法怎么实现？？计算carry和当前位的值用除法和取余是很巧妙的方法
 * 		convert int to string: Integer.toString(intX)
 * 		string和string才可以加来加去，string和char不能加来加去只能append
 * */
public class sep7_easy67 {
	public static void main(String[] args){
		String a = new String("11");
		String b = new String("1");
		System.out.println(addBinary(a, b));
	}
	
    public static String addBinary(String a, String b) {
        int carry = 0;
        int aLen = a.length();
        int bLen = b.length();
        int maxLen = Math.max(aLen, bLen);
        String res = "";
        int p, q;
        
        for(int i=0; i<maxLen; i++){
        	// get 2 calculators
        	if(i<aLen)
        		p = a.charAt(aLen-1-i)-'0';
        	else
        		p=0;
        	if(i<bLen)
        		q = b.charAt(bLen-1-i)-'0';
        	else 
        		q=0;
        	// calculate
        	res = Integer.toString((p+q+carry)%2) +res;
        	carry = (p+q+carry)/2;
        }
        // if there is carry for the highest digit, add "1"
        if(carry==1)
        	return("1"+res);
        return res.toString();
    }
}
