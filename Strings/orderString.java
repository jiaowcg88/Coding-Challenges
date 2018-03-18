
/* Sort String in a way that the most frequent character come first, then lexicographically.
*
*/

/*  thinking process 

* step1 :
           have a hashMap to store the each character as a key, and its frequencies of character in this string as a value;
* step 2:
           have a list array, called bucket which to map all the same frequencies of character in the same bucket.
* : when we add to the char to list, we should keep the same order as the original.
* here we can use a boolean array to avoid the same character which is visited before.
* step 3:
* go to print the string
* starting from the most frequencies of character to the least frequencies of character.
* if there are same frequencies

import java.util.*;

public class Solution {
    public static String frequencySort(String s) {
        Map<Character, Integer> map = new TreeMap<>();
        char[] ca = s.toCharArray();
        for (char c : ca){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        List<Character> [] bucket = new List[s.length()+1];
        for (char c : map.keySet()) {
            int frequency = map.get(c);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(c);
        }
        StringBuilder sb = new StringBuilder();
        for(int pos = bucket.length - 1; pos>= 0; pos-- ){
            if(bucket[pos] != null){
                for (char num : bucket[pos]){
                    for (int i = 0; i<map.get(num); i++){
                        sb.append(num);
                    }
                }
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	String input = "aaaccccdddeeeeabe";
    	System.out.println(frequencySort(input));

    }
}

