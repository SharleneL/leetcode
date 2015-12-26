import java.util.HashMap;

/*
 * 思路：逐个遍历string中的每一个相同位置的char，map1存<ch1, ch2>， map2存<ch2, ch1>
 * 也就是说ch1->ch2; ch2->ch1两个映射关系
 * 必须要map中相互映射才能是isomorphic
 * */


public class oct14_205 {
	public static void main(String[] args){
		// test goes here
	}
	
	public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
        	return false;
        HashMap<Character, Character> map1 = new HashMap<Character, Character>();
        HashMap<Character, Character> map2 = new HashMap<Character, Character>();
        
        for(int i=0; i<s.length(); i++){
        	char ch1 = s.charAt(i);
        	char ch2 = t.charAt(i);
        	if(map1.containsKey(ch1)){
        		if(map1.get(ch1) != ch2)
        			return false;
        	}
        	if(map2.containsKey(ch2)){
        		if(map2.get(ch2) != ch1)
        			return false;
        	}
        	map1.put(ch1, ch2);
        	map2.put(ch2, ch1);
        }
        
        return true;
    }
}
