/*
 * 卧槽花了我将近三小时的一道题。。。。。。。。。。。要点是string的各种内置函数的应用！注意看要点！
 * 题意：给两个string类型的小数表示版本号，比较这两个小数的大小
 * 参考：http://www.senonweb.com/?p=483
 * 思路1：循环两轮（分别比较小数点前版本数字和小数点后版本数字）：
 * 		#1 pre标记string的第一个char，直到小数点前一位为最后位置post，获取substring，通过Integer.valueOf(str)得到小数点前版本数字，比较大小；
 * 		#2 pre标记小数点后面第一个char为开始的地方，直到最后一位为最后位置post，获取substring，通过Integer.valueOf(str)得到小数点前版本数字，比较大小
 * 要点：1.如何将string转为int？ Integer.valueOf(str);
 * 		2.如何提取substring？ str.substring(startIndex, endIndex); 返回的是[startIndex, endIndex)字符串。注意！！！不包括endIndex!!
 * 		
 * 然而要注意一个问题就是1.1和1.2.3这种怎么比较...感觉思路1太麻烦了所以换成以下更简单的思路2
 * 
 * 思路2:将原string以'.'分隔成一个string构成的数组 然后一个个比较。用到很多java内置的string处理函数，要注意。
 * 参考：http://www.zhuangjingyang.com/leetcode-compare-version-numbers/
 * 要点：1. 如何分隔字符串？ str.split("str/char")
 * 		2. java中的字符串比较：
 * 			1) == 								比较对象，两个对象完全一样才返回true
 * 			2) str1.equals(str2) 				比较string的内容
 * 			3) str1.compareTo(str2) 			按字典序比较，如果str1在前则返回负整数，在后则返回正整数，一样则返回0
 * 			4) str1.compareToIgnoreCase(str2)	按字典序比较，但不考虑大小写。在比较之前已经使用了Character.toLowerCase/.toUpperCase(char)来消除
 * 		4. 如何string->int? Integer.parseInt(str)
 * 		3. 如何把if-else写在一行里？参见compare函数的最后一行多元运算！！
 * */
public class sep7_easy165 {
	public static void main(String[] args){
		String v1 = new String("1.1.000");
		String v2 = new String("1.1");
		System.out.println(compareVersion(v1, v2));
	}
    public static int compareVersion(String version1, String version2) {
    	String[] v1 = version1.split("\\."); // 注意：原string中存储的一定是"\."所以要用"\."来分隔字符串。而.之前要用\，所以这里是\\.
    	String[] v2 = version2.split("\\.");
    	
    	// 从第一个开始挨个比较数组中的元素
    	int i=0; // i写在外面，因为for循环之后可能还要用的！
    	for(; i<v1.length && i<v2.length; i++){
    		if(compare(v1[i], v2[i])<0)  // 这里不能用compareTo，因为compareTo给的结果是01<1
    			return -1;
    		else if(compare(v1[i], v2[i])>0)
    			return 1;
    	}
    	// 接下来是 两个数组长度不一样&&等长部分数组内容都相等 的情况
    	if(i<v1.length){ // v1比较长
    		if(Integer.parseInt(v1[i])!=0) // 排除1.4.0000 == 1.4中数组中有0000的情况
    			return 1;
    	}
    	else if(i<v2.length){ // v2比较长
    		if(Integer.parseInt(v2[i])!=0)
    			return -1;
    	}
    	return 0; // 1.4.0000 == 1.4的情况
    }
    
    public static int compare(String v1, String v2){
    	int m1 = Integer.parseInt(v1);
    	int m2 = Integer.parseInt(v2);
//    	if(m1>m2)
//    		return 1;
//    	else if(m1<m2)
//    		return -1;
//    	else
//    		return 0;
    	return m1>m2?1:m1<m2?-1:0;		// 注意：这个三元运算看起来牛掰死了是吧，一行顶6行——如何把if-else写在一行里
    }
}
