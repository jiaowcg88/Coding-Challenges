
import java.util.HashMap;
import java.util.Map;
import java.util.*;

class Pair {
    String name;
    long timestamp;
    public Pair(String name, long timestamp) {
        this.name = name;
        this.timestamp = timestamp;
    }
}

public class Solution {
    public static String getHighest(List<Pair>list, long time) {
        if (time == 0) return null;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i<list.size(); i++) {
            Pair p = list.get(i);
            if (p.timestamp <= time) {
                map.put(p.name, map.getOrDefault(p.name,0) + 1);
            }
        }

        // traversal the map to see the maximum of value
        int max = 0;
        String result ="";
        for (String key : map.keySet()) {
            if (map.get(key) >= max) {
                max = map.get(key);
                result = key;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Pair p1 = new Pair("a", 100);
        Pair p2 = new Pair("b", 150);
        Pair p3 = new Pair("b", 200);
        List<Pair> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        String result = getHighest(list, 200);
        System.out.println(result);
    }
}
