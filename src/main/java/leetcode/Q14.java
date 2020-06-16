package leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。

 如果不存在公共前缀，返回空字符串 ""。

 示例 1:

 输入: ["flower","flow","flight"]
 输出: "fl"

 */
public class Q14 {
    public static void main(String[] args) {
        String[] s = new String[]{"c","c"};
        System.out.println(longestCommonPrefix(s));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0)return "";
        if(strs.length==1)return strs[0];
        List<String> strings = Arrays.asList(strs);
        Collections.sort(strings);
        String s = strings.get(0);
        String s1 = strings.get(strs.length - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<Math.min(s.length(),s1.length());i++){

            if(s.charAt(i)==s1.charAt(i)){
                stringBuilder.append(s.charAt(i));
            }
            else{
                return stringBuilder.toString();
            }

        }
        return stringBuilder.toString();
    }
}
