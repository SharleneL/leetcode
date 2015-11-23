import java.util.HashMap;

/*
 * 模式匹配
 * 参考：http://my.oschina.net/Tsybius2014/blog/514983
 * 思路：char<->str 遍历
 * */
public class oct14_290 {
	public static void main(String[] args){
		// test goes here
		System.out.println(wordPattern("abba", "dog cat cat dog"));
	}
	
	public static boolean wordPattern(String pattern, String str) {
        String[] s = str.split(" ");
        if(pattern.isEmpty() || str.isEmpty())
        	return false;
        if(pattern.length() != s.length)
        	return false;
        
        HashMap<Character, String> map = new HashMap<Character, String>();
        for(int i=0; i<pattern.length(); i++){
        	if(map.containsKey(pattern.charAt(i))){
        		if(!map.get(pattern.charAt(i)).equals(s[i]))	// 注意：string之间要用.equals()来比较值
        			return false;
        	}
        	else if(map.containsValue(s[i]))					// 注意这里:如果map里面没有第i个char作为key，却有第i个string作为value，说明不是双向match的，则为false
        		return false;
        	else{
        		map.put(pattern.charAt(i), s[i]);
        	}
        }
        return true;
    }
}
