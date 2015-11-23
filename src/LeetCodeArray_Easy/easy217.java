/*08-07-2015
 *HashSet的使用 
 * */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.swing.text.html.HTMLDocument.Iterator;

public class easy217 {
	public boolean containsDuplicate(int[] nums) {
        HashSet set = new HashSet();
        for(int i: nums){
        	if(!set.add(i)){// duplicate
        		return true;
        	} 
        }
        return false;
    }
}

