package leetcode2;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 示例:
 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 输出:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]

 */
public class Q49 {
    public static void main(String[] args) {
        String[] s= new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(s));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> result = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            // 对此字符串进行排序
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
           if(result.keySet().contains(s)){
               result.get(s).add(str);
           }else{
               List<String> list = new ArrayList<>();
               list.add(str);
               result.put(s, list) ;
           }

        }
        Collection<List<String>> values = result.values();
        return new ArrayList<>(values);
    }


}
