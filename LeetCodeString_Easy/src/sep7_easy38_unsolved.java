/*
 * sep7-nnd调不通了！！！！气死了 line19开始的循环条件什么的有问题
 * String API 函数总结： http://www.runoob.com/java/java-string.html
 * 题意：给一种奇葩的sequence规定，这玩意儿叫count and say。把sequence里面当前的元素读出来，就生成了后面的元素。求第n个元素（string类型）是啥。
 * 要点：1.因为只需要第n个值，所以前面n-1个都不用的，因此只要维护两个string就可以了。
 * 		2. String数组必须在定义的时候指定长度，如果想要不定长数组，得用ArrayList
 * 		3. String拷贝的时候直接str1=str2就行了
 * 		4. 如何对StringBuilder进行清空？ str.delete(int start, int end); 包含start不包含end！
 * */
public class sep7_easy38_unsolved {
	public static void main(String[] args){
		System.out.println(countAndSay(3));
	}
    public static String countAndSay(int n) {
        String curRes = new String("1");
        StringBuilder res = new StringBuilder();
        int count = 1;
        while(count<n){ // find the n-th result
        	int duplicate=1;
        	if(curRes.length()==1){
        		res.append("1"+curRes.charAt(0));
        	}
        	else{
        		for(int i=1; i<curRes.length(); i++){ // get the next res
        			if(curRes.charAt(i)==curRes.charAt(i-1))
        				duplicate++;
        			else{
        				res.append(Integer.toString(duplicate) + curRes.charAt(i-1));
        				duplicate=1;
        			}
        		}
        	}
//        	res.append(Integer.toString(duplicate) + curRes.charAt(curRes.length()-1));
        	curRes = res.toString();
        	res.delete(0, res.length());
        	count++;
        }
        return curRes;
    }
}
