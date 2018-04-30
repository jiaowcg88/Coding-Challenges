package com.company;

import java.util.*;

/**
 * Sort string in a way that the most frequent chacteract come first, then
 * lexicographically
 * input: String type. "bacadeffccc"
 * output: "ccccaabdef"
 */

// thinking process
// // Solution one:
// 1. first count the frequencies of each character, then store in the int array, the index is each chacter's AscII
// the element at the index array is the number of character occuring in the string
// 2. we create another hashmap to store the number of character as key, the chacter as value, since there
// there might be many character having the same frequencies, the hashmap value is a list
// Map<Interger, List<Character>>
// 3. sort the keyset of the map, and sort the list, then we get the answer
public class SortString {

    public static void main(String[] args) {
        String testInput = "bacadeffccc";
        System.out.println(sortString(testInput));
    }

    public static String sortString(String input) {
        int[] counts = new int[26];
        for (char c: input.toCharArray()) {
            counts[c-'a']++;
        }
        Map<Integer, List<Character>> map = new HashMap<>();
        for (char i='a'; i<='z'; i++) {
            int count = counts[i-'a'];
            if (!map.containsKey(count)) {
                map.put(count, new ArrayList<>());
            }
            // add in the order of characters
            map.get(count).add(i);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Integer i: list){
            List<Character> charList = map.get(i);
            for (char c: charList) {
                int count = 0;
                while (count < i){
                    sb.append(c);
                    count++;
                }
            }
        }
        return sb.toString();
    }
}






