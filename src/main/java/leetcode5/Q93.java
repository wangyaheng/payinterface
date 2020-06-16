package leetcode5;

import org.springframework.jdbc.support.incrementer.SybaseAnywhereMaxValueIncrementer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 示例:
 输入: "25525511135"
 输出: ["255.255.11.135", "255.255.111.35"]

 */
public class Q93 {

    public static void main(String[] args) {
        List<String> strings = restoreIpAddresses("25525511135");
        System.out.println(strings);

    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s.length()>12) return result;
        backtrace(s,result ,0 ,4 ,new LinkedList<>());
        return result;
    }

    public static boolean isValid(String str){
        int length = str.length();
        if(length>3) return false;

        return str.charAt(0)=='0'?(length==1):(Integer.valueOf(str)<=255);
    }
    public static String getipAddr(List<String> list){
        StringBuilder str = new StringBuilder();
        list.forEach(s->str.append(".").append(s));
        return str.toString().substring(1,str.length());
    }
    // n 为ip地址剩余的位数
    public static void backtrace(String str,List<String> result,int start,int n,List<String> temp){
        for (int i = 0; i < 3; i++) {
            if(start + i + 1>str.length()) continue;
            String substring = str.substring(start, start + i + 1);

            if(isValid(substring)){
                // 符合ip地址的规范
                temp.add(substring);
                if(temp.size()==4&&start + i + 1==str.length()){
                    System.out.println(temp);
                    result.add(getipAddr(temp));
                }
                else backtrace(str, result, start + i + 1,4-temp.size() ,temp );
                temp.remove(temp.size()-1);
            }

        }

    }
}
