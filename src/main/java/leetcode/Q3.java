package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: "abcabcbb"
   输出: 3
   解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Q3 {
    public static void main(String[] args) {

        int abcabcbb = lengthOfLongestSubstring("dvdfda");

        System.out.println(abcabcbb);
    }

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int i=0,j=0,ans=0;
        while(i<n&&j<n){

            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, set.size());
            }else{
                set.remove(s.charAt(i++));
            }
        }


        return ans;
    }




    public static int lengthOfLongestSubstring1(String s) {
        if(s.length()==0) return 0;
        int count = 0;
       List<Character> chars = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!chars.contains(c)){
                chars.add(c);
            }else{
                if(chars.size()>count)count = chars.size();
                chars.remove(c);
                chars.add(c);
            }
        }
        //Optional<Integer> max = countList.stream().max((a, b) -> a - b);
        if(chars.size()>count)count = chars.size();
        return count;
    }
}
