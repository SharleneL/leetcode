/*
 * 题意：给一个字符串，把它排列成⬇️↗️⬇️↗⬇️↗这样的写法，然后按行输出
 * 参考：http://www.cnblogs.com/springfor/p/3889414.html
 * 思路：是个数学题。找每行中char下标的规律然后append到string上
 * 要点：1. 如何初始化一个string？ StringBuilder s = new StringBuilder();
 * 			String是immutable的，一旦定义不能改变，但是可以和其他字符串加加减减再赋值；StringBuilder和StringBuffer都是可以改变的，可以append什么的
 * 			输出的时候使用s.toString()方法将StringBuffer转化为String
 * 		2. 如何取出string中的某个char？s.charAt(index); 其中index是从0开始的！
 * 		3. special case!! special case!! special case!!!! 注意返回值是返回空字符串还是null
 * */
public class sep7_easy6 {
	public static void main(String[] args){
		StringBuilder s = new StringBuilder("AB");
		System.out.println(convert(s.toString(), 1));
	}
	
    public static String convert(String s, int numRows) {
    	if(s==null || s.length()<=0)
    		return "";
    	if(s.length()==1 || numRows==1)
    		return s;
    	
    	StringBuilder res = new StringBuilder();	// how to initialize a string
    	int size = 2*numRows-2; 					// 将一个zigzag看作一个单元，每个单元有2n-2个元素
        for(int i=0; i<numRows; i++){		 		// 对于每一行
        	for(int j=i; j<s.length(); j+=size){	// j是遍历⬇️方向上的所有数
        		res.append(s.charAt(j));			// how to pick up a char in string
        		if(i!=0 && i!=numRows-1){			// 第一行和最后一行 中间没有↗️的元素，所以不用额外append
        			if(j+size-2*i<s.length())
        				res.append(s.charAt(j+size-2*i));//这里的数学公式很重要，找到在两个⬇️元素之间↗️元素在原string中的位置。画个图就明白了
        		}
        	}
        }
        return res.toString();
    }
}
