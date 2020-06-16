package leetcode;

import org.aspectj.weaver.ast.Var;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 说明：
 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 */
public class Q8 {

    public static void main(String[] args) {
       /* String pattenstr = "^(-)?\\d.*$";
        //Pattern patten = Pattern.compile(pattenstr);
        String str = "1234123sdfgs";
        System.out.println(Pattern.matches(pattenstr, str));*/
        int i = myAtoi("  +42");
        System.out.println(i);

    }

    /**
     * 竟然不能用正则表达式
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        str = str.trim();
        StringBuilder stringBuilder = new StringBuilder();
        if(str.matches("^(?:[+-]?[0-9])(.*)?$")){
            for (Character c : str.toCharArray()) {
                if(c.equals('+'))continue;
                if(!Character.isDigit(c)&&!c.equals('-')){
                    return Integer.valueOf(stringBuilder.toString());
                }
                stringBuilder.append(c);
            }

            Long aLong = Long.valueOf(stringBuilder.toString());
            if(aLong>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(aLong<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            return Integer.valueOf(stringBuilder.toString());

        }
       return 0;
    }

    /**
     * 竟然不能用正则表达式
     * @param str
     * @return
     */
    public static int myAtoi1(String str) {
        String trim = str.trim();
        if(trim.matches("^(-)?\\d.*$")){
            Pattern patten = Pattern.compile("^(-)?\\d*\\d");
            Matcher matcher = patten.matcher(trim);
            if(matcher.find()){
                String group = matcher.group(0);
                return Integer.valueOf(group);
            }

            return 0;
        }
        return 0;
    }
}
