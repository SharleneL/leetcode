package LeetCodeHashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by luoshalin on 12/24/15.
 */
public class easy299 {
    public static void main(String[] args){
        // test goes here
    }

    public String getHint(String secret, String guess) {
        if(secret==null || guess==null)
            return "0A0B";

        int bulls = 0;
        int cows = 0;
        int len = secret.length();
        HashMap<Character, Integer> secretMap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> guessMap = new HashMap<Character, Integer>();
        for(int i=0; i<len; i++){
            // update bull value
            if(secret.charAt(i) == guess.charAt(i))
                bulls++;
            // update secretMap
            if(secretMap.containsKey(secret.charAt(i)))
                secretMap.put(secret.charAt(i), secretMap.get(secret.charAt(i))+1);
            else
                secretMap.put(secret.charAt(i), 1);
            // update guessMap
            if(guessMap.containsKey(guess.charAt(i)))
                guessMap.put(guess.charAt(i), guessMap.get(guess.charAt(i))+1);
            else
                guessMap.put(guess.charAt(i), 1);
        }
        // got bull value; calculate cow value
        for(Map.Entry<Character, Integer> entry : guessMap.entrySet()){
            char key = entry.getKey();
            if(secretMap.containsKey(key)){
                cows += Math.min(secretMap.get(key), guessMap.get(key));
            }
        }
        cows -= bulls;
        return bulls + "A" + cows + "B";
    }
}

// bulls: same ch; same pos
// cows: same ch; diff pos
//find bull:
//    for each ch in secret & guess: compare
//find cow:
//    save ch & appear times to hashmap
//    iterate over the map
//    for each key in guessmap: if exists in secret map, add up the min
//    subtract by the number of bulls
