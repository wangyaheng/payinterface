package leetcode4;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 示例：
 输入: S = "ADOBECODEBANC", T = "ABC"
 输出: "BANC"
 说明：
 如果 S 中不存这样的子串，则返回空字符串 ""。
 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class Q76 {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    /**
     * 滑动窗口
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {

        // 两个map记录t中字符串字符以及出现的次数
        // 第二个map记录窗口中出现的目标字符以及出现的次数
        Map<Character,Integer> needs = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();

        // 初始化needs
        for (int i = 0; i < t.length(); i++) {
            needs.put(t.charAt(i),needs.getOrDefault(t.charAt(i),0 )+1);
        }
        // count 目前遍历到哪个元素，need 已经放入窗口的目标字符个数
        int right = 0,left = 0,count =0;
        int minLength = Integer.MAX_VALUE;
        int start = 0,end = 0;
        while(right<s.length()){
            char c = s.charAt(right);
            if(needs.keySet().contains(c)){
                // 是目标字符
                window.put(s.charAt(right),window.getOrDefault(s.charAt(right),0 )+1);
                if(window.get(c).compareTo(needs.get(c))==0){
                    // 窗口中的当前字符的个数达到目标
                    count++;
                }
            }
            right++;
            while(count==needs.size()){
                // 窗口中已经包含了所有的目标字符
                if(right-left<minLength){
                    minLength = right-left;
                    start = left;
                    end = right;
                }
                // 窗口的左侧向右移动
               if(needs.containsKey(s.charAt(left))){
                    window.put(s.charAt(left),window.getOrDefault(s.charAt(left),1)-1);
                    if(window.get(s.charAt(left))<needs.get(s.charAt(left))){
                        // 窗口中的元素不在符合要求
                        count--;
                    }
               }
               left++;
            }

        }
        return minLength==Integer.MAX_VALUE?"":s.substring(start,end);
    }
}
