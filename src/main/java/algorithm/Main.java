package algorithm;

import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        System.out.println(sort("sssWWWWadf"));

    }

    private static String sort(String line) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        String[] split = line.split("");
        for (int i = 0; i < split.length; i++) {
            if (map.containsKey(split[i])) {
                int count = map.get(split[i]);
                map.put(split[i], count + 1);
            } else {
                map.put(split[i], 1);
            }
        }
        MapValueComparator mapValueComparator = new MapValueComparator(map);
        Map<String, Integer> sortmap = new TreeMap<String, Integer>(mapValueComparator);
        sortmap.putAll(map);
        StringBuilder builder = new StringBuilder();
        sortmap.forEach((key,val)->{
            for (int i = 0; i < val; i++) {
                builder.append(key);
            }
        });
        return builder.toString();
    }

}

class MapValueComparator<T extends Comparable<T>> implements Comparator<String> {

    private Map<String, T> map = null;


    public MapValueComparator(Map<String, T> map) {
        this.map = map;
    }


    public int compare(String o1, String o2) {
        int r = map.get(o2).compareTo(map.get(o1));
        if (r == 0) {
            r = 1;
        }
        return r;
    }


}