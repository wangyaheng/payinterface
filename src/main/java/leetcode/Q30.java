package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 示例 1：
 输入：
 s = "barfoothefoobarman",
 words = ["foo","bar"]
 输出：[0,9]
 解释：
 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 输出的顺序不重要, [9,0] 也是有效答案。
 "wordgoodgoodgoodbestword"
 ["word","good","best","word"]
 */
public class Q30 {

    public static void main(String[] args) {
       String s = "wordgoodgoodgoodbestword";
       String[] words = {"word","good","best","good"};
        System.out.println(findSubstring(s, words));
    }

    /**
     * 暴力解法
     * @param s
     * @param words
     * @return
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(words.length==0) return result;
        if(s==null||s.length()==0) return result;
        int wordLength = words[0].length();
        int totalLengh = wordLength*words.length;
        if(s.length()<totalLengh) return result;

        Map<String,Integer> wordMap = new HashMap<>();

        for(int i = 0;i<words.length;i++){
            Integer integer = wordMap.get(words[i]);
            if(integer==null){
                wordMap.put(words[i],1 );
            }else{
                wordMap.put(words[i],++integer );
            }

        }

        for(int j = 0;j<=s.length()-totalLengh;j++){
            Map<String,Integer> map = new HashMap<>();
            int num = 0;
           for(int i = 1;i<=words.length;i++){
               String substring = s.substring(j+((i-1) * wordLength), j + (i * wordLength));
               if(!wordMap.containsKey(substring)) break;
               Integer integer = map.get(substring);

               if(integer==null){
                   map.put(substring,1 );
               }else{
                   map.put(substring,++integer );
               }
               if(map.get(substring)>wordMap.get(substring)) break;
               num++;

           }
            if(num==words.length) result.add(j);
        }
        return result;
    }
}
